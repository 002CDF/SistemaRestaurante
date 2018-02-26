package negocio;
import dao.ItemTicketDao;
import datos.ItemTicket;
import datos.Producto;
import datos.Ticket;

import java.util.List;
public class ItemTicketABM {
	private ItemTicketDao dao = new ItemTicketDao();

	public int agregarItemTicket(Producto producto, Ticket ticket, double precioUnitario, long cantidad){
		ItemTicket i = new ItemTicket (producto, ticket, precioUnitario, cantidad);
		return dao.agregarItemTicket(i);
	}
	
	public void agregarItemTicketCompleto(ItemTicket itemTicket){
		dao.agregarItemTicketCompleto(itemTicket);
	}

	public void modificarItemTicket(ItemTicket itemTicket){
		dao.actualizarItemTicket(itemTicket);
	}

	public void eliminarItemTicket(long idItemTicket){
		ItemTicket i = dao.traerItemTicket(idItemTicket);
		dao.eliminarItemTicket(i);
	}

	public ItemTicket traerItemTicket(long idItemTicket){
		return dao.traerItemTicket(idItemTicket);
	}

	public List<ItemTicket> traerItemTicket(){
		return dao.traerItemTicket();
	}

}
