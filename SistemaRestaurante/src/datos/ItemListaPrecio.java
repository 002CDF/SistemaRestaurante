package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class ItemListaPrecio {
	private long idItemListaPrecio;
	private ListaPrecio listaPrecio;
	private Producto producto;
	private double precio;
	
	public ItemListaPrecio(){}

	public ItemListaPrecio(ListaPrecio listaPrecio, Producto producto,
			double precio) {
		super();
		this.listaPrecio = listaPrecio;
		this.producto = producto;
		this.precio = precio;
	}

	public long getIdItemListaPrecio() {
		return idItemListaPrecio;
	}

	public void setIdItemListaPrecio(long idItemListaPrecio) {
		this.idItemListaPrecio = idItemListaPrecio;
	}

	public ListaPrecio getListaPrecio() {
		return listaPrecio;
	}

	public void setListaPrecio(ListaPrecio listaPrecio) {
		this.listaPrecio = listaPrecio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "idItemListaPrecio= " + idItemListaPrecio+ ", Lista Precio= " + listaPrecio
				+ ", Producto= " + producto+ ", Precio= " + precio;
	}

	public boolean equals(ItemListaPrecio itemListaPrecio){
		boolean igual =false;
		if (this.getIdItemListaPrecio()== itemListaPrecio.getIdItemListaPrecio()){
			igual=true;
		}
		return igual;

	}
	
	
}
