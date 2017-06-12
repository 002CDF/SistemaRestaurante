package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Comanda {
	private long idComanda;
	private GregorianCalendar fecha;
	private Mesa mesa;
	private Cliente cliente;
	private Set<ItemComanda> itemComandas;
	private Camarero camarero;
	private int numHabitacion;
	private boolean activo;
	
	public Comanda(){}

	public Comanda(GregorianCalendar fecha, Mesa mesa, Cliente cliente,
			Camarero camarero, int numHabitacion, boolean activo) {
		super();
		this.fecha = fecha;
		this.mesa = mesa;
		this.cliente = cliente;
		this.camarero = camarero;
		this.numHabitacion = numHabitacion;
		this.activo = activo;
	}

	public long getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(long idComanda) {
		this.idComanda = idComanda;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ItemComanda> getItemComandas() {
		return itemComandas;
	}

	public void setItemComandas(Set<ItemComanda> itemComandas) {
		this.itemComandas = itemComandas;
	}

	public Camarero getCamarero() {
		return camarero;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void agregarItemComanda(ItemComanda itemComanda)throws Exception{
		List<ItemComanda> lista = new ArrayList(this.itemComandas);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(itemComanda)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		itemComandas.add(itemComanda);
	}

	@Override
	public String toString() {
		return "idComanda= " + idComanda+ ", Fecha= " + fecha
				+ ", Mesa= " + mesa+ ", Cliente= " + cliente
				+ ", Lista ItemComandas= " + itemComandas+ ", Camarero= " + camarero
				+ "Numero de Habitacion" + numHabitacion + "esta activa=" + activo;
	}

	public boolean equals(Comanda comanda){
		boolean igual =false;
		if (this.getIdComanda()==comanda.getIdComanda()){
			igual=true;
		}
		return igual;

	}
	
	
}
