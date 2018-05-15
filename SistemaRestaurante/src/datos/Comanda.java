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
	private Set<ItemComanda> itemComandas;
	private boolean activo;
	
	public Comanda(){}

	public Comanda(GregorianCalendar fecha, Mesa mesa, boolean activo) {
		super();
		this.fecha = fecha;
		this.mesa = mesa;
		this.activo = true;
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

	public Set<ItemComanda> getItemComandas() {
		return itemComandas;
	}

	public void setItemComandas(Set<ItemComanda> itemComandas) {
		this.itemComandas = itemComandas;
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
				+ ", Mesa= " + mesa + ", Lista ItemComandas= " + itemComandas
			    + "esta activa=" + activo;
	}

	public boolean equals(Comanda comanda){
		boolean igual =false;
		if (this.getIdComanda()==comanda.getIdComanda()){
			igual=true;
		}
		return igual;

	}
	
	
}
