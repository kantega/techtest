package no.kantega.blog.servlets;

import no.kantega.blog.config.BlogConfig;
import no.kantega.blog.dao.BlogDao;
import no.kantega.blog.popularity.Stats;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static no.kantega.blog.services.Services.getService;

/**
 *
 */
@WebServlet(urlPatterns = {"/popularity"})
public class PopularityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Stats stats = getService(Stats.class, request.getServletContext());
        BlogDao dao = getService(BlogDao.class, request.getServletContext());

        request.setAttribute("highscore", stats.getVisits(dao.getAllBlogs()));

        request.getRequestDispatcher("/WEB-INF/jsp/popularity.jsp").forward(request, response);

        request.getSession().setAttribute("blogConfig", getBlogConfig(request.getSession().getServletContext()));

    }

    /**
     * Parse the blog config
     */
    private BlogConfig getBlogConfig(ServletContext servletContext) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(servletContext.getResourceAsStream("/WEB-INF/blog-config.xml"));
            return new BlogConfig(doc);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

    }
}
