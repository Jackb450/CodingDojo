<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book details</title>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row text-center mb-3">
			<h1>All books</h1>
		</div>
		<div class="row text-center">
			<p><a href="/book/new">Add new Book</a></p>
		</div>
	</div>
	<div class="row text-center mb-3">
		<table>
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Title</th>
		            <th>Description</th>
		            <th>Language</th>
		            <th>Number of Pages</th>
		            <th>Options</th>
		        </tr>
		    </thead>
		    <tbody>
		    	<tr>
		    		<th>
			    		<c:forEach var="allBooks" items="${books}">
		        			<p><c:out value="${allBooks.id}"></c:out></p>
		    			</c:forEach>
		    			<c:out value="${book.id}"/>
		    		</th>
		    		<th>
			    		<c:forEach var="allBooks" items="${books}">
		        			<p><a href="/book/${allBooks.id}"><c:out value="${allBooks.title}"></c:out></a></p>
		    			</c:forEach>
		    			<c:out value="${book.title}"/>
		    		</th>
		    		<th>
			    		<c:forEach var="allBooks" items="${books}">
		        			<p><c:out value="${allBooks.description}"></c:out></p>
		    			</c:forEach>
		    			<c:out value="${book.description}"/>
		    		</th>
		    		<th>
			    		<c:forEach var="allBooks" items="${books}">
		        			<p><c:out value="${allBooks.language}"></c:out></p>
		    			</c:forEach>
		    			<c:out value="${book.language}"/>
		    		</th>
		    		<th>
			    		<c:forEach var="allBooks" items="${books}">
		        			<p><c:out value="${allBooks.numOfPages}"></c:out></p>
		         		</c:forEach>
		    			<c:out value="${book.numOfPages}"/>
		    		</th>
		    		<th>
		    			<c:forEach var="allBooks" items="${books}">
		    				<p>
			    				<a href="/book/${allBooks.id}/edit">Edit</a> |
			    				<a href="/book/delete/${allBooks.id}">Delete</a>
		    				</p>
		    			</c:forEach>
		    		</th>
		    	</tr>
		    </tbody>
		</table>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>