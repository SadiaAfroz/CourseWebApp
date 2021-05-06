package net.therap.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sadia.afroz
 * @since 5/6/21
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (req.getRequestURI().contains("home") || req.getRequestURI().contains("login")
                || req.getRequestURI().contains("getalltrainees") || req.getRequestURI().contains("getallcourses")) {
            resp.getWriter().println(req.getRequestURI());
            chain.doFilter(request, response);
        } else {
            if (session == null || session.getAttribute("sesionid") == null) {
                resp.sendRedirect("home");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
    }
}

