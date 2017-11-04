package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Usuario {
	private long idUsuario;
	private String nombre;
	private String apellido;
	private TipoUsuario tipoUsuario;
	private Login login;
	
	public Usuario(){}

	public Usuario(String nombre, String apellido,
			TipoUsuario tipoUsuario, Login login) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoUsuario = tipoUsuario;
		this.login = login;
		
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	protected void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoUsuario="
				+ tipoUsuario + "]";
	}

	public boolean equals(Usuario usuario){
		boolean igual =false;
		if (this.getIdUsuario()== usuario.getIdUsuario()){
			igual=true;
		}
		return igual;

	}
	
	
	
	
}
