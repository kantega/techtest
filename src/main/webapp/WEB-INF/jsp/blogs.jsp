<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Blogs" scope="request"/>
<c:set var="main" scope="request">


    <h1>SuperBlog</h1>
    <p class="ingress">
        Welcome to Superblog!
    </p>
    <form action="blogs" method="POST">
        <fieldset style="width: 500px">
            <legend>Create new blog</legend>

            <table summary="data entry for creating new blog">
                <tr>
                    <td>
                        Name:
                    </td>
                    <td>
                        <input type="text" name="blogname">
                        <c:if test="${nameIsMissing}">
                            <span class="missingField">Name is required!</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>Color:</td>
                    <td>
                        <select name="color">
                            <option value="#ffc0cb">#ffc0cb</option>
                            <option value="#87ceeb">#87ceeb</option>
                            <option value="#ffffe0">#ffffe0</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create"></td>
                </tr>
            </table>

            <br>




        </fieldset>
    </form>

    <p>Found ${blogs.size()} blogs:</p>

<ul>
    <c:forEach items="${blogs}" var="blog">
        <li>
            <a href="blog/${blog.linkId}">${blog.name}</a>
            <c:if test="${sessionScope.admin != null}">
                <a href="/blogs?delete=${blog.name}">Delete</a>
            </c:if>
        </li>
    </c:forEach>

</ul>
</c:set>



<jsp:include page="design.jsp"/>