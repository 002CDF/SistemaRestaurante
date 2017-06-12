package negocio;
import dao.StockDao;
import java.util.List;
import datos.Stock;
import datos.Ingrediente;
public class StockABM {
	private StockDao dao = new StockDao();

	public int agregarStock(Ingrediente ingrediente, double cantidadActual,
			double cantidadMinima, double cantidadDeseada){
		Stock s = new Stock (ingrediente, cantidadActual, cantidadMinima, 
				cantidadDeseada);
		return dao.agregarStock(s);
	}

	public void modificarStock(Stock stock){
		dao.actualizarStock(stock);
	}

	public void eliminarStock (long idStock){
		Stock s = dao.traerStock(idStock);
		dao.eliminarStock(s);
	}

	public Stock traerStock( long idStock){
		return dao.traerStock(idStock);
	}

	public List<Stock> traerStock(){
		return dao.traerStock();
	}

}
