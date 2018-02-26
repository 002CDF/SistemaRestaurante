package state;
import negocio.ItemTicketABM;
import negocio.TicketABM;
import datos.Comanda;
import datos.ItemListaPrecio;
import datos.ItemTicket;
import datos.Mesa;
import datos.Ticket;
import datos.Usuario;
public class Ocupada extends EstadoMesa{
	@Override
	public EstadoMesa dejarDisponible(long idMesa) {
		try {
			throw new Exception( "Error, la mesa ya esta ocupada, primero debe finalizarse" );
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return this;
	}
	@Override
	public EstadoMesa ocupar(Usuario usuario, Comanda comanda) {
		try {
			throw new Exception( "Error, esta mesa ya está ocupada" );
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return this;
	}
	@Override
	public EstadoMesa finalizar(Ticket ticket) {
		ItemTicketABM itemTicketAbm = new ItemTicketABM();
		TicketABM ticketAbm = new TicketABM();
		long idTicketUltimo = ticketAbm.agregarTicketCompleto(ticket);
		ticket.setIdTicket(idTicketUltimo);
		for (ItemTicket itemTicket : ticket.getItemTickets()) {
			itemTicketAbm.agregarItemTicketCompleto(itemTicket);
		}
		return new Finalizada();
	}
}