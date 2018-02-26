package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Camarero {
	private long idCamarero;
	private long dni;
	private String nombre;
	private String apellido;
	
	public Camarero(){}

	public Camarero(long dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public long getIdCamarero() {
		return idCamarero;
	}

	public void setIdCamarero(long idCamarero) {
		this.idCamarero = idCamarero;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
//	public void agregarComanda(Comanda comanda)throws Exception{
//		List<Comanda> lista = new ArrayList(this.comandas);
//		for(int i=0;i<lista.size();i++){
//			if(lista.get(i).equals(comanda)){
//				throw new Exception("Error: El item que desea agregar ya existe");
//			}
//		}
//		comandas.add(comanda);
//	}

	@Override
	public String toString() {
		return "id del camarero= " + idCamarero+ ", DNI= " + dni
				+ ", Nombre= " + nombre+ ", Apellido= " + apellido;
	}

	public boolean equals(Camarero camarero){
		boolean igual =false;
		if (this.getIdCamarero()==camarero.getIdCamarero()){
			igual=true;
		}
		return igual;

	}
	
	
}
