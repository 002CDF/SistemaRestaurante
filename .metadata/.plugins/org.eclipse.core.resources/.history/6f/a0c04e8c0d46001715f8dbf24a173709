package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Menu;
public class MenuDao {
	private static Session session;
	private Transaction tx ;
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}

	public int agregarMenu(Menu objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx .commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	} 

	public void actualizarMenu(Menu objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx .commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session .close();
		}
	}
	public void eliminarMenu(Menu objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session .delete(objeto);
			tx .commit();
		}
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session .close();
		}
	}
	public Menu traerMenu(long idMenu) throws HibernateException {
		Menu objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Menu)session.get(Menu.class , idMenu);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Menu> traerMenu() throws HibernateException {
		List<Menu> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from Menu m order by m.idMenu asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	public Menu traerMenuCompleto(long idMenu) throws HibernateException {
		Menu objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Menu m where m.idMenu =" +idMenu;
			objeto=(Menu)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getProductos());
		}
		finally {
			session .close();
		}
		return objeto;
	}
}