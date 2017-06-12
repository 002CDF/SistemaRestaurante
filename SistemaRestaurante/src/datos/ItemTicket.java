package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class ItemTicket {
	private long idItemTicket;
	private Producto producto;
	private double precioUnitario;
	private int cantidad;
	
	public ItemTicket(){}

	public ItemTicket(Producto producto, double precioUnitario, int cantidad) {
		super();
		this.producto = producto;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
	}

	public long getIdItemTicket() {
		return idItemTicket;
	}

	public void setIdItemTicket(long idItemTicket) {
		this.idItemTicket = idItemTicket;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "idItemTicket= " + idItemTicket + ", Producto= " + producto
				+ ", Precio Unitario= " + precioUnitario + ", Cantidad= " + cantidad;
	}

	public boolean equals(ItemTicket itemTicket){
		boolean igual =false;
		if (this.getIdItemTicket()==itemTicket.getIdItemTicket()){
			igual=true;
		}
		return igual;

	}
	
}
