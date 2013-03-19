<%@page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Scalability" scope="request"/>

<c:set var="main" scope="request">
    <h1>Volume</h1>
    <p class="difficulty">
        <b>Difficulty: </b><span class="star-2">2</span><br/>
        <b>Time: </b><span class="clock-2">2</span>
    </p>

    <p class="ingress">Some of out bloggers are on stereoids. We think it is because of the
       new feature to automatically get instagrams and tweets up as blog
       posts. Øysteins "what I ate for dinner taken with a crappy camera"-blog
       is one of the blogs that get most frequently updated with new posts.</p>
        
    <div class="email">
        <div class="mailheader">
            <p><b>From:</b> Hungry &lt;hungry@hippo.com&gt;</p>
            <p><b>To:</b> Editor &lt;mail@blogplatform.com&gt;</p>
            <p><b>Date:</b> 2012-03-08 12:13:14</p>
            <p><b>Subject:</b> Slow food :(</p>
        </div>

        <div class="mailbody">
            <p>Hi,</p> 

            <p>OMG! Øysteins "what I ate for dinner taken with a crappy camera"-blog is so cool!.</p>

            <p>Alas, lately it has also become so slow :( :( :'-(</p> 
            
            <p>Regards,<br/> 
            Hungry</p>
          </div>
    </div>
    
    <h2>Task</h2>
    
    <p>Write a performance test that measures the performance on the blog posts page after lots of posts has been added.</p>
    
    <p class="tip">Insert lots of blog posts.</p>
    
    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>