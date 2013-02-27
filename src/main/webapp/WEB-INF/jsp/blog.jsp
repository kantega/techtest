<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="title" value="Blogs" scope="request"/>

<c:set var="head" scope="request">
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/markdown.js"></script>
    <script type="text/javascript">

        window.addEventListener("load", function(e) {
            function updatePreview() {
                document.querySelector("#contentPreview").innerHTML = markdown.toHTML(document.querySelector("#content").value);
                document.querySelector("#titlePreview").innerText = document.querySelector("#title").value;
            }

            function commentLinkClicked(event) {
                var postId = event.target.getAttribute("postId");
                document.querySelector("#commentFor_" + postId).style.display = 'inline-block';
                event.target.parentNode.removeChild(event.target);
                event.preventDefault()

            }
            document.querySelector("#content").addEventListener("keyup", updatePreview);
            document.querySelector("#title").addEventListener("keyup", updatePreview);

            document.querySelector("#content").innerText = document.querySelector("#defaultContent").innerText;
            updatePreview();

            var contents = document.querySelectorAll("script.content");

            for(var i = 0, l = contents.length; i < l; i++) {
                var script = contents[i];
                var markup = markdown.toHTML(script.innerText)
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
    <style type="text/css">
        .previewPane {
            border: 1px solid gray;
            background-color: #fffafa;
            padding: 1em;

        }

        td {
            vertical-align: top;
        }
    </style>
</c:set>

<c:set var="backgroundColor" value="${blog.color}" scope="request"/>

<c:set var="main" scope="request">

    <h1>${blog.name}</h1>

    <a href="#" onclick="this.style.display='none';document.querySelector('#postform').style.display='block'">+ New blog post</a>
    <div id="postform" style="display: none">
    <table style="width:100%">
        <tr>
            <td style="width: 50%">
                <form action="${blog.linkId}" method="POST">
                    <fieldset>
                        <legend>New blog post</legend>
                        <label for="title">Title:</label> <input id="title" name="title" size="60" value="My new blogpost">
                        <br>
                            <textarea name="content" cols="80" rows="10" id="content"></textarea>
                        <br>
                        <input type="submit" value="Save">

                    </fieldset>

                </form>
            </td>

            <td style="width: 50%">
                <div class="previewPane">
                    <h2 id="titlePreview"></h2>
                    <div id="contentPreview"></div>
                </div>
            </td>
        </tr>
    </table>

    </div>

    <c:forEach var="post" items="${posts}">

        <a href="<%=request.getContextPath()%>/blog/${post.blog.linkId}/${post.linkId}">
            <h2>${post.title} ${post.blogPostId}</h2>
        </a>
        <p class="publishDate">Published ${post.getPublishDateInFormat('yyyy-MM-dd HH:mm')}</p>
<script type="text/html" class="content"><c:out value="${post.content}"/></script>
        <p class="numComments">

            <c:choose>
                <c:when test="${post.commentCount == 0}">
                    Zero comments. <a href="#" class="formCommentLink" postId="${post.blogPostId}">Be the first to comment!</a>
                </c:when>
                <c:otherwise>
                    <a href="">${post.commentCount} comments.
                    <a href="#" class="formCommentLink" postId="${post.blogPostId}">Add a comment</a>
                </c:otherwise>
            </c:choose>
        </p>
        <div class="commentForm" id="commentFor_${post.blogPostId}">
            <form action="${blog.linkId}/${post.linkId}" method="post">
                <label for="commentAuthor">Who are you</label>: <input id="commentAuthor" name="commentAuthor" type="text" size="80" value="John Doe">
                <br>
                <textarea name="content" cols="80" rows="10">I really like...</textarea>
                <br>
                <input type="submit" value="Add comment">
            </form>
        </div>
    </c:forEach>
</c:set>



<jsp:include page="design.jsp"/>