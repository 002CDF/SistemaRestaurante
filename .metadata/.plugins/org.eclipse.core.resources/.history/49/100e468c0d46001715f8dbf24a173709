package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.TipoCliente;
public class TipoClienteDao {
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

	public int agregarTipoCliente(TipoCliente objeto) {
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

	public void actualizarTipoCliente(TipoCliente objeto) throws HibernateException {
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
	public void eliminarTipoCliente(TipoCliente objeto) throws HibernateException {
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
	public TipoCliente traerTipoCliente(long idTipoCliente) throws HibernateException {
		TipoCliente objeto = null ;
		try {
			iniciaOperacion();
			objeto = (TipoCliente)session.get(TipoCliente.class , idTipoCliente);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<TipoCliente> traerTipoCliente() throws HibernateException {
		List<TipoCliente> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from TipoCliente t order by t.idTipoCliente asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	public TipoCliente traerTipoClienteCompleto(long idTipoCliente) throws HibernateException {
		TipoCliente objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from TipoCliente t where t.idTipoCliente =" +idTipoCliente;
			objeto=(TipoCliente)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getListaPrecios());
			
		}
		finally {
			session .close();
		}
		return objeto;
	}
}