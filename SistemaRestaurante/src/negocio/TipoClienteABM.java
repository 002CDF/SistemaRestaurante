package negocio;
import dao.TipoClienteDao;
import java.util.List;
import datos.TipoCliente;
public class TipoClienteABM {
	private TipoClienteDao dao = new TipoClienteDao();

	public int agregarTipoCliente(String tipo){
		TipoCliente t = new TipoCliente (tipo);
		return dao.agregarTipoCliente(t);
	}

	public void modificarTipoCliente(TipoCliente tipoCliente){
		dao.actualizarTipoCliente(tipoCliente);
	}

	public void eliminarTipoCliente(long idTipoCliente){
		TipoCliente t = dao.traerTipoCliente(idTipoCliente);
		dao.eliminarTipoCliente(t);
	}

	public TipoCliente traerTipoCliente(long idTipoCliente){
		return dao.traerTipoCliente(idTipoCliente);
	}

	public List<TipoCliente> traerTipoCliente(){
		return dao.traerTipoCliente();
	}

	public TipoCliente traerTipoClienteNombre(String tipoCliente){
		return dao.traerTipoClienteNombre(tipoCliente);
	}
	
	public TipoCliente traerTipoClienteCompleto (long idTipoCliente){
		return dao.traerTipoClienteCompleto(idTipoCliente);
	}

}
