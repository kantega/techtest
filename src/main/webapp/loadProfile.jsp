<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Welcome" scope="request"/>

<c:set var="main" scope="request">
    <h1>Load Profile</h1>
    
    <h2>User behaviour</h2>
    
    <p>
        After analysing logs in the production environment, the following characteristics represent how the
        users/administrators are using the application.
    </p>
    <ul>
        <li>Almost every user requesting the frontpage, continues on to a specific blog.</li>
        <li>Having accessed a specific blog, around 50 percent create a blog post.</li>
        <li>Around 80 percent makes a comment on an already existing blog post.</li>
        <li>Only 10 percent of the users creates a new blog when visiting the application.</li>
        <li>After logging in, administrators read in average one blog per login.</li>
        <li>Administrators delete in average one blog per 20 login.</li>
        <li>One third of the administrators log out.</li>
    </ul>

    <h2>Statistics</h2>
    
    <p>The following statistics are also taken from the production environment, over a period of 1 hour.</p>
    
    <table border="1">
        <tr>
            <th>URL</th>
            <th>Request count</th>
        </tr>
        <tr>
            <td>/blogs (Frontpage)</td>
            <td>2501</td>
        </tr>
        <tr>
            <td>/blogs (Create blog)</td>
            <td>240</td>
        </tr>
        <tr>
            <td>/blog/... (Access existing blog)</td>
            <td>2707</td>
        </tr>
        <tr>
            <td>/blog/... (Create blog post)</td>
            <td>1244</td>
        </tr>
        <tr>
            <td>/blog/.../... (Comment blog post)</td>
            <td>2019</td>
        </tr>
        <tr>
            <td>/admin (Access admin page)</td>
            <td>198</td>
        </tr>
        <tr>
            <td>/login (Administrators logging in)</td>
            <td>191</td>
        </tr>
        <tr>
            <td>/blogs?delete=... (Administrators deleting blog)</td>
            <td>11</td>
        </tr>
        <tr>
            <td>/logout (Administrators loggin out)</td>
            <td>63</td>
        </tr>
    </table>
    
    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>