package state;
import datos.Mesa;
import datos.Usuario;
public class Ocupada extends EstadoMesa{
	@Override
	public EstadoMesa dejarDisponible() {
		try {
			throw new Exception( "Error, la mesa ya esta ocupada, primero debe finalizarse" );
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return this;
	}
	@Override
	public EstadoMesa ocupar(Usuario usuario) {
		try {
			throw new Exception( "Error, esta mesa ya está ocupada" );
		} catch (Exception e ) {
			e.printStackTrace();
		}
		return this;
	}
	@Override
	public EstadoMesa finalizar() {
		return new Finalizada();
	}
}