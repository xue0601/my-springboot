package com.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @program: my-springboot
 * @description:
 * @author: Xue0601
 * @create: 2018-12-24 15:33
 **/

@Component

public class HttpServletRequestReplacedFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ServletRequest requestWrapper = null;
//        System.out.println("请求参数:"+request.getParameter("id"));
//        Map<String, String[]> a = request.getParameterMap();
//        forDemo (String s : a.keySet( )) {
//            System.out.println(s );
//        }
//        if (request instanceof HttpServletRequest) {
//            System.out.println("拦截到参数" );
//            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//            if ("POST".equals(httpServletRequest.getMethod( ).toUpperCase( ))) {
////                requestWrapper = new BodyHttpServletRequestWrapper((HttpServletRequest) request);
//            }
//        }

        if (requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
