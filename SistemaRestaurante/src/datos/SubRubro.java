package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class SubRubro {
	private long idSubRubro;
	private String descripcion;
	private Set<Rubro> rubros;
	private Set<Producto> productos;
	
	public SubRubro(){}

	public SubRubro(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public long getIdSubRubro() {
		return idSubRubro;
	}

	public void setIdSubRubro(long idSubRubro) {
		this.idSubRubro = idSubRubro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Rubro> getRubros() {
		return rubros;
	}

	public void setRubros(Set<Rubro> rubros) {
		this.rubros = rubros;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	public void agregarRubro(Rubro rubro)throws Exception{
		List<Rubro> lista = new ArrayList(this.rubros);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(rubro)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		rubros.add(rubro);
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
		return "idSubRubro= " + idSubRubro+ ", Productos= " + productos
				+ ", Descripción= " + descripcion+ ", Rubros= " + rubros;
	}

	public boolean equals(SubRubro subRubro){
		boolean igual =false;
		if (this.getIdSubRubro()== subRubro.getIdSubRubro()){
			igual=true;
		}
		return igual;

	}
	
	
}
