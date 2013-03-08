<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Create a blog" scope="request"/>

<c:set var="main" scope="request">
    <h1>Create a blog</h1>

    <ul>
        <li>Create your own blog</li>
        <li>Write a blog post</li>
        <li>Comment on it!</li>
        <li>Log in as administrator</li>
        <li>Delete a blog</li>
    </ul>


    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>