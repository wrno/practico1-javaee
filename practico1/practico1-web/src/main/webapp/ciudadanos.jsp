<%@page import="tse2023.grupo16.practico1.datatypes.DtCiudadano"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="/header.jsp" %>
</head>
<body>
<%@include file="/navbar.jsp" %>
<div class="container"style="margin-top: 20px;">
	<h2 style="margin-bottom: 30px;">Ciudadanos</h2>
	<% if(request.getAttribute("errorMessage") != null){ %>
	<div class="alert alert-danger" role="alert">
	  ${errorMessage}
	</div>
	<% }else{ %>
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Cédula</th>
	      <th scope="col">E-mail</th>
	      <th scope="col"></th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
	  	<% ArrayList<?> ciudadanos = (ArrayList<?>) request.getAttribute("ciudadanos"); %>
	  	<% for(Object it : ciudadanos){ %>
	  	<% if(DtCiudadano.class.isInstance(it)){ %>
	  	<% DtCiudadano ciudadano = (DtCiudadano) it; %>
	    <tr>
	      <td><%=ciudadano.getCi()%></td>
	      <td><%=ciudadano.getEmail()%></td>
	      <td><a href="./Ciudadano?ci=<%=ciudadano.getCi()%>"><i class="fa-solid fa-magnifying-glass" style="color: rgba(0, 0, 0, 0.5);"></i></a></td>
	      <td><a href="./Eliminar?ci=<%=ciudadano.getCi()%>"><i class="fa-solid fa-xmark" style="color: rgb(255, 0, 0);"></i></a></td>
	    </tr>
	    <% } %>
	    <% } %>
	  </tbody>
	</table>
	<% } %>
</div>
</body>
</html>