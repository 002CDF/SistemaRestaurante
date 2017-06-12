package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class MesaSimple extends Mesa{
	private long idMesaSimple;
	private int capacidad;
	
	public MesaSimple(){}

	public MesaSimple(EstadoMesa estadoMesa, Salon salon, long idMesaSimple, int capacidad) {
		super(estadoMesa, salon);
		this.idMesaSimple = idMesaSimple;
		this.capacidad = capacidad;
	}

	public long getIdMesaSimple() {
		return idMesaSimple;
	}

	public void setIdMesaSimple(long idMesaSimple) {
		this.idMesaSimple = idMesaSimple;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "idMesaSimple= " + idMesaSimple+ ", Capacidad= " + capacidad;
	}

	public boolean equals(MesaSimple mesaSimple){
		boolean igual =false;
		if (this.getIdMesaSimple()==mesaSimple.getIdMesaSimple()){
			igual=true;
		}
		return igual;

	}
	

	
	
	
	
}
