package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Ticket;
public class TicketDao {
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

	public int agregarTicket(Ticket objeto) {
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

	public void actualizarTicket(Ticket objeto) throws HibernateException {
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
	public void eliminarTicket(Ticket objeto) throws HibernateException {
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
	public Ticket traerTicket(long idTicket) throws HibernateException {
		Ticket objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Ticket)session.get(Ticket.class , idTicket);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Ticket> traerTicket() throws HibernateException {
		List<Ticket> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from Ticket t order by t.idTicket asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	public Ticket traerTicketCompleto(long idTicket) throws HibernateException {
		Ticket objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Ticket t where t.idTicket =" +idTicket;
			objeto=(Ticket)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getItemTickets());
		}
		finally {
			session .close();
		}
		return objeto;
	}
}