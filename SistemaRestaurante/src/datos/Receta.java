package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Receta {
	private long idReceta;
	private String nombre;
	private String descripcion;
	private Set<ItemReceta> itemRecetas;
	
	public Receta(){}

	public Receta(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public long getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(long idReceta) {
		this.idReceta = idReceta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<ItemReceta> getItemRecetas() {
		return itemRecetas;
	}

	public void setItemRecetas(Set<ItemReceta> itemRecetas) {
		this.itemRecetas = itemRecetas;
	}
	
	public void agregarItemReceta(ItemReceta itemReceta)throws Exception{
		List<ItemReceta> lista = new ArrayList(this.itemRecetas);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(itemReceta)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		itemRecetas.add(itemReceta);
	}

	@Override
	public String toString() {
		return "idReceta= " + idReceta+ ", Nombre= " + nombre
				+ ", Descripción= " + descripcion+ ", Item Recetas= " + itemRecetas;
	}

	public boolean equals(Receta receta){
		boolean igual =false;
		if (this.getIdReceta()== receta.getIdReceta()){
			igual=true;
		}
		return igual;

	}
	
	
}
