package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.SubRubro;
public class SubRubroDao {
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

	public int agregarSubRubro(SubRubro objeto) {
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

	public void actualizarSubRubro(SubRubro objeto) throws HibernateException {
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
	public void eliminarSubRubro(SubRubro objeto) throws HibernateException {
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
	public SubRubro traerSubRubro(long idSubRubro) throws HibernateException {
		SubRubro objeto = null ;
		try {
			iniciaOperacion();
			objeto = (SubRubro)session.get(SubRubro.class , idSubRubro);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<SubRubro> traerSubRubro() throws HibernateException {
		List<SubRubro> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from SubRubro s order by s.idSubRubro asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	public SubRubro traerSubRubroCompleto(long idSubRubro) throws HibernateException {
		SubRubro objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from SubRubro s where s.idSubRubro =" +idSubRubro;
			objeto=(SubRubro)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getRubros());
			Hibernate.initialize(objeto.getProductos());

		}
		finally {
			session .close();
		}
		return objeto;
	}
}