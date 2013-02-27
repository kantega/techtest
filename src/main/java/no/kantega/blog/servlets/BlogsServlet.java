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
import java.io.IOException;

import static no.kantega.blog.services.Services.getService;


/**
 *
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
        req.setAttribute("blogs", dao.getAllBlogs());

        req.getRequestDispatcher("/WEB-INF/jsp/blogs.jsp").forward(req, resp);

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
