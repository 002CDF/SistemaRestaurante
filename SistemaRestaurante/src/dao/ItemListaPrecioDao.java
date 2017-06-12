package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ItemListaPrecio;
public class ItemListaPrecioDao {
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

	public int agregarItemListaPrecio(ItemListaPrecio objeto) {
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

	public void actualizarItemListaPrecio(ItemListaPrecio objeto) throws HibernateException {
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
	public void eliminarItemListaPrecio(ItemListaPrecio objeto) throws HibernateException {
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
	public ItemListaPrecio traerItemListaPrecio(long idItemListaPrecio) throws HibernateException {
		ItemListaPrecio objeto = null ;
		try {
			iniciaOperacion();
			objeto = (ItemListaPrecio)session.get(ItemListaPrecio.class , idItemListaPrecio);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<ItemListaPrecio> traerItemListaPrecio() throws HibernateException {
		List<ItemListaPrecio> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from ItemListaPrecio i order by i.idItemListaPrecio asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}

}