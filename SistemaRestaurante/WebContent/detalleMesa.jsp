<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="datos.Login" %>
<%@page import="datos.Mesa" %>
<%@page import="java.util.List"%>
<% 	String nombreUsuario = (String) session.getAttribute("nombreUsuario");
	if(nombreUsuario != null){ 
%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Restaurante - Detalle de mesa </title>
</head>
<!-- Scripts -->
<script src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src='js/bootstrap.min.js'></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<body>
<!-- Barra de navegación -->
<nav class="navbar navbar-inverse" style="background-color: black;">
	<div class="btn-group" role="group" aria-label="Grupo">
	 <button type="button" class="btn btn-primary">Sistema Restaurante | Pedidos</button>
  	 <button type="button" class="btn btn-secondary" onclick="location.href='/SistemaRestaurante/inicioRestaurante.jsp';">Inicio</button>
 	 <button type="button" class="btn btn-secondary">Salones</button>
 	 <button type="button" class="btn btn-secondary" onclick="location.href='SistemaRestaurante/Logout';">Perfil</button>
	</div>
	<div class="text-right">
	<form method="POST" action="/SistemaRestaurante/Logout">
	<button type="submit" class="btn btn-secondary">Despedirse</button>
	</form>
	</div>
</nav>
<!-- Barra de navegación -->
<br/><br/>
<% Mesa mesa = (Mesa)request.getAttribute("mesa"); %>

<h3 class="display-3">Detalle de la mesa <%=""+mesa.getNroMesa()%>:</h3>
<label><strong>Estado: </strong></label> <%if(mesa.getEstadoMesa() == 1) out.print("disponible");
						  if(mesa.getEstadoMesa() == 2) out.print("ocupada");
						  if(mesa.getEstadoMesa() == 3) out.print("finalizada");%>
<br/>
<label><strong>En salon: </strong></label> <%=""+mesa.getSalon().getDescripcion()%>

<div class="form-group" class="col-xs-3">
  <label for="accionMesa"><strong>Seleccione una accion:</strong></label>
  <select class="form-control-sm" id="accionMesa" onchange="ejecutarAccion(this.form)">
  	<option value="" selected disabled>Seleccionar</option>
    <%if(mesa.getEstadoMesa() == 1) out.print("<option value='ocupar'>Ocupar mesa</option>");%>
    <%if(mesa.getEstadoMesa() == 2) out.print("<option value='finalizar'>Finalizar mesa</option>");%>
    <%if(mesa.getEstadoMesa() == 3) out.print("<option value='liberar'>Liberar mesa</option>");%>
    <%if(mesa.getEstadoMesa() == 2) out.print("<option value='verComanda'>Ver comandas</option>");%>
    <%if(mesa.getEstadoMesa() == 2) out.print("<option value='agrComanda'>Agregar comanda</option>");%>
  </select>
</div>

<div id="divOcupar" class="form-inline col-lg-2">
    <p><label for="camareroDNI"><strong>DNI del camarero</strong></label>
    <input type="text" class="form-control input-sm" id="camareroDNI"></p>
    <p><label for="clienteDNI"><strong>DNI del cliente</strong></label>
    <input type="text" class="form-control input-sm" id="clienteDNI"></p>
    <p><label for="numHabitacion"><strong>Numero de habitacion</strong></label>
    <input type="text" class="form-control input-sm" id="numHabitacion"></p>
</div>


<div id="ocuparMesa" style="display: none">

</div>

</body>
</html>
<%} else{
	response.sendRedirect("/SistemaRestaurante/");
}
%>