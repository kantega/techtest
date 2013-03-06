<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="main" scope="request">

    <h1>You are now logged in as an administrator.</h1>

    Back to the <a href="/blogs">blogs</a>.

</c:set>

<jsp:include page="design.jsp"/>