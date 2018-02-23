package negocio;
import java.util.GregorianCalendar;
import java.util.List;

import dao.LoginDao;
import datos.Login;
import datos.Usuario;

public class LoginABM {
	LoginDao dao = new LoginDao();

    public int agregar(String nombreUsuario, String password){
    	Login objeto= new Login(nombreUsuario,password);
        return dao .agregar(objeto);
    }

    public void actualizar(Login c){
        dao.actualizar(c);
    }

    public void eliminar(Login objeto){
    	Login c= dao .traerLogin(objeto.getIdLogin());
        dao .eliminar(c);
    }
    
    public Login traerLogin( long idLogin){
    	Login c= dao.traerLogin(idLogin);
        return c;
    }
	public Login traerLogin(String nombreUsuario, String password){
		return dao.traerLogin(nombreUsuario, password);
	}
	public Login traerLoginUser(String nombreUsuario){
		return dao.traerLoginUser(nombreUsuario);
	}
    public List<Login> traerLogin(){
    	return dao.traerLogin();
    	}
    
    
}