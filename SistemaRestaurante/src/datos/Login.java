package datos;

public class Login {

	
	private long idLogin;
	private String nombreUsuario;
	private String password;
	
	
	public Login() {
		super();
	}

	public Login(String nombreUsuario, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	public long getIdLogin() {
		return idLogin;
	}

	protected void setIdLogin(long idLogin) {
		this.idLogin = idLogin;
	}

	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idLogin ^ (idLogin >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (idLogin != other.idLogin)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Login [idLogin=" + idLogin + ", usuario=" + nombreUsuario + ", password=" + password + "]";
	}

	
	
	
}
