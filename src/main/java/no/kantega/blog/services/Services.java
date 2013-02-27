package no.kantega.blog.services;

import javax.servlet.ServletContext;

/**
 *
 */
public class Services {

    public static <T> T getService(Class<T> clazz, ServletContext servletContext) {
        return (T) servletContext.getAttribute(clazz.getName());
    }

    public static <T> void addService(Class<T> clazz, T implementation, ServletContext servletContext) {
        servletContext.setAttribute(clazz.getName(), implementation);
    }


}
