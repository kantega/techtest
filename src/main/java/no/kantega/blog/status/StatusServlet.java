package no.kantega.blog.status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import static no.kantega.blog.services.Services.getService;

/**
 *
 */
@WebServlet(urlPatterns = "/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("dataSource", getService(DataSource.class, request.getServletContext()));

        request.setAttribute("memory", ManagementFactory.getMemoryMXBean());
        request.getRequestDispatcher("/WEB-INF/jsp/status.jsp").forward(request, response);
    }
}
