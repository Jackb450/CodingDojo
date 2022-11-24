<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row text-center mb-3">
			<h1>Home</h1>
			<a href="/dojos/new">Create dojo</a>
			<a href="/dojos/new/ninja">Add ninja</a>
		</div>
	</div>
	<table>
		<thead>
			<tr>
				<th>Dojos</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${dojos}">
				<tr>
					<td>
						<a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"></c:out></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>		
	</table>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>