package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class ItemComanda {
	private long idItemComanda;
	private Comanda comanda;
	private Producto producto;
	private long cantidad;
	
	public ItemComanda(){}

	public ItemComanda(Comanda comanda, Producto producto, long cantidad) {
		super();
		this.comanda = comanda;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public long getIdItemComanda() {
		return idItemComanda;
	}

	public void setIdItemComanda(long idItemComanda) {
		this.idItemComanda = idItemComanda;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "idItemComanda= " + idItemComanda+ ", Comanda= " + comanda
				+ ", Producto= " + producto + ", Cantidad= " + cantidad;
	}

	public boolean equals(ItemComanda itemComanda){
		boolean igual =false;
		if (this.getIdItemComanda()== itemComanda.getIdItemComanda()){
			igual=true;
		}
		return igual;

	}
	
	
}
