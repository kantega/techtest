<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Stability" scope="request"/>

<c:set var="main" scope="request">
    <h1>Stability</h1>
    
    <p class="ingress">After it has been running for a while the blog server start getting hickup.
        Suddenly it has 10 second periods where it stops responding to page views.
        After even longer time is crashes with out of memory exception.</p>
        
    <div class="email">
        <div class="mailheader">
            <p><b>From:</b> BOFH &lt;it_ops@blogprovider.com&gt;</p>
            <p><b>To:</b> Blog Software Development Team &lt;blogs@development.com&gt;</p>
            <p><b>Date:</b> 2012-03-14 12:13:37</p>
            <p><b>Importance: </b>High!</p>
            <p><b>Subject:</b> Crash with OOM in Prod!</p>
        </div>

        <div class="mailbody">
            <p>Hi,</p> 

            <p>thanks for fixing the nightly restart problem - 
               now we have a weekly restart problem instead :(</p>

            <p>We didn't see this problem in the previous version, could the 
                reason be the new <a href="/popularity">popularity</a> page that was added
                in the latest version?</p>
            
            <p>This breaks the <a href="sla.jsp">SLA</a>!</p>
            
            <p>Take a look at the attached stacktrace...</p>

<pre>
[STDERR] 2013-03-10 17:31:21.844:WARN:oejs.ServletHandler:qtp1867424930-27: Error for /popularity
[STDERR] java.lang.OutOfMemoryError: Java heap space
[STDERR]        at org.apache.xerces.dom.DeferredDocumentImpl.createChunk(DeferredDocumentImpl.java:1873)
[STDERR]        at org.apache.xerces.dom.DeferredDocumentImpl.ensureCapacity(DeferredDocumentImpl.java:1767)
[STDERR]        at org.apache.xerces.dom.DeferredDocumentImpl.createNode(DeferredDocumentImpl.java:1786)
[STDERR]        at org.apache.xerces.dom.DeferredDocumentImpl.createDeferredDocument(DeferredDocumentImpl.java:220)
[STDERR]        at org.apache.xerces.parsers.AbstractDOMParser.startDocument(AbstractDOMParser.java:714)
[STDERR]        at org.apache.xerces.impl.XMLNamespaceBinder.startDocument(XMLNamespaceBinder.java:444)
[STDERR]        at org.apache.xerces.impl.dtd.XMLDTDValidator.startDocument(XMLDTDValidator.java:644)
[STDERR]        at org.apache.xerces.impl.XMLDocumentScannerImpl.startEntity(XMLDocumentScannerImpl.java:431)
[STDERR]        at org.apache.xerces.impl.XMLEntityManager.startEntity(XMLEntityManager.java:878)
[STDERR]        at org.apache.xerces.impl.XMLEntityManager.startDocumentEntity(XMLEntityManager.java:741)
[STDERR]        at org.apache.xerces.impl.XMLDocumentScannerImpl.setInputSource(XMLDocumentScannerImpl.java:260)
[STDERR]        at org.apache.xerces.parsers.DTDConfiguration.parse(DTDConfiguration.java:498)
[STDERR]        at org.apache.xerces.parsers.DTDConfiguration.parse(DTDConfiguration.java:580)
[STDERR]        at org.apache.xerces.parsers.XMLParser.parse(XMLParser.java:152)
[STDERR]        at org.apache.xerces.parsers.DOMParser.parse(DOMParser.java:253)
[STDERR]        at org.apache.xerces.jaxp.DocumentBuilderImpl.parse(DocumentBuilderImpl.java:201)
[STDERR]        at javax.xml.parsers.DocumentBuilder.parse(DocumentBuilder.java:121)
[STDERR]        at no.kantega.blog.servlets.PopularityServlet.getBlogConfig(PopularityServlet.java:46)
[STDERR]        at no.kantega.blog.servlets.PopularityServlet.doGet(PopularityServlet.java:37)
</pre>
            
            <p>Regards,<br/> 
            BOFH</p>
          </div>
    </div>
    
    <h2>Task</h2>
    
    <p>Run a stability test to check what happens when you test the software for a while.</p>
    
    <p class="tip">Use load profile and data from scalability test to find a good setting for the test.</p>
    
    <p class="tip">...but remember to update with information about the new page.</p>
    
    <p class="tip">
        Use jvisualvm (in the same directoy as the java executable) on the org.eclipse.jettymaven.plugin.Starter process to follow memory usage
    </p>
    
    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>