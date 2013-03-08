package no.kantega.blog.listener;

import no.kantega.blog.config.BlogConfig;
import no.kantega.blog.dao.BlogDao;
import no.kantega.blog.model.Blog;
import no.kantega.blog.model.BlogPost;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static no.kantega.blog.services.Services.getService;

/**
 * Listen to created and destroyed sessions.
 */
public class BlogSessionListener implements HttpSessionListener {
    private ConcurrentHashMap<String, HttpSession> sessions = new ConcurrentHashMap<>();
    private AtomicInteger getTotalSessionCount = new AtomicInteger();

    /**
     * Called when sessions are created.
     * 
     * @param sessionEvent Information about the session 
     */
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {

        HttpSession session = sessionEvent.getSession();
        try {
            BlogDao dao = getService(BlogDao.class, session.getServletContext());

            Map<String, BlogPost> blogPostCache = new HashMap<>();


            for(Blog blog : dao.getAllBlogs()) {
                for(BlogPost post : dao.getBlogPosts(blog)) {
                    blogPostCache.put(blog.getLinkId() +"/" + post.getLinkId(), post);
                }
            }

            session.setAttribute("blogPostCache", blogPostCache);

            // 8 hours sessions
            session.setMaxInactiveInterval(8 * 60 * 60);


            session.setAttribute("blogConfig", getBlogConfig(sessionEvent.getSession().getServletContext()));
        } finally {
            sessions.put(session.getId(), session);
            getTotalSessionCount.incrementAndGet();
        }
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

    /**
     * Called when a session is destroyed/invalidated (e.g. timeout).
     * 
     * @param httpSessionEvent Information about the session
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessions.remove(httpSessionEvent.getSession().getId());
    }

    /**
     * Utility method to invalidate all sessions.
     */
    public void invalidateAllSessions() {
        for(HttpSession session : sessions.values()) {
            session.invalidate();
        }
    }

    /**
     * Returns the number of sessions for statistics.
     * 
     * @return the number of current sessions
     */
    public long getCurrentSessionCount() {
        return sessions.size();
    }

    /**
     * Return the total number of sessions created.
     * 
     * @return Total number of sessions created
     */
    public int getTotalSessionCount() {
        return getTotalSessionCount.get();
    }

}
