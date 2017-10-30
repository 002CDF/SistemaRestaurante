<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<HTML>
<HEAD>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>Sistema Restaurante - Login</TITLE>
</HEAD>
<BODY>
	<%@ include file="/cabecera.jsp"%>
	<FORM method="POST" action="/SistemaRestaurante/LoginJSP ">
		<p><h4> Iniciar sesion: </h4> <br/><br/></p>
			  <div class="col-lg-3">
				<label>Nombre de usuario </label>
				<input class="form-control input-sm" name="nombreUsuario" type="text">
				<label>Contraseña </label>
				<input class="form-control input-sm" name="password" type="password">
				<br>
				<input type="submit" value="Enviar">
			  </div>
	</FORM>
</BODY>
</HTML>