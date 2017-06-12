package negocio;
import dao.ViandaDao;
import java.util.List;
import datos.Vianda;
public class ViandaABM {
	private ViandaDao dao = new ViandaDao();

	public int agregarVianda(String descripcion){
		Vianda v = new Vianda (descripcion);
		return dao.agregarVianda(v);
	}

	public void modificarVianda(Vianda vianda){
		dao.actualizarVianda(vianda);
	}

	public void eliminarVianda(long idVianda){
		Vianda v = dao.traerVianda(idVianda);
		dao.eliminarVianda(v);
	}

	public Vianda traerVianda(long idVianda){
		return dao.traerVianda(idVianda);
	}

	public List<Vianda> traerVianda(){
		return dao.traerVianda();
	}

	public Vianda traerViandaCompleto (long idVianda){
		return dao.traerViandaCompleto(idVianda);
	}

}
