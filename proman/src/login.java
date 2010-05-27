import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class login extends javax.swing.JFrame {
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblUsuario;
	private JPasswordField txtContraseña;
	private JLabel lblContraseña;
	private JTextField txtUsuario;
	private Main mainFrm;
	
	private Conexion conexionDB;

	/**
	* Auto-generated main method to display this JFrame
	*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				login inst = new login(null, null);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	*/
	
	public login(Main parent, Conexion dbConnection) {
		super();
		initGUI();
		
		mainFrm = parent;
		conexionDB = dbConnection;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Proyect Manager: Login");
			this.setPreferredSize(new java.awt.Dimension(272, 125));
			this.setAlwaysOnTop(true);
			this.setResizable(false);
			this.addWindowListener(new WindowAdapter() {
				public void windowIconified(WindowEvent evt) {
					thisWindowIconified(evt);
				}
			});
			{
				btnAceptar = new JButton();
				getContentPane().add(btnAceptar);
				btnAceptar.setText("Aceptar");
				btnAceptar.setBounds(12, 62, 109, 21);
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAceptarActionPerformed(evt);
					}
				});
			}
			{
				btnCancelar = new JButton();
				getContentPane().add(btnCancelar);
				btnCancelar.setText("Cancelar");
				btnCancelar.setBounds(133, 62, 109, 21);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelarActionPerformed(evt);
					}
				});
			}
			{
				txtUsuario = new JTextField();
				getContentPane().add(txtUsuario);
				txtUsuario.setBounds(79, 9, 163, 21);
			}
			{
				lblUsuario = new JLabel();
				getContentPane().add(lblUsuario);
				lblUsuario.setText("Usuario");
				lblUsuario.setBounds(12, 12, 61, 14);
				lblUsuario.setFont(new java.awt.Font("Arial",0,11));
			}
			{
				lblContraseña = new JLabel();
				getContentPane().add(lblContraseña);
				lblContraseña.setText("Contraseña");
				lblContraseña.setBounds(12, 38, 56, 14);
				lblContraseña.setFont(new java.awt.Font("Arial",0,11));
			}
			{
				txtContraseña = new JPasswordField();
				getContentPane().add(txtContraseña);
				txtContraseña.setBounds(80, 35, 162, 21);
			}
			pack();
			this.setSize(272, 125);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnAceptarActionPerformed(ActionEvent evt) {
		if (txtUsuario.getText().equals("") || txtContraseña.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Ingrese nombre de usuario y password!", "Error al ingresar al sistema", JOptionPane.ERROR_MESSAGE);
		}else{
			try {
				conexionDB.conectarBD();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Statement stmt = conexionDB.statement();
			
			String query = "select * from usuarios where nombre = '" + txtUsuario.getText() + "' and password = '" + txtContraseña.getText() + "'";
			
			System.out.println(query);
	        try {
				ResultSet rs = stmt.executeQuery(query);
		        //si el usuario existe y el password matchea
		        if (rs.next()){
		        	System.out.println("Usuario logeado");
		        	mainFrm.setCurrentUser(txtUsuario.getText());
		        	mainFrm.setVisible(true);
		        	this.dispose();
		        }else{
		        	JOptionPane.showMessageDialog(this, "El nombre de usuario o el password es incorrecto.", "Error al ingresar al sistema", JOptionPane.ERROR_MESSAGE);
		        	txtUsuario.setText("");
		        	txtContraseña.setText("");
		        }
		        
				stmt.close();
				conexionDB.desconectarBD();
				
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private void btnCancelarActionPerformed(ActionEvent evt) {
		System.out.println("btnCancelar.actionPerformed, event="+evt);
		this.dispose();
	}
	
	private void thisWindowIconified(WindowEvent evt) {
		System.out.println("this.windowIconified, event="+evt);
		//TODO add your code for this.windowIconified
	}

}
