<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dino Lovers</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
	<h1>Welcome to Dinosaur Lovers Community</h1>
	<p>Join our growing Community</p>
	
	<div class="two_forms">
		<form:form action="/register" method="post" modelAttribute="newUser">
		<h2>Register</h2>
		<form:errors class="our_errors" path="userName"/>
		<form:errors class="our_errors" path="email"/>
		<form:errors class="our_errors" path="password"/>
		<form:errors class="our_errors" path="confirmPassword"/>
		
		<div>
          <form:label path="userName">User Name: </form:label>
          <form:input type="text" path="userName" />
        </div>
        
        <div>
          <form:label path="email">Email: </form:label>
          <form:input type="text" path="email" />
        </div>
        
        <div>
          <form:label path="password">Password: </form:label>
          <form:input type="password" path="password" />
        </div>
        
        <div>
          <form:label path="confirmPassword">Confirm Password: </form:label>
          <form:input type="password" path="confirmPassword" />
        </div>
        <input type="submit" value="Submit" class="submit_button"/>
		</form:form>
<!-- ================================================================-->      
		<form:form action="/login" method="post" modelAttribute="loginUser">
	 	<h2>Login</h2>
	 	<p><c:out value="${error}"></c:out></p>
	 	<form:errors class="our_errors" path="email"/>
        <form:errors class="our_errors" path="password"/>
	 	
	 	
        <div>
          <form:label path="email">Email: </form:label>
          <form:input type="text" path="email" />
        </div>

        <div>
          <form:label path="password">Password: </form:label>
          <form:input type="password" path="password" />
        </div>
        <input type="submit" value="Login" class="submit_button"/>
      </form:form>
	
	</div>
	
	
	
	
	
	
	
	
	
	
</body>
</html>