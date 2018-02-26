package facade;

import negocio.CamareroABM;
import negocio.ClienteABM;
import negocio.ComandaABM;
import negocio.ConversionABM;
import negocio.IngredienteABM;
import negocio.ItemComandaABM;
import negocio.ItemListaPrecioABM;
import negocio.ItemRecetaABM;
import negocio.ItemTicketABM;
import negocio.ListaPrecioABM;
import negocio.LoginABM;
import negocio.MenuABM;
import negocio.MesaABM;
import negocio.PrivilegioABM;
import negocio.ProductoABM;
import negocio.RecetaABM;
import negocio.RubroABM;
import negocio.SalonABM;
import negocio.SubRubroABM;
import negocio.TicketABM;
import negocio.TipoClienteABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;
import negocio.ViandaABM;

public class Facade {

	public CamareroABM getCamareroABM(){
		return new CamareroABM();
	}
	
	public ClienteABM getClienteABM(){
		return new ClienteABM();
	}
	
	public ComandaABM getComandaABM(){
		return new ComandaABM();
	}
	
	public ConversionABM getConversionABM(){
		return new ConversionABM();
	}
	
	public IngredienteABM getIngredienteABM(){
		return new IngredienteABM();
	}
	
	public ItemComandaABM getItemComandaABM(){
		return new ItemComandaABM();
	}
	
	public ItemListaPrecioABM getItemListaPrecioABM(){
		return new ItemListaPrecioABM();
	}
	
	public ItemRecetaABM getItemRecetaABM(){
		return new ItemRecetaABM();
	}
	
	public ItemTicketABM getItemTicketABM(){
		return new ItemTicketABM();
	}
	
	public ListaPrecioABM getListaPrecioABM(){
		return new ListaPrecioABM();
	}
	
	public LoginABM getLoginABM(){
		return new LoginABM();
	}
	
	public MenuABM getMenuABM(){
		return new MenuABM();
	}
	
	public MesaABM getMesaABM(){
		return new MesaABM();
	}
	
	public PrivilegioABM getPrivilegioABM(){
		return new PrivilegioABM();
	}
	
	public ProductoABM getProductoABM(){
		return new ProductoABM();
	}
	
	public RecetaABM getRecetaABM(){
		return new RecetaABM();
	}
	
	public RubroABM getRubroABM(){
		return new RubroABM();
	}
	
	public SalonABM getSalonABM(){
		return new SalonABM();
	}
	
	public SubRubroABM getSubrubroABM(){
		return new SubRubroABM();
	}
	
	public TicketABM getTicketABM(){
		return new TicketABM();
	}
	
	public TipoClienteABM getTipoClienteABM(){
		return new TipoClienteABM();
	}
	
	public TipoUsuarioABM getTipoUsuarioABM(){
		return new TipoUsuarioABM();
	}
	
	public UsuarioABM getUsuarioABM(){
		return new UsuarioABM();
	}
	
	public ViandaABM getViandaABM(){
		return new ViandaABM();
	}
	
}
