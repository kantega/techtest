package no.kantega.blog.popularity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import no.kantega.blog.model.Blog;

/**
 * Keeps track on the number of visits on different blogs.
 */
public class Stats {
    private ConcurrentHashMap<Long, AtomicLong> viewsPerBlog = new ConcurrentHashMap<>();

    /**
     * Adds a visit to a given blog. New blogs are ignored as they have no id.
     * 
     * @param blog The blog that is visited  
     */
    public void addVisitTo(Blog blog) {
        if (!blog.isNew()) {
            viewsPerBlog.putIfAbsent(blog.getId(), new AtomicLong());
            viewsPerBlog.get(blog.getId()).incrementAndGet();
        }
    }

    /**
     * Returns the number of visits for a given blog.
     * 
     * @param blog The blog to get the number of visits for
     * @return The number of visits for a given blog
     */
    private long getVisitsFor(Blog blog) {
        viewsPerBlog.putIfAbsent(blog.getId(), new AtomicLong());
        return viewsPerBlog.get(blog.getId()).get();
    }

    /**
     * Returns a list of visits for a set of blogs.
     * 
     * @param allBlogs The blogs to get visits for
     * @return Visits for all those blogs, sorted on the number of visits (highest first)
     */
    public List<BlogVisits> getVisits(List<Blog> allBlogs) {
        List<BlogVisits> visits = new ArrayList<>();

        for (Blog blog : allBlogs) {
            visits.add(new BlogVisits(blog, getVisitsFor(blog)));
        }

        Collections.sort(visits, new Comparator<BlogVisits>() {
            @Override
            public int compare(BlogVisits o1, BlogVisits o2) {
                return Long.compare(o2.getVisits(), o1.getVisits());
            }
        });

        return visits;
    }
}
