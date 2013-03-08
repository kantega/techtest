<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Blogs" scope="request"/>

<c:set var="head" scope="request">
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/markdown.js"></script>
    <script type="text/javascript">

        window.addEventListener("load", function(e) {
            function updatePreview() {
                document.querySelector("#contentPreview").innerHTML = markdown.toHTML(document.querySelector("#content").value);
                document.querySelector("#titlePreview").innerHTML = document.querySelector("#title").value;
            }

            function commentLinkClicked(event) {
                var postId = event.target.getAttribute("data-postId");
                document.querySelector("#commentFor_" + postId).style.display = 'inline-block';
                event.target.parentNode.removeChild(event.target);
                event.preventDefault()

            }
            document.querySelector("#content").addEventListener("keyup", updatePreview);
            document.querySelector("#title").addEventListener("keyup", updatePreview);

            document.querySelector("#content").innerHTML = document.querySelector("#defaultContent").innerHTML;
            updatePreview();

            var contents = document.querySelectorAll("script.content");

            for(var i = 0, l = contents.length; i < l; i++) {
                var script = contents[i];
                var markup = markdown.toHTML(script.innerHTML)
                var div = document.createElement("div")
                div.innerHTML = markup;
                script.parentNode.replaceChild(div, script);
            }

            var commentLinks = document.querySelectorAll("a.formCommentLink");

            for(var i = 0, l = commentLinks.length; i < l; i++) {
                var link = commentLinks[i];
                link.addEventListener("click", commentLinkClicked);
            }
        });


    </script>
    <script type="text/html" id="defaultContent">
Something __really__ weird happend today on my way to school:

* First I fell off my bike
* Then my phone started ringing..

</script>

</c:set>

<c:set var="backgroundColor" value="${blog.color}" scope="request"/>

<c:set var="main" scope="request">


    <h1>${blog.name}</h1>

    <p class="ingress">
        <a href="#" onclick="this.style.display='none';document.querySelector('#postform').style.display='block'">+ New blog post</a>
    </p>
    <div id="postform" style="display: none">
        <form action="${blog.linkId}" method="POST">
                    <fieldset>
                        <legend>New blog post</legend>
                        <p>
                        <label for="title">Title:</label> <input id="title" name="title" size="60" value="My new blogpost">
                        </p>

                            <textarea name="content" style="width:100%;height: 10em" id="content"></textarea>
                        <p>
                        <input type="submit" value="Save">
                        </p>

                        <div class="previewPane">
                            <p>Preview:</p>
                            <h2 id="titlePreview"></h2>
                            <div id="contentPreview"></div>
                        </div>
                    </fieldset>

                </form>




    </div>

    <c:forEach var="post" items="${posts}">

        <h2>
            <a href="<%=request.getContextPath()%>/blog/${post.blog.linkId}/${post.linkId}">${post.title}</a>
        </h2>
        <p class="publishDate">Published ${post.getPublishDateInFormat('yyyy-MM-dd HH:mm')}</p>
<script type="text/html" class="content"><c:out value="${post.content}"/></script>
        <p class="numComments">

            <c:choose>
                <c:when test="${post.commentCount == 0}">
                    Zero comments. <a href="#" class="formCommentLink" data-postId="${post.blogPostId}">Be the first to comment!</a>
                </c:when>
                <c:otherwise>
                    <a href="">${post.commentCount} comments.</a>
                    <a href="#" class="formCommentLink" data-postId="${post.blogPostId}">Add a comment</a>
                </c:otherwise>
            </c:choose>
        </p>
        <div class="commentForm" id="commentFor_${post.blogPostId}">
            <form action="${blog.linkId}/${post.linkId}" method="post">
                <p>
                <label for="commentAuthor_${post.blogPostId}">Who are you</label>: <input id="commentAuthor_${post.blogPostId}" name="commentAuthor" type="text" size="80" value="John Doe">
                </p>

                <textarea name="content" cols="80" rows="10">I really like...</textarea>
                <p>
                <input type="submit" value="Add comment">
                </p>
            </form>
        </div>
    </c:forEach>
</c:set>



<jsp:include page="design.jsp"/>