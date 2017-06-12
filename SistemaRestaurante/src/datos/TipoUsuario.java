package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class TipoUsuario {
	private long idTipoUsuario;
	private String tipoUsuario;
	private Set<Privilegio> privilegios;
	
	public TipoUsuario(){}

	public TipoUsuario(String tipoUsuario) {
		super();
		this.tipoUsuario = tipoUsuario;
	}

	public long getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Set<Privilegio> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(Set<Privilegio> privilegios) {
		this.privilegios = privilegios;
	}
	
	public void agregarPrivilegio(Privilegio privilegio)throws Exception{
		List<Privilegio> lista = new ArrayList(this.privilegios);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(privilegio)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		privilegios.add(privilegio);
	}

	@Override
	public String toString() {
		return "idTipoUsuario= " + idTipoUsuario+ ", Tipo Usuario= " + tipoUsuario
				+ ", Privilegios= " + privilegios;
	}

	public boolean equals(TipoUsuario tipoUsuario){
		boolean igual =false;
		if (this.getIdTipoUsuario()== tipoUsuario.getIdTipoUsuario()){
			igual=true;
		}
		return igual;

	}
	
	
}
