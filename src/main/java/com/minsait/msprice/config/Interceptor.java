package com.minsait.msprice.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {
    ///////////////////////////// Comprobar si public class Filtro implements Filter
    ///////////////////////////// { vale la pena
    // https://github.com/miw-upm/betca-spring3/blob/master/src/main/java/servlets/Filtro.java
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("\nPre Handle method is Calling");
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        System.out.println("[INFO ] ProcessingTime:" + request.getRequestURL().toString() + "::"
                + (System.currentTimeMillis() - startTime)
                + "ms");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        log.info("\nRequest and Response is completed");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}