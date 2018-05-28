<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@page import="datos.Producto" %>
<%@page import="negocio.ProductoABM" %>
<%@page import="java.io.PrintWriter" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
//System.out.println(field1);
long idRubro = Integer.parseInt(request.getParameter("idRubro"));

Producto producto = new Producto();
ProductoABM productoAbm = new ProductoABM();
List<Producto> productos = productoAbm.traerProductoPorRubro(idRubro);
System.out.println(productos.size());
PrintWriter salida = response.getWriter();
salida.println("<option value='-1' selected disabled>Producto</option>");
for(int i=1 ; i<=productos.size() ; i++){
   salida.println("<option value='"+productos.get(i-1).getIdProducto()+"'>"+productos.get(i-1).getNombre()+"</option>");
}

%>