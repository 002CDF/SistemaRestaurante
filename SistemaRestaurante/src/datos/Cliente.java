package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Cliente {
	private long idCliente;
	private long dni;
	private String nombre;
	private String apellido;
	private TipoCliente tipoCliente;
	private long numHabitacion;
	
	public Cliente(){}

	public Cliente(long dni, String nombre, String apellido, TipoCliente tipoCliente, long numHabitacion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoCliente = tipoCliente;
		this.numHabitacion	= numHabitacion;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
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
	
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	public long getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(long numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	@Override
	public String toString() {
		return "idCliente= " + idCliente+ ", Nombre= " + nombre
				+ ", DNI= " + dni + ", Apellido= " + apellido
				+ ", Num Habitacion= "+ numHabitacion;
	}

	public boolean equals(Cliente cliente){
		boolean igual =false;
		if (this.getIdCliente()== cliente.getIdCliente()){
			igual=true;
		}
		return igual;

	}
	
	
}
