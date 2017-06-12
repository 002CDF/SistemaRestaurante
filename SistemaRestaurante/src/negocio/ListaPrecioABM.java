package negocio;
import dao.ListaPrecioDao;
import java.util.GregorianCalendar;
import java.util.List;
import datos.ListaPrecio;
import datos.TipoCliente;
public class ListaPrecioABM {
	private ListaPrecioDao dao = new ListaPrecioDao();

	public int agregarListaPrecio(GregorianCalendar fecha, TipoCliente tipoCliente){
		ListaPrecio l = new ListaPrecio (fecha, tipoCliente);
		return dao.agregarListaPrecio(l);
	}

	public void modificarListaPrecio(ListaPrecio listaPrecio){
		dao.actualizarListaPrecio(listaPrecio);
	}

	public void eliminarListaPrecio(long idListaPrecio){
		ListaPrecio l = dao.traerListaPrecio(idListaPrecio);
		dao.eliminarListaPrecio(l);
	}

	public ListaPrecio traerListaPrecio(long idListaPrecio){
		return dao.traerListaPrecio(idListaPrecio);
	}

	public List<ListaPrecio> traerListaPrecio(){
		return dao.traerListaPrecio();
	}

	public ListaPrecio traerListaPrecioCompleto (long idListaPrecio){
		return dao.traerListaPrecioCompleto(idListaPrecio);
	}

}
