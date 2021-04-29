package net.therap.controller;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CacheFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse resp=(HttpServletResponse) response;
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
