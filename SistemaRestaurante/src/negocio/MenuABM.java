package negocio;
import dao.MenuDao;
import java.util.GregorianCalendar;
import java.util.List;
import datos.Menu;
public class MenuABM {
	private MenuDao dao = new MenuDao();

	public int agregarMenu(GregorianCalendar fechaUnica, String disponibilidadSemana){
		Menu m = new Menu (fechaUnica, disponibilidadSemana);
		return dao.agregarMenu(m);
	}

	public void modificarMenu(Menu menu){
		dao.actualizarMenu(menu);
	}

	public void elminarMenu(long idMenu){
		Menu m = dao.traerMenu(idMenu);
		dao.eliminarMenu(m);
	}

	public Menu traerMenu(long idMenu){
		return dao.traerMenu(idMenu);
	}

	public List<Menu> traerMenu(){
		return dao.traerMenu();
	}

	public Menu traerMenuCompleto (long idMenu){
		return dao.traerMenuCompleto(idMenu);
	}

}
