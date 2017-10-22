package com.uizhi.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiwei
 * Date: 2017-10-22
 * Time: 15:49
 */

public class TimeFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("start filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        Long time = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("time filter 耗时："+(new Date().getTime()-time));
    }

    @Override
    public void destroy() {
        System.out.println("filter end ");
    }
}
