package com.lonch.game.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: lpx
 * @create: 2022-03-16 11:10
 */
@Component
public class CrosFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response1 = (HttpServletResponse) response;

        response1.setHeader("Access-Control-Allow-Origin","*");
        response1.setHeader("Access-Control-Allow-Methods", "*");
        response1.setHeader("Access-Control-Allow-Headers", "*");
        chain.doFilter(request, response);

    }

//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        //解决跨域问题
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "content-type");
//        filterChain.doFilter(servletRequest, servletResponse);
//
//    }
}
