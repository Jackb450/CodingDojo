<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruits</title>
</head>
<body>
	<h1>Fruit Store</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${fruits}">
				<tr>
					<td>${item.getName()}</td>
					<td>${item.getPrice()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>