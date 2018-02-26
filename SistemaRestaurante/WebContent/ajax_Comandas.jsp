<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="datos.Producto" %>
<%@page import="datos.Comanda" %>
<%@page import="datos.Camarero" %>
<%@page import="datos.ItemComanda" %>
<%@page import="negocio.ComandaABM" %>
<%@page import="negocio.ProductoABM" %>
<%@page import="negocio.CamareroABM" %>
<%@page import="negocio.Funciones" %>
<%@page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
Comanda comanda = new Comanda();
ComandaABM comandaAbm = new ComandaABM();
Camarero camarero = new Camarero();
CamareroABM camareroAbm = new CamareroABM();
Producto producto = new Producto();
ProductoABM productoAbm = new ProductoABM();
int contador=0;
List<Comanda> comandas = comandaAbm.traerComanda(); //comandaAbm.traerComandaMesa(Integer.parseInt(request.getParameter("nroMesa")));
// for (Comanda comandaActual : comandas) { //Recorriendo el HashSet
// 	for (ItemComanda itemComanda : comandaActual.getItemComandas()) { 
// 		System.out.println(itemComanda.getProducto().getIdProducto());
// 	}
// }
PrintWriter salida = response.getWriter();
int i=1;
salida.println("<table class='table table-striped'>");
salida.println("<tr>");
salida.println("<th>Comanda</th>");
salida.println("<th>Día</th>");
salida.println("<th>Hora</th>");
salida.println("<th>Producto</th>");
salida.println("<th>Cantidad</th>");
salida.println("</tr>");
for (Comanda comandaActual : comandas) { //Recorriendo el HashSet
	if(comandaActual.getMesa().getIdMesa()==Integer.parseInt(request.getParameter("nroMesa"))){ //Si la mesa es la actual
		if(comandaActual.isActivo()){
			salida.println("<tr>");
			salida.println("<td>"+comandaActual.getIdComanda()+"</td>");
			salida.println("<td>"+Funciones.traerFechaCorta(comandaActual.getFecha())+"</td>");
			salida.println("<td>"+Funciones.traerFechaCortaConHora(comandaActual.getFecha()).substring(11)+"</td>");
			for (ItemComanda itemComanda : comandaActual.getItemComandas()) {
				contador++;
				if(contador<=1){ //si contador no es mayor a 1
				producto = productoAbm.traerProducto(itemComanda.getProducto().getIdProducto());
				salida.println("<td>"+producto.getNombre()+"</td>");
				salida.println("<td>"+itemComanda.getCantidad()+"</td>");
				}
			
				if(contador>1){
				salida.println("<tr>");
				salida.println("<td>"+comandaActual.getIdComanda()+"</td>");
				salida.println("<td>"+Funciones.traerFechaCorta(comandaActual.getFecha())+"</td>");
				salida.println("<td>"+Funciones.traerFechaCortaConHora(comandaActual.getFecha()).substring(11)+"</td>");
				//Agrego otro producto
				producto = productoAbm.traerProducto(itemComanda.getProducto().getIdProducto());
				salida.println("<td>"+producto.getNombre()+"</td>");
				salida.println("<td>"+itemComanda.getCantidad()+"</td>");
				}
				salida.println("</tr>");
			
			}
		contador = 0;
		i++;
		camarero = null;
		producto = null;
		}
	}
}
salida.println("</table>");

//for(int i=1 ; i<=productos.size() ; i++){
//	 salida.println("<option value='"+productos.get(i-1).getIdProducto()+"'>"+productos.get(i-1).getNombre()+"</option>");
//}
%>