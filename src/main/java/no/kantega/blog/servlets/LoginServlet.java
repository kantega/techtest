package no.kantega.blog.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet class for login.
 */
@WebServlet(urlPatterns = {"/login/*", "/logout"})
public class LoginServlet extends HttpServlet {

    public static final String ADMIN_SESSION_ATTRIBUTE = "admin";
    public static final String CORRECT_USERNAME = "admin";
    public static final String CORRECT_PASSWORD = "admin";
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Object admin = session.getAttribute(ADMIN_SESSION_ATTRIBUTE);

        if(admin != null && req.getServletPath().equals("/logout")) {
            session.removeAttribute(ADMIN_SESSION_ATTRIBUTE);
            resp.sendRedirect("/blogs");
        }
        else {
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession(true);

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
            session.setAttribute(ADMIN_SESSION_ATTRIBUTE, username);
            resp.sendRedirect("/blogs");
        }
        else {
            session.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        }
    }
}
