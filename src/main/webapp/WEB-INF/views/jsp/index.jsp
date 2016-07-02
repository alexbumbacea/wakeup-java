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
    </div>
</nav>

<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Name</th>
            <th class="hidden-phone hidden-tablet">Type</th>
            <th>IP</th>
            <th class="hidden-phone hidden-tablet">MAC</th>
            <th colspan="2">Actions</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${computers}" var="computer">
                <tr>
                    <td>${computer.name}</td>
                    <td>${computer.type}</td>
                    <td>${computer.IP}</td>
                    <td>${computer.MAC}</td>
                    <td>
                        <a class="btn btn-primary" href="">Wake</a>
                        <a class="btn btn-default" href="">Check</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
</div>
<spring:url value="/resources/css/hello.js" var="coreJs"/>
<spring:url value="/resources/css/bootstrap.min.js" var="bootstrapJs"/>

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>