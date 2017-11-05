package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Mesa {
	private long idMesa;
	private int estadoMesa;
	private int nroMesa;
	private Salon salon;
	private Set<MesaSimple> mesaSimples;
	
	public Mesa(){}

	public Mesa(int estadoMesa, int nroMesa, Salon salon) {
		super();
		this.estadoMesa = estadoMesa;
		this.nroMesa = nroMesa;
		this.salon = salon;
	}

	public long getIdMesa() {
		return idMesa;
	}

	protected void setIdMesa(long idMesa) {
		this.idMesa = idMesa;
	}

	public int getEstadoMesa() {
		return estadoMesa;
	}

	public void setEstadoMesa(int estadoMesa) {
		this.estadoMesa = estadoMesa;
	}

	public long getNroMesa() {
		return nroMesa;
	}

	public void setNroMesa(int nroMesa) {
		this.nroMesa = nroMesa;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Set<MesaSimple> getMesaSimples() {
		return mesaSimples;
	}

	public void setMesaSimples(Set<MesaSimple> mesaSimples) {
		this.mesaSimples = mesaSimples;
	}

	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", estadoMesa=" + estadoMesa
				+ ", nroMesa=" + nroMesa + ", salon=" + salon + "]";
	}

	
	
	

}

	