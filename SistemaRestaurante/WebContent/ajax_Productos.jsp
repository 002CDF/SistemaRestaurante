<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="datos.Producto" %>
<%@page import="negocio.ProductoABM" %>
<%@page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
Producto producto = new Producto();
ProductoABM productoAbm = new ProductoABM();
List<Producto> productos = productoAbm.traerProducto();
PrintWriter salida = response.getWriter();
for(int i=1 ; i<=productos.size() ; i++){
	 salida.println("<option value='"+productos.get(i-1).getIdProducto()+"'>"+productos.get(i-1).getNombre()+"</option>");
}
%>