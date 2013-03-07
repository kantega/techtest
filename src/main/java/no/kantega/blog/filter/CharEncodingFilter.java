package no.kantega.blog.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Set the content type on all callse.
 */
public class CharEncodingFilter implements Filter {

    /**
     * Initialize the filter - not used.
     * 
     * @param filterConfig Configuration for the filter
     * @throws ServletException In case the filter can't be configured
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // empty
    }

    /**
     * Set content type on the response.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * Destroy filter on shutdown - not used.
     */
    @Override
    public void destroy() {
        // empty
    }
}
