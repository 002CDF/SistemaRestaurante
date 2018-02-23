package negocio;
import dao.CamareroDao;

import java.util.List;

import datos.Camarero;
public class CamareroABM {
	private CamareroDao dao = new CamareroDao();

	public int agregarCamarero(long dni, String nombre, String apellido){
		Camarero c = new Camarero (dni, nombre, apellido);
		return dao.agregarCamarero(c);
	}

	public void modificarCamarero(Camarero camarero){
		dao.actualizarCamarero(camarero);
	}

	public void eliminarCamarero(long idCamarero){
		Camarero c = dao.traerCamarero(idCamarero);
		dao.eliminarCamarero(c);
	}

	public Camarero traerCamarero(long idCamarero){
		return dao.traerCamarero(idCamarero);
	}
	
	public Camarero traerCamareroDNI(long dniCamarero){
		return dao.traerCamareroDNI(dniCamarero);
	}

	public List<Camarero> traerCamarero(){
		return dao.traerCamarero();
	}

	public Camarero traerCamareroCompleto (long idCamarero){
		return dao.traerCamareroCompleto(idCamarero);
	}

}
