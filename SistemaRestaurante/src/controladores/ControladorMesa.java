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
import datos.Salon;
import negocio.SalonABM;

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
		//NOTA: ACÁ ENTRAN TODOS LOS FORM RELACIONADOS A CUALQUIER MESA.
		//LOS TIPO HIDDEN QUE ENTRAN DEFINEN LA ACCION A REALIZAR:
		//-1 = Ocupar
		//-2 = Mover
		Mesa mesa = new Mesa();
		MesaABM mesaAbm = new MesaABM();
		//
		response.setContentType( "text/html;charset=UTF-8" );
		HttpSession session = request.getSession();
		//Mover mesa de salón
		if(request.getParameter("tipoAccion") != null && request.getParameter("tipoAccion").equalsIgnoreCase("-2")){
			try{
				Salon salon = new Salon();
				SalonABM salonAbm = new SalonABM();
				long idSalon = Integer.parseInt(request.getParameter("salon"));
				System.out.println("hasta aca anda");
				salon = salonAbm.traerSalon(idSalon);
				int numMesa = Integer.parseInt(request.getParameter("mesa"));
				System.out.println("hasta aca anda");
				mesa = mesaAbm.traerMesa(numMesa);
				if(mesa.getSalon().getIdSalon() != salon.getIdSalon()){ //Si no está en ese salon
				mesa.setSalon(salon);
				mesaAbm.modificarMesa(mesa);
				}
				else session.setAttribute("errorSalon", "La mesa "+mesa.getNroMesa()+" ya se encuentra en ese salon");
				request.getRequestDispatcher("/pedidos.jsp").forward(request, response);
			}
			catch (Exception e ) {
				System.out.println(e.getMessage());
				response .sendError(500, "Error al cambiar la mesa de salon" );
			}
		}
		
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