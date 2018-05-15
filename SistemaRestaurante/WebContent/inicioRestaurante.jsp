<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="datos.Login" %>
<% 	String nombreUsuario = (String) session.getAttribute("nombreUsuario");
	if(nombreUsuario != null){ 
%>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Restaurante - Inicio</title>
</head>
<!-- Scripts -->


<body>
<!-- Barra de navegaci�n -->
<nav class="navbar navbar-inverse" style="background-color: black;">
	<div class="btn-group" role="group" aria-label="Grupo">
	 <button type="button" class="btn btn-primary">Sistema Restaurante | Inicio</button>
  	 <button type="submit" class="btn btn-secondary" onclick="location.href='/SistemaRestaurante/pedidos.jsp';">Pedidos</button>
 	 <button type="submit" class="btn btn-secondary" onclick="location.href='/SistemaRestaurante/informe.jsp';">Informe</button>
 	 
 	 <button type="button" class="btn btn-secondary">Perfil</button>
	</div>
	<div class="text-right">
	<form method="POST" action="/SistemaRestaurante/Logout">
	<button type="submit" class="btn btn-secondary">Despedirse</button>
	</form>
	</div>
</nav>
<!-- Barra de navegaci�n -->
<br>
<CENTER><strong><h2>�Bienvenido al sistema restaurante!</h2></strong><br></p></CENTER>

<h4> 
Indicaciones para la navegaci�n y uso del sistema:
</h4>
<br>   - En la secci�n "pedidos" se encuentran las mesas existentes con su respectivo estado.
<br>   - Seg�n el estado de las mismas se permitir�n hacer las acciones correspondientes.
<br>   - El color de las mesas en el layout es: Verde(libre), Rojo(ocupada), Azul(terminada).
<br>   - En el caso de encontrarse ocupada se habilitar� la creaci�n de comandas para dicha mesa.
<br>   - Al cerrarse la mesa se emitir� autom�ticamente el ticket con los gastos de los comensales.

<br><br><br>
<strong> Buena estad�a! :)</strong>
</body>
</html>
<% }
else{
	response.sendRedirect("/SistemaRestaurante/");
}
%>