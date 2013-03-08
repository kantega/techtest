<%@page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="title" value="FAIL!" scope="request"/>

<c:set var="main" scope="request">

    <h1>¡Ay, caramba!</h1>

    <p class="ingress">
        We seem to have crashed..
    </p>

    <img src="/assets/bitmaps/whale.jpg" class="failwhale">

    <p>The following stack trace might give you a hint why:</p>
    <div class="stacktrace"><pre><c:out value="${stackTrace}"/></pre></div>

</c:set>

<jsp:include page="design.jsp"/>