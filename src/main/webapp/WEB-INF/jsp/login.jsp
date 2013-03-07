<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Login" scope="request"/>

<c:set var="main" scope="request">

    <h2>Log in</h2>

    <table style="width:100%">
        <tr>
            <td style="width: 50%">
                <form action="/login" method="POST">
                    <fieldset>
                        <p>
                            <label for="username">Username</label><br/>
                            <input class="text" type="text" id="username" name="username"/>
                        </p>
                        <p>
                            <label for="password">Password</label><br/>
                            <input class="text" type="password" id="password" name="password"/>
                        </p>
                        <button type="submit" id="formSubmitButton" class="button positive">
                            <img src="/css/blueprint/plugins/buttons/icons/tick.png" alt=""/>Log in
                        </button>
                    </fieldset>
                </form>
            </td>
        </tr>
    </table>
</c:set>

<jsp:include page="design.jsp"/>