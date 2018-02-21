<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="datos.Salon" %>
<%@page import="negocio.SalonABM" %>
<%@page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
Salon salon = new Salon();
SalonABM salonAbm = new SalonABM();
String color;
List<Salon> salones = salonAbm.traerSalon();
PrintWriter salida = response.getWriter();
salida.println("<option value='' selected disabled>Seleccionar</option>");
for(int i=1 ; i<=salones.size() ; i++){
	 salida.println("<option value='"+salones.get(i-1).getIdSalon()+"'>"+salones.get(i-1).getDescripcion()+"</option>");
}
%>