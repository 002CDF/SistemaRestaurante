package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Vianda;
public class ViandaDao {
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

	public int agregarVianda(Vianda objeto) {
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

	public void actualizarVianda(Vianda objeto) throws HibernateException {
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
	public void eliminarVianda(Vianda objeto) throws HibernateException {
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
	public Vianda traerVianda(long idVianda) throws HibernateException {
		Vianda objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Vianda)session.get(Vianda.class , idVianda);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Vianda> traerVianda() throws HibernateException {
		List<Vianda> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from Vianda v order by v.idVianda asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	public Vianda traerViandaCompleto(long idVianda) throws HibernateException {
		Vianda objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Vianda v where v.idVianda =" +idVianda;
			objeto=(Vianda)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getProductos());
			
		}
		finally {
			session .close();
		}
		return objeto;
	}
}
