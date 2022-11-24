<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expenses</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row text-center mb-3">
			<h1>Save travels</h1>
		</div>
	</div>
	<div class="row text-center mb-3">
		<table>
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachTravel" items="${listTravel}">
					<tr>
						<td>
							<a href="/expenses/${eachTravel.id}"><c:out value="${eachTravel.expense}"></c:out></a>
						</td>
						<td>
							<c:out value="${eachTravel.vendor}"></c:out>
						</td>
						<td>
							$<c:out value="${eachTravel.amount}"></c:out>
						</td>
						<td>
							<a href="/expenses/edit/${eachTravel.id}">Edit</a> | 
							<a href="/expenses/delete/${eachTravel.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form action='/expenses' method='POST' modelAttribute="newTravel">
			<p>
				<form:errors path="expense" />
				<form:label path="expense">Expense:</form:label>
				<form:input path="expense" />
			</p>
			<p>
				<form:errors path="vendor" />
				<form:label path="vendor">Vendor:</form:label>
				<form:input path="vendor" />
			</p>
			<p>
				<form:errors path="amount" />
				<form:label path="amount">Amount:</form:label>
				<form:input path="amount" />
			</p>
			<p>
				<form:errors path="description" />
				<form:label path="description">Description:</form:label>
				<form:input path="description" />
			</p>
			<input type="submit" value="Add Expense" />
		</form:form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>