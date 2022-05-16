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
<title>Chosen Dino</title>
<link rel="stylesheet" type="text/css" href="/css/show.css">
</head>
<body>
	<h1 class="title">
	  <span class="title-content"><c:out value="${dino.name}"></c:out></span>
      <span class="title-content title-second">Posted by: <c:out value="${dino.user.userName}"></c:out></span>
      <span class="title-content title-third">Size: <c:out value="${dino.size}"></c:out></span>
      <span class="title-content title-fourth">Habitat: <c:out value = "${dino.habitat}"></c:out></span>
      <span class="title-content title-fifth">Diet: <c:out value = "${dino.diet}"></c:out></span>
      <span class="title-content title-sixth">Facts: <c:out value = "${dino.facts}"></c:out></span>
      	<a href="/dino/edit/${dino.id}">Edit this Dinosaur</a>
		<a href="/dashboard">Dashboard</a>
	</h1>
</body>
</html>