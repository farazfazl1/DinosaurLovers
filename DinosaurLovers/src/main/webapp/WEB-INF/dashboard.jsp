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
<title>Welcome To DinoWorld</title>
<link rel="stylesheet" type="text/css" href="/css/dashboard.css">
</head>
<body>
	<div class="background">
	
	<div class="header">
      <h1>
      	Hello <c:out value="${user.userName}"></c:out> 
      </h1>
      <a href="/logout" class="logout_button">log out</a>
    </div>
    
     
    	<h1>List of Our Dinosaurs</h1>
  	
    
    <table>
    	<tr>
    		<th>Name</th>
    		<th>Size</th>
    		<th>Habitat</th>
    		<th>Diet</th>
    		<th>Facts</th>
    		<th>Options</th>
    	</tr>
    	
    	<c:forEach var="dinos" items="${all_dinos}">
    		<tr>
    			<td>
    				<a href="/dino/${dinos.id}" class="dino_name" ><c:out value="${dinos.name}"></c:out></a>
    			</td>
    			<td> <c:out value="${dinos.size}"></c:out> Kg</td>
    			<td> <c:out value="${dinos.habitat}"></c:out> </td>
    			<td> <c:out value="${dinos.diet}"></c:out> </td>
    			<td> <c:out value="${dinos.facts}"></c:out> </td>
    			<td>
    				<form class="delete_form" action="/dino/delete/${dinos.id}" method="post">
        			<input type="hidden" name="_method" value="delete">
    				<input type="submit" class="dino_delete" value="Delete" id="text_delete">
    				</form>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
    
    
     <a href="/add_dino"><button class="cta">
    	 <span>New Dinosaur</span> <i class="ri-arrow-right-line"></i></button>
     </a>
    </div>
   
</body>
</html>