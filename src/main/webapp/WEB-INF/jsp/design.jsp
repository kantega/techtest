<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <title>Kantega testing workshop - ${title}</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/blog.css">
    <style type="text/css">
        body {
            <c:if test="${not empty backgroundColor}">
                background-color: ${backgroundColor};
            </c:if>
        }
    </style>
    ${head}
</head>

<body>
<div class="status">
<a href="<%=request.getContextPath()%>/status">Status</a>
<a href="<%=request.getContextPath()%>/admin">Admin</a>
<c:if test="${sessionScope.admin != null}">
    <a href="<%=request.getContextPath()%>/logout">Log out</a>
</c:if>
</div>
${main}
</body>
</html>