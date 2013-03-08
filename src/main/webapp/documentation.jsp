<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Docs" scope="request"/>

<c:set var="main" scope="request">
    <h1>Documentation</h1>

    <ul>
        <li><a href="http://docs.oracle.com/javase/7/docs/api/"</a>Java 7 JavaDoc</li>
        <li><a href="http://jmeter.apache.org/usermanual/index.html">JMeter Users Manual</a></li>
        <li><a href="http://jmeter.apache.org/usermanual/test_plan.html">JMeter Elements in Test Plan</a></li>
    </ul>
    
    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>
