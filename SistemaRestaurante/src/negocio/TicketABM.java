package negocio;
import dao.TicketDao;
import java.util.List;
import datos.Ticket;
import datos.Usuario;
public class TicketABM {
	private TicketDao dao = new TicketDao();

	public int agregarTicket(double monto, Usuario usuario, boolean esFiscal,
			boolean esCortesia){
		Ticket t = new Ticket (monto, usuario, esFiscal, esCortesia);
		return dao.agregarTicket(t);
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

	public List<Ticket> traerTicket(){
		return dao.traerTicket();
	}

	public Ticket traerTicketCompleto (long idTicket){
		return dao.traerTicketCompleto(idTicket);
	}

}
