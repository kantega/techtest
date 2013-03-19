<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Concurrency" scope="request"/>

<c:set var="main" scope="request">
    <h1>Concurrency</h1>
    <p class="difficulty">
        <b>Difficulty: </b><span class="star-2">2</span><br/>
        <b>Time: </b><span class="clock-2">2</span>
    </p>

    <p class="ingress">Lately we have been seeing an increasing amount of emails like the one below, especially during lunch hour.
        We think this might happen more often now that we have gotten increased usage with new and popular blogs.</p>

    <div class="email">
        <div class="mailheader">
            <p><b>From:</b> Fashin Freak &lt;fashion.freak@gmail.com&gt;</p>
            <p><b>To:</b> Web Admin &lt;admin@eiriksgfashionblog.com&gt;</p>
            <p><b>Date:</b> 2012-03-08 12:13:14</p>
            <p><b>Subject:</b> I did not say that!</p>
        </div>

        <div class="mailbody">
            <p>Hi,</p>

            <p>I was trying to comment on Eiriks blog post about his new dress, but when I posted
                suddenly some other comment came in place of mine.</p>

            <p>The webpage says that I said Eirik looks so good in the new polka-dot dress, but
               that is not what I wrote! In fact I think it made him look fat and old.
               It is only my comment that is changed - not my name - so it looks like I have
               written the comment :(</p>

            <p>This is the second time this happens to me during lunch hour. It never happens
                other times of the day.</p>

            <p>If I can't post comments on fashion blogs and be taken seriously my life falls to pieces.</p>

            <p>Regards,<br/> 
            Fashonista</p>
          </div>
    </div>
    
    <h2>Task</h2>
    
    <p>Write a performance test that checks what happens when several comments are written simultaneously.</p>
    
    <p class="tip">Remember to check that they can read their own comment.</p>
    
    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>