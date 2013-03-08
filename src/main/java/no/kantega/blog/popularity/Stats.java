package no.kantega.blog.popularity;

import no.kantega.blog.model.Blog;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 */
public class Stats {
    private ConcurrentHashMap<Long, AtomicLong> viewsPerBlog = new ConcurrentHashMap<>();

    public void addVisitTo(Blog blog) {
        viewsPerBlog.putIfAbsent(blog.getId(), new AtomicLong());
        viewsPerBlog.get(blog.getId()).incrementAndGet();
    }

    public long getVisitsFor(Blog blog) {
        viewsPerBlog.putIfAbsent(blog.getId(), new AtomicLong());
        return viewsPerBlog.get(blog.getId()).get();
    }


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
