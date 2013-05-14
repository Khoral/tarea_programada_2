


import gnu.prolog.term.AtomTerm;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.lang.model.element.VariableElement;

import gnu.prolog.term.AtomicTerm;
import gnu.prolog.term.CompoundTerm;
import gnu.prolog.term.IntegerTerm;
import gnu.prolog.term.Term;
import gnu.prolog.term.VariableTerm;
import gnu.prolog.vm.Environment;
import gnu.prolog.vm.Interpreter;
import gnu.prolog.vm.PrologCode;
import gnu.prolog.vm.PrologException;
//public class gprolog {
//
//	public static void main(String[] args) throws IOException {
//		/**
//	     * Entorno que usará el interprete.
//	     * 
//	     */
//		
//	   
//	    Environment env;
//	    /**
//	     * Interprete de PROLOG.
//	     */
//	    Interpreter interpreter;
//
//	    env = new Environment();
//	    // Cargamos el fichero en el entorno.
//	    env.ensureLoaded(AtomTerm.get("/home/ldcoma10/workspace/Diego/foo.pl"));
//	    // Obtenemos el interprete
//	    
//	    interpreter = env.createInterpreter();
//	    // Y lo inicializamos
//	    env.runInitialization(interpreter);
//	    
//	    
//
////	Y por ultimo realizar las consultas  :
//	    
//	    
//	    
//	    // Argumentos para la consulta en este caso constantes.
//	    Term[] argumentos = { AtomTerm.get("adri"), VariableTerm };
//	    // Construimos la consulta Paco es desdenciente de Tito?
//	    CompoundTerm goalTerm =
//	        new CompoundTerm(AtomTerm.get("familia"), argumentos);
//	    Term y =goalTerm.dereference();
//	    System.out.println(y.toString());
//	    
//	    /*/String[]arg={"adri","diego"};
//	    int limit=3;
//	    int length=3;
//	    
//	    
//	    VariableTerm listTerm = new VariableTerm("List");
//	     VariableTerm answerTerm = new VariableTerm("Answer");
//	     // Create the arguments to the compound term which is the question
//	     Term[] arg = { new IntegerTerm(limit), new IntegerTerm(length), listTerm, answerTerm };
//	     // Construct the question
//	     CompoundTerm goalTer = new CompoundTerm(AtomTerm.get("arithmetic"), arg);
//	   
//		
//	    
//	    
//	    //CompoundTermTag goalTerm1;
//	    //goalTerm1.functor.equals("hermanos");
//	    //goalTerm1.arity=2;
//	    //goalTerm1.comma.equals(arg);
//	    //env.addPrologCodeListener(goalTerm1,PrologCodeListener);*/
//	       
//	    try {
//	    	
//	        if (interpreter.runOnce(goalTerm) == PrologCode.SUCCESS)
//	        {               
//	            System.out.println("Pepe es descendiente de Tito.");
//	        } else {
//	            System.out.println("Pepe NO es descendiente de Tito.");
//	        }
//	    } catch (PrologException e) {
//	        System.out.println("Error." + e.getMessage());           
//	    } 
//	    // Fin. 
//	    env.closeStreams();     
//}
//}


public class gprolog {

	public class PoloNorteInc {

	}

	public static void main(String[] args) throws IOException {
		
		
		try {
			FileWriter archivo=new FileWriter("foo.pl",true);
			PrintWriter pw=new PrintWriter(archivo);
			pw.print("\nedades(7,5).");
			System.out.println("Elemento Insertado");
			pw.print("\notro(A,H).");
			archivo.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/**
	     * Entorno que usara el interprete.
	     */
	    Environment env;
	    /**
	     * Interprete de PROLOG.
	     */
	    Interpreter interpreter;

	    env = new Environment();
	    // Cargamos el fichero en el entorno.
	    env.ensureLoaded(AtomTerm.get("/home/ldcoma10/workspace/Diego/foo.pl"));
	    // Obtenemos el interprete
	    interpreter = env.createInterpreter();
	    // Y lo inicializamos
	    env.runInitialization(interpreter);

//	Y por ultimo realizar las consultas  :

	    // Argumentos para la consulta en este caso constantes.
	    
	     // Create the arguments to the compound term which is the question
	    
	    VariableTerm g=new VariableTerm();
	    VariableTerm h=new VariableTerm();
	    VariableTerm i=new VariableTerm();
	    VariableTerm j=new VariableTerm();
	    VariableTerm k=new VariableTerm();
	    VariableTerm l=new VariableTerm();
	    
	    Term[] arg={AtomTerm.get("cama"),i,j,k};
	     Term[] argus = { g };
	     // Construct the question
	     CompoundTerm goalTerm = new CompoundTerm(AtomTerm.get("esregalo"), arg);
	     



	       
	    try {
	    	
	        if (interpreter.runOnce(goalTerm) == 
	            PrologCode.SUCCESS)
	        {           
	        	Term y=goalTerm.dereference();	        	
	            System.out.println("Pepe es descendiente de Tito."+y.toString()+g.dereference());
	        } else {
	        	
	            System.out.println("Pepe NO es descendiente de Tito.");
	        }
	    } catch (PrologException e) {
	        System.out.println("Error." + e.getMessage());           
	    } 
	    // Fin. 
	    env.closeStreams();     
}
}


