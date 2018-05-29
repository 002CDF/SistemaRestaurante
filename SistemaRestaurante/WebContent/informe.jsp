<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="datos.Login"%>
<%@page import="datos.Informe"%>
<%@page import="negocio.Funciones"%>
<%
	Informe informe = null; //Por defecto
	int hayFecha = 0; //Por defecto
	int informeDetallado = 0; //Por defecto
	if(session.getAttribute("informe") != null) informe = (Informe) session.getAttribute("informe");
	if(session.getAttribute("hayFecha") != null) hayFecha = (Integer) session.getAttribute("hayFecha");
	if(session.getAttribute("informeDetallado") != null) informeDetallado = (Integer) session.getAttribute("informeDetallado");
	String nombreUsuario = (String) session.getAttribute("nombreUsuario");
	if (nombreUsuario != null) {
%>
<html>
<head>

<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="JSCal2/css/jscal2.css" />
    <link rel="stylesheet" type="text/css" href="JSCal2/css/border-radius.css" />
    <link rel="stylesheet" type="text/css" href="JSCal2/css/gold/gold.css" />
    <script type="text/javascript" src="JSCal2/js/jscal2.js"></script>
    <script type="text/javascript" src="JSCal2/js/lang/en.js"></script>
<script LANGUAGE="JavaScript" SRC="js/calendar.js"></script>

<!-- <script type="text/javascript" src="js/moment.min.js"></script> -->
<!-- <script type="text/javascript" src="js/daterangepicker.min.js"></script> -->
<!-- <link rel="stylesheet" type="text/css" href="css/daterangepicker.css" /> -->

<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
<!-- <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap/latest/css/bootstrap.css" /> -->

<script>
function pasarValorFecha(){
	var fecha = document.getElementById("fecha").innerHTML;
	var arrayFechas = fecha.split("/");
	var fechaInicio = arrayFechas[0];
	var fechaFin = arrayFechas[1];
	document.getElementById("fechaInicio").value = fechaInicio;
	document.getElementById("fechaFin").value = fechaFin;
	return true;
}
</script>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Restaurante - Informe</title>
</head>
<!-- Scripts -->


<body>
	<!-- Barra de navegación -->
	<nav class="navbar navbar-inverse" style="background-color: black;">
	<div class="btn-group" role="group" aria-label="Grupo">
		<button type="button" class="btn btn-primary">Sistema
			Restaurante | Informe</button>
		<button type="submit" class="btn btn-secondary"
			onclick="location.href='/SistemaRestaurante/inicioRestaurante.jsp';">Inicio</button>
		<button type="submit" class="btn btn-secondary"
			onclick="location.href='/SistemaRestaurante/pedidos.jsp';">Pedidos</button>

		<button type="button" class="btn btn-secondary">Perfil</button>
	</div>
	<div class="text-right">
		<form method="POST" action="/SistemaRestaurante/Logout">
			<button type="submit" class="btn btn-secondary">Despedirse</button>
		</form>
	</div>
	</nav>
	<!-- Barra de navegación -->
	<br>
<table style="float: left; margin: 0 1em 1em 0"><tr><td>

  <!-- element that will contain the calendar -->
  <div id="calendar-container"></div>

  <!-- here we will display selection information -->
  <div id="calendar-info" style="text-align: center; margin-top: 0.3em"></div>

</td></tr></table>

<table style="float: left; margin: 0 1em 1em 0"><tr><td>

  <!-- element that will contain the calendar -->
  <div id="calendar-container"></div>

  <!-- here we will display selection information -->
  <div id="calendar-info" style="text-align: center; margin-top: 0.3em"></div>

</td></tr></table>



<form name="informe" method="POST" action="/SistemaRestaurante/Informe" onsubmit="pasarValorFecha()">
<fieldset>
	<strong>Fechas de tickets</strong><br>
	<div id="reportrange" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 25%">
    <i class="fa fa-calendar"></i> &nbsp;
    <span id="fecha" name="fecha"></span> <i class="ranges"></i>
	</div>

<script type="text/javascript">
$(function() {

    var start = moment().subtract(29, 'days');
    var end = moment();

    function cb(start, end) {
        $('#reportrange span').html(start.format('YYYY-MM-DD') + '/' + end.format('YYYY-MM-DD'));
    }

    $('#reportrange').daterangepicker({
        startDate: start,
        endDate: end,
        ranges: {
           'Hoy': [moment(), moment()],
           'Ayer': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
           'Ultimos 7 dias': [moment().subtract(6, 'days'), moment()],
           'Ultimos 30 dias': [moment().subtract(29, 'days'), moment()],
           'Este mes': [moment().startOf('month'), moment().endOf('month')],
           'Ultimo mes': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        }
    }, cb);

    cb(start, end);

});
</script>


	<input type="hidden" id="fechaInicio" name="fechaInicio" value="">
	<input type="hidden" id="fechaFin" name="fechaFin" value="">

	<br>

	<div class="form-group">
		<strong>Tipo de informe</strong><br>
		<label class="radio-inline"><input type="radio" name="tipoInforme" value="G" checked="checked">General</label><br>
		<label class="radio-inline"><input type="radio" name="tipoInforme" value="D">Detallado</label>
	</div>

	<input type="submit" name="informe" class="btn btn-primary" value="Generar Informe">
</fieldset>
<br>
<br/>

<% if(hayFecha==1){ %>
<table class="table table-striped">
	<tr>
 		<th>Desde</th>
 		<th>Hasta</th>
 		<th>Tickets emitidos</th>
		 <th>Facturacion total</th>
 		<th>Mayor ticket facturado</th>
 		<th>Promedio</th>
	</tr>

	<tr>
 		<td><%out.print(informe.getFechaInicio()); %></td>
 		<td><%out.print(informe.getFechaFin()); %></td> 
 		<td><%out.print(informe.getCantidadTickets()); %></td>
 		<td>$<%out.print(informe.getTotalFacturado()); %></td>
 		<td>$<%out.print(informe.getMaxTicket()); %></td>
 		<td>$<%out.print(String.format("%.2f", informe.getPromedio())); %></td>
	</tr>
</table>
<% session.removeAttribute("hayFecha");
session.removeAttribute("informe");
%>
<% } %>
<br>
<% if(informeDetallado==1){ %>
<table class="table table-striped">
	<tr>
 		<th>ID Ticket</th>
 		<th>DNI Cliente</th>
 		<th>DNI Camarero</th>
 		<th>Nro. Mesa</th>
 		<th>Fecha</th>
 		<th>Importe</th>
	</tr>
	
	<%for(int i=0 ; i<informe.getTickets().size() ; i++){ %>
	<tr>
 		<td><%out.print(informe.getTickets().get(i).getIdTicket()); %></td>
 		<td><%out.print(informe.getTickets().get(i).getCliente().getDni()); %></td> 
 		<td><%out.print(informe.getTickets().get(i).getCamarero().getDni()); %></td>
 		<td><%out.print(informe.getTickets().get(i).getMesa().getNroMesa()); %></td>
 		<td><%out.print(Funciones.traerFechaCorta(informe.getTickets().get(i).getFechaEmision())); %></td>
 		<td>$<%out.print(informe.getTickets().get(i).getMonto()); %></td>
	</tr>
	<%} %>
</table>
<% session.removeAttribute("informeDetallado"); %>
<% } %>
</form>

</body>
</html>
<%
	} else {
		response.sendRedirect("/SistemaRestaurante/");
	}
%>