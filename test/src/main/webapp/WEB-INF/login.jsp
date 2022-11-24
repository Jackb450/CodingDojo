<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login test</title>
<link rel="stylesheet" type="text/css" href="/css/demo.css">
</head>
<body>
	<h3>Login</h3>
    <form action='/login' method='POST'>
		<label>Email:</label>
    	<input type="text" name='email'>
		<label>Password:</label>
    	<input type='text' name='password'>
    	<input type='submit' value='login'>
    </form>
</body>
</html>