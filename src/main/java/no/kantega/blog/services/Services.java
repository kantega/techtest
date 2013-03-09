package no.kantega.blog.services;
import javax.servlet.ServletContext;

/**
 * Utility that does type casting from the servlet context.
 */
public final class Services {

    private Services() {}
    
    /**
     * Returns a service of a given type.
     * 
     * @param <T> The type of the service
     * @param clazz The class of the service
     * @param servletContext The servlet context to get the service from
     * @return Service of a given type
     */
    @SuppressWarnings("unchecked")
    public static <T> T getService(Class<T> clazz, ServletContext servletContext) {
        return (T) servletContext.getAttribute(clazz.getName());
    }

    /**
     * Adds a service with a given type.
     * 
     * @param <T> The type of service
     * @param clazz The class of the service
     * @param implementation The implementation of the service
     * @param servletContext The servlet context to add it to
     */
    public static <T> void addService(Class<T> clazz, T implementation, ServletContext servletContext) {
        servletContext.setAttribute(clazz.getName(), implementation);
    }

}
