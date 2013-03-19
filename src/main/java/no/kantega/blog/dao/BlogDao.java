package no.kantega.blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import no.kantega.blog.model.Blog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * Database abstraction layer.
 */
public class BlogDao {

    private final JdbcTemplate template;

    /**
     * Create a new Data Access Object.
     * 
     * @param dataSource the connection to the database to talk with 
     */
    public BlogDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    /**
     * Return all blogs.
     * 
     * @return list of all blogs ordered by name 
     */
    public List<Blog> getAllBlogs() {
        return getBlogsWhere("");
    }

    private List<Blog> getBlogsWhere(String wherePart, Object... params) {
        return template.query("select * from blog " + wherePart +" order by blogname", new RowMapper<Blog>() {
            @Override
            public Blog mapRow(ResultSet resultSet, int i) throws SQLException {
                return getBlogFromResultSet(resultSet);
            }
        }, params);
    }

    /**
     * Converts resultset columns to blog object.
     * 
     * @param resultSet The resultset to read from
     * @return Blog object
     * @throws SQLException If blog data can't be read from result set 
     */
    public static Blog getBlogFromResultSet(ResultSet resultSet) throws SQLException {
        Blog blog = new Blog();
        blog.setId(resultSet.getLong("blogid"));
        blog.setName(resultSet.getString("blogname"));
        blog.setColor(resultSet.getString("color"));
        return blog;
    }

    /**
     * Saves a blog post to the database.
     * 
     * @param blog the blog post to save 
     */
    public void saveOrUpdate(Blog blog) {
        if (blog.isNew()) {
            template.update("INSERT INTO blog (blogname, color) VALUES (?, ?)", blog.getName(), blog.getColor());
        } else {
            template.update("UPDATE blog SET blogname=?, color=? WHERE blogid=?", blog.getName(), blog.getColor(), blog.getId());
        }
    }

    /**
     * Return a blog given an unique name.
     * 
     * @param blogName The name of the blog
     * @return Blog with the given name
     * @throws IllegalArgumentException If no blog with the given name can be found
     */
    public Blog getBlogByName(String blogName) {
        List<Blog> blogs = getBlogsWhere(" where blogname=?", blogName);
        if(blogs.isEmpty()) {
            throw new IllegalArgumentException("Blog not found " + blogName);
        }
        return blogs.iterator().next();
    }
    
        /**
     * Return a blog given the id of the blog.
     * 
     * @param blogId The id of the blog
     * @return Blog with the given id
     * @throws IllegalArgumentException If no blog with the given name can be found
     */
    public Blog getBlogById(long blogId) {
        List<Blog> blogs = getBlogsWhere("where blogid=?", blogId);
        if(blogs.isEmpty()) {
            throw new IllegalArgumentException("Blog not found with id: " + blogId);
        }
        return blogs.iterator().next();
    }

    /**
     * Delete a blog given its name.
     * 
     * @param blogName The name of the blog to delete
     */
    public void deleteBlogByName(String blogName) {
        Blog blog = getBlogByName(blogName);
        template.update("DELETE FROM blog WHERE blogname=?", blog.getName());
    }

}
