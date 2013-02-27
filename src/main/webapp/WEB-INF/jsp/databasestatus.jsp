<%@ page import="org.apache.commons.dbcp.BasicDataSource" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="static no.kantega.blog.services.Services.getService" %>
<%
    DataSource dataSource = getService(DataSource.class, config.getServletContext());
    if(dataSource != null && dataSource instanceof BasicDataSource) {
        pageContext.setAttribute("dataSource", (BasicDataSource)dataSource);
    }
%>

<table id="dataSourceInfo">
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