package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Ingrediente {
	private long idIngrediente;
	private String nombre;
	private String descripcion;
	private Conversion conversion;
	private Set<ItemReceta> itemRecetas;
	private double unidadCompra;
	private double unidadConsumo;
	
	public Ingrediente(){}

	public Ingrediente(String nombre, String descripcion,
			Conversion conversion, double unidadCompra, double unidadConsumo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.conversion = conversion;
		this.unidadCompra = unidadCompra;
		this.unidadConsumo = unidadConsumo;
	}

	public long getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(long idIngrediente) {
		this.idIngrediente = idIngrediente;
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

	public Conversion getConversion() {
		return conversion;
	}

	public void setConversion(Conversion conversion) {
		this.conversion = conversion;
	}

	public Set<ItemReceta> getItemRecetas() {
		return itemRecetas;
	}

	public void setItemRecetas(Set<ItemReceta> itemRecetas) {
		this.itemRecetas = itemRecetas;
	}

	public double getUnidadCompra() {
		return unidadCompra;
	}

	public void setUnidadCompra(double unidadCompra) {
		this.unidadCompra = unidadCompra;
	}

	public double getUnidadConsumo() {
		return unidadConsumo;
	}

	public void setUnidadConsumo(double unidadConsumo) {
		this.unidadConsumo = unidadConsumo;
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
		return "idIngrediente= " + idIngrediente+ ", Nombre= " + nombre
				+ ", Descripción= " + descripcion+ ", Conversion= " + conversion
				+ ", Lista ItemRecetas= " + itemRecetas+ ", Unidad de Compra= " + unidadCompra
				+ "Unidad de Consumo" + unidadConsumo;
	}

	public boolean equals(Ingrediente ingrediente){
		boolean igual =false;
		if (this.getIdIngrediente()==ingrediente.getIdIngrediente()){
			igual=true;
		}
		return igual;

	}



}
