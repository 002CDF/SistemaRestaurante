<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="datos.Mesa" %>
<%@page import="negocio.MesaABM" %>
<%@page import="datos.Salon" %>
<%@page import="negocio.SalonABM" %>
<%@page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
Mesa mesa = new Mesa();
MesaABM mesaAbm = new MesaABM();
Salon salon = new Salon();
SalonABM salonAbm = new SalonABM();
String color;
int cantDisponibles=0, cantOcupadas=0, cantFinalizadas=0;
List<Salon> salones = salonAbm.traerSalon();
List<Mesa> mesas = mesaAbm.traerMesa();
PrintWriter salida = response.getWriter();
for(int j=1 ; j<=salones.size() ; j++){
	if(j>1) salida.println("<br><br><br>");
	salida.println("<strong>Salon "+salones.get(j-1).getIdSalon()+": "+salones.get(j-1).getDescripcion()+"</strong>");
	salida.println("<table class='table'>");
	for(int i=1 ; i<=mesas.size() ; i++){
		if(salones.get(j-1).getIdSalon() == mesas.get(i-1).getSalon().getIdSalon()){
	 		if(mesas.get(i-1).getEstadoMesa()==1){
	 			color="green";
	 			cantDisponibles++;
	 		}
			 else if(mesas.get(i-1).getEstadoMesa()==2){
				 color="red";
				 cantOcupadas++;
			 }
	 		else{
	 			color="blue";
	 			cantFinalizadas++;
	 		}
	 	 	if(i==1) salida.println("<tr>");
	  		salida.println("<td><button type='submit' class='btn btn-primary btn-lg btn pull-right' name='mesa' style='background-color:"+color+"' value='"+mesas.get(i-1).getNroMesa()+"'>Mesa"+mesas.get(i-1).getNroMesa()+"</button></td>");
	 	 	if(i%3 == 0) salida.println("</tr></tr>");
		}
	  }
salida.println("</table>");
salida.println("<span class='badge badge-success'>Disponibles</span> "+cantDisponibles+"<br>");
salida.println("<span class='badge badge-danger'>Ocupadas</span> "+cantOcupadas+"<br>");
salida.println("<span class='badge badge-primary'>Finalizadas</span> "+cantFinalizadas+"<br>");
cantDisponibles=0;
cantOcupadas=0;
cantFinalizadas=0;
}
%>