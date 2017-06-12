package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class TipoCliente {
	private long idTipoCliente;
	private String tipo;
	private Set<ListaPrecio> listaPrecios;
	
	public TipoCliente(){}

	public TipoCliente(String tipo) {
		super();
		this.tipo = tipo;
	}

	public long getIdTipoCliente() {
		return idTipoCliente;
	}

	public void setIdTipoCliente(long idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<ListaPrecio> getListaPrecios() {
		return listaPrecios;
	}

	public void setListaPrecios(Set<ListaPrecio> listaPrecios) {
		this.listaPrecios = listaPrecios;
	}
	
	public void agregarListaPrecio(ListaPrecio listaPrecio)throws Exception{
		List<ListaPrecio> lista = new ArrayList(this.listaPrecios);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(listaPrecio)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		listaPrecios.add(listaPrecio);
	}

	@Override
	public String toString() {
		return "idTipoCliente= " + idTipoCliente+ ", Tipo= " + tipo
				+ ", Lista Precios= " + listaPrecios;
	}

	public boolean equals(TipoCliente tipoCliente){
		boolean igual =false;
		if (this.getIdTipoCliente()== tipoCliente.getIdTipoCliente()){
			igual=true;
		}
		return igual;

	}
	
	
}
