package no.kantega.blog.popularity;

import no.kantega.blog.model.Blog;

/**
 * Information about the number of visits to a given blog.
 */
public class BlogVisits {
    private final Blog blog;
    private final long visits;

    /**
     * Create a new blog visits object storing the blog and the number of visits.
     * 
     * @param blog The blog this is information about
     * @param visits The number of visits this blog has
     */
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
