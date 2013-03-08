<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="title" value="System status" scope="request"/>

<c:set var="main" scope="request">

    <h1>Most visited blogs</h1>

    <p class="ingress">Who has the most popular blog..?</p>
    <table>
        <tr>
            <th>Blog</th>
            <th>Visits</th>
        </tr>

    <c:forEach items="${highscore}" var="line">
        <tr>
            <td>${line.blog.name}</td>
            <td class="numeric">${line.visits}</td>
        </tr>
    </c:forEach>
    </table>
</c:set>

<jsp:include page="design.jsp"/>