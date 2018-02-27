package controladores;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import datos.Login;
import facade.Facade;
public class ControladorLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response )
			throws ServletException, IOException {
		procesarPeticion(request, response );
	}
	protected void doPost(HttpServletRequest request , HttpServletResponse response )
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}
	private void procesarPeticion(HttpServletRequest request , HttpServletResponse
			response ) throws ServletException, IOException {
		response.setContentType( "text/html;charset=UTF-8" );
		HttpSession session = request.getSession();
		try {
			String nombreUsuario =  request.getParameter("nombreUsuario");
			String password = request.getParameter("password");
			Facade facade = new Facade();
			Login login = facade.getLoginABM().traerLogin(nombreUsuario, password);
			session.setAttribute("idUsuario", login.getIdLogin());
			session.setAttribute("nombreUsuario", login.getNombreUsuario());
			request.getRequestDispatcher("/inicioRestaurante.jsp").forward(request, response);
		}
		catch (Exception e ) {
			System.out.println(e.getMessage());
			response .sendError(500, "Los datos ingresados no corresponden a un usuario válido." );
		}
		//session.setAttribute("usuario", request.getAttribute("usuario"));
	}
}