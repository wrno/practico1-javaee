<%@page import="java.time.format.FormatStyle"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="tse2023.grupo16.practico1.datatypes.DtCiudadano"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="/header.jsp" %>
<% DtCiudadano ciudadano = null; %>
<% if(request.getAttribute("ciudadano") != null){ ciudadano = (DtCiudadano) request.getAttribute("ciudadano"); }%>
</head>
<body>
	<%@include file="/navbar.jsp" %>
	<div class="container" style="margin-top: 20px;">
		<div class="row">
			<div class="col-9"><h2 style="margin-bottom: 30px;">Ciudadano</h2></div>
			<% if(ciudadano != null){ %><div class="col-3"><form action="Modificar" method="post"><input type="hidden" name="ci" value="<%=ciudadano.getCi()%>"><button type="submit" class="btn btn-primary">Modificar</button></form></div><% } %>
		</div>
		<% if(request.getAttribute("errorMessage") != null){ %>
		<div class="alert alert-danger" role="alert">
		  ${errorMessage}
		</div>
		<% } %>
		<% if(ciudadano != null){ %>
		<div class="row">
			<div class="col-3"><b>Cédula de identidad</b></div>
			<div class="col"><%=ciudadano.getCi()%></div>
		</div>
		<div class="row">
			<div class="col-3"><b>E-mail</b></div>
			<div class="col"><%=ciudadano.getEmail()%></div>
		</div>
		<div class="row">
			<div class="col-3"><b>Fecha de alta</b></div>
			<div class="col"><%=ciudadano.getFechaAlta().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))%></div>
		</div>
		<% } %>
	</div>
</body>
</html>