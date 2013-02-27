package no.kantega.blog.listener;

import no.kantega.blog.dao.BlogDao;
import no.kantega.blog.model.Blog;
import no.kantega.blog.model.BlogPost;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

import static no.kantega.blog.services.Services.getService;

/**
 *
 */
public class BlogSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        BlogDao dao = getService(BlogDao.class, sessionEvent.getSession().getServletContext());

        Map<String, BlogPost> blogPostCache = new HashMap<String, BlogPost>();


        for(Blog blog : dao.getAllBlogs()) {
            for(BlogPost post : dao.getBlogPosts(blog)) {
                blogPostCache.put(blog.getLinkId() +"/" + post.getLinkId(), post);
            }
        }

        sessionEvent.getSession().setAttribute("blogPostCache", blogPostCache);


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
