package state;
import datos.Mesa;
import datos.Usuario;
public class Finalizada extends EstadoMesa{
	@Override
	public EstadoMesa dejarDisponible() {
		//algo de la bd
		return this;
	}
	@Override
	public EstadoMesa ocupar(Usuario usuario) {
		try {
			throw new Exception( "Error, la mesa se encuentra finalizada" );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	@Override
	public EstadoMesa finalizar() {
		try {
			throw new Exception( "Error, la mesa ya se encuentra finalizada" );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}