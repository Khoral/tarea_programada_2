import gnu.prolog.term.AtomTerm;


import gnu.prolog.term.CompoundTerm;
import gnu.prolog.term.IntegerTerm;
import gnu.prolog.term.Term;
import gnu.prolog.term.VariableTerm;
import gnu.prolog.vm.Environment;
import gnu.prolog.vm.Interpreter;
import gnu.prolog.vm.PrologCode;
import gnu.prolog.vm.PrologException;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.util.StringTokenizer;



public class BadChildren extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	
	public BadChildren(final JFrame frame,PoloNorteInc datos) {
		
	    String ninosmalos="";
	    int k=datos.lista.size();
		for (int j=0;k>j;j++){
			//prolog
			
			Environment env = new Environment();				    
		    env.ensureLoaded(AtomTerm.get("/home/ldcoma10/workspace/Diego/BaseConocimiento.pl"));
		    Interpreter interpreter = env.createInterpreter();	 
		    env.runInitialization(interpreter);
		    
			nino temp=datos.lista.get(j);
			VariableTerm a=new VariableTerm();
		    VariableTerm b=new VariableTerm();
		    VariableTerm c=new VariableTerm();
		    VariableTerm d=new VariableTerm();
	    
		    //Se construye la pregunta a prolog
		    Term[] arg={AtomTerm.get(temp.Nombre.toLowerCase()),IntegerTerm.get(temp.Edad.toString()),AtomTerm.get(temp.Pais.toLowerCase()),a,b,c,d};
		    CompoundTerm goalTerm = new CompoundTerm(AtomTerm.get("esnino"), arg);
		    
	     				       
	    
	    	
	        try {
				if (interpreter.runOnce(goalTerm) == PrologCode.SUCCESS)
				{           
					String lista=a.toString();
					String lista2=b.toString();
					StringTokenizer tokens= new StringTokenizer(lista, ",");
					StringTokenizer tokens2= new StringTokenizer(lista2, ",");
					if (tokens.countTokens()<tokens2.countTokens()){
						ninosmalos+="\n"+temp.Nombre;
					}
					}        	
				else {
					ninosmalos= "no se encontró";  }
			} catch (PrologException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}           
	        
	    
	    // Fin. 
	    env.closeStreams();
		}
		
		
		
		
		
		
		
		
		setBackground(Color.LIGHT_GRAY);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 0, 438, 271);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblninoosbuenos = new JLabel("Lista de Niñ@s Mal@s");
		lblninoosbuenos.setBounds(99, 22, 219, 15);
		lblninoosbuenos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblninoosbuenos.setForeground(new Color(255, 255, 255));
		panel.add(lblninoosbuenos);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				BadChildren.this.dispose();
			}
		});
		btnNewButton.setBounds(284, 201, 117, 25);
		panel.add(btnNewButton);
		
				
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setForeground(Color.BLACK);
		textArea.setBounds(10, 59, 234, 202);
		textArea.setEditable(false);
		textArea.setText(ninosmalos);
		panel.add(textArea);
		
	    
  		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/home/ldcoma10/workspace/Diego/src/chucky.gif"));
		lblNewLabel_1.setBounds(250, 62, 164, 127);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/ldcoma10/workspace/Diego/src/arboles-de-navidad-fondos-pantalla.jpg"));
		lblNewLabel.setBounds(-69, -126, 693, 542);
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
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(true);
				BadChildren.this.dispose();
			}
		});
		mntmNewMenuItem_1.setForeground(Color.WHITE);
		mntmNewMenuItem_1.setBackground(Color.DARK_GRAY);
		mnNewMenu.add(mntmNewMenuItem_1);
		
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