package no.kantega.blog.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class BlogPost {

    private final Blog blog;
    private long blogPostId;

    private String title;

    private String content;

    private Date publishDate;
    private int commentCount;

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

    public boolean isNew() {
        return blogPostId == 0;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishDateInFormat(String format) {
        return new SimpleDateFormat(format).format(publishDate);
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public String getLinkId()  {
        if(title == null) {
            return null;
        }
        try {
            return URLEncoder.encode(title, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
