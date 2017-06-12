package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Rubro {
	private long idRubro;
	private String descripcion;
	private Set<SubRubro> subRubros;
	private Set<Producto> productos;
	
	public Rubro(){}

	public Rubro(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public long getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(long idRubro) {
		this.idRubro = idRubro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<SubRubro> getSubRubros() {
		return subRubros;
	}

	public void setSubRubros(Set<SubRubro> subRubros) {
		this.subRubros = subRubros;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	public void agregarSubRubro(SubRubro subRubro)throws Exception{
		List<SubRubro> lista = new ArrayList(this.subRubros);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(subRubro)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		subRubros.add(subRubro);
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
		return "idRubro= " + idRubro+ ", Sub Rubros= " + subRubros
				+ ", Descripción= " + descripcion+ ", Productos= " + productos;
	}

	public boolean equals(Rubro rubro){
		boolean igual =false;
		if (this.getIdRubro()== rubro.getIdRubro()){
			igual=true;
		}
		return igual;
	}
}
