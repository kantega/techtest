<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="SLA" scope="request"/>

<c:set var="main" scope="request">
    <h1>Tools</h1>

    <ul>
        <li><a href="http://www.oracle.com/technetwork/java/javase/downloads/index.html"</a>Java 7</li>
        <li><a href="http://maven.apache.org/">Apache Maven</a></li>
        <li><a href="http://jmeter.apache.org">http://jmeter.apache.org</a></li>
        <li><a href="http://visualvm.java.net">http://visualvm.java.net</a></li>
    </ul>
    
    <a href="/">Back...</>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>
