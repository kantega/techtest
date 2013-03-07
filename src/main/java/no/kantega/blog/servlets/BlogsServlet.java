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

import static no.kantega.blog.services.Services.getService;

/**
 * Lets you create, delete and list blogs.
 */
@WebServlet(urlPatterns = "/blogs")
@ServletSecurity(httpMethodConstraints = @HttpMethodConstraint("GET"))
public class BlogsServlet extends HttpServlet {

    private BlogDao dao;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.dao = getService(BlogDao.class, servletConfig.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        String blogToDelete = req.getParameter("delete");

        if (blogToDelete == null) {
            // Show all blogs
            req.setAttribute("blogs", dao.getAllBlogs());
            req.getRequestDispatcher("/WEB-INF/jsp/blogs.jsp").forward(req, resp);
        } else {
            // Delete a single blog
            Object admin = session.getAttribute(LoginServlet.ADMIN_SESSION_ATTRIBUTE);
            if (admin == null) {
                // Not logged in
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
            } else {
                dao.deleteBlogByName(blogToDelete);
                resp.sendRedirect("/blogs");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("blogname");
        if(name == null || name.trim().isEmpty()) {
            request.setAttribute("nameIsMissing", Boolean.TRUE);
            doGet(request, response);
            return;
        }

        String color = request.getParameter("color");

        Blog blog = new Blog();
        blog.setName(name);
        blog.setColor(color);
        dao.saveOrUpdate(blog);

        response.sendRedirect("blogs");
    }
}
