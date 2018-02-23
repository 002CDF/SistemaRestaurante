package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import datos.Usuario;
import datos.Comanda;
import state.EstadoMesa;
import state.Disponible;
import state.Ocupada;
import state.Finalizada;

public class Mesa {
	private long idMesa;
	private int estadoMesa;
	private int nroMesa;
	private Salon salon;
	private Set<MesaSimple> mesaSimples;
	private EstadoMesa estado;
	
	public Mesa(){}

	public Mesa(int estadoMesa, int nroMesa, Salon salon) {
		super();
		this.estadoMesa = estadoMesa;
		this.nroMesa = nroMesa;
		this.salon = salon;
		this.estado = new Disponible();
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

	public int getNroMesa() {
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
	
	public EstadoMesa getEstado(){
		return estado;
	}
	public void setEstado(EstadoMesa estado ){
		this.estado = estado;
	}

	//Métodos state:
	public void liberarMesa(){
		if(this.estadoMesa==1) this.estado = new Disponible();
		if(this.estadoMesa==2) this.estado = new Ocupada();
		if(this.estadoMesa==3) this.estado = new Finalizada();
		this.setEstado(this.getEstado().dejarDisponible());
	}
	public void ocuparMesa(Usuario usuario, Comanda comanda){
		if(this.estadoMesa==1) this.estado = new Disponible();
		if(this.estadoMesa==2) this.estado = new Ocupada();
		if(this.estadoMesa==3) this.estado = new Finalizada();
		this.setEstado(this.getEstado().ocupar(usuario, comanda));
	}
	public void finalizarMesa(){
		this.setEstado( this.getEstado().finalizar());
	}
	
	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", estadoMesa=" + estadoMesa
				+ ", nroMesa=" + nroMesa + ", salon=" + salon + "]";
	}

	
	
	

}

	