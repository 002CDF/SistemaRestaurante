package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Usuario {
	private long idUsuario;
	private String nombreUsuario;
	private String password;
	private TipoUsuario tipoUsuario;
	
	public Usuario(){}

	public Usuario(String nombreUsuario, String password,
			TipoUsuario tipoUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	@Override
	public String toString() {
		return "idUsuario= " + idUsuario+ ", Nombre de Usuario= " + nombreUsuario
				+ ", Password= " + password+ ", Tipo de Usuario= " + tipoUsuario;
	}

	public boolean equals(Usuario usuario){
		boolean igual =false;
		if (this.getIdUsuario()== usuario.getIdUsuario()){
			igual=true;
		}
		return igual;

	}
	
	
}
