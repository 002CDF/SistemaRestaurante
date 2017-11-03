package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import datos.Mesa;
public class MesaSimple extends Mesa{
	private Mesa mesa;
	private long capacidad;
	
	public MesaSimple(){}

	public MesaSimple(Mesa mesa, long capacidad) {
		super();
		this.mesa = mesa;
		this.capacidad = capacidad;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(long capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "MesaSimple [mesa=" + mesa + ", capacidad=" + capacidad + "]";
	}

	
	
}
