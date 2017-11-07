package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Mesa;
import negocio.MesaABM;

public class ControladorMesa extends HttpServlet {
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
		Mesa mesa = new Mesa();
		MesaABM mesaAbm = new MesaABM();
		try {
			int numMesa = Integer.parseInt(request.getParameter("mesa"));
			mesa = mesaAbm.traerMesa(numMesa);
			request.setAttribute("mesa", mesa);
			mesa.getSalon().getDescripcion();
			request.getRequestDispatcher("/detalleMesa.jsp").forward(request, response);
		}
		catch (Exception e ) {
			System.out.println(e.getMessage());
			response .sendError(500, "Error al traer la mesa" );
		}
		//session.setAttribute("usuario", request.getAttribute("usuario"));
	}
}