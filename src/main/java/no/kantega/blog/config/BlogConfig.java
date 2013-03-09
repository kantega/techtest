package no.kantega.blog.config;

import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.*;

/**
 * Configuration for the blog software.
 */
public class BlogConfig {

    private final Document blogDocument;

    /**
     * Create a new blog configuration.
     * 
     * @param blogDocument Document storing the configuration
     */
    public BlogConfig(Document blogDocument) {
        this.blogDocument = blogDocument;
    }

    /**
     * Get the logo from the configuration.
     * 
     * @return Logo
     */
    public byte[] getLogo() {
        Element elem = (Element) blogDocument.getElementsByTagName("base64EncodedLogo").item(0);

        NodeList childNodes = elem.getChildNodes();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if(item instanceof Text) {
                sb.append(((Text) item).getData());
            }
        }
        return Base64.decodeBase64(sb.toString());
    }
}
