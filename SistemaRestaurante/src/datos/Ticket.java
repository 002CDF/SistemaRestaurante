package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Ticket {
	private long idTicket;
	private double monto;
	private Usuario usuario;
	private Set<ItemTicket> itemTickets;
	private boolean esFiscal;
	private boolean esCortesia;
	
	public Ticket(){}
	
	public Ticket(double monto, Usuario usuario, boolean esFiscal,
			boolean esCortesia) {
		super();
		this.monto = monto;
		this.usuario = usuario;
		this.esFiscal = esFiscal;        //Los dos booleanos son necesario? (ya que por defecto vienen en 0)
		this.esCortesia = esCortesia;
	}

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

	public boolean isEsFiscal() {
		return esFiscal;
	}

	public void setEsFiscal(boolean esFiscal) {
		this.esFiscal = esFiscal;
	}

	public boolean isEsCortesia() {
		return esCortesia;
	}

	public void setEsCortesia(boolean esCortesia) {
		this.esCortesia = esCortesia;
	}
	
	
	/*public void agregarComanda(Comanda comanda)throws Exception{
		List<Comanda> lista = new ArrayList(this.comandas);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(comanda)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		comandas.add(comanda);
	}*/
	
	public void agregarItemTicket(ItemTicket itemTicket)throws Exception{
		List<ItemTicket> lista = new ArrayList(this.itemTickets);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(itemTicket)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		itemTickets.add(itemTicket);
	}

	@Override
	public String toString() {
		return "idTicket= " + idTicket+ ", Monto= " + monto
				+ ", Usuario= " + usuario+ ", Es Fiscal=" + esFiscal
				+ ", Es Cortesia=" + esCortesia;
	}

	public boolean equals(Ticket ticket){
		boolean igual =false;
		if (this.getIdTicket()== ticket.getIdTicket()){
			igual=true;
		}
		return igual;

	}
	
	
}
