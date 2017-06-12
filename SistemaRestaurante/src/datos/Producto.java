package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Producto {
	private long idProducto;
	private String nombre;
	private String descripcion;
	private Receta receta;
	private Rubro rubro;
	private SubRubro subRubro;
	private boolean habilitado;
	private String imagen;
	private Set<Menu> menues;
	private Set<ItemListaPrecio> precios;
	private Set<Vianda> viandas;
	private Set<ItemComanda> itemComandas;
	
	public Producto(){}
	
	public Producto(String nombre, String descripcion, Receta receta,
			Rubro rubro, SubRubro subRubro, boolean habilitado, String imagen) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.receta = receta;
		this.rubro = rubro;
		this.subRubro = subRubro;
		this.habilitado = habilitado;
		this.imagen = imagen;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
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

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public SubRubro getSubRubro() {
		return subRubro;
	}

	public void setSubRubro(SubRubro subRubro) {
		this.subRubro = subRubro;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Set<Menu> getMenues() {
		return menues;
	}

	public void setMenues(Set<Menu> menues) {
		this.menues = menues;
	}

	public Set<ItemListaPrecio> getPrecios() {
		return precios;
	}

	public void setPrecios(Set<ItemListaPrecio> precios) {
		this.precios = precios;
	}

	public Set<Vianda> getViandas() {
		return viandas;
	}

	public void setViandas(Set<Vianda> viandas) {
		this.viandas = viandas;
	}

	public Set<ItemComanda> getItemComandas() {
		return itemComandas;
	}

	public void setItemComandas(Set<ItemComanda> itemComandas) {
		this.itemComandas = itemComandas;
	}
	
	public void agregarMenu(Menu menu)throws Exception{
		List<Menu> lista = new ArrayList(this.menues);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(menu)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		menues.add(menu);
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
	
	public void agregarItemComanda(ItemComanda itemComanda)throws Exception{
		List<ItemComanda> lista = new ArrayList(this.itemComandas);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(itemComanda)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		itemComandas.add(itemComanda);
	}

	@Override
	public String toString() {
		return "idProducto= " + idProducto+ ", Nombre= " + nombre
				+ ", Descripción= " + descripcion+ ", Receta= " + receta
				+ ", Rubro="+ rubro + ", Sub Rubro="+ subRubro + ", Habilitado= " 
				+ habilitado+ ", Imagen= " + imagen + ", Menues=" + menues 
				+ ", Precios =" + precios + ", Item Comandas" + itemComandas;
	}

	public boolean equals(Producto producto){
		boolean igual =false;
		if (this.getIdProducto()== producto.getIdProducto()){
			igual=true;
		}
		return igual;

	}
	
	
	
}
