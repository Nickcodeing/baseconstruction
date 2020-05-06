package com.nick.baseconstruction.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CheckURLFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("there is init method.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse hsrs = (HttpServletResponse) servletResponse;
        HttpServletRequest hsrq = (HttpServletRequest) servletRequest;
        String contextPath = hsrq.getServletPath();
        if(contextPath.indexOf("/index") == -1){
            System.out.println("url no index!");
        }else{
            System.err.println("url have index!");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("there is destory method.");
    }
}
