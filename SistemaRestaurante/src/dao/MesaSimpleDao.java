package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Mesa;
import datos.MesaSimple;
public class MesaSimpleDao {
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

	public int agregarMesaSimple(MesaSimple objeto) {
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

	public void actualizarMesaSimple(MesaSimple objeto) throws HibernateException {
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
	public void eliminarMesaSimple(MesaSimple objeto) throws HibernateException {
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
	public MesaSimple traerMesaSimple(long idMesaSimple) throws HibernateException {
		MesaSimple objeto = null ;
		try {
			iniciaOperacion();
			objeto = (MesaSimple)session.get(MesaSimple.class , idMesaSimple);
		} finally {
			session .close();
		}
		return objeto;
	}

	@SuppressWarnings ( "unchecked" )
	public List<MesaSimple> traerMesaSimple() throws HibernateException {
		List<MesaSimple> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from MesaSimple m order by m.idMesa asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
}