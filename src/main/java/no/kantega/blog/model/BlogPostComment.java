package no.kantega.blog.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Domain object representing a comment on a given blog post.
 * 
 * A comment belongs to a single blog post, but a blog post can have 
 * many comments.
 */
public class BlogPostComment {

    private final BlogPost blogPost;
    private long blogPostCommentId;
    private String author;
    private String content;
    private Date publishDate;

    /**
     * Create a new comment on a given blog post.
     * 
     * @param blogPost The post this is a comment on 
     */
    public BlogPostComment(BlogPost blogPost) {
        this.blogPost = blogPost;
    }

    public long getBlogPostCommentId() {
        return blogPostCommentId;
    }

    public void setBlogPostCommentId(long blogPostCommentId) {
        this.blogPostCommentId = blogPostCommentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Returns true if this is a new comment - that is not stored to the database yet.
     * 
     * @return true if this comment has not been saved to the database
     */
    public boolean isNew() {
        return blogPostCommentId == 0;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * Gets the publish date if the comment in a formatted way.
     * 
     * @param format The format to use
     * @return String representing the published date of the comment
     */
    public String getPublishDateInFormat(String format) {
        return new SimpleDateFormat(format, Locale.US).format(publishDate);
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
