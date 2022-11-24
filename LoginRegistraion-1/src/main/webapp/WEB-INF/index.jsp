<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginReg</title>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row text-center mb-3">
			<h1>Welcome</h1>
		</div>
		<div class="container d-flex justify-content-between">
			<div>
				<h1>Register</h1>
				<form:form action='/register' method='POST' modelAttribute="newUser">
					<p>
						<form:errors path="userName" />
						<form:label path="userName">User Name:</form:label>
						<form:input path="userName" />
					</p>
					<p>
						<form:errors path="email" />
						<form:label path="email">Email:</form:label>
						<form:input path="email" />
					</p>
					<p>
						<form:errors path="password" />
						<form:label path="password">Password:</form:label>
						<form:input path="password" />
					</p>
					<p>
						<form:errors path="confirm" />
						<form:label path="confirm">Confirm Password:</form:label>
						<form:input path="confirm" />
					</p>
					<input type="submit" value="Add User" />
				</form:form>
			</div>
			<div>
				<h1>Login</h1>
				<form:form action='/login' method='POST' modelAttribute="newLogin">
					<p>
						<form:errors path="email" />
						<form:label path="email">Email:</form:label>
						<form:input path="email" />
					</p>
					<p>
						<form:errors path="password" />
						<form:label path="password">Password:</form:label>
						<form:input path="password" />
					</p>
					<input type="submit" value="Login" />
				</form:form>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>