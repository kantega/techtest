package no.kantega.blog.listener;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Listen to created and destroyed sessions.
 */
public class BlogSessionListener implements HttpSessionListener {
    private ConcurrentHashMap<String, HttpSession> sessions = new ConcurrentHashMap<>();
    private AtomicInteger getTotalSessionCount = new AtomicInteger();

    /**
     * Called when sessions are created.
     * 
     * @param sessionEvent Information about the session 
     */
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        HttpSession session = sessionEvent.getSession();
        // 8 hours sessions
        session.setMaxInactiveInterval(8 * 60 * 60);
        sessions.put(session.getId(), session);
        getTotalSessionCount.incrementAndGet();
    }

    /**
     * Called when a session is destroyed/invalidated (e.g. timeout).
     * 
     * @param httpSessionEvent Information about the session
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessions.remove(httpSessionEvent.getSession().getId());
    }

    /**
     * Utility method to invalidate all sessions.
     */
    public void invalidateAllSessions() {
        for(HttpSession session : sessions.values()) {
            session.invalidate();
        }
    }

    /**
     * Returns the number of sessions for statistics.
     * 
     * @return the number of current sessions
     */
    public long getCurrentSessionCount() {
        return sessions.size();
    }

    /**
     * Return the total number of sessions created.
     * 
     * @return Total number of sessions created
     */
    public int getTotalSessionCount() {
        return getTotalSessionCount.get();
    }

}
