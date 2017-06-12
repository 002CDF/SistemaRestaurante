package negocio;
import dao.IngredienteDao;
import java.util.List;
import datos.Ingrediente;
import datos.Conversion;
public class IngredienteABM {
	private IngredienteDao dao = new IngredienteDao();

	public int agregarIngrediente(String nombre, String descripcion, 
			Conversion conversion, double unidadCompra, double unidadConsumo){
		Ingrediente i = new Ingrediente (nombre, descripcion, conversion, 
				unidadCompra, unidadConsumo);
		return dao.agregarIngrediente(i);
	}

	public void modificarIngrediente(Ingrediente ingrediente){
		dao.actualizarIngrediente(ingrediente);
	}

	public void eliminarIngrediente(long idIngrediente){
		Ingrediente i = dao.traerIngrediente(idIngrediente);
		dao.eliminarIngrediente(i);
	}

	public Ingrediente traerIngrediente(long idIngrediente){
		return dao.traerIngrediente(idIngrediente);
	}

	public List<Ingrediente> traerIngrediente(){
		return dao.traerIngrediente();
	}

	public Ingrediente traerIngredienteCompleto (long idIngrediente){
		return dao.traerIngredienteCompleto(idIngrediente);
	}

}
