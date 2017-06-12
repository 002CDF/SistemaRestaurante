package negocio;
import dao.SalonDao;
import java.util.List;
import datos.Salon;
public class SalonABM {
	private SalonDao dao = new SalonDao();

	public int agregarSalon(String descripcion){
		Salon s = new Salon (descripcion);
		return dao.agregarSalon(s);
	}

	public void modificarSalon(Salon salon){
		dao.actualizarSalon(salon);
	}

	public void eliminarSalon(long idSalon){
		Salon s = dao.traerSalon(idSalon);
		dao.eliminarSalon(s);
	}

	public Salon traerSalon(long idSalon){
		return dao.traerSalon(idSalon);
	}

	public List<Salon> traerSalon(){
		return dao.traerSalon();
	}

	public Salon traerSalonCompleto (long idSalon){
		return dao.traerSalonCompleto(idSalon);
	}

}
