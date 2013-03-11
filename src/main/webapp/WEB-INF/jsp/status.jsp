<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="title" value="System status" scope="request"/>

<c:set var="main" scope="request">

    <h1>System status</h1>

    <h2>Database</h2>
<table id="dataSourceInfo" class="datatable" summary="information about database system resource usage">
    <tr>
        <th>Datasource:&nbsp;</th>
        <td>${dataSource['class'].simpleName}</td>
    </tr>
    <tr>
        <th>Max active connections:&nbsp;</th>
        <td>${dataSource.maxActive}</td>
    </tr>
    <tr>
        <th>Active connections:&nbsp;</th>
        <td>${dataSource.numActive}</td>
    </tr>
    <tr>
        <th>Idle connections:&nbsp;</th>
        <td>${dataSource.numIdle}</td>
    </tr>
</table>

    <h2>Memory</h2>

<table class="datatable" summary="information about used memory">
    <thead>
    <tr>
        <th>Mem</th>
        <th>Used</th>
        <th>Committed</th>
        <th>Max</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th>
            Heap
        </th>
        <td class="number">
            <fmt:formatNumber maxFractionDigits="3" minFractionDigits="3" value="${memory.heapMemoryUsage.used/1024/1024}"/>
        </td>
        <td class="number">
            <fmt:formatNumber maxFractionDigits="3" minFractionDigits="3" value="${memory.heapMemoryUsage.committed/1024/1024}"/>
        </td>
        <td class="number">
            <fmt:formatNumber maxFractionDigits="3" minFractionDigits="3" value="${memory.heapMemoryUsage.max/1024/1024}"/>
        </td>

    </tr>
    <tr>
        <th>
            Non-heap
        </th>
        <td class="number">
            <fmt:formatNumber maxFractionDigits="3" minFractionDigits="3" value="${memory.nonHeapMemoryUsage.used/1024/1024}"/>
        </td>
        <td class="number">
            <fmt:formatNumber maxFractionDigits="3" minFractionDigits="3" value="${memory.nonHeapMemoryUsage.committed/1024/1024}"/>
        </td>
        <td class="number">
            <fmt:formatNumber maxFractionDigits="3" minFractionDigits="3" value="${memory.nonHeapMemoryUsage.max/1024/1024}"/>
        </td>
    </tr>
    </tbody>
</table>

    <h2>Sessions</h2>
    <table class="datatable">
        <tr>
            <th>
                Current active sessions:
            </th>
            <td class="number">
                    ${activeSessionCount}
            </td>
        </tr>
        <tr>
            <th>
                Total sessions created:
            </th>
            <td class="number">
                ${totalSessionCount}
            </td>
        </tr>
    </table>

    <form action="status" method="POST">
        <p>
        <input type="submit" name="invalidateSessions" value="Invalidate sessions" >
        </p>
    </form>
</c:set>

<jsp:include page="design.jsp"/>