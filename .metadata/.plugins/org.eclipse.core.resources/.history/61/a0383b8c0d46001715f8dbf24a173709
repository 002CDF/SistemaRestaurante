package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Camarero;
public class CamareroDao {
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

	public int agregarCamarero(Camarero objeto) {
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

	public void actualizarCamarero(Camarero objeto) throws HibernateException {
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
	public void eliminarCamarero(Camarero objeto) throws HibernateException {
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
	public Camarero traerCamarero(long idCamarero) throws HibernateException {
		Camarero objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Camarero)session.get(Camarero.class , idCamarero);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Camarero> traerCamarero() throws HibernateException {
		List<Camarero> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from Camarero c order by c.nombre asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	public Camarero traerCamareroCompleto(long idCamarero) throws HibernateException {
		Camarero objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Camarero c where c.idCamarero =" +idCamarero;
			objeto=(Camarero)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getComandas());
		}
		finally {
			session .close();
		}
		return objeto;
	}
}