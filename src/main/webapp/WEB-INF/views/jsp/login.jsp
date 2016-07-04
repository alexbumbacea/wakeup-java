<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Wake on LAN</title>

    <spring:url value="/resources/css/main.css" var="coreCss"/>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WOL JAVA</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="/autodiscovery">Autodiscovery</a></li>
        </ul>
        <ul class="nav navbar-nav pull-right">
            <li><a href="#">${pageContext.request.userPrincipal.name}</a> </li>
            <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a> </li>
        </ul>
    </div>
</nav>

<div class="container">
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="alert alert-info">${msg}</div>
    </c:if>

    <form name='loginForm'
          action="<c:url value='j_spring_security_check' />" method='POST'>

        <table>
            <tr>
                <td>User:</td>
                <td><input class="input-lg" type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input class="input-lg" type='password' name='password' /></td>
            </tr>
            <tr>
                <td colspan='2'><input class="btn btn-primary" name="submit" type="submit"
                                       value="submit" /></td>
            </tr>
        </table>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />

    </form>
</div>
<spring:url value="/resources/css/hello.js" var="coreJs"/>
<spring:url value="/resources/css/bootstrap.min.js" var="bootstrapJs"/>

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>