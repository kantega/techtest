package no.kantega.blog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Filter that give nice HTTP 500 errors
 */
public class ErrorFilter implements Filter {

    /**
     * Initialize filter.
     * 
     * @param filterConfig Configuration for filter
     * @throws ServletException If filter can't be initialized
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // empty
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

    /**
     * Destroy filter on shutdown - not used.
     */
    @Override
    public void destroy() {
        // empty
    }
}
