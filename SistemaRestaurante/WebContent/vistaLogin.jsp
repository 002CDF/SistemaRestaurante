<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>
<%@ page import = "datos.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html; charset=ISO-8859-1" >
<title> Sistema Restaurante </title>
</head>
<BODY>
<%@ include file = "/cabecera.jsp" %>
<% Usuario usuario=(Usuario)request.getAttribute("usuario"); %>
<BR>
Se ha logueado correctamente como <%= usuario.getNombreUsuario() %> <BR>
<BR>
<A href = "/SistemaRestaurante/index.jsp"> Volver... </A>
</BODY>
</html>