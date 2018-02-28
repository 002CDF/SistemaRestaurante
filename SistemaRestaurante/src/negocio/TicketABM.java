package negocio;
import dao.TicketDao;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Camarero;
import datos.Cliente;
import datos.Mesa;
import datos.Ticket;
import datos.Usuario;
public class TicketABM {
	private TicketDao dao = new TicketDao();

	public int agregarTicket(double monto, GregorianCalendar fechaEmision,
			Cliente cliente, Camarero camarero, Mesa mesa, Usuario usuario,
			boolean esCortesia){
		Ticket t = new Ticket (monto, fechaEmision, cliente, camarero,
								mesa, usuario, esCortesia);
		return dao.agregarTicket(t);
	}
	
	public int agregarTicketCompleto(Ticket ticket){
		return dao.agregarTicketCompleto(ticket);
	}

	public void modificarTicket(Ticket ticket){
		dao.actualizarTicket(ticket);
	}

	public void eliminarTicket(long idTicket){
		Ticket t = dao.traerTicket(idTicket);
		dao.eliminarTicket(t);
	}

	public Ticket traerTicket(long idTicket){
		return dao.traerTicket(idTicket);
	}
	
	public Ticket traerTicketMesa(long idMesa){
		return dao.traerTicketMesa(idMesa);
	}
	
	public List<Ticket> traerTicket(){
		return dao.traerTicket();
	}

	public Ticket traerTicketCompleto (long idTicket){
		return dao.traerTicketCompleto(idTicket);
	}

}
