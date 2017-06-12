package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class ListaPrecio {
	private long idListaPrecio;
	private GregorianCalendar fecha;
	private Set<ItemListaPrecio> precios;
	private TipoCliente tipoCliente;
	
	public ListaPrecio(){}

	public ListaPrecio(GregorianCalendar fecha, TipoCliente tipoCliente) {
		super();
		this.fecha = fecha;
		this.tipoCliente = tipoCliente;
	}

	public long getIdListaPrecio() {
		return idListaPrecio;
	}

	public void setIdListaPrecio(long idListaPrecio) {
		this.idListaPrecio = idListaPrecio;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public Set<ItemListaPrecio> getPrecios() {
		return precios;
	}

	public void setPrecios(Set<ItemListaPrecio> precios) {
		this.precios = precios;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	public void agregarItemListaPrecio(ItemListaPrecio itemListaPrecio)throws Exception{
		List<ItemListaPrecio> lista = new ArrayList(this.precios);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(itemListaPrecio)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		precios.add(itemListaPrecio);
	}

	@Override
	public String toString() {
		return "idListaPrecio= " + idListaPrecio + ", Fecha= " + fecha
				+ ", Precios= " + precios + ", TipoCLiente=" + tipoCliente;
	}

	public boolean equals(ListaPrecio listaPrecio){
		boolean igual =false;
		if (this.getIdListaPrecio()==listaPrecio.getIdListaPrecio()){
			igual=true;
		}
		return igual;

	}
	
	
	
}
