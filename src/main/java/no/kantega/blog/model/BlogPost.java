package no.kantega.blog.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Domain object representing a single blog post.
 * 
 * A blog can have several blog posts, but each blog post belongs to only
 * one blog.
 * 
 * A blog post can have many comments.
 */
public class BlogPost {

    private final Blog blog;
    private long blogPostId;

    private String title;

    private String content;

    private DateTime publishDate;
    private int commentCount;

    /**
     * Create a new blog post in a given blog.
     * 
     * @param blog The blog this post is written in 
     */
    public BlogPost(Blog blog) {
        this.blog = blog;
    }

    public long getBlogPostId() {
        return blogPostId;
    }

    public void setBlogPostId(long blogPostId) {
        this.blogPostId = blogPostId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Blog getBlog() {
        return blog;
    }

    /**
     * Return true if this blog post has not been saved to the database yet.
     * 
     * @return true if this blog post has not been saved to the database yet
     */
    public boolean isNew() {
        return blogPostId == 0;
    }

    public DateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = new DateTime(publishDate);
    }

    /**
     * Returns string representation of the published date in a given format.
     * 
     * @param format The format of the string representation
     * @return string representation of published date
     */
    public String getPublishDateInFormat(String format) {
        return DateTimeFormat.forPattern(format).withLocale(Locale.US).print(publishDate);
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    /**
     * Return the id used in the URL to this blog post.
     * 
     * @return part of URL used for this blog post
     */
    public String getLinkId()  {
        return (title == null) ? null : getUrlEncodedName();
    }

    private String getUrlEncodedName() {
        try {
            return URLEncoder.encode(title, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
