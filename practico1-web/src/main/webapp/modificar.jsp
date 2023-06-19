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
		<form action="GuardarModificacion" method="post">
			<div class="row">
				<div class="col-9"><h2 style="margin-bottom: 30px;">Modificar ciudadano</h2></div>
				<% if(ciudadano != null){ %><div class="col-3"><input type="hidden" name="ci" value="<%=ciudadano.getCi()%>"><button type="submit" class="btn btn-primary">Guardar</button></div><% } %>
			</div>
			<% if(request.getAttribute("errorMessage") != null){ %>
			<div class="alert alert-danger" role="alert">
			  ${errorMessage}
			</div>
			<% } %>
			<% if(ciudadano != null){%>
			  <div class="mb-3 row">
			    <label for="email" class="col-sm-2 col-form-label">E-mail</label>
			    <div class="col-sm-5">
			      <input type="text" class="form-control" id="email" name="emailNuevo" value="<%=ciudadano.getEmail()%>">
			    </div>
			  </div>
			    <div class="mb-3 row">
			    <label for="cedula" class="col-sm-2 col-form-label">Cédula de identidad</label>
			    <div class="col-sm-5">
			      <input type="text" class="form-control" id="cedula" name="ciNueva" value="<%=ciudadano.getCi()%>">
			    </div>
			  </div>
			  <% } %>
		</form>
	</div>
</body>
</html>