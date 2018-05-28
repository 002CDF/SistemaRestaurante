package negocio;
import dao.ProductoDao;

import java.util.List;
import datos.Producto;
import datos.Conversion;
import datos.Receta;
import datos.Rubro;
import datos.SubRubro;
public class ProductoABM {
	private ProductoDao dao = new ProductoDao();

	public int agregarProducto(String nombre, String descripcion, Receta receta,
			Rubro rubro, SubRubro subRubro, boolean habilitado, String imagen){
		Producto p = new Producto (nombre, descripcion, receta, rubro,
				subRubro, habilitado, imagen);
		return dao.agregarProducto(p);
	}

	public void modificarProducto(Producto producto){
		dao.actualizarProducto(producto);
	}

	public void eliminarProducto(long idProducto){
		Producto p = dao.traerProducto(idProducto);
		dao.eliminarProducto(p);
	}

	public Producto traerProducto(long idProducto){
		return dao.traerProducto(idProducto);
	}

	public List<Producto> traerProducto(){
		return dao.traerProducto();
	}
	
	public List<Producto> traerProductoPorRubro(long idRubro){
		return dao.traerProductoPorRubro(idRubro);
	}
	
	public Producto traerProductoCompleto (long idProducto){
		return dao.traerProductoCompleto(idProducto);
	}

}
