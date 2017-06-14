package test;

import java.util.GregorianCalendar;

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
import negocio.MenuABM;
import negocio.MesaABM;
import negocio.PrivilegioABM;
import negocio.ProductoABM;
import negocio.RecetaABM;
import negocio.RubroABM;
import negocio.SalonABM;
import negocio.StockABM;
import negocio.SubRubroABM;
import negocio.TicketABM;
import negocio.TipoClienteABM;
import negocio.TipoUsuarioABM;
import negocio.UsuarioABM;
import negocio.ViandaABM;
import datos.Camarero;
import datos.Cliente;
import datos.Comanda;
import datos.Conversion;
import datos.EstadoMesa;
import datos.Ingrediente;
import datos.ItemListaPrecio;
import datos.ListaPrecio;
import datos.Mesa;
import datos.Producto;
import datos.Receta;
import datos.Rubro;
import datos.Salon;
import datos.SubRubro;
import datos.TipoCliente;
import datos.TipoUsuario;
import datos.Usuario;

public class TestAgregarObjeto {

	public static void main(String[] args) {
		//Se crean los abm de todas las clases
		CamareroABM camareroABM = new CamareroABM();
		ClienteABM clienteABM = new ClienteABM();
		ComandaABM comandaABM = new ComandaABM();
		ConversionABM conversionABM = new ConversionABM();
		IngredienteABM ingredienteABM = new IngredienteABM();
		ItemComandaABM itemComandaABM = new ItemComandaABM();
		ItemListaPrecioABM itemListaPrecioABM = new ItemListaPrecioABM();
		ItemRecetaABM itemRecetaABM = new ItemRecetaABM();
		ItemTicketABM itemTicketABM = new ItemTicketABM();
		ListaPrecioABM listaPrecioABM = new ListaPrecioABM();
		MenuABM menuABM = new MenuABM();
		MesaABM mesaABM = new MesaABM();
		PrivilegioABM privilegioABM = new PrivilegioABM();
		ProductoABM productoABM = new ProductoABM();
		RecetaABM recetaABM = new RecetaABM();
		RubroABM rubroABM = new RubroABM();
		SalonABM salonABM = new SalonABM();
		StockABM stockABM = new StockABM();
		SubRubroABM subRubroABM = new SubRubroABM();
		TicketABM ticketABM = new TicketABM();
		TipoClienteABM tipoClienteABM = new TipoClienteABM();
		TipoUsuarioABM tipoUsuarioABM = new TipoUsuarioABM();
		UsuarioABM usuarioABM = new UsuarioABM();
		ViandaABM viandaABM = new ViandaABM();
		//Objetos que necesitamos para agregar como atributo en constructor
		TipoCliente tipoCliente = new TipoCliente("tipoCliente");
		TipoUsuario tipoUsuario = new TipoUsuario("tipoUsuario");
		Camarero camarero = new Camarero(1111111, "Nombre", "Apellido");
		Salon salon = new Salon("descripcion");
		EstadoMesa estadoMesa = new EstadoMesa();
		Mesa mesa = new Mesa(estadoMesa, salon);
		Receta receta = new Receta("Nombre", "descripcion");
		Conversion conversion = new Conversion("Kilo");
		Rubro rubro = new Rubro("descripcion");
		SubRubro subRubro = new SubRubro("descripcion");
		Cliente cliente = new Cliente(1111111, "Nombre", "Apellido", tipoCliente);
		Comanda comanda = new Comanda(new GregorianCalendar(), mesa, cliente, camarero, 1, true);
		Producto producto = new Producto("Nombre", "descripcion", receta, rubro, subRubro, true, "imagen");
		ListaPrecio listaPrecio = new ListaPrecio(new GregorianCalendar(), tipoCliente);
		Ingrediente ingrediente = new Ingrediente("Nombre", "descripcion", conversion, 20.00, 15.00);
		Usuario usuario = new Usuario("NombreUsuario", "Password", tipoUsuario);
		//Se envia cada constructo al ABM para ser creado y agregado a la BD
		camareroABM.agregarCamarero(111111111, "Nombre", "Apellido");
		/*clienteABM.agregarCliente(11111111, "Nombre", "Apellido", tipoCliente);
		comandaABM.agregarComanda(new GregorianCalendar(), mesa, cliente, camarero, 1, true);
		conversionABM.agregarConversion("Kilo");
		ingredienteABM.agregarIngrediente("Nombre", "Descripcion", conversion, 2.0, 2.0);
		itemComandaABM.agregarItemComanda(comanda, producto, 2);
		itemListaPrecioABM.agregarItemListaPrecio(listaPrecio, producto, 50.00);
		itemRecetaABM.agregarItemReceta(receta, ingrediente, 4);
		itemTicketABM.agregarItemTicket(producto, 20, 2);
		listaPrecioABM.agregarListaPrecio(new GregorianCalendar(), tipoCliente);
		menuABM.agregarMenu(new GregorianCalendar(), "Lunes-Martes-Sabado");
		privilegioABM.agregarPrivilegio("privilegio");
		productoABM.agregarProducto("Nombre", "descripcion", receta, rubro, subRubro, true, "imagen");
		recetaABM.agregarReceta("Nombre", "descripcion");
		rubroABM.agregarRubro("descripcion");
		salonABM.agregarSalon("descripcion");
		stockABM.agregarStock(ingrediente, 500, 30, 700);
		subRubroABM.agregarSubRubro("descripcion");
		ticketABM.agregarTicket(350.25, usuario, false, false);
		tipoClienteABM.agregarTipoCliente("tipo");
		usuarioABM.agregarUsuario("NombreUsuario", "Password", tipoUsuario);
		viandaABM.agregarVianda("descripcion");*/
	}

}
