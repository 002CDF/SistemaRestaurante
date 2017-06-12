package negocio;
import dao.SubRubroDao;
import java.util.List;
import datos.SubRubro;
public class SubRubroABM {
	private SubRubroDao dao = new SubRubroDao();

	public int agregarSubRubro(String descripcion){
		SubRubro s = new SubRubro (descripcion);
		return dao.agregarSubRubro(s);
	}

	public void modificarSubRubro(SubRubro subRubro){
		dao.actualizarSubRubro(subRubro);
	}

	public void eliminarSubRubro(long idSubRubro){
		SubRubro s = dao.traerSubRubro(idSubRubro);
		dao.eliminarSubRubro(s);
	}

	public SubRubro traerSubRubro(long idSubRubro){
		return dao.traerSubRubro(idSubRubro);
	}

	public List<SubRubro> traerSubRubro(){
		return dao.traerSubRubro();
	}

	public SubRubro traerSubRubroCompleto (long idSubRubro){
		return dao.traerSubRubroCompleto(idSubRubro);
	}

}
