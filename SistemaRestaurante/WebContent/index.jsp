<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd" >
<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE> Sistema Restaurante - Usuario </TITLE>
</HEAD>
<BODY>
<%@ include file = "/cabecera.jsp" %>
<FORM method="POST" action ="/SistemaFrances/MostrarClienteJSP ">
B�squeda de usuarios <BR><BR>
<TABLE border = "0">
<TR>
<TD> Nombre de usuario: </TD>
<TD><INPUT name="nombreUsuario"></TD>
<TD> Contrase�a: </TD>
<TD><INPUT name="password"></TD>
</TR>
<TR>
<TD>
<INPUT type="submit" value="Consultar">
</TD>
</TR>
</TABLE>
</FORM>
</BODY>
</HTML>