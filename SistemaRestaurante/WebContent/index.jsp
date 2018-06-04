<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<%@page import="datos.Usuario" %>
<%  String nombreUsuario = (String) session.getAttribute("nombreUsuario");
	if(nombreUsuario == null){ 
%>
<HTML>
<body background="images/FondoRestaurante.jpg" height="10%">
<HEAD>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>Sistema Restaurante - Login</TITLE>
</HEAD>
<BODY>
			<%@ include file="/cabecera.jsp"%>
			<FORM method="POST" action="/SistemaRestaurante/Inicio ">
		<p><h4> Iniciar sesion: </h4><br></p>
			<!-- Alertas de errores -->
				<%if(session.getAttribute("errorLogin") != null){%>
				<div class="alert alert-danger alert-dismissible col-md-3">
 				 <strong>Atención: </strong> <%out.println(session.getAttribute("errorLogin"));%>
				</div>
				<%session.setAttribute("errorLogin", null); }%>
			<!-- Alertas de errores -->
			  <div class="col-lg-3">
				<label>Nombre de usuario </label>
				<input class="form-control input-sm" name="nombreUsuario" type="text">
				<label>Contraseña </label>
				<input class="form-control input-sm" name="password" type="password">
				<br>
				<input type="submit" class="btn btn-primary" value="Enviar">
			  </div>
	</FORM>

</BODY>
</HTML>
<% } 
else{
	response.sendRedirect("/SistemaRestaurante/inicioRestaurante.jsp");
	}
%>