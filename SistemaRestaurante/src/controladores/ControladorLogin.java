package controladores;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import datos.Usuario;
import negocio.UsuarioABM;
public class ControladorLogin extends HttpServlet {
protected void doGet(HttpServletRequest request , HttpServletResponse response )
throws ServletException, IOException {
procesarPeticion( request , response );
}
protected void doPost(HttpServletRequest request , HttpServletResponse response )
throws ServletException, IOException {
procesarPeticion( request , response );
}
private void procesarPeticion(HttpServletRequest request , HttpServletResponse
response ) throws ServletException, IOException {
response .setContentType( "text/html;charset=UTF-8" );
try {
String nombreUsuario =  request.getParameter("nombreUsuario");
String password = request.getParameter("password");
UsuarioABM usuarioAbm = new UsuarioABM ();
Usuario usuario = usuarioAbm.traerUsuario(nombreUsuario, password);
response.setStatus(200);
PrintWriter salida = response.getWriter();
salida.println( "" );
salida.println( "<!DOCTYPE 4.01 Transitional//EN\">" );
salida.println( "<HTML>" );
salida.println( " <HEAD>" );
salida.println( " <TITLE>Sistema Restaurante</TITLE>" );
salida.println( " </HEAD>" );
salida.println( " <BODY>" );
salida.println( " Nombre de Usuario: " +usuario.getNombreUsuario()+ "<BR>" );
salida.println( " Contraseña : " +usuario.getPassword()+ "<BR>" );
salida.println( "<A href=\"/SistemaRestaurante/usuario.html\">Volver...</A>" );
salida.println( " </BODY>" );
salida.println( "</HTML>" );
}
catch (Exception e) {
response.sendError(500, "Los datos ingresados no corresponden a un usuario valido." );
}
}
}