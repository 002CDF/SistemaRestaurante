package negocio;
import dao.RubroDao;

import java.util.List;

import datos.Rubro;
public class RubroABM {
	private RubroDao dao = new RubroDao();

	public int agregarRubro(String descripcion){
		Rubro r = new Rubro (descripcion);
		return dao.agregarRubro(r);
	}

	public void modificarRubro(Rubro rubro){
		dao.actualizarRubro(rubro);
	}

	public void eliminarRubro(long idRubro){
		Rubro r = dao.traerRubro(idRubro);
		dao.eliminarRubro(r);
	}

	public Rubro traerRubro(long idRubro){
		return dao.traerRubro(idRubro);
	}

	public List<Rubro> traerRubro(){
		return dao.traerRubro();
	}

	public Rubro traerRubroCompleto (long idRubro){
		return dao.traerRubroCompleto(idRubro);
	}

}
