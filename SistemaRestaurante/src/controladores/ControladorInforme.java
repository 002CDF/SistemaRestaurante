package controladores;
import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.Funciones;
import datos.Login;
import facade.Facade;
public class ControladorInforme extends HttpServlet {
	
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
			String fechaInicio =  request.getParameter("fechaInicio");
			String fechaFin =  request.getParameter("fechaFin");
			System.out.println(fechaInicio);
			System.out.println(fechaFin);
			session.setAttribute("hayFecha", 1); //Flag para validar en la vista (se debe volver a 0 una vez que se muestra)
			
			request.getRequestDispatcher("/informe.jsp").forward(request, response);
		}
		catch (Exception e ) {
			System.out.println(e.getMessage());
			response .sendError(500, "Error al realizar el informe." );
		}
		//session.setAttribute("usuario", request.getAttribute("usuario"));
	}
}