package datos;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class MesaCompuesta extends Mesa{
	private long idMesaCompuesta;
	private Set<MesaSimple> mesasSimples;
	
	public MesaCompuesta(){}

	public long getIdMesaCompuesta() {
		return idMesaCompuesta;
	}

	public void setIdMesaCompuesta(long idMesaCompuesta) {
		this.idMesaCompuesta = idMesaCompuesta;
	}

	public Set<MesaSimple> getMesasSimples() {
		return mesasSimples;
	}

	public void setMesasSimples(Set<MesaSimple> mesasSimples) {
		this.mesasSimples = mesasSimples;
	}
	public void agregarMesaSimple(MesaSimple mesaSimple)throws Exception{
		List<MesaSimple> lista = new ArrayList(this.mesasSimples);
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).equals(mesaSimple)){
				throw new Exception("Error: El item que desea agregar ya existe");
			}
		}
		mesasSimples.add(mesaSimple);
	}

	@Override
	public String toString() {
		return "Mesas Simples= " + mesasSimples;
	}


	
	
}
