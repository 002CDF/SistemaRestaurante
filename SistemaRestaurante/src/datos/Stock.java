package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Stock {
	private long idStock;
	private Ingrediente ingrediente;
	private double cantidadActual;
	private double cantidadMinima;
	private double cantidadDeseada;
	
	public Stock(){}

	public Stock(Ingrediente ingrediente, double cantidadActual,
			double cantidadMinima, double cantidadDeseada) {
		super();
		this.ingrediente = ingrediente;
		this.cantidadActual = cantidadActual;
		this.cantidadMinima = cantidadMinima;
		this.cantidadDeseada = cantidadDeseada;
	}

	public long getIdStock() {
		return idStock;
	}

	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(double cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public double getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(double cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public double getCantidadDeseada() {
		return cantidadDeseada;
	}

	public void setCantidadDeseada(double cantidadDeseada) {
		this.cantidadDeseada = cantidadDeseada;
	}
	
	@Override
	public String toString() {
		return "idStock= " + idStock+ ", Ingrediente= " + ingrediente
				+ ", Cantidad Actual= " + cantidadActual+ ", Cantidad Mínima= " + cantidadMinima
				+ ", Cantidad Deseada=" + cantidadDeseada;
	}

	public boolean equals(Stock stock){
		boolean igual =false;
		if (this.getIdStock()== stock.getIdStock()){
			igual=true;
		}
		return igual;

	}
	
	
}
