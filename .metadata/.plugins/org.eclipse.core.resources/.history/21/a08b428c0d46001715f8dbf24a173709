package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ListaPrecio;
public class ListaPrecioDao {
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

	public int agregarListaPrecio(ListaPrecio objeto) {
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

	public void actualizarListaPrecio(ListaPrecio objeto) throws HibernateException {
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
	public void eliminarListaPrecio(ListaPrecio objeto) throws HibernateException {
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
	public ListaPrecio traerListaPrecio(long idListaPrecio) throws HibernateException {
		ListaPrecio objeto = null ;
		try {
			iniciaOperacion();
			objeto = (ListaPrecio)session.get(ListaPrecio.class , idListaPrecio);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<ListaPrecio> traerListaPrecio() throws HibernateException {
		List<ListaPrecio> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from ListaPrecio l order by l.idListaPrecio asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	public ListaPrecio traerListaPrecioCompleto(long idListaPrecio) throws HibernateException {
		ListaPrecio objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from ListaPrecio l where l.idListaPrecio =" +idListaPrecio;
			objeto=(ListaPrecio)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getPrecios());
		}
		finally {
			session .close();
		}
		return objeto;
	}
}