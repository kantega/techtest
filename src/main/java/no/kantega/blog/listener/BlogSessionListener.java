package no.kantega.blog.listener;

import no.kantega.blog.dao.BlogDao;
import no.kantega.blog.model.Blog;
import no.kantega.blog.model.BlogPost;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static no.kantega.blog.services.Services.getService;

/**
 *
 */
public class BlogSessionListener implements HttpSessionListener {
    private ConcurrentHashMap<String, HttpSession> sessions = new ConcurrentHashMap<>();
    private AtomicInteger getTotalSessionCount = new AtomicInteger();

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {

        HttpSession session = sessionEvent.getSession();
        try {
            BlogDao dao = getService(BlogDao.class, session.getServletContext());

            Map<String, BlogPost> blogPostCache = new HashMap<String, BlogPost>();


            for(Blog blog : dao.getAllBlogs()) {
                for(BlogPost post : dao.getBlogPosts(blog)) {
                    blogPostCache.put(blog.getLinkId() +"/" + post.getLinkId(), post);
                }
            }

            session.setAttribute("blogPostCache", blogPostCache);


            // 8 hours sessions
            session.setMaxInactiveInterval(8 * 60 * 60);
        } finally {
            sessions.put(session.getId(), session);
            getTotalSessionCount.incrementAndGet();
        }
    }

    public long getCurrentSessionCount() {
        return sessions.size();
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessions.remove(httpSessionEvent.getSession().getId());
    }

    public void invalidateAllSessions() {
        for(HttpSession session : sessions.values()) {
            session.invalidate();
        }
    }

    public int getTotalSessionCount() {
        return getTotalSessionCount.get();
    }

}
