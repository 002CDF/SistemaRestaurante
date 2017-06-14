package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Mesa {
	protected long idMesa;
	protected EstadoMesa estadoMesa;
	protected Salon salon;
	
	public Mesa(){}

	public Mesa(EstadoMesa estadoMesa, Salon salon) { //Patron state va en el constructor?
		super(); //Al ser una superclase, debe tener esto?
		this.estadoMesa = estadoMesa;
		this.salon = salon;
	}

	public long getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(long idMesa) {
		this.idMesa = idMesa;
	}

	public EstadoMesa getEstadoMesa() {
		return estadoMesa;
	}

	public void setEstadoMesa(EstadoMesa estadoMesa) {
		this.estadoMesa = estadoMesa;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	
	
}
