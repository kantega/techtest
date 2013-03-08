package no.kantega.blog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 */
public class ErrorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            req.setAttribute("stackTrace", sw.toString());
            req.getRequestDispatcher("/WEB-INF/jsp/500.jsp").forward(servletRequest, servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
