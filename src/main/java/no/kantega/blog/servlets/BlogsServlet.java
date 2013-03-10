package no.kantega.blog.servlets;

import no.kantega.blog.dao.BlogDao;
import no.kantega.blog.model.Blog;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;

import static no.kantega.blog.services.Services.getService;

/**
 * Lets you create, delete and list blogs.
 */
@WebServlet(urlPatterns = "/blogs")
@ServletSecurity(httpMethodConstraints = @HttpMethodConstraint("GET"))
public class BlogsServlet extends HttpServlet {

    private transient BlogDao dao;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.dao = getService(BlogDao.class, servletConfig.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("blogs", dao.getAllBlogs());
        req.getRequestDispatcher("/WEB-INF/jsp/blogs.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (shouldDelete(request)) {
            deletePost(request, response);
        } else {
            newBlogPost(request, response);
        }
    }

    private void newBlogPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String color = request.getParameter("color");
        String name = request.getParameter("blogname");

        if(name == null || name.trim().isEmpty()) {
            request.setAttribute("nameIsMissing", Boolean.TRUE);
            doGet(request, response);
            return;
        }

        Blog blog = new Blog();
        blog.setName(name);
        blog.setColor(color);
        dao.saveOrUpdate(blog);

        response.sendRedirect("blogs");
    }
    
    private void deletePost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String blogToDelete = URLDecoder.decode(request.getParameter("delete"), "utf-8");
        if (blogToDelete != null) {
            // Delete a single blog
            HttpSession session = request.getSession(true);
            Object admin = session.getAttribute(LoginServlet.ADMIN_SESSION_ATTRIBUTE);
            if (admin == null) {
                // Not logged in
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            } else {
                dao.deleteBlogByName(blogToDelete);
                response.sendRedirect("/blogs");
            }
        }
    }

    private boolean shouldDelete(HttpServletRequest request) {
        return request.getParameter("delete") != null;
    }
}
