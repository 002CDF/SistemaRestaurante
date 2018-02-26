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
//SALONES
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
//PRODUCTOS
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
            	$('#Producto1').append(this.responseText);
            	$('#Producto2').append(this.responseText);
            	$('#Producto3').append(this.responseText);
            	$('#Producto4').append(this.responseText);
            	$('#Producto5').append(this.responseText);
            	$('#Producto_1').append(this.responseText);
            	$('#Producto_2').append(this.responseText);
            	$('#Producto_3').append(this.responseText);
            	$('#Producto_4').append(this.responseText);
            	$('#Producto_5').append(this.responseText);
            }
        };
        xmlhttp.open("GET","ajax_Productos.jsp?="+1,true);
        xmlhttp.send();
});
</script>

<script>
//TICKET
</script>

<script>
function ejecutarAccion(form, nroMesa){
	if(($("#accionMesa").val())==="ocupar"){
		document.getElementById("divOcupar").style.display = "inline";
	}
	else document.getElementById("divOcupar").style.display = "none";
	
	if(($("#accionMesa").val())==="mover"){
		document.getElementById("divMover").style.display = "inline";
	}
	else document.getElementById("divMover").style.display = "none";
	
	if(($("#accionMesa").val())==="verComanda"){ //Se usa el ajax para mostrar las comandas de la mesa
		if (window.XMLHttpRequest) {
            // code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
            	$('#divVer').append(this.responseText);
            	document.getElementById("divVer").style.display = "inline";
            }
        };
        xmlhttp.open("GET","ajax_Comandas.jsp?nroMesa="+nroMesa,true);
        xmlhttp.send();
	}
	else document.getElementById("divVer").style.display = "none";
	
	if(($("#accionMesa").val())==="agregarComanda"){
		document.getElementById("divAgregar").style.display = "inline";
	}
	else document.getElementById("divAgregar").style.display = "none";
	
	if(($("#accionMesa").val())==="finalizar"){
		document.getElementById("divFinalizar").style.display = "inline";
	}
	else document.getElementById("divFinalizar").style.display = "none";
	
	if(($("#accionMesa").val())==="liberar"){
		document.getElementById("divLiberar").style.display = "inline";
	}
	else document.getElementById("divLiberar").style.display = "none";
	if(($("#accionMesa").val())==="verTicket"){
		if (window.XMLHttpRequest) {
	        // code for IE7+, Firefox, Chrome, Opera, Safari
	        xmlhttp = new XMLHttpRequest();
	    } else {
	        // code for IE6, IE5
	        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	    xmlhttp.onreadystatechange = function() {
	        if (this.readyState == 4 && this.status == 200) {
	        	document.getElementById("detalleTicket").style.display = "inline";
	        	//$('#detalleTicket').append(this.responseText);
	        	document.getElementById("detalleTicket").innerHTML = this.responseText;
	        }
	    };
	    xmlhttp.open("GET","ajax_Tickets.jsp?nroMesa="+nroMesa,true);
	    xmlhttp.send();
	}
	else document.getElementById("detalleTicket").style.display = "none";
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

<script src="js/botonComandas.js"></script>
<script src="js/botonComandas2.js"></script>


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
  <select class="form-control-sm" id="accionMesa" onchange="ejecutarAccion(this.form, '<%=""+mesa.getNroMesa()%>')">
  	<option value="" selected disabled>Seleccionar</option>
    <%if(mesa.getEstadoMesa() == 1) out.print("<option value='ocupar'>Ocupar mesa</option>");
       								out.print("<option value='mover'>Mover mesa</option>");%>
    <%if(mesa.getEstadoMesa() == 2) out.print("<option value='finalizar'>Finalizar mesa</option>");%>
    <%if(mesa.getEstadoMesa() == 2) out.print("<option value='verComanda'>Ver comandas</option>");%>
    <%if(mesa.getEstadoMesa() == 2) out.print("<option value='agregarComanda'>Agregar comanda</option>");%>
    <%if(mesa.getEstadoMesa() == 3) out.print("<option value='liberar'>Liberar mesa</option>");%>
    <%if(mesa.getEstadoMesa() == 3) out.print("<option value='verTicket'>Pre-ticket</option>");%>
  </select>
</div>
<%if(mesa.getEstadoMesa()==3){%>
<div id="detalleTicket">
</div>
<%} %>

<div id="divOcupar" class="form-inline col-lg-2" style="display: none">
	<form name="ocuparMesa" method="POST" action="/SistemaRestaurante/DetalleMesa">
    	<input type="hidden" name="tipoAccion" id="tipoAccion" value="-1"> <!-- Ocupar -->
    	<input type="hidden" name="mesa" id="mesa" value="<%=mesa.getNroMesa()%>">
   
		<p class="boton-margen-inferior">
		<input type="button" class="btn btn-default" id="addComanda" value="Agregar comanda" onclick="agregarComanda()">
		<input type="button" class="btn btn-default" id="deleteComanda" value="Quitar" onclick="quitarComanda()"></p>
    	    	
    	<div class="btn-group" id="Comanda1" role="group">
        <select class="form-control" name="Producto1" id="Producto1">
        <option value="-1" selected>Seleccionar producto</option>
        </select>
        <input class="form-control" size="3" id="Cantidad1" name="Cantidad1" type="text" placeholder="Cant." autocomplete="off">
	    </div>
	    <br>
	    <div class="btn-group" id="Comanda2" role="group" style="display: none">
        <select class="form-control" name="Producto2" id="Producto2">
        <option value="-1" selected disabled>Seleccionar producto</option>
        </select>
        <input class="form-control" size="3" id="Cantidad2" name="Cantidad2" type="text" placeholder="Cant." autocomplete="off">
	    </div>
	    <br>
	    <div class="btn-group" id="Comanda3" role="group" style="display: none">
        <select class="form-control" name="Producto3" id="Producto3">
        <option value="-1" selected disabled>Seleccionar producto</option>
        </select>
        <input class="form-control" size="3" id="Cantidad3" name="Cantidad3" type="text" placeholder="Cant." autocomplete="off">
        <br>
	    </div>
	    
	    <div class="btn-group" id="Comanda4" role="group" style="display: none">
        <select class="form-control" name="Producto4" id="Producto4">
        <option value="-1" selected disabled>Seleccionar producto</option>
        </select>
        <input class="form-control" size="3" id="Cantidad4" name="Cantidad4" type="text" placeholder="Cant." autocomplete="off">
        <br>
	    </div>
	    
	    <div class="btn-group" id="Comanda5" role="group" style="display: none">
        <select class="form-control" name="Producto5" id="Producto5">
        <option value="-1" selected disabled>Seleccionar producto</option>
        </select>
        <input class="form-control" size="3" id="Cantidad5" name="Cantidad5" type="text" placeholder="Cant." autocomplete="off">
        <br>
	    </div>
	    	    
    	<br>
    	<input type="submit" name="ocupar" class="btn btn-primary" value="Enviar">
    </form>
</div>

<form name="moverMesa" method="POST" action="/SistemaRestaurante/DetalleMesa">
	<div id="divMover" class="form-inline col-lg-2" style="display: none">
		<input type="hidden" name="tipoAccion" id="tipoAccion" value="-2"> <!-- Mover -->
		<input type="hidden" name="mesa" id="mesa" value="<%=mesa.getNroMesa()%>">
		<p><strong>Seleccione un salon para mover su mesa: </strong>
		<select class='form-control-sm' name='salon' id='salon'>
		</select>
		<br>
		<input type="submit" name="mover" class="btn btn-primary" value="Enviar">
	</div>
</form>

<div id="divVer" style="display: none"></div> <!-- Muestra una tabla con las comandas de la mesa -->

<div id="divAgregar" class="form-inline col-lg-2" style="display: none">
	<form name="agrComanda" method="POST" action="/SistemaRestaurante/DetalleMesa">
    	<input type="hidden" name="tipoAccion" id="tipoAccion" value="-3"> <!-- Agregar comanda -->
    	<input type="hidden" name="mesa" id="mesa" value="<%=mesa.getNroMesa()%>">
   
		<p class="boton-margen-inferior">
		<input type="button" class="btn btn-default" id="addComanda2" value="Agregar comanda" onclick="agregarComanda2()">
		<input type="button" class="btn btn-default" id="deleteComanda2" value="Quitar" onclick="quitarComanda2()"></p>
    	    	
    	<div class="btn-group" id="Comanda_1" role="group">
        <select class="form-control" name="Producto_1" id="Producto_1">
        <option value="-1" selected>Seleccionar producto</option>
        </select>
        <input class="form-control" size="3" id="Cantidad_1" name="Cantidad_1" type="text" placeholder="Cant." autocomplete="off">
	    </div>
	    <br>
	    <div class="btn-group" id="Comanda_2" role="group" style="display: none">
        <select class="form-control" name="Producto_2" id="Producto_2">
        <option value="-1" selected disabled>Seleccionar producto</option>
        </select>
        <input class="form-control" size="3" id="Cantidad_2" name="Cantidad_2" type="text" placeholder="Cant." autocomplete="off">
	    </div>
	    <br>
	    <div class="btn-group" id="Comanda_3" role="group" style="display: none">
        <select class="form-control" name="Producto_3" id="Producto_3">
        <option value="-1" selected disabled>Seleccionar producto</option>
        </select>
        <input class="form-control" size="3" id="Cantidad_3" name="Cantidad_3" type="text" placeholder="Cant." autocomplete="off">
        <br>
	    </div>
	    
	    <div class="btn-group" id="Comanda_4" role="group" style="display: none">
        <select class="form-control" name="Producto_4" id="Producto_4">
        <option value="-1" selected disabled>Seleccionar producto</option>
        </select>
        <input class="form-control" size="3" id="Cantidad_4" name="Cantidad_4" type="text" placeholder="Cant." autocomplete="off">
        <br>
	    </div>
	    
	    <div class="btn-group" id="Comanda_5" role="group" style="display: none">
        <select class="form-control" name="Producto_5" id="Producto_5">
        <option value="-1" selected disabled>Seleccionar producto</option>
        </select>
        <input class="form-control" size="3" id="Cantidad_5" name="Cantidad_5" type="text" placeholder="Cant." autocomplete="off">
        <br>
	    </div>
	    	    
    	<br>
    	<input type="submit" name="agregar" class="btn btn-primary" value="Enviar">
    </form>
</div>

<div id="divFinalizar" class="form-inline col-lg-2" style="display: none">
<form name="finalizarMesa" method="POST" action="/SistemaRestaurante/DetalleMesa">
	<p><strong>DNI del camarero</strong><br>
    <input type="text" class="form-control input-sm" name="camareroDNI" id="camareroDNI"></p>
    <input type="checkbox" id="esCliente" checked="checked" onchange="validarCliente()"> Cliente (SI/NO)
    <p><strong>DNI del cliente</strong><br>
    <input type="text" class="form-control input-sm" name="clienteDNI" id="clienteDNI"></p>
    
	<input type="hidden" name="tipoAccion" id="tipoAccion" value="-4"> <!-- Finalizar -->
	<input type="hidden" name="mesa" id="mesa" value="<%=mesa.getNroMesa()%>">
	<input type="hidden" name="user" id="user" value="<%=nombreUsuario%>">
	

	<input type="submit" name="finalizarM" class="btn btn-primary" value="Finalizar">
</form>
</div>

<div id="divLiberar" class="form-inline col-lg-2" style="display: none">
<form name="finalizarMesa" method="POST" action="/SistemaRestaurante/DetalleMesa">
	<input type="hidden" name="mesa" id="mesa" value="<%=mesa.getNroMesa()%>">
	<input type="hidden" name="user" id="user" value="<%=nombreUsuario%>">
	<input type="hidden" name="tipoAccion" id="tipoAccion" value="-5"> <!-- Liberar -->
	
	<p><strong>Ingrese su contraseña para confirmar la acción</strong><br>
    <input type="password" class="form-control input-sm" name="pass" id="pass"></p>
    
    <input type="submit" name="liberarM" class="btn btn-primary" value="Liberar">
</form>
</div>

</body>
</html>
<%} else{
	response.sendRedirect("/SistemaRestaurante/");
}
%>