package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import datos.Mesa;
public class MesaSimple{
	private long idMesaSimple;
	private long capacidad;
	
	public MesaSimple(){}

	public MesaSimple(long capacidad) {
		super();
		this.capacidad = capacidad;
	}

	public long getIdMesaSimple() {
		return idMesaSimple;
	}

	protected void setIdMesaSimple(long idMesaSimple) {
		this.idMesaSimple = idMesaSimple;
	}

	public long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(long capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "MesaSimple [idMesaSimple=" + idMesaSimple + ", capacidad="
				+ capacidad + "]";
	}

	

	
	
}
