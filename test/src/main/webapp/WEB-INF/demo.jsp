<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
<link rel="stylesheet" type="text/css" href="/css/demo.css">
<script type="text/javascript" src="/js/demo.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/demo.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h3>Hello World!</h3>
	<h1>test 1</h1>
	<% for(int i = 0; i < 5; i++) { %><p><%= i %></p><% } %>
    <h1>jsp import test</h1>
    <p>The time is: <%= new Date() %></p>
    <h1>jstl test</h1>
    <p>Two plus two is: <c:out value="${2+2}"/></p>
	<h1>Model.AddAtttribute</h1>
	<p><c:out value="${fruit}"/></p>
	<h3>String Model.AddAttribute</h3>
	<p><c:out value="${FName}"/> <c:out value="${LName}"/></p>
	<p><c:out value="${Email}"/></p>
	<p><c:out value="${Age}"/></p>
	<h1>Arrays dojos</h1>
    <c:forEach var="oneDojo" items="${dojosFromMyController}">
        <p><c:out value="${oneDojo}"></c:out></p>
    </c:forEach>
    <h1>Session</h1>
    <p><c:out value="${Count}"/></p>
</body>
</html>