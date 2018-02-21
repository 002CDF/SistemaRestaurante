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

<script>
$(document).ready(function(){
        if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
            	$('#salon').append(this.responseText);
            }
        };
        xmlhttp.open("GET","ajax_Salones.jsp?="+1,true);
        xmlhttp.send();
});
</script>

<script>
function ejecutarAccion(form){
	if(($("#accionMesa").val())==="ocupar"){
		document.getElementById("divOcupar").style.display = "inline";
	}
	else document.getElementById("divOcupar").style.display = "none";
	if(($("#accionMesa").val())==="mover"){
		document.getElementById("divMover").style.display = "inline";
	}
	else document.getElementById("divMover").style.display = "none";
}
</script>

<script>
function validarCliente(){
	var esCliente = $('#esCliente').is(':checked');
	if(esCliente==false){
		document.getElementById("clienteDNI").disabled = true;
	}
	if(esCliente==true){
		document.getElementById("clienteDNI").disabled = false;
	}
}
</script>

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
  <label for="accionMesa"><strong>Seleccione una acción:</strong></label>
  <select class="form-control-sm" id="accionMesa" onchange="ejecutarAccion(this.form)">
  	<option value="" selected disabled>Seleccionar</option>
    <%if(mesa.getEstadoMesa() == 1) out.print("<option value='ocupar'>Ocupar mesa</option>");
       								out.print("<option value='mover'>Mover mesa</option>");%>
    <%if(mesa.getEstadoMesa() == 2) out.print("<option value='finalizar'>Finalizar mesa</option>");%>
    <%if(mesa.getEstadoMesa() == 3) out.print("<option value='liberar'>Liberar mesa</option>");%>
    <%if(mesa.getEstadoMesa() == 2) out.print("<option value='verComanda'>Ver comandas</option>");%>
    <%if(mesa.getEstadoMesa() == 2) out.print("<option value='agrComanda'>Agregar comanda</option>");%>
  </select>
</div>


<div id="divOcupar" class="form-inline col-lg-2" style="display: none">
	<form method="POST" action="/SistemaRestaurante/DetalleMesa">
   	 	<p><strong>DNI del camarero</strong><br>
    	<input type="text" class="form-control input-sm" id="camareroDNI"></p>
    	<input type="checkbox" id="esCliente" checked="checked" onchange="validarCliente()"> Cliente (SI/NO)
    	<p><strong>DNI del cliente</strong><br>
    	<input type="text" class="form-control input-sm" id="clienteDNI"></p>
    	<input type="hidden" id="tipoAccion" value="-1"> <!-- Ocupar -->
    	<input type="submit" value="Enviar">
    </form>
</div>

<form method="POST" action="/SistemaRestaurante/DetalleMesa">
	<div id="divMover" class="form-inline col-lg-2" style="display: none">
		<input type="hidden" name="tipoAccion" id="tipoAccion" value="-2"> <!-- Mover -->
		<input type="hidden" name="mesa" id="mesa" value="<%=mesa.getNroMesa()%>">
		<p><strong>Seleccione un salon para mover su mesa: </strong>
		<select class='form-control-sm' name='salon' id='salon'>
		</select>
		<br>
		<input type="submit" value="Enviar">
	</div>
</form>

</body>
</html>
<%} else{
	response.sendRedirect("/SistemaRestaurante/");
}
%>