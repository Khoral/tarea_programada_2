import java.util.LinkedList;
import java.util.List;

public class child {
	String  nombre; 
	int edad;
	String pais;
	List<String> buenasAcciones=new LinkedList<String>();
	List<String> malasAcciones=new LinkedList<String>();;
	List<String> regalosDeseados=new LinkedList<String>();
	int presupuesto;  // Presupuesto asignado a cada nino
	
	public void  agregarBuenasAcciones(String parametro){
		buenasAcciones.add(parametro);
	}
	
	public void  agregarMalasAcciones(String parametro){
		malasAcciones.add(parametro);
	}
	
	public void  agregarRegalosDeseados(String parametro){
		regalosDeseados.add(parametro);
	}
	public void agregarPresupuestoAdicional(int parametro){
		presupuesto+=parametro;
	}
	
}
