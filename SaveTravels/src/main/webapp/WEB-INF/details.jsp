<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row text-center mb-3">
			<h1>Expense details</h1>
			<a href="/expenses">Go back</a>
		</div>
		<p>Expense name: <c:out value="${location.expense}"/></p>
		<p>Expense description: <c:out value="${location.description}"/></p>
		<p>Expense vendor: <c:out value="${location.vendor}"/></p>
		<p>Expense cost: $<c:out value="${location.amount}"/></p>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>