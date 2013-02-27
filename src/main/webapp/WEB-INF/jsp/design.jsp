<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <title>${title}</title>
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
${main}
</body>
</html>