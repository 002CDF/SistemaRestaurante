package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class ItemReceta {
	private long idItemReceta;
	private Receta receta;
	private Ingrediente ingrediente;
	private long cantidad;
	
	public ItemReceta(){}
	
	public ItemReceta(Receta receta, Ingrediente ingrediente, long cantidad) {
		super();
		this.receta = receta;
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
	}

	public long getIdItemReceta() {
		return idItemReceta;
	}

	public void setIdItemReceta(long idItemReceta) {
		this.idItemReceta = idItemReceta;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	
	
	@Override
	public String toString() {
		return "idItemReceta= " + idItemReceta + ", Receta= " + receta
				+ ", Ingrediente= " + ingrediente + ", Cantidad= " + cantidad;
	}

	public boolean equals(ItemReceta itemReceta){
		boolean igual =false;
		if (this.getIdItemReceta()==itemReceta.getIdItemReceta()){
			igual=true;
		}
		return igual;

	}
	
	
}
