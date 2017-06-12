package negocio;
import dao.ItemRecetaDao;
import java.util.List;
import datos.Ingrediente;
import datos.ItemReceta;
import datos.Receta;
public class ItemRecetaABM {
	private ItemRecetaDao dao = new ItemRecetaDao();
	public int agregarItemReceta(Receta receta, Ingrediente ingrediente, long cantidad){
		ItemReceta i = new ItemReceta (receta, ingrediente, cantidad);
		return dao.agregarItemReceta(i);
	}

	public void modificarItemReceta(ItemReceta itemReceta){
		dao.actualizarItemReceta(itemReceta);
	}

	public void eliminarItemReceta(long idItemReceta){
		ItemReceta i = dao.traerItemReceta(idItemReceta);
		dao.eliminarItemReceta(i);
	}

	public ItemReceta traerItemReceta(long idItemReceta){
		return dao.traerItemReceta(idItemReceta);
	}

	public List<ItemReceta> traerItemReceta(){
		return dao.traerItemReceta();
	}

}
