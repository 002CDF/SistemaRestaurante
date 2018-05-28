package datos;

import java.util.GregorianCalendar;
import java.util.List;

public class Informe {
	
	private String fechaInicio;
	private String fechaFin;
	private int cantidadTickets;
	private double totalFacturado;
	private double maxTicket;
	private double promedio;
	private List<Ticket> tickets;
	
	public Informe(){}
	
	public Informe(String fechaInicio, String fechaFin,
			int cantidadTickets, double totalFacturado, double maxTicket,
			double promedio) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantidadTickets = cantidadTickets;
		this.totalFacturado = totalFacturado;
		this.maxTicket = maxTicket;
		this.promedio = promedio;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	public int getCantidadTickets() {
		return cantidadTickets;
	}


	public void setCantidadTickets(int cantidadTickets) {
		this.cantidadTickets = cantidadTickets;
	}


	public double getTotalFacturado() {
		return totalFacturado;
	}


	public void setTotalFacturado(double totalFacturado) {
		this.totalFacturado = totalFacturado;
	}


	public double getMaxTicket() {
		return maxTicket;
	}


	public void setMaxTicket(double maxTicket) {
		this.maxTicket = maxTicket;
	}


	public double getPromedio() {
		return promedio;
	}


	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
	
}
