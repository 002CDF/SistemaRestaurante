package negocio;
import dao.MesaDao;
import java.util.List;
import datos.EstadoMesa;
import datos.Mesa;
import datos.Salon;
public class MesaABM {
	private MesaDao dao = new MesaDao();

	public int agregarMesa(int estadoMesa, int nroMesa, Salon salon){
		Mesa m = new Mesa (estadoMesa, nroMesa, salon);
		return dao.agregarMesa(m);
	}

	public void modificarMesa(Mesa mesa){
		dao.actualizarMesa(mesa);
	}

	public void eliminarMesa(long idMesa){
		Mesa m = dao.traerMesa(idMesa);
		dao.eliminarMesa(m);
	}

	public Mesa traerMesa(long idMesa){
		return dao.traerMesa(idMesa);
	}
	public Mesa traerMesa(int nroMesa){
		return dao.traerMesa(nroMesa);
	}
	public List<Mesa> traerMesa(){
		return dao.traerMesa();
	}
	
}
