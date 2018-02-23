package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Login;
import datos.Usuario;


public class LoginDao {	
private static Session session ;
	private Transaction tx ;
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}

	public int agregar(Login objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer. parseInt ( session .save(objeto).toString());
			tx .commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session .close();
		}
		return id;
	}
	public void actualizar(Login objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session .update(objeto);
			tx .commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session .close();
		}
	}
	
	public void eliminar(Login objeto) throws HibernateException {
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
	public Login traerLogin( long idLogin) throws HibernateException {
		Login objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Login) session .get(Login. class , idLogin);
		} finally {
			session .close();
		}
		return objeto;
	}
	public Login traerLogin(String nombreUsuario, String password) throws HibernateException {
		Login objeto = null ;
		try {
			iniciaOperacion();
			String hql = "from Login l where l.nombreUsuario='"+nombreUsuario+"' and l.password='"+password+"'";
			objeto = (Login)session.createQuery(hql).uniqueResult();
		} finally {
			session .close();
		}
		
		return objeto;
	}
	public Login traerLoginUser(String nombreUsuario) throws HibernateException {
		Login objeto = null ;
		try {
			iniciaOperacion();
			String hql = "from Login l where l.nombreUsuario='"+nombreUsuario+"'";
			objeto = (Login)session.createQuery(hql).uniqueResult();
		} finally {
			session .close();
		}
		
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Login> traerLogin() throws HibernateException {
		List<Login> lista= null ;
		try {
			iniciaOperacion();
			lista= session .createQuery( "from Login l order by l.idLogin" ).list() ;
		} finally {
			session .close();
		}
		return lista;
	}
}