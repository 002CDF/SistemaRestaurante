package negocio;
import dao.MesaSimpleDao;

import java.util.List;

import datos.EstadoMesa;
import datos.MesaSimple;
import datos.Salon;
public class MesaSimpleABM {
	private MesaSimpleDao dao = new MesaSimpleDao();

	public int agregarMesaSimple(EstadoMesa estadoMesa, Salon salon, long idMesaSimple, int capacidad){
		MesaSimple m = new MesaSimple (estadoMesa, salon, idMesaSimple, capacidad);
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

	public MesaSimple traerMesaSimpleCompleto (long idMesaSimple){
		return dao.traerMesaSimpleCompleto(idMesaSimple);
	}

}
