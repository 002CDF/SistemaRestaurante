package negocio;

import dao.TipoUsuarioDao;
import java.util.List;
import datos.TipoUsuario;

public class TipoUsuarioABM {
	private TipoUsuarioDao dao = new TipoUsuarioDao();

	public int agregarTipoUsuario(String tipoUsuario) {
		TipoUsuario t = new TipoUsuario(tipoUsuario);
		return dao.agregarTipoUsuario(t);
	}

	public void modificarTipoUsuario(TipoUsuario tipoUsuario) {
		dao.actualizarTipoUsuario(tipoUsuario);
	}

	public void eliminarTipoUsuario(long idTipoUsuario) {
		TipoUsuario t = dao.traerTipoUsuario(idTipoUsuario);
		dao.eliminarTipoUsuario(t);
	}

	public TipoUsuario traerTipoUsuario(long idTipoUsuario) {
		return dao.traerTipoUsuario(idTipoUsuario);
	}

	public List<TipoUsuario> traerTipoUsuario() {
		return dao.traerTipoUsuario();
	}

	public TipoUsuario traerTipoUsuarioCompleto(long idTipoUsuario) {
		return dao.traerTipoUsuarioCompleto(idTipoUsuario);
	}

}
