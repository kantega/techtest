<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Welcome" scope="request"/>

<c:set var="main" scope="request">
    <h1>Workshop: Introduction to Technical Testing</h1>

    <p class="ingress">
        In this workshop, we give you a seemingly functional <a href="blog">blog application</a>. By running, writing and testing with automated
        load tests you'll discover that the system is buggy, unstable and just doesn't scale! Well'll then show you
        tools and techniques which will help you in identifying common classes of bugs, how to resolve them and how
        to verify that the situation actually improved
    </p>
    <h2>Resources</h2>
    <ul>
        <li><a href="tools.jsp">Tools</a></li>
        <li><a href="loadProfile.jsp">Load Profile</a></li>
        <li><a href="sla.jsp">Service Level Agreement (SLA)</a></li>
        <li><a href="documentation.jsp">Documentation</a></li>
    </ul>
    
    <h2>Tasks:</h2>

    <h3>Task 1: Create a blog!</h3>
    <ul>
        <li>Create your own blog</li>
        <li>Write a blog post</li>
        <li>Comment on it!</li>
        <li>Log in as administrator</li>
        <li>Delete a blog</li>
    </ul>

    <h3>Interlude</h3>
    <p>Instructions on how to write simple read-only test to open index, go to own blog, open a comment. HTTP GET.</p>
    <p>Introduce: Thread groups, reports, samplers, assertions, http common. Not cookie managers!</p>
    <p>Log in/out</p>

    <h3>Task 2: Measure simple, single threaded performance</h3>

    <p>Getting to know the application and using JMeter</p>
    <p>
        Expand the test from the interlude to add posts and comments, according to the
        <a href="loadProfile.jsp">load profile</a>
    </p>
    
    <h3>Interlude</h3>
    <p>We must post data (comments), and check that the data vi posted is the one we are getting. (Kenneth)</p>

    <h3>Task 3: <a href="concurrency.jsp">Concurrency</a></h3>

    <h3>Task 4: <a href="fault_tolerance.jsp">Fault tolerance testing</a></h3>

    <h3>Task 5: <a href="scalability.jsp">Scalability</a></h3>

    <h3>Task 6: <a href="stability.jsp">Stability</a></h3>


</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>
