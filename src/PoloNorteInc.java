import java.util.LinkedList;
import java.util.List;




public class PoloNorteInc {
	public int contador=0;
	public int contador2=0;
	public int presupuesto=0;
	List <nino> lista=new LinkedList<nino>();
	
	boolean buscarnino(String nombre,int edad,String pais){
		boolean retorno=false;
		int k=lista.size();
		for (int j=0;k>j;j++){
			nino temp=lista.get(j);
			if (temp.Nombre.equals(nombre)& temp.Edad==edad & temp.Pais.equals(pais)){				
				retorno=true;
				break;}}
			return retorno;
	}}
	
	

