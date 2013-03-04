<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="title" value="Blogs" scope="request"/>

<c:set var="head" scope="request">
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/markdown.js"></script>
    <script type="text/javascript">

        window.addEventListener("load", function(e) {

            var contents = document.querySelectorAll("script.content");

            for(var i = 0, l = contents.length; i < l; i++) {
                var script = contents[i];
                var markup = markdown.toHTML(script.innerHTML)
                var div = document.createElement("div")
                div.innerHTML = markup;
                script.parentNode.replaceChild(div, script);
            }


            function commentLinkClicked(event) {
                var postId = event.target.getAttribute("postId");
                document.querySelector("#commentFor_" + postId).style.display = 'inline-block';
                event.target.parentNode.removeChild(event.target);
                event.preventDefault()

            }

            var commentLinks = document.querySelectorAll("a.formCommentLink");

            for(var i = 0, l = commentLinks.length; i < l; i++) {
                var link = commentLinks[i];
                link.addEventListener("click", commentLinkClicked);
            }
        });


    </script>
</c:set>

<c:set var="backgroundColor" value="${post.blog.color}" scope="request"/>

<c:set var="main" scope="request">


            <h2>${post.title} ${post.blogPostId}</h2>

        <p class="publishDate">Published ${post.getPublishDateInFormat('yyyy-MM-dd HH:mm')}</p>
        <script type="text/html" class="content"><c:out value="${post.content}"/></script>
        <p class="numComments">

            <c:choose>
                <c:when test="${post.commentCount == 0}">
                    Zero comments. <a href="#" class="formCommentLink" postId="${post.blogPostId}">Be the first to comment!</a>
                </c:when>
                <c:otherwise>
                    ${post.commentCount} comments:
                    <a href="#" class="formCommentLink" postId="${post.blogPostId}">Add a comment</a>
                </c:otherwise>
            </c:choose>
        </p>
        <div class="commentForm" id="commentFor_${post.blogPostId}">
            <form action="${blog.linkId}" method="post">
                <input type="hidden" name="blogPostId" value="${post.blogPostId}">
                <label for="commentAuthor">Who are you</label>: <input id="commentAuthor" name="commentAuthor" type="text" size="80" value="John Doe">
                <br>
                <textarea name="content" cols="80" rows="10">I really like...</textarea>
                <br>
                <input type="submit" value="Add comment">
            </form>
        </div>

    <c:forEach var="comment" items="${comments}">
        <div class="comment">
            <strong>${comment.author} said:</strong> (${post.getPublishDateInFormat('yyyy-MM-dd HH:mm')})
            <p>
                <c:out value="${comment.content}"/>
            </p>
        </div>
    </c:forEach>
</c:set>



<jsp:include page="design.jsp"/>