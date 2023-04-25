<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file='/header.jsp' %>
</head>
<body>
<%@include file='/navbar.jsp'%>
<div class="container" style="margin-top: 20px;">
<h2 style="margin-bottom: 30px;">Registrar ciudadano</h2>
<% if(request.getAttribute("errorMessage") != null){ %>
	<div class="alert alert-danger" role="alert">
	  ${errorMessage}
	</div>
<% } %>
<% if(request.getAttribute("exito") != null && (Boolean) request.getAttribute("exito") == true){ %>
	<div class="alert alert-success" role="alert">
	  La cuenta de ciudadano se creó con éxito.
	</div>
<% } %>
<form action="RegistrarCiudadano" method="post">
  <div class="mb-3 row">
    <label for="email" class="col-sm-2 col-form-label">E-mail</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="email" name="email" value="${email}">
    </div>
  </div>
    <div class="mb-3 row">
    <label for="cedula" class="col-sm-2 col-form-label">Cédula de identidad</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="cedula" name="ci" value="${ci}">
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Registrar</button>
  </form>
</div>
</body>
</html>