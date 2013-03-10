<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Welcome" scope="request"/>

<c:set var="main" scope="request">
    <h1>Load Profile</h1>
    
    <h2>User behavior</h2>
    <p>
        After analyzing logs in the production environment, the following characteristics represent how the
        users/administrators are using the application.
    </p>
    <ul>
        <li>Almost every user requesting the frontpage, continues on to a specific blog.</li>
        <li>Having accessed a specific blog, around 50 percent create a blog post.</li>
        <li>On average, users write two comments during a session.</li>
        <li>Only 10 percent of the users creates a new blog when visiting the application.</li>
        <li>The number of requests from administrators is around 10 percent of the total number of requests.</li>
        <li>After logging in, administrators read in average one blog per login.</li>
        <li>Administrators delete in average one blog per 20 login.</li>
        <li>One third of the administrators log out.</li>
    </ul>

    <h2>Statistics</h2>
    
    <p>The following statistics are also taken from the production environment, over a period of 1 hour.</p>
    
    <table class="datatable">
        <thead>
        <tr>
            <th>URL</th>
            <th>HTTP Verb</th>
            <th>Description</th>
            <th>Request count</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>/blogs</th>
            <td>GET</td>
            <td>Frontpage</td>
            <td class="number">31378</td>
        </tr>
        <tr>
            <th>/blogs</th>
            <td>POST</td>
            <td>Create Blog</td>
            <td class="number">2849</td>
        </tr>
        <tr>
            <th>/blog/&lt;blogid&gt;</th>
            <td>GET</td>
            <td>Access existing blog</td>
            <td class="number">31087</td>
        </tr>
        <tr>
            <th>/blog/&lt;blogid&gt;</th>
            <td>POST</td>
            <td>Create blog post</td>
            <td class="number">13680</td>
        </tr>
        <tr>
            <th>/blog/&lt;blogid&gt;?commentAuthor=&lt;author&gt;</th>
            <td>POST</td>
            <td>Add comment to blog post</td>
            <td class="number">44933</td>
        </tr>
        <tr>
            <th>/admin</th>
            <td>GET</td>
            <td>Access admin page</td>
            <td class="number">3051</td>
        </tr>
        <tr>
            <th>/login</th>
            <td>GET</td>
            <td>Show login form</td>
            <td class="number">2987</td>
        </tr>
        <tr>
            <th>/login</th>
            <td>POST</td>
            <td>Administrator logging in</td>
            <td class="number">2986</td>
        </tr>
        <tr>
            <th>/blogs?delete=&lt;blogid&gt;</th>
            <td>POST</td>
            <td>Administrator deleting blog</td>
            <td class="number">141</td>
        </tr>
        <tr>
            <th>/logout</th>
            <td>GET</td>
            <td>Administrator logging out</td>
            <td class="number">960</td>
        </tr>
        </tbody>
    </table>
    
    <br/>
    
    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>