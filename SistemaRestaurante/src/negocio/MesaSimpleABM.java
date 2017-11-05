package negocio;
import datos.Mesa;
import datos.MesaSimple;
import dao.MesaSimpleDao;

import java.util.List;

import datos.EstadoMesa;
import datos.MesaSimple;
import datos.Salon;
public class MesaSimpleABM {
	private MesaSimpleDao dao = new MesaSimpleDao();

	public int agregarMesaSimple(long capacidad){
		MesaSimple m = new MesaSimple (capacidad);
		return dao.agregarMesaSimple(m);
	}

	public void modificarMesaSimple(MesaSimple mesaSimple){
		dao.actualizarMesaSimple(mesaSimple);
	}

	public void eliminarMesaSimple(long idMesaSimple){
		MesaSimple m = dao.traerMesaSimple(idMesaSimple);
		dao.eliminarMesaSimple(m);
	}

	public MesaSimple traerMesaSimple(long idMesaSimple){
		return dao.traerMesaSimple(idMesaSimple);
	}

	public List<MesaSimple> traerMesaSimple(){
		return dao.traerMesaSimple();
	}

}
