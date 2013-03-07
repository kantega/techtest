package no.kantega.blog.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet for admin page. Lets you see that you are logged in.
 */
@WebServlet(urlPatterns = "/admin/*")
public class AdminServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        HttpSession session = req.getSession(true);

        Object admin = session.getAttribute(LoginServlet.ADMIN_SESSION_ATTRIBUTE);

        if (admin == null) {
            // Not logged in
            resp.sendRedirect("/login");
        } else {
            session.getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin.jsp").forward(req, resp);
        }
    }


}
