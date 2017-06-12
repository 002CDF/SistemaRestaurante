package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Vianda {
	private long idVianda;
	private String descripcion;
	private Set<Producto> productos;
	
	public Vianda(){}

	public Vianda(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public long getIdVianda() {
		return idVianda;
	}

	public void setIdVianda(long idVianda) {
		this.idVianda = idVianda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	public void agregarProducto(Producto producto)throws Exception{
		List<Producto> lista = new ArrayList(this.productos);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(producto)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		productos.add(producto);
	}

	@Override
	public String toString() {
		return "idVianda= " + idVianda+ ", Descripcion= " + descripcion
				+ ", Productos= " + productos;
	}

	public boolean equals(Vianda vianda){
		boolean igual =false;
		if (this.getIdVianda()== vianda.getIdVianda()){
			igual=true;
		}
		return igual;

	}
	
	
}
