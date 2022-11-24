<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fortune</title>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/fortune.css">
</head>
<body>
	<div class="container">
        <div class="row text-center mb-3">
            <h1>Here's your Omikuji</h1>
        </div>
		<div class="row text-ceneter">
			<div class="blue">
				<p>In <c:out value="${num}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, <c:out value="${hobby}"/> for a living. The next time you see a <c:out value="${mammal}"/>, you will have good luck. Also, <c:out value="${happy}"/>.
			</div>
		</div>
		<div class="row text-center">
			<a href="/omikuji">Go back!</a>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>