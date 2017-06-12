package negocio;
import dao.ItemTicketDao;
import datos.ItemTicket;
import datos.Producto;
import java.util.List;
public class ItemTicketABM {
	private ItemTicketDao dao = new ItemTicketDao();

	public int agregarItemTicket(Producto producto, double precioUnitario, int cantidad){
		ItemTicket i = new ItemTicket (producto, precioUnitario, cantidad);
		return dao.agregarItemTicket(i);
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
