<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="datos.Mesa" %>
<%@page import="negocio.MesaABM" %>
<%@page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
Mesa mesa = new Mesa();
MesaABM mesaAbm = new MesaABM();
String color;
List<Mesa> mesas = mesaAbm.traerMesa();
PrintWriter salida = response.getWriter();
salida.println("<table class='table'>");
for(int i=1 ; i<=mesas.size() ; i++){
	 if(mesas.get(i-1).getEstadoMesa()==1) color="green";
	 else if(mesas.get(i-1).getEstadoMesa()==2) color="red";
	 else color="blue";
	  if(i==1) salida.println("<tr>");
	  salida.println("<td><button type='submit' class='btn btn-primary btn-lg btn pull-right' name='mesa' style='background-color:"+color+"' value='"+mesas.get(i-1).getNroMesa()+"'>Mesa"+mesas.get(i-1).getNroMesa()+"</button></td>");
	  if(i%3 == 0) salida.println("</tr></tr>");
	  }
salida.println("</table>");
%>