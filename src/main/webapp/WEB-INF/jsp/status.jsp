<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="title" value="System status" scope="request"/>

<c:set var="main" scope="request">

    <h1>System status</h1>

    <h2>Database</h2>
<table id="dataSourceInfo" summary="information about database system resource usage">
    <tr>
        <td>Datasource:</td>
        <td>${dataSource['class'].simpleName}</td>
    </tr>
    <tr>
        <td>maxActive:</td>
        <td>${dataSource.maxActive}</td>
    </tr>
    <tr>
        <td>numActive:</td>
        <td>${dataSource.numActive}</td>
    </tr>
    <tr>
        <td>numIdle:</td>
        <td>${dataSource.numIdle}</td>
    </tr>
</table>

    <h2>Memory</h2>

<table summary="information about used memory">
    <tr>
        <th>Mem</th>
        <th>Used</th>
        <th>Committed</th>
        <th>Max</th>
    </tr>

    <tr>
        <td>
            Heap
        </td>
        <td class="numeric">
            <fmt:formatNumber value="${memory.heapMemoryUsage.used/1024/1024}"/>
        </td>
        <td class="numeric">
            <fmt:formatNumber value="${memory.heapMemoryUsage.committed/1024/1024}"/>
        </td>
        <td class="numeric">
            <fmt:formatNumber value="${memory.heapMemoryUsage.max/1024/1024}"/>
        </td>

    </tr>
    <tr>
        <td>
            Non-heap
        </td>
        <td class="numeric">
            <fmt:formatNumber value="${memory.nonHeapMemoryUsage.used/1024/1024}"/>
        </td>
        <td class="numeric">
            <fmt:formatNumber value="${memory.nonHeapMemoryUsage.committed/1024/1024}"/>
        </td>
        <td class="numeric">
            <fmt:formatNumber value="${memory.nonHeapMemoryUsage.max/1024/1024}"/>
        </td>

    </tr>

</table>

    <h2>Sessions</h2>
    <p>Current active sessions: ${activeSessionCount}</p>
    <p>Total sessions created: ${totalSessionCount}</p>
    <form action="status" method="POST">
        <input type="submit" name="invalidateSessions" value="Invalidate sessions" >
    </form>
</c:set>

<jsp:include page="design.jsp"/>