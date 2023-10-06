package com.minsait.msprice.config;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class RateLimit implements Filter{
    private final long MAX_REQUESTS_PER_SECOND = 10;
    private final ConcurrentHashMap<String, AtomicInteger> clients = new ConcurrentHashMap<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String clientIp = request.getRemoteAddr();
        AtomicInteger rateInfo = clients.computeIfAbsent(clientIp, k -> new AtomicInteger(0));

        if (rateInfo.incrementAndGet() > MAX_REQUESTS_PER_SECOND) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            httpResponse.getWriter().write("Exceeded rate limit of " + MAX_REQUESTS_PER_SECOND + " requests per second");
            return;
        }

        chain.doFilter(request, response);
        // TODO: review this
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ignored) {
            }
            rateInfo.decrementAndGet();
        }).start();
    }
}
