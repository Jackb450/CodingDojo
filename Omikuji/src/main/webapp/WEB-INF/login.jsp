<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
        <div class="row text-center mb-3">
            <h1>Send a Omikuji</h1>
        </div>
		<div class="row text-center mb-3">
			<form action='/omikuji/confirm' method='POST'>
		    	<div class="number">
			    	<c:out value="${numError}"/>
			    	<div class="question">
						<label>Pick a number from 5 to 25:</label>
			    	</div>
			    	<input type="number" name='num'>
			    </div>
		    	<div class="city">
			    	<c:out value="${cityError}"/>
			    	<div class="question">
						<label>A city name:</label>
					</div>
			    	<input type='text' name='city'>
			    </div>
		    	<div class="person">
			    	<c:out value="${personError}"/>
			    	<div class="question">
			    		<label>A random person:</label>
			    	</div>
			    	<input type="text" name='person'>
			    </div>
		    	<div class="hobby">
			    	<c:out value="${hobbyError}"/>
			    	<div class="question">
						<label>Something you like to do (hobbies/games):</label>
			    	</div>
			    	<input type='text' name='hobby'>
			    </div>
		    	<div class="mammal">
			    	<c:out value="${mammalError}"/>
			    	<div class="question">
			    		<label>Something LIVING (like animals):</label>
			    	</div>
			    	<input type="text" name='mammal'>
			   	</div>
			    <div class="happy">
			    	<c:out value="${happyError}"/>
			    	<div class="question">
						<label>Something nice for someone else:</label>
			    	</div>
			    	<input type='text' name='happy'>
			   	</div>
			   	<input type='submit' value='login'>
			   </form>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>