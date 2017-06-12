package negocio;
import dao.RecetaDao;

import java.util.List;

import datos.Receta;
public class RecetaABM {
	private RecetaDao dao = new RecetaDao();

	public int agregarReceta(String nombre, String descripcion){
		Receta r = new Receta (nombre, descripcion);
		return dao.agregarReceta(r);
	}

	public void modificarReceta(Receta receta){
		dao.actualizarReceta(receta);
	}

	public void eliminarReceta(long idReceta){
		Receta r = dao.traerReceta(idReceta);
		dao.eliminarReceta(r);
	}

	public Receta traerReceta(long idReceta){
		return dao.traerReceta(idReceta);
	}

	public List<Receta> traerReceta(){
		return dao.traerReceta();
	}

	public Receta traerRecetaCompleto (long idReceta){
		return dao.traerRecetaCompleto(idReceta);
	}

}
