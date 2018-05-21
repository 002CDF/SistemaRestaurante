package dao;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import negocio.Funciones;

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

	public int agregarTicketCompleto(Ticket objeto) {
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
	public Ticket traerTicketMesa(long idMesa) throws HibernateException {
		Ticket objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Ticket t left join fetch t.cliente inner join fetch t.camarero where t.fechaEmision in(select MAX(t.fechaEmision) from Ticket t where idMesa="+idMesa+")";
			objeto=(Ticket)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getItemTickets());
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
			String hql= "from Ticket t inner join fetch t.cliente inner join fetch t.camarero where t.idTicket =" +idTicket;
			objeto=(Ticket)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getItemTickets());
		}
		finally {
			session .close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<Ticket> traerInformeTicket (String fechaInicio, String fechaFin) throws HibernateException {
		List<Ticket> lista= null ;
		try {
			int fechaFin_dia = Integer.parseInt(fechaFin.substring(8, 10));
			int fechaFin_mes = Integer.parseInt(fechaFin.substring(5, 7));
			int fechaFin_anio = Integer.parseInt(fechaFin.substring(0, 4));
			GregorianCalendar fechaFinPosterior = new GregorianCalendar(fechaFin_anio, fechaFin_mes-1, fechaFin_dia);
			fechaFinPosterior.add(Calendar.DAY_OF_YEAR, 1);
			String fechaFinPost = ""+Funciones.traerNumeroAnio(fechaFinPosterior)+"-"+Funciones.traerNumeroMes(fechaFinPosterior)+"-"+Funciones.traerNumeroDiaMes(fechaFinPosterior);
			iniciaOperacion();
			lista= session.createQuery("from Ticket t where t.fechaEmision between '"+fechaInicio+"' and '"+fechaFinPost+"'").list();
		} finally {
			session .close();
		}
		return lista;
	}
	
}