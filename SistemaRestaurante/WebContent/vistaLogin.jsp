<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>
<%@ page import = "datos.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1" >
<title> Sistema Hotelero </title>
</head>
<BODY>
<%@ include file = "/cabecera.jsp" %>
<% Usuario usuario=(Usuario)request.getAttribute("usuario"); %>
<BR>
nombreUsuario: <%= usuario.getNombreUsuario() %> <BR>
contraseña : <%= usuario.getPassword() %> <BR>
<BR>
<A href = "/SistemaHotelero/index.jsp"> Volver... </A>
</BODY>
</html>