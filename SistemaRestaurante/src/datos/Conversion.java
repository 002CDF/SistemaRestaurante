package datos;

public class Conversion {
	private long idConversion;
	private String unidad;
	
	public Conversion(){}

	public Conversion(String unidad) {
		super();
		this.unidad = unidad;
	}

	public long getIdConversion() {
		return idConversion;
	}

	public void setIdConversion(long idConversion) {
		this.idConversion = idConversion;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
	
}
