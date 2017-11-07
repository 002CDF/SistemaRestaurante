package state;
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
	public EstadoMesa ocupar(Usuario usuario) {
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