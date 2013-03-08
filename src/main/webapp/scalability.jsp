<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Scalability" scope="request"/>

<c:set var="main" scope="request">
    <h1>Scalability</h1>
    

    <p class="ingress">Jørgen's new blogpost hit Slashdot, but we are just hanging.</p>
        
    <div class="email">
        <div class="mailheader">
            <p><b>From:</b> A Reader &lt;anonymous@gmail.com&gt;</p>
            <p><b>To:</b> Web Admin &lt;admin@eiriksgfashionblog.com&gt;</p>
            <p><b>Date:</b> 2012-03-08 12:13:14</p>
            <p><b>Subject:</b> Slashdot effect!</p>
        </div>

        <div class="mailbody">
            <p>Hi,</p> 

            <p>I wanted to read Jørgen's new cool blog about band music which
               I found a reference to from Slashdot, but unfortunately your
               web page doesn't respond.</p>

            <p>Please fix ASAP, as I can't wait to read it!</p>
            
            <p>Regards,<br/> 
            Anonymous Reader</p>
          </div>
    </div>
    
    <h2>Task</h2>
    
    <p>Write a performance test uses the <a href="loadProfile.jsp">load profile</a> and check how many simultaneous users we can handle within the <a href="sla.jsp">SLA</a>.</p>
    
    <p class="tip">Start with a few users.</p>
    
    <p class="tip">
        Database connection pool too small? Locking? Too synchronized?
        Show status page?
    </p>

    <ul>
       <li>Users: Synchronize db pool</li>
       <li>Volume: n+1 select - get blog posts</li>
    </ul>

    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>