package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

import negocio.ComandaABM;
import negocio.ListaPrecioABM;
import negocio.ProductoABM;
import negocio.TicketABM;
import negocio.TipoClienteABM;
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
	public void liberarMesa(long idMesa){
		if(this.estadoMesa==1) this.estado = new Disponible();
		if(this.estadoMesa==2) this.estado = new Ocupada();
		if(this.estadoMesa==3) this.estado = new Finalizada();
		this.setEstado(this.getEstado().dejarDisponible(idMesa));
		this.setEstadoMesa(1);
	}
	public void ocuparMesa(Usuario usuario, Comanda comanda){
		if(this.estadoMesa==1) this.estado = new Disponible();
		if(this.estadoMesa==2) this.estado = new Ocupada();
		if(this.estadoMesa==3) this.estado = new Finalizada();
		this.setEstado(this.getEstado().ocupar(usuario, comanda));
		this.setEstadoMesa(2); //Ocupada
	}
	public void finalizarMesa(Ticket ticket){
		if(this.estadoMesa==1) this.estado = new Disponible();
		if(this.estadoMesa==2) this.estado = new Ocupada();
		if(this.estadoMesa==3) this.estado = new Finalizada();
		this.setEstado(this.getEstado().finalizar(ticket));
		this.setEstadoMesa(3); //Finalizada
	}
	//Metodos relevantes al ticket:
	public ItemTicket generarItemTicket(Ticket ticket, ItemComanda itemComanda, ListaPrecio listaPrecio){
		ItemTicket itemTicket = new ItemTicket();
		Producto producto = new Producto();
		ProductoABM productoAbm = new ProductoABM();
		double precioUnitario = -1;
		producto = productoAbm.traerProducto(itemComanda.getProducto().getIdProducto()); //Producto completo
		itemTicket.setProducto(producto);
		for (ItemListaPrecio itemListaPrecio : listaPrecio.getPrecios()) {
			if(itemListaPrecio.getProducto().getIdProducto() == producto.getIdProducto()) precioUnitario = itemListaPrecio.getPrecio();
		}
		itemTicket.setProducto(producto);
		itemTicket.setPrecioUnitario(precioUnitario);
		itemTicket.setCantidad(itemComanda.getCantidad());
		itemTicket.setTicket(ticket);
		return itemTicket;
	}
	public Ticket generarTicket(Cliente cliente, Camarero camarero, Usuario usuario){
		Ticket ticket = new Ticket();
		TicketABM ticketAbm = new TicketABM();
		ItemTicket itemTicket = new ItemTicket();
		TipoCliente tipoCliente = new TipoCliente();
		ListaPrecio listaPrecio = new ListaPrecio();
		ListaPrecioABM listaPrecioAbm = new ListaPrecioABM();
		TipoClienteABM tipoClienteAbm = new TipoClienteABM();
		ComandaABM comandaAbm = new ComandaABM();
		Set<ItemTicket> itemTickets = new HashSet<ItemTicket>();
		List<Comanda> comandas = comandaAbm.traerComandaMesa(this.idMesa);
		ticket.setCliente(cliente);
		ticket.setMesa(this);
		ticket.setCamarero(camarero);
		ticket.setUsuario(usuario);
		ticket.setMonto(0);
		ticket.setFechaEmision(new GregorianCalendar());
		ticket.setEsCortesia(false);
		ticket.setItemTickets(itemTickets); //Paso la lista vacia para trabajarla desde el objeto
		//Trayendo tipo cliente
		if(cliente==null) tipoCliente = tipoClienteAbm.traerTipoCliente(4);
		else tipoCliente = tipoClienteAbm.traerTipoCliente(cliente.getTipoCliente().getIdTipoCliente()); //Tipo cliente completo
		listaPrecio = listaPrecioAbm.traerUltimaListaPrecio(tipoCliente.getIdTipoCliente());
		for (Comanda comanda : comandas) {
			for (ItemComanda itemComanda : comanda.getItemComandas()) {
				ticket.agregarItemTicket(this.generarItemTicket(ticket, itemComanda, listaPrecio));
			}
		}
		//Agregando itemTickets
		//Agregando ticket
		ticket.setMonto(ticket.calcularTotal());
		//ticketAbm.agregarTicketCompleto(ticket);
		return ticket;
	}
	
	
	@Override
	public String toString() {
		return "Mesa [idMesa=" + idMesa + ", estadoMesa=" + estadoMesa
				+ ", nroMesa=" + nroMesa + ", salon=" + salon + "]";
	}

	
	

}

	