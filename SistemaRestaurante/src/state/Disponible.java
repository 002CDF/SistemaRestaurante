package state;
import negocio.ComandaABM;
import negocio.ItemComandaABM;
import datos.ItemComanda;
import datos.Comanda;
import datos.Mesa;
import datos.Usuario;
public class Disponible extends EstadoMesa{
	@Override
	public EstadoMesa dejarDisponible() {
		try {
			throw new Exception( "Error, esta mesa ya está disponible" );
		} catch (Exception e ) {
			e .printStackTrace();
		}
		return this ;
	}
	@Override
	public EstadoMesa ocupar(Usuario usuario, Comanda comanda) {
		ComandaABM comandaAbm = new ComandaABM();
		ItemComandaABM itemComandaAbm = new ItemComandaABM();
		long idComandaAgregado = comandaAbm.agregarComanda(comanda.getFecha(), comanda.getMesa(), comanda.getCliente(), comanda.getCamarero(), comanda.isActivo());
		comanda.setIdComanda(idComandaAgregado);
		for (ItemComanda itemComanda : comanda.getItemComandas()) { //Recorriendo el HashSet
			itemComandaAbm.agregarItemComanda(itemComanda.getComanda(), itemComanda.getProducto(), itemComanda.getCantidad());
		}
		Ocupada ocupada = new Ocupada();
		ocupada.setUsuario(usuario);
		return ocupada;
	}
	@Override
	public EstadoMesa finalizar() {
		try {
			throw new Exception( "Error, la mesa no ha sido ocupada" );
		} catch (Exception e ) {
			e .printStackTrace();
		}
		return this ;
	}
}