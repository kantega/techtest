package no.kantega.blog.servlets;

import no.kantega.blog.dao.BlogDao;
import no.kantega.blog.model.Blog;
import no.kantega.blog.model.BlogPost;
import no.kantega.blog.model.BlogPostComment;
import no.kantega.blog.popularity.Stats;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import no.kantega.blog.dao.BlogPostCommentDao;
import no.kantega.blog.dao.BlogPostDao;

import static no.kantega.blog.services.Services.getService;

/**
 * Code for a single blog. 
 * 
 * Let you create blog posts and comments, and shows a 
 * single blog with all its posts or a single post. 
 * 
 * The URL looks like /blog/[blog-name]/[post-title]
 */
@WebServlet(urlPatterns = "/blog/*")
public class BlogServlet extends HttpServlet {

    private transient BlogDao dao;
    private transient BlogPostDao postDao;
    private transient BlogPostCommentDao commentDao;
    private volatile String content;
    private transient Stats stats;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.dao = getService(BlogDao.class, servletConfig.getServletContext());
        this.postDao = getService(BlogPostDao.class, servletConfig.getServletContext());
        this.commentDao = getService(BlogPostCommentDao.class, servletConfig.getServletContext());
        this.stats = getService(Stats.class, servletConfig.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(isBlogPostRequest(req)) {
            BlogPost post = getBlogPost(req);
            countBlog(post.getBlog());
            req.setAttribute("post", post);
            req.setAttribute("comments", commentDao.getComments(post));
            req.getRequestDispatcher("/WEB-INF/jsp/post.jsp").forward(req, resp);

        } else {
            Blog blog = getBlog(req);
            countBlog(blog);
            req.setAttribute("blog", blog);
            req.setAttribute("posts", postDao.getBlogPosts(blog));
            req.getRequestDispatcher("/WEB-INF/jsp/blog.jsp").forward(req, resp);
        }
    }

    private void countBlog(Blog blog) {
        stats.addVisitTo(blog);
    }

    /**
     * It is a blog post if it contains a / after the /blog/-part. That is
     * between the blog name and the post title.
     */
    private boolean isBlogPostRequest(HttpServletRequest req) {
        return req.getRequestURI().indexOf('/', "/blog/".length()) != -1;
    }

    private Blog getBlog(HttpServletRequest req) throws UnsupportedEncodingException {
        String requestURI = getRequestUri(req);
        String blogName = URLDecoder.decode(requestURI, "utf-8");
        return dao.getBlogByName(blogName);
    }

    private BlogPost getBlogPost(HttpServletRequest req) throws UnsupportedEncodingException {
        String requestURI = getRequestUri(req);
        String blogName = URLDecoder.decode(requestURI.substring(0, requestURI.indexOf('/')), "utf-8");
        String postName = URLDecoder.decode(requestURI.substring(requestURI.indexOf('/')+1), "utf-8");

        return postDao.getBlogPost(dao.getBlogByName(blogName), postName);
    }

    /**
     * Extract the interesting part of the URI.
     */
    private String getRequestUri(HttpServletRequest req) {
        return req.getRequestURI().substring("/blog/".length());
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect;
        if (isComment(req)) {
            redirect = postBlogComment(req);
        } else {
            redirect = postBlogEntry(req);
        }
        resp.sendRedirect(redirect);
    }

    /**
     * It is a comment if commentAuthor field is set.
     * 
     * @param req The request
     * @return True if this is an add comment POST
     */
    private boolean isComment(HttpServletRequest req) {
        return req.getParameter("commentAuthor") != null;
    }

    private String postBlogComment(HttpServletRequest req) throws IOException {
        // TODO: Thread safety: Should this be a local variable?
        content = req.getParameter("content");

        BlogPost post = getBlogPost(req);
        String author = req.getParameter("commentAuthor");

        BlogPostComment comment = new BlogPostComment(post);
        comment.setAuthor(author);
        comment.setContent(content);
        commentDao.saveOrUpdate(comment);
        return post.getLinkId();
    }

    private String postBlogEntry(HttpServletRequest req) throws IOException {
        String title = req.getParameter("title");
        String blogContent = req.getParameter("content");
        Blog blog = getBlog(req);

        BlogPost post = new BlogPost(blog);
        post.setTitle(title);
        post.setContent(blogContent);
        postDao.saveOrUpdate(post);

        return blog.getLinkId();
    }
}
