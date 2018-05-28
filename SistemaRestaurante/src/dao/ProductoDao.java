package dao;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Producto;
public class ProductoDao {
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

	public int agregarProducto(Producto objeto) {
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

	public void actualizarProducto(Producto objeto) throws HibernateException {
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
	public void eliminarProducto(Producto objeto) throws HibernateException {
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
	public Producto traerProducto(long idProducto) throws HibernateException {
		Producto objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Producto)session.get(Producto.class , idProducto);
		} finally {
			session .close();
		}
		return objeto;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Producto> traerProductoPorRubro(long idRubro) throws HibernateException {
		List<Producto> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from Producto p where idRubro="+idRubro+" order by p.nombre asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Producto> traerProducto() throws HibernateException {
		List<Producto> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery("from Producto p order by p.nombre asc").list() ;
		} finally {
			session .close();
		}
		return lista;
	}
	public Producto traerProductoCompleto(long idProducto) throws HibernateException {
		Producto objeto = null ;
		try {
			iniciaOperacion();
			String hql= "from Producto p where p.idProducto =" +idProducto;
			objeto=(Producto)session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getMenues());
			Hibernate.initialize(objeto.getPrecios());
			Hibernate.initialize(objeto.getViandas());
			Hibernate.initialize(objeto.getItemComandas());
		}
		finally {
			session .close();
		}
		return objeto;
	}
}