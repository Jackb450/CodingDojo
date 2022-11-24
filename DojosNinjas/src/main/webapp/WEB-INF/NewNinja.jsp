<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row text-center mb-3">
			<h1>New ninja</h1>
			<a href="/dojos">Go back to Dash board</a>
		</div>
		<form:form action='/dojos/new/ninja' method='POST' modelAttribute="newNinja">
			<p>
				<form:select path="dojo">
					<c:forEach var="eachDojo" items="${dojos}">
						<form:option value="${eachDojo.id}">
							<c:out value="${eachDojo.name}"></c:out>
						</form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				<form:errors path="fName" />
				<form:label path="fName">First name:</form:label>
				<form:input path="fName" />
			</p>
			<p>
				<form:errors path="lName" />
				<form:label path="lName">Last name:</form:label>
				<form:input path="lName" />
			</p>
			<p>
				<form:errors path="age" />
				<form:label path="age">Age:</form:label>
				<form:input path="age" />
			</p>
			<input type="submit" value="Add Ninja" />
		</form:form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>