package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Receta;
public class RecetaDao {
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

	public int agregarReceta(Receta objeto) {
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

	public void actualizarReceta(Receta objeto) throws HibernateException {
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
	public void eliminarReceta(Receta objeto) throws HibernateException {
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
	public Receta traerReceta(long idReceta) throws HibernateException {
		Receta objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Receta)session.get(Receta.class , idReceta);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Receta> traerReceta() throws HibernateException {
		List<Receta> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from Receta r order by r.nombre asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	public Receta traerRecetaCompleto(long idReceta) throws HibernateException {
		Receta objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Receta r where r.idReceta =" +idReceta;
			objeto=(Receta)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getItemRecetas());
		}
		finally {
			session .close();
		}
		return objeto;
	}
}