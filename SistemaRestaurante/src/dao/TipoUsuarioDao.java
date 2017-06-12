package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.TipoUsuario;
public class TipoUsuarioDao {
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

	public int agregarTipoUsuario(TipoUsuario objeto) {
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

	public void actualizarTipoUsuario(TipoUsuario objeto) throws HibernateException {
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
	public void eliminarTipoUsuario(TipoUsuario objeto) throws HibernateException {
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
	public TipoUsuario traerTipoUsuario(long idTipoUsuario) throws HibernateException {
		TipoUsuario objeto = null ;
		try {
			iniciaOperacion();
			objeto = (TipoUsuario)session.get(TipoUsuario.class , idTipoUsuario);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<TipoUsuario> traerTipoUsuario() throws HibernateException {
		List<TipoUsuario> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from TipoUsuario t order by t.idTipoUsuario asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	public TipoUsuario traerTipoUsuarioCompleto(long idTipoUsuario) throws HibernateException {
		TipoUsuario objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from TipoUsuario t where t.idTipoUsuario =" +idTipoUsuario;
			objeto=(TipoUsuario)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getPrivilegios());
		}
		finally {
			session .close();
		}
		return objeto;
	}
}