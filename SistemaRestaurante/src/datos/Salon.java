package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Salon {
	private long idSalon;
	private String descripcion;
	private Set<Mesa> mesas;
	
	public Salon(){}

	public Salon(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public long getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(long idSalon) {
		this.idSalon = idSalon;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Set<Mesa> mesas) {
		this.mesas = mesas;
	}
	
	public void agregarMesa(Mesa mesa)throws Exception{
		List<Mesa> lista = new ArrayList(this.mesas);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(mesas)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		mesas.add(mesa);
	}
	
	@Override
	public String toString() {
		return "idSalon= " + idSalon+ ", Descripcion= " + descripcion
				+ ", Mesas= " + mesas;
	}

	public boolean equals(Salon salon){
		boolean igual =false;
		if (this.getIdSalon()== salon.getIdSalon()){
			igual=true;
		}
		return igual;

	}
	
}
