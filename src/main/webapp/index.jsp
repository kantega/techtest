<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Welcome" scope="request"/>

<c:set var="main" scope="request">
    <h1>Workshop: Introduction to Technical Testing</h1>

    <p class="ingress">
        In this workshop, we give you a seemingly functional <a href="blogs">blog application</a>. By running, writing and testing with automated
        load tests you'll discover that the system is buggy, unstable and just doesn't scale! Well'll then show you
        tools and techniques which will help you in identifying common classes of bugs, how to resolve them and how
        to verify that the situation actually improved
    </p>
    <h2>Part I</h2>

    <h3>Task 1: <a href="create_a_blog.jsp">Create your own blog</a></h3>
    <h3>Task 2: <a href="create_a_test.jsp">Create your own test</a></h3>

    <h2>Part II</h2>

    <p>
        Choose one of the following tasks. Or do them all if you have time!
    </p>
    <h3>Task 3: <a href="concurrency.jsp">Concurrency</a></h3>
    <h3>Task 4: <a href="fault_tolerance.jsp">Fault tolerance</a></h3>
    <h3>Task 5: <a href="volume.jsp">Volume</a></h3>

    <h2>Part III</h2>
    <h3>Task 6: <a href="scalability.jsp">Scalability</a></h3>
    <h3>Task 7: <a href="stability.jsp">Stability</a></h3>

    <h2>Resources</h2>
    <ul>
        <li><a href="getting_started.jsp">Geting Started</a></li>
        <li><a href="tools.jsp">Tools</a></li>
        <li><a href="loadProfile.jsp">Load Profile</a></li>
        <li><a href="sla.jsp">Service Level Agreement (SLA)</a></li>
        <li><a href="documentation.jsp">Documentation</a></li>
    </ul>


</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>
