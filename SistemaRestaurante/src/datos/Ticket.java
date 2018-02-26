package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Ticket {
	private long idTicket;
	private double monto;
	private GregorianCalendar fechaEmision;
	private Cliente cliente;
	private Camarero camarero;
	private Mesa mesa;
	private Usuario usuario;
	private Set<ItemTicket> itemTickets;
	private boolean esCortesia;
	
	public Ticket(){}
	
	public Ticket(double monto, GregorianCalendar fechaEmision,
			Cliente cliente, Camarero camarero, Mesa mesa, Usuario usuario,
			boolean esCortesia) {
		super();
		this.monto = monto;
		this.fechaEmision = fechaEmision;
		this.cliente = cliente;
		this.camarero = camarero;
		this.mesa = mesa;
		this.usuario = usuario;
		this.esCortesia = esCortesia;
	}

	/*public void agregarItemTicket(ItemTicket itemTicket)throws Exception{
		List<ItemTicket> lista = new ArrayList(this.itemTickets);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(itemTicket)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		comandas.add(itemTicket);
	}*/
	
	public long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(long idTicket) {
		this.idTicket = idTicket;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public GregorianCalendar getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(GregorianCalendar fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Camarero getCamarero() {
		return camarero;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<ItemTicket> getItemTickets() {
		return itemTickets;
	}

	public void setItemTickets(Set<ItemTicket> itemTickets) {
		this.itemTickets = itemTickets;
	}

	public boolean isEsCortesia() {
		return esCortesia;
	}

	public void setEsCortesia(boolean esCortesia) {
		this.esCortesia = esCortesia;
	}

	public void agregarItemTicket(ItemTicket itemTicket){
		boolean agregar = true;
		List<ItemTicket> lista = new ArrayList(this.itemTickets);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(itemTicket)){
				lista.get(i).setCantidad(lista.get(i).getCantidad()+itemTicket.getCantidad());
				agregar=false;
			}
		}
		if(agregar) itemTickets.add(itemTicket); //Si no está repetido en la lista se agrega, sino solo se le suma
	}

	public double calcularTotal(){
		double precioTotal=0;
		for (ItemTicket itemTicket : this.getItemTickets()) {
			precioTotal += itemTicket.calcularSubTotal();
		}
		return precioTotal;
	}
	
	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", monto=" + monto
				+ ", fechaEmision=" + fechaEmision + ", cliente=" + cliente
				+ ", camarero=" + camarero + ", mesa=" + mesa + ", usuario="
				+ usuario + ", esCortesia=" + esCortesia + "]";
	}

	public boolean equals(Ticket ticket){
		boolean igual =false;
		if (this.getIdTicket()== ticket.getIdTicket()){
			igual=true;
		}
		return igual;

	}
	
	
}
