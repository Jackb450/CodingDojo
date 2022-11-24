<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit book details</title>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
        <div class="row text-center mb-3">
            <h1>Edit a Book</h1>
        </div>
        <div class="row text-center">
			<p><a href="/books">Go back to Dash board</a></p>
		</div>
		<div class="row text-center mb-3">
			<form action='/book/edit/${book.id}/verify' method='POST'>
		    	<div class="title">
			    	<c:out value="${titleError}"/>
			    	<div class="question">
						<label>Book's name?:</label>
			    	</div>
			    	<input type="text" name='title'>
			    </div>
		    	<div class="description">
			    	<c:out value="${descError}"/>
			    	<div class="question">
						<label>Book's description:</label>
					</div>
			    	<input type='text' name='description'>
			    </div>
		    	<div class="language">
			    	<c:out value="${languageError}"/>
			    	<div class="question">
			    		<label>What language is it written in?:</label>
			    	</div>
			    	<input type="text" name='language'>
			    </div>
		    	<div class="numOfPages">
			    	<c:out value="${numError}"/>
			    	<div class="question">
						<label>How many pages are there (100 minimum)?:</label>
			    	</div>
			    	<input type='number' name='numOfPages'>
			    </div>
			   	<input type='submit' value='Confirm Edit'>
			</form>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>