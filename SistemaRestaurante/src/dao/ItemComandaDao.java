package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ItemComanda;
public class ItemComandaDao {
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

	public int agregarItemComanda(ItemComanda objeto) {
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

	public void actualizarItemComanda(ItemComanda objeto) throws HibernateException {
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
	public void eliminarItemComanda(ItemComanda objeto) throws HibernateException {
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
	public ItemComanda traerItemComanda(long idItemComanda) throws HibernateException {
		ItemComanda objeto = null ;
		try {
			iniciaOperacion();
			objeto = (ItemComanda)session.get(ItemComanda.class , idItemComanda);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<ItemComanda> traerItemComandas(long idComanda) throws HibernateException { //Trae todos los item comanda de una comanda
		List<ItemComanda> lista= null ;
		try {
			iniciaOperacion();
			String hql= "from ItemComanda i where i.idComanda="+idComanda+" order by i.idItemComanda asc";
			lista = session .createQuery(hql).list();
		} finally {
			session .close();
		}
		return lista;
	}
	@SuppressWarnings ( "unchecked" )
	public List<ItemComanda> traerItemComanda() throws HibernateException {
		List<ItemComanda> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from ItemComanda i order by i.idItemComanda asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}

}