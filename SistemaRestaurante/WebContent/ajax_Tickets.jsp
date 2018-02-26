<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="datos.Producto" %>
<%@page import="datos.Ticket" %>
<%@page import="datos.Camarero" %>
<%@page import="datos.ItemTicket" %>
<%@page import="negocio.TicketABM" %>
<%@page import="datos.TipoCliente" %>
<%@page import="negocio.TipoClienteABM" %>
<%@page import="negocio.ProductoABM" %>
<%@page import="negocio.CamareroABM" %>
<%@page import="negocio.Funciones" %>
<%@page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
Ticket ticket = new Ticket();
TicketABM ticketAbm = new TicketABM();
Camarero camarero = new Camarero();
CamareroABM camareroAbm = new CamareroABM();
Producto producto = new Producto();
ProductoABM productoAbm = new ProductoABM();
TipoCliente tipoCliente = new TipoCliente();
TipoClienteABM tipoClienteAbm = new TipoClienteABM();
PrintWriter salida = response.getWriter();

//Levantando el ticket completo:
ticket = ticketAbm.traerTicketMesa(Integer.parseInt(request.getParameter("nroMesa")));

salida.println("<h3>Pre-ticket: </h3>");

salida.println("Nro ticket: "+ticket.getIdTicket()+"<br>");
salida.println("Fecha de emision: "+Funciones.traerFechaCortaConHora(ticket.getFechaEmision())+"<br>");
if(ticket.getCliente()==null) salida.println("DNI cliente: S/D <br>");
else salida.println("DNI cliente: "+ticket.getCliente().getDni()+"<br>");
salida.println("Camarero: "+ticket.getCamarero().getNombre()+"<br>");
salida.println("ID Cajero: "+ticket.getUsuario().getIdUsuario()+"<br><br><br>");

salida.println("<table class='table table-striped'>");
salida.println("<tr>");
salida.println("<th>Producto</th>");
salida.println("<th>Cantidad</th>");
salida.println("<th>Precio</th>");
salida.println("</tr>");

for (ItemTicket itemTicket : ticket.getItemTickets()) { //Recorriendo el HashSet
	salida.println("<tr>");
	producto = productoAbm.traerProducto(itemTicket.getProducto().getIdProducto());
	salida.println("<td>"+producto.getNombre()+"</td>");
	salida.println("<td>"+itemTicket.getCantidad()+"</td>");
	salida.println("<td> $"+itemTicket.calcularSubTotal()+"</td>");
	salida.println("</tr>");
}

salida.println("<tr>");
salida.println("<td> </td>");
salida.println("<td> </td>");
salida.println("<td><strong> Total: $"+ticket.calcularTotal()+"</strong></td>");
salida.println("</tr>");

salida.println("</table>");

//for(int i=1 ; i<=productos.size() ; i++){
//	 salida.println("<option value='"+productos.get(i-1).getIdProducto()+"'>"+productos.get(i-1).getNombre()+"</option>");
//}
%>