package negocio;
import dao.ItemListaPrecioDao;
import java.util.List;
import datos.ItemListaPrecio;
import datos.ListaPrecio;
import datos.Producto;
public class ItemListaPrecioABM {
	private ItemListaPrecioDao dao = new ItemListaPrecioDao();

	public int agregarItemListaPrecio(ListaPrecio listaPrecio, Producto producto,
			double precio){
		ItemListaPrecio i = new ItemListaPrecio (listaPrecio, producto, precio);
		return dao.agregarItemListaPrecio(i);
	}

	public void modificarItemListaPrecio(ItemListaPrecio itemListaPrecio){
		dao.actualizarItemListaPrecio(itemListaPrecio);
	}

	public void eliminarItemListaPrecio(long idItemListaPrecio){
		ItemListaPrecio i = dao.traerItemListaPrecio(idItemListaPrecio);
		dao.eliminarItemListaPrecio(i);
	}

	public ItemListaPrecio traerItemListaPrecio(long idItemListaPrecio){
		return dao.traerItemListaPrecio(idItemListaPrecio);
	}

	public List<ItemListaPrecio> traerItemListaPrecio(){
		return dao.traerItemListaPrecio();
	}

}
