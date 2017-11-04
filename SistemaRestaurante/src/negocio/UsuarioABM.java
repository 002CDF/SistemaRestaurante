package negocio;
import dao.UsuarioDao;
import java.util.List;

import datos.Login;
import datos.TipoUsuario;
import datos.Usuario;
public class UsuarioABM {
	private UsuarioDao dao = new UsuarioDao();

	public int agregarUsuario(String nombre, String apellido,
			TipoUsuario tipoUsuario, Login login){
		Usuario u = new Usuario (nombre, apellido,tipoUsuario,login);
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
	
	public Usuario traerUsuario(String nombre, String apellido){
		return dao.traerUsuario(nombre, apellido);
	}
	
	public List<Usuario> traerUsuario(){
		return dao.traerUsuario();
	}

}
