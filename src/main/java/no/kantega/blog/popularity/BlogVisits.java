package no.kantega.blog.popularity;

import no.kantega.blog.model.Blog;

/**
 *
 */
public class BlogVisits {
    private final Blog blog;
    private final long visits;

    public BlogVisits(Blog blog, long visits) {
        this.blog = blog;
        this.visits = visits;
    }

    public Blog getBlog() {
        return blog;
    }

    public long getVisits() {
        return visits;
    }
}
