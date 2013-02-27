<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Techtest Workshop" scope="request"/>

<c:set var="main" scope="request">
    <h1>Testing workshop</h1>


    <a href="blogs">Blogs</a>


    <h2>Tasks:</h2>

    <h3>Task 0: Download JMeter</h3>
    <p>
        <a href="http://jmeter.apache.org">http://jmeter.apache.org</a>
    </p>
    <h3>Task 1: Measure simple, single threaded performance</h3>

    <h3>Task 2: Stability</h3>

    <h3>Task 2: Fault tolerance testing</h3>

    <h3>Task 3: </h3>

</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>
