package negocio;
import dao.ConversionDao;
import java.util.List;
import datos.Ingrediente;
import datos.Conversion;
public class ConversionABM {
	private ConversionDao dao = new ConversionDao();

	public int agregarConversion(String unidad){
		Conversion c = new Conversion (unidad);
		return dao.agregarConversion(c);
	}

	public void modificarConversion(Conversion conversion){
		dao.actualizarConversion(conversion);
	}

	public void eliminarConversion (long idConversion){
		Conversion c = dao.traerConversion(idConversion);
		dao.eliminarConversion(c);
	}

	public Conversion traerConversion (long idConversion){
		return dao.traerConversion(idConversion);
	}

	public List<Conversion> traerConversion(){
		return dao.traerConversion();
	}

}