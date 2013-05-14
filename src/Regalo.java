import gnu.prolog.term.AtomTerm;
import gnu.prolog.term.CompoundTerm;
import gnu.prolog.term.Term;
import gnu.prolog.term.VariableTerm;
import gnu.prolog.vm.Environment;
import gnu.prolog.vm.Interpreter;
import gnu.prolog.vm.PrologCode;
import gnu.prolog.vm.PrologException;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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


public class Regalo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Regalo(final JFrame frame,final PoloNorteInc contadorglobal) {
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
		
		JLabel lblEdad = new JLabel("Precio");
		lblEdad.setForeground(new Color(240, 230, 140));
		lblEdad.setBounds(395, 109, 70, 15);
		panel.add(lblEdad);
		
		JLabel lblPas = new JLabel("Marca");
		lblPas.setForeground(new Color(240, 230, 140));
		lblPas.setBounds(33, 163, 70, 15);
		panel.add(lblPas);
		
		JLabel lblPresupuestoParaEl = new JLabel("Edad Necesaria");
		lblPresupuestoParaEl.setForeground(new Color(240, 230, 140));
		lblPresupuestoParaEl.setBounds(339, 163, 129, 15);
		panel.add(lblPresupuestoParaEl);
		
		final JTextField textField = new JTextField();
		textField.setBounds(106, 107, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		final JTextField textField_1 = new JTextField();
		textField_1.setBounds(457, 161, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		final JTextField textField_2 = new JTextField();
		textField_2.setBounds(457, 107, 114, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		final JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(106, 161, 114, 19);
		panel.add(textField_3);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nombre=textField.getText();
				String EdadNecesaria=textField_1.getText();
				String Precio=textField_2.getText();
				String Marca=textField_3.getText();
				
				boolean entrada=true;
				int confirmado=JOptionPane.showConfirmDialog(panel,"¿Confirma los datos anteriores?");
				
					if (JOptionPane.OK_OPTION == confirmado & (contadorglobal.contador2!=0 & (!Nombre.isEmpty()) & (!EdadNecesaria.isEmpty()) & (!Precio.isEmpty()) & (!Marca.isEmpty()))){
						
						//prolog
						
						Environment env = new Environment();				    
					    env.ensureLoaded(AtomTerm.get("/home/ldcoma10/workspace/Diego/BaseConocimiento.pl"));
					    Interpreter interpreter = env.createInterpreter();	 
					    env.runInitialization(interpreter);
					    // Y por ultimo realizar las consultas  :
					    			    
					    VariableTerm a=new VariableTerm();
					    VariableTerm b=new VariableTerm();			    
					    
					    
					    //Term[] arg={AtomTerm.get(Nombre.toLowerCase()), f,AtomTerm.get(Pais.toLowerCase()),a,b,c,d};
					     // Construct the question
					   
					    Term[] arg={AtomTerm.get(Nombre.toLowerCase()),a,b,AtomTerm.get(Marca.toLowerCase())};
					     CompoundTerm goalTerm = new CompoundTerm(AtomTerm.get("esregalo"), arg);
					     				       
					    try {
					    	
					        if (interpreter.runOnce(goalTerm) == 
					            PrologCode.SUCCESS)
					        {           
					        	
					            JOptionPane.showMessageDialog(panel,"El regalo que ingresó ya está en la lista de Santa Claus","Error",JOptionPane.ERROR_MESSAGE);
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
					
					/*
					 * 
					 */
					if ((!Nombre.isEmpty()) & (!EdadNecesaria.isEmpty()) & (!Precio.isEmpty()) & (!Marca.isEmpty())& (entrada==true)) {
						
							int edad=Integer.parseInt(EdadNecesaria);
							int precio=Integer.parseInt(Precio);
							
														 
							try {
								
								FileWriter archiv=new FileWriter("BaseConocimiento.pl",true);
								PrintWriter pw=new PrintWriter(archiv);
								pw.print("\nregalo("+Nombre.toLowerCase()+","+edad+","+precio+","+Marca.toLowerCase()+").");								
								archiv.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							contadorglobal.contador2++;							
							frame.setVisible(true);
							Regalo.this.dispose();
							
							
							
						}
						
						else if (entrada==true){
							JOptionPane.showMessageDialog(panel,"Error","Error debe llenar todas las opciones",JOptionPane.ERROR_MESSAGE);
							
						}}
					
					
					
				});
		btnAceptar.setBounds(271, 265, 117, 25);
		panel.add(btnAceptar);
		
		JLabel lblPoloNorteInc = new JLabel("Polo Norte INC");
		lblPoloNorteInc.setForeground(new Color(0, 191, 255));
		lblPoloNorteInc.setBounds(130, 12, 455, 83);
		lblPoloNorteInc.setFont(new Font("Dialog", Font.BOLD, 49));
		panel.add(lblPoloNorteInc);
		
		JLabel lblNewLabel = new JLabel("Precio");
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
				Regalo.this.dispose();
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
