<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Welcome" scope="request"/>

<c:set var="main" scope="request">
    <h1>Testing workshop</h1>


    <a href="blogs">Blogs</a>


    <h2>Tasks:</h2>

    <h3>Task 0: Tools</h3>
    <ul>

        <li><a href="http://jmeter.apache.org">http://jmeter.apache.org</a></li>
        <li><a href="http://visualvm.java.net">http://visualvm.java.net</a></li>

    </ul>
    <h3>Task 1: Create a blog!</h3>
    <ul>
        <li>Create your own blog</li>
        <li>Write a blog post</li>
        <li>Comment on it!</li>
    </ul>


    <h3>Interlude</h3>
    <p>Instructions on how to write simple read-only test to open index, go to own blog, open a comment. HTTP GET.</p>
    <p>Introduce: Thread groups, reports, samplers, assertions, http common. Not cookie managers!</p>

    <h3>Task 2: Measure simple, single threaded performance</h3>

    <p>Getting to know the application and using JMeter</p>
    <p>Expand the test from the interlude to add posts and comments</p>

    <h3>Task 3: Scalability</h3>

    <p>
        Database connection pool too small? Locking? Too synchronized?
        Show status page?
    </p>
        <ul>
           <li>Users: Synchronize db pool</li>
           <li>Volume: n+1 select</li>
        </ul>

    <h3>Task 4: Stability</h3>

    <p>
        Memory leaks with session? Use of Cookie manager.
        Show JVisual VM.
    </p>

    <h3>Task 5: Fault tolerance testing</h3>

    <p>
        Create a JMeter test which demonstrates <a href="https://issues.apache.org/jira/browse/DBCP-28">this issue</a>.
        The test should run database-dependent code with moderate load while the database is restarted.
        Keep an eye on the <a href="status">status page</a> to see what happens with the connection pool.
    </p>

    <h3>Task 6: Concurrency</h3>

    <p>
        What happens when two or more users try to post comments concurrently?
    </p>

</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>
