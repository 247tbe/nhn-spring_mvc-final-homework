package com.nhnacademy.springmvc.interceptor;

import java.util.Arrays;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();

        try {
            Arrays.stream(cookies)
                .filter(c -> c.getName().equals("SESSION"))
                .findFirst()
                .orElse(null);

            return true;
        } catch (Exception e) {
            response.sendRedirect("/login");
            return false;
        }
    }
}
