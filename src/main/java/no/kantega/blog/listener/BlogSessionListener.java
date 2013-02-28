package no.kantega.blog.listener;

import no.kantega.blog.dao.BlogDao;
import no.kantega.blog.model.Blog;
import no.kantega.blog.model.BlogPost;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static no.kantega.blog.services.Services.addService;
import static no.kantega.blog.services.Services.getService;

/**
 *
 */
public class BlogSessionListener implements HttpSessionListener, ServletContextListener {
    private AtomicLong sessionCounter = new AtomicLong();

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {

        try {
            BlogDao dao = getService(BlogDao.class, sessionEvent.getSession().getServletContext());

            Map<String, BlogPost> blogPostCache = new HashMap<String, BlogPost>();


            for(Blog blog : dao.getAllBlogs()) {
                for(BlogPost post : dao.getBlogPosts(blog)) {
                    blogPostCache.put(blog.getLinkId() +"/" + post.getLinkId(), post);
                }
            }

            sessionEvent.getSession().setAttribute("blogPostCache", blogPostCache);


            // 8 hours sessions
            sessionEvent.getSession().setMaxInactiveInterval(8*60*60);
        } finally {
            sessionCounter.incrementAndGet();
        }
    }

    public long getCurrentSessionCount() {
        return sessionCounter.get();
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionCounter.decrementAndGet();
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        addService(BlogSessionListener.class, this, servletContextEvent.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
