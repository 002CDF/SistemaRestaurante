package negocio;
import dao.UsuarioDao;
import java.util.List;
import datos.TipoUsuario;
import datos.Usuario;
public class UsuarioABM {
	private UsuarioDao dao = new UsuarioDao();

	public int agregarUsuario(String nombreUsuario, String password,
			TipoUsuario tipoUsuario){
		Usuario u = new Usuario (nombreUsuario, password, tipoUsuario);
		return dao.agregarUsuario(u);
	}

	public void modificarUsuario(Usuario usuario){
		dao.actualizarUsuario(usuario);
	}

	public void eliminarUsuario(long idUsuario){
		Usuario u = dao.traerUsuario(idUsuario);
		dao.eliminarUsuario(u);
	}

	public Usuario traerUsuario(long idUsuario){
		return dao.traerUsuario(idUsuario);
	}
	
	public Usuario traerUsuario(String nombreUsuario, String password){
		return dao.traerUsuario(nombreUsuario, password);
	}
	
	public List<Usuario> traerUsuario(){
		return dao.traerUsuario();
	}

}
