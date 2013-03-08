<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="SLA" scope="request"/>

<c:set var="main" scope="request">
    <h1>Service Level Agreement (SLA)</h1>

    <h2>Response rate</h2>

    <p>All requests must be answered within 1 second.</p>
    
    <h2>Errors</h2>

    <p>We should have less than 0.5% error.</p>
    
    <h2>Availability</h2>
    
    <p>5-nines availability.</p>
    
    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>