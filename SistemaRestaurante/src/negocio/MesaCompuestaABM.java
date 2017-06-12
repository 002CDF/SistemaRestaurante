package negocio;
import dao.MesaCompuestaDao;
import java.util.List;
import datos.MesaCompuesta;
public class MesaCompuestaABM {
	private MesaCompuestaDao dao = new MesaCompuestaDao();

	public int agregarMesaCompuesta(){
		MesaCompuesta m = new MesaCompuesta();
		return dao.agregarMesaCompuesta(m);
	}

	public void modificarMesaCompuesta(MesaCompuesta mesaCompuesta){
		dao.actualizarMesaCompuesta(mesaCompuesta);
	}

	public void eliminarMesaCompuesta(long idMesaCompuesta){
		MesaCompuesta m = dao.traerMesaCompuesta(idMesaCompuesta);
		dao.eliminarMesaCompuesta(m);
	}

	public MesaCompuesta traerMesaCompuesta(long idMesaCompuesta){
		return dao.traerMesaCompuesta(idMesaCompuesta);
	}

	public List<MesaCompuesta> traerMesaCompuesta(){
		return dao.traerMesaCompuesta();
	}

	public MesaCompuesta traerMesaCompuestaCompleto (long idMesaCompuesta){
		return dao.traerMesaCompuestaCompleto(idMesaCompuesta);
	}

}
