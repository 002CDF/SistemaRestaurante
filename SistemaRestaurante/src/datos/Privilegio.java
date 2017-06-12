package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Privilegio {
	private long idPrivilegio;
	private String privilegio;
	private Set<TipoUsuario> tipoUsuarios;
	
	public Privilegio(){}

	public Privilegio(String privilegio) {
		super();
		this.privilegio = privilegio;
	}

	public long getIdPrivilegio() {
		return idPrivilegio;
	}

	public void setIdPrivilegio(long idPrivilegio) {
		this.idPrivilegio = idPrivilegio;
	}

	public String getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}

	public Set<TipoUsuario> getTipoUsuarios() {
		return tipoUsuarios;
	}

	public void setTipoUsuarios(Set<TipoUsuario> tipoUsuarios) {
		this.tipoUsuarios = tipoUsuarios;
	}
	
	public void agregarTipoUsuario(TipoUsuario tipoUsuario)throws Exception{
		List<TipoUsuario> lista = new ArrayList(this.tipoUsuarios);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(tipoUsuarios)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		tipoUsuarios.add(tipoUsuario);
	}

	@Override
	public String toString() {
		return "idPrivilegio= " + idPrivilegio+ ", Privilegio= " + privilegio
				+ ", Tipos de Usuarios= " + tipoUsuarios;
	}

	public boolean equals(Privilegio privilegio){
		boolean igual =false;
		if (this.getIdPrivilegio()==privilegio.getIdPrivilegio()){
			igual=true;
		}
		return igual;

	}
	
}
