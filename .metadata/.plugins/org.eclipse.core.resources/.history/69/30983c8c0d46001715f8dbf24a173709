package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Comanda;
public class ComandaDao {
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

	public int agregarComanda(Comanda objeto) {
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

	public void actualizarComanda(Comanda objeto) throws HibernateException {
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
	public void eliminarComanda(Comanda objeto) throws HibernateException {
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
	public Comanda traerComanda(long idComanda) throws HibernateException {
		Comanda objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Comanda)session.get(Comanda.class , idComanda);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Comanda> traerComanda() throws HibernateException {
		List<Comanda> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from Comanda c order by c.idComanda asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	public Comanda traerComandaCompleto(long idComanda) throws HibernateException {
		Comanda objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Comanda c where c.idComanda =" +idComanda;
			objeto=(Comanda)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getItemComandas());
		}
		finally {
			session .close();
		}
		return objeto;
	}
}