package negocio;
import dao.ItemComandaDao;
import java.util.List;
import datos.Comanda;
import datos.ItemComanda;
import datos.Producto;
public class ItemComandaABM {
	private ItemComandaDao dao = new ItemComandaDao();

	public int agregarItemComanda(Comanda comanda, Producto producto, long cantidad){
		ItemComanda i = new ItemComanda (comanda, producto, cantidad);
		return dao.agregarItemComanda(i);
	}

	public void modificarItemComanda(ItemComanda itemComanda){
		dao.actualizarItemComanda(itemComanda);
	}

	public void eliminarItemComanda(long idItemComanda){
		ItemComanda i = dao.traerItemComanda(idItemComanda);
		dao.eliminarItemComanda(i);
	}

	public ItemComanda traerItemComanda(long idItemComanda){
		return dao.traerItemComanda(idItemComanda);
	}
	
	public List<ItemComanda> traerItemComandas(Comanda comanda){
		return dao.traerItemComandas(comanda.getIdComanda());
	}

	public List<ItemComanda> traerItemComanda(){
		return dao.traerItemComanda();
	}

}
