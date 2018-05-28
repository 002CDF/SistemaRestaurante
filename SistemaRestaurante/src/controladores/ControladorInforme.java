package controladores;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.TicketABM;
import datos.Informe;
import datos.Ticket;
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
			double totalFacturado=0;
			double maxTicket = 0;
			double promedio = 0;
			String fechaInicio =  request.getParameter("fechaInicio");
			String fechaFin =  request.getParameter("fechaFin");
			TicketABM tabm = new TicketABM();
			List<Ticket> listaTickets= tabm.traerInformeTicket(fechaInicio, fechaFin);
			int cantidadTickets = listaTickets.size();
			for(int i=0; i<cantidadTickets; i++){
				totalFacturado+=listaTickets.get(i).getMonto();
				if(listaTickets.get(i).getMonto()>maxTicket) maxTicket = listaTickets.get(i).getMonto();
			}
			if(cantidadTickets>0) promedio = totalFacturado/cantidadTickets;
			Informe informe = new Informe(fechaInicio, fechaFin, cantidadTickets, totalFacturado, maxTicket, promedio);
			informe.setTickets(listaTickets);
			session.setAttribute("informe", informe); //Objeto informe en variable de sesion (debe ser borrado posteriormente)
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