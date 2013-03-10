package no.kantega.blog.config;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for blog config.
 */
public class BlogConfigTest {

    @Test
    public void shouldGetLogoWithCorrectSize() throws ParserConfigurationException, IOException, SAXException {

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("src/main/webapp/WEB-INF/blog-config.xml"));

        assertEquals("Logo should have correct size", 33132, new BlogConfig(doc).getLogo().length);
    }

}
