package state;
import datos.Comanda;
import datos.Mesa;
import datos.Usuario;
public abstract class EstadoMesa {
	private Usuario usuario;
	public abstract EstadoMesa dejarDisponible();
	public abstract EstadoMesa ocupar(Usuario usuario, Comanda comanda);
	public abstract EstadoMesa finalizar();
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
