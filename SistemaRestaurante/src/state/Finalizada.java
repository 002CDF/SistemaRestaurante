package state;
import java.util.ArrayList;
import java.util.List;

import negocio.ComandaABM;
import datos.Comanda;
import datos.Mesa;
import datos.Ticket;
import datos.Usuario;
public class Finalizada extends EstadoMesa{
	@Override
	public EstadoMesa dejarDisponible(long idMesa) {
		ComandaABM comandaAbm = new ComandaABM();
		List<Comanda> comandas = comandaAbm.traerComandaMesa(idMesa);
		for(int i=0 ; i<comandas.size() ; i++){
			comandas.get(i).setActivo(false);
			comandaAbm.modificarComanda(comandas.get(i));
		}
		return this;
	}
	@Override
	public EstadoMesa ocupar(Usuario usuario, Comanda comanda) {
		try {
			throw new Exception( "Error, la mesa se encuentra finalizada" );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	@Override
	public EstadoMesa finalizar(Ticket ticket) {
		try {
			throw new Exception( "Error, la mesa ya se encuentra finalizada" );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}