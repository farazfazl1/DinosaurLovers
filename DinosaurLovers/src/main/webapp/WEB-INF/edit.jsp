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
<title>Edit</title>
<link rel="stylesheet" type="text/css" href="/css/edit.css">
</head>
<body>

	<div class="loader">
    	<div class="ball"></div>
    	<div class="ball"></div>
    	<div class="ball"></div>
    	<span>Edit Dinosaur</span>
    </div>
	<form:form action="/dino/edit/${dino.id}" method="post" modelAttribute="dino">
	
		 <input type="hidden" name="_method" value="put"/>
		 <form:input type="hidden" path="user" value="${user.id}"/>
		 
		<form:errors class="our_errors" path="name"/>
		<form:errors class="our_errors" path="size"/>
		<form:errors class="our_errors" path="habitat"/>
		<form:errors class="our_errors" path="diet"/>
		<form:errors class="our_errors" path="facts"/>
      	

		
		<div>
        	<form:label path="name">Name: </form:label>
        	<form:input path="name" />
		</div>
		
		<div>
        	<form:label path="size">Size: </form:label>
        	<form:input path="size" />
		</div>
		
		<div>
        	<form:label path="habitat">Habitat: </form:label>
        	<form:input path="habitat" />
		</div>
		
		<div>
        	<form:label path="diet">Diet: </form:label>
        	<form:input path="diet" />
		</div>
		
		<div>
        	<form:label path="facts">Facts: </form:label>
        	
        	<form:textarea path="facts" cols="30" rows="5"></form:textarea>
      	</div>
      	
      	
      	<input type="submit" value="Submit" class="button" />
	</form:form>
		<a class="button" id="cancel" href="/dashboard"> cancel</a>

</body>
</html>