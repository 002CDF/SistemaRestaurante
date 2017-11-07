package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Login;
import datos.Mesa;
import datos.Usuario;
public class MesaDao {
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

	public int agregarMesa(Mesa objeto) {
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

	public void actualizarMesa(Mesa objeto) throws HibernateException {
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
	public void eliminarMesa(Mesa objeto) throws HibernateException {
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
	public Mesa traerMesa(long idMesa) throws HibernateException {
		Mesa objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Mesa)session.get(Mesa.class , idMesa);
		} finally {
			session .close();
		}
		return objeto;
	}
	public Mesa traerMesa(int nroMesa) throws HibernateException {
		Mesa objeto = null ;
		try {
			iniciaOperacion();
			String hql = "from Mesa m inner join fetch m.salon where m.nroMesa='"+nroMesa+"'";
			objeto = (Mesa) session.createQuery(hql).uniqueResult();
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Mesa> traerMesa() throws HibernateException {
		List<Mesa> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from Mesa m order by m.nroMesa asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<Mesa> traerMesasDisponibles() throws HibernateException {
		List<Mesa> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from Mesa m where estadoMesa=1 order by m.idMesa asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
}