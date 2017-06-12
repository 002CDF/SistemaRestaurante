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
	private Set<Comanda> comandas; //ES NECESARIO?
	private TipoCliente tipoCliente;
	
	public Cliente(){}

	public Cliente(long dni, String nombre, String apellido, TipoCliente tipoCliente) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoCliente = tipoCliente;
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

	public Set<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(Set<Comanda> comandas) {
		this.comandas = comandas;
	}
	
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public void agregarComanda(Comanda comanda)throws Exception{
		List<Comanda> lista = new ArrayList(this.comandas);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(comanda)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		comandas.add(comanda);
	}

	@Override
	public String toString() {
		return "idCliente= " + idCliente+ ", Nombre= " + nombre
				+ ", DNI= " + dni + ", Apellido= " + apellido
				+ ", Lista Comandas= " + comandas;
	}

	public boolean equals(Cliente cliente){
		boolean igual =false;
		if (this.getIdCliente()== cliente.getIdCliente()){
			igual=true;
		}
		return igual;

	}
	
	
}
