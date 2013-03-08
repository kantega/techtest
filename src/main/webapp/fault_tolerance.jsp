<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Fault Tolerance" scope="request"/>

<c:set var="main" scope="request">
    <h1>Fault Tolerance</h1>
    
    <h2>Introduction</h2>
    
    <p>When we put the blog in production, and started taking backup of the database, we found a problem.</p>
        
    <tt class="email">
        <div class="mailheader">
            <p><b>From:</b> BOFH &lt;it_ops@blogprovider.com&gt;</p>
            <p><b>To:</b> Blog Software Development Team &lt;blogs@development.com&gt;</p>
            <p><b>Date:</b> 2012-03-14 12:13:37</p>
            <p><b>Importance: </b>High!</p>
            <p><b>Subject:</b> Nightly crashes of blog in prod!</p>
        </div>

        <div class="mailbody">
            <p>Hi,</p> 

            <p>The freaking blog software crashes every night!</p>

            <p>It didn't do this while in test and QA environments.</p>

            <p>The application seems to be running (status page tells load 
               balancer everything is OK), but doesn't respond to HTTP
               requests to show blogs (no reply, just hangs).</p>
            
            <p>Regards,<br/> 
            BOFH</p>
          </div>
    </tt>
    
    <h2>Task</h2>
    
    <p>Run a performance test while you stop and start the database to
       reproduce the problem of stopped database during nightly backup.</p>
    
    <p class="tip">Pressing enter in the "mvn exec:java" shell stops the database.</p>
    
    <p class="tip">
        Create a JMeter test which demonstrates <a href="https://issues.apache.org/jira/browse/DBCP-28">this issue</a>.
        The test should run database-dependent code with moderate load while the database is restarted.
        Keep an eye on the <a href="status">status page</a> to see what happens with the connection pool.
    </p>
    
    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>