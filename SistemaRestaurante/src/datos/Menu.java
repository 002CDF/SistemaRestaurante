package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Menu {
	private long idMenu;
	private Set<Producto> productos;
	private GregorianCalendar fechaUnica;
	private String disponibilidadSemana;
	
	public Menu(){}

	public Menu(GregorianCalendar fechaUnica, String disponibilidadSemana) {
		super();
		this.fechaUnica = fechaUnica;
		this.disponibilidadSemana = disponibilidadSemana;
	}

	public long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(long idMenu) {
		this.idMenu = idMenu;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public GregorianCalendar getFechaUnica() {
		return fechaUnica;
	}

	public void setFechaUnica(GregorianCalendar fechaUnica) {
		this.fechaUnica = fechaUnica;
	}

	public String getDisponibilidadSemana() {
		return disponibilidadSemana;
	}

	public void setDisponibilidadSemana(String disponibilidadSemana) {
		this.disponibilidadSemana = disponibilidadSemana;
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
		return "idMenu= " + idMenu+ ", Productos= " + productos
				+ ", FechaUnica= " + fechaUnica+ ", DisponibilidadSemana= " + disponibilidadSemana;
	}

	public boolean equals(Menu menu){
		boolean igual =false;
		if (this.getIdMenu()==menu.getIdMenu()){
			igual=true;
		}
		return igual;

	}
	
	
}
