

import gnu.prolog.term.AtomTerm;
import gnu.prolog.term.CompoundTerm;
import gnu.prolog.term.IntegerTerm;
import gnu.prolog.term.Term;
import gnu.prolog.term.VariableTerm;
import gnu.prolog.vm.Environment;
import gnu.prolog.vm.Interpreter;
import gnu.prolog.vm.PrologCode;
import gnu.prolog.vm.PrologException;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;


import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class DatosNino extends JFrame {

	
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
	

	
	/**
	 * Create the frame.
	 */
	public DatosNino(final JFrame frame,final PoloNorteInc contadorglobal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombre.setForeground(new Color(240, 230, 140));
		lblNombre.setBounds(33, 109, 70, 15);
		panel.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setForeground(new Color(240, 230, 140));
		lblEdad.setBounds(310, 128, 70, 15);
		panel.add(lblEdad);
		
		JLabel lblPas = new JLabel("País");
		lblPas.setForeground(new Color(240, 230, 140));
		lblPas.setBounds(33, 163, 70, 15);
		panel.add(lblPas);
		
		JLabel lblPresupuestoParaEl = new JLabel("Presupuesto para el niñ@");
		lblPresupuestoParaEl.setForeground(new Color(240, 230, 140));
		lblPresupuestoParaEl.setBounds(33, 219, 197, 15);
		panel.add(lblPresupuestoParaEl);
		
		final JTextField textField = new JTextField();
		textField.setBounds(106, 107, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		final JTextField textField_1 = new JTextField();
		textField_1.setBounds(386, 126, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		final JTextField textField_2 = new JTextField();
		textField_2.setBounds(248, 217, 187, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		final JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(106, 161, 114, 19);
		panel.add(textField_3);
		
		JLabel lblPoloNorteInc = new JLabel("Polo Norte INC");
		lblPoloNorteInc.setForeground(new Color(0, 191, 255));
		lblPoloNorteInc.setBounds(101, 0, 455, 83);
		lblPoloNorteInc.setFont(new Font("Dialog", Font.BOLD, 49));
		panel.add(lblPoloNorteInc);
		
		JLabel lblListaDeBuenas = new JLabel("Lista de Buenas Acciones");
		lblListaDeBuenas.setForeground(new Color(240, 230, 140));
		lblListaDeBuenas.setBounds(33, 264, 197, 15);
		panel.add(lblListaDeBuenas);
		
		final JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(248, 262, 343, 19);
		panel.add(textField_4);
		
		final JTextField textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(248, 305, 343, 19);
		panel.add(textField_5);
		
		
		final JTextField textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(248, 347, 343, 19);
		panel.add(textField_6);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nombre=textField.getText();
				String Edad=textField_1.getText();
				String Pais=textField_3.getText();
				String LBA=textField_4.getText();
				String LMA=textField_5.getText();
				String LRD=textField_6.getText();
				String PresupSanta=textField_2.getText();
				
				boolean entrada=true;
				int confirmado=JOptionPane.showConfirmDialog(panel,"¿Confirma los datos anteriores?");
				if (JOptionPane.OK_OPTION == confirmado & (contadorglobal.contador!=0)&(!Nombre.isEmpty()) & (!Edad.isEmpty()) & (!Pais.isEmpty()) & (!LBA.isEmpty()) & (!LMA.isEmpty()) & (!LRD.isEmpty()) & (!PresupSanta.isEmpty())){
					
					//prolog
					
					Environment env = new Environment();				    
				    env.ensureLoaded(AtomTerm.get("/home/ldcoma10/workspace/Diego/BaseConocimiento.pl"));
				    Interpreter interpreter = env.createInterpreter();	 
				    env.runInitialization(interpreter);
				    // Y por ultimo realizar las consultas  :
				    			    
				    VariableTerm a=new VariableTerm();
				    VariableTerm b=new VariableTerm();
				    VariableTerm c=new VariableTerm();
				    VariableTerm d=new VariableTerm();
				    
				    
				    
				    //Term[] arg={AtomTerm.get(Nombre.toLowerCase()), f,AtomTerm.get(Pais.toLowerCase()),a,b,c,d};
				     // Construct the question
				   
				    Term[] arg={AtomTerm.get(Nombre.toLowerCase()),IntegerTerm.get(Edad),AtomTerm.get(Pais.toLowerCase()),a,b,c,d};
				     CompoundTerm goalTerm = new CompoundTerm(AtomTerm.get("esnino"), arg);
				     				       
				    try {
				    	
				        if (interpreter.runOnce(goalTerm) == 
				            PrologCode.SUCCESS)
				        {           
				        	
				            JOptionPane.showMessageDialog(panel,"El niño que ingresó ya está en la lista de Santa Claus","Error",JOptionPane.ERROR_MESSAGE);
				        	entrada=false;
				        } else {
				        	entrada=true;
				        }
				    } catch (PrologException e1) {
				    	entrada=false;
				        System.out.println("Error." + e1.getMessage());           
				    } 
				    // Fin. 
				    env.closeStreams();     
			
				}
					
					
				
				if ((!Nombre.isEmpty()) & (!Edad.isEmpty()) & (!Pais.isEmpty()) & (!LBA.isEmpty()) & (!LMA.isEmpty()) & (!LRD.isEmpty()) & (!PresupSanta.isEmpty())& (entrada==true) ){
					int edad=Integer.parseInt(Edad);
					int presupSanta=Integer.parseInt(PresupSanta);
					List <String> lba=new LinkedList<String>();
					List <String> lma=new LinkedList<String>();
					List <String> lrd=new LinkedList<String>();
					StringTokenizer tokens= new StringTokenizer(LBA, ",");
					StringTokenizer tokens1= new StringTokenizer(LMA, ",");
					if (tokens.countTokens()<tokens1.countTokens()){
						LRD="medias_de_golfista";}
					StringTokenizer tokens2= new StringTokenizer(LRD, ",");
					while (tokens.hasMoreTokens()){
						lba.add(tokens.nextToken());
					}
					while (tokens1.hasMoreTokens()){
						lma.add(tokens1.nextToken());
					}
					while (tokens2.hasMoreTokens()){
						
						lrd.add(tokens2.nextToken());			
						
								}
					
					 
					try {
						FileWriter archiv=new FileWriter("BaseConocimiento.pl",true);
						PrintWriter pw=new PrintWriter(archiv);
						pw.print("\nnino("+Nombre.toLowerCase()+","+edad+","+Pais.toLowerCase()+",[");
						
						
						int k=lba.size();
						for (int j=0;k-1>j;j++){
							String temp=lba.get(j);
							pw.print(temp.toLowerCase()+",");
							System.out.println(temp);}
						String ultimo=lba.get(k-1);
						pw.print(ultimo+"],[");
						
						
						k=lma.size();
						for (int j=0;k-1>j;j++){
							String temp=lma.get(j);
							pw.print(temp.toLowerCase()+",");
							System.out.println(temp);}
						ultimo=lma.get(k-1);
						pw.print(ultimo+"],[");
						
						k=lrd.size();
						for (int j=0;k-1>j;j++){
							String temp=lrd.get(j);
							pw.print(temp.toLowerCase()+",");
							System.out.println(temp);}
						ultimo=lrd.get(k-1);
						pw.print(ultimo+"],"+presupSanta+").");
						contadorglobal.lista.add(new nino(Nombre.toLowerCase(),edad,Pais.toLowerCase()));
						System.out.println("Elemento Insertado");
						contadorglobal.contador+=1;
						archiv.close();
						contadorglobal.presupuesto+=presupSanta;
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.setVisible(true);
					DatosNino.this.dispose();
					
					
				}
				
				else if (entrada==true){
					JOptionPane.showMessageDialog(panel,"Error","Error debe llenar todas las opciones",JOptionPane.ERROR_MESSAGE);
					
				}}
				
				
		});
		
		
		
		JLabel lblListaDeMalas = new JLabel("Lista de Malas Acciones");
		lblListaDeMalas.setForeground(new Color(240, 230, 140));
		lblListaDeMalas.setBounds(33, 307, 197, 15);
		panel.add(lblListaDeMalas);
		btnAceptar.setBounds(333, 378, 117, 25);
		panel.add(btnAceptar);
		
		JLabel lblListaDeRegalos = new JLabel("Lista de Regalos Deseados");
		lblListaDeRegalos.setForeground(new Color(240, 230, 140));
		lblListaDeRegalos.setBounds(33, 344, 197, 15);
		panel.add(lblListaDeRegalos);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/ldcoma10/workspace/Diego/src/christmas-caper-bluray-penguins-madagascar-links-30106.jpg"));
		lblNewLabel.setBounds(0, 0, 679, 437);
		panel.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon("/home/ldcoma10/workspace/Diego/src/images.jpg"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem.setForeground(Color.WHITE);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("SALIR           ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosNino.this.dispose();
			}
		});
		mntmNewMenuItem_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1.setBackground(Color.DARK_GRAY);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Ayuda");
		mnNewMenu_1.setForeground(Color.WHITE);
		mnNewMenu_1.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmInformacinDe = new JMenuItem("Info de Polo Norte INC ");
		mntmInformacinDe.setForeground(Color.WHITE);
		mntmInformacinDe.setBackground(Color.DARK_GRAY);
		mnNewMenu_1.add(mntmInformacinDe);
	}
}
