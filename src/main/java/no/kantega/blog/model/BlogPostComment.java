package no.kantega.blog.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class BlogPostComment {
    private final BlogPost blogPost;
    private long blogPostCommentId;

    private String author,content;

    private Date publishDate;

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

    public boolean isNew() {
        return blogPostCommentId == 0;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getPublishDateInFormat(String format) {
        return new SimpleDateFormat(format).format(publishDate);
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
