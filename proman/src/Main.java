import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

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
public class Main extends javax.swing.JFrame {
	private JButton btnCrearProyecto;
	private JButton jButton1;
	private JButton jButton2;
	private JButton btn;
	private JButton jButton4;
	private JButton jButton3;
	private Conexion conexionBD = null;
	private String currentUser;

	public void setCurrentUser(String name){
		currentUser = name;
	}
	
	public String getCurrentUserName(){
		return currentUser;
	}
	
	public String getCurrentUserID(){
		try {
			conexionBD.conectarBD();
			Statement stmt = conexionBD.statement();
			
			String query = "select id_usuario from usuarios where nombre = '" + currentUser + "'";
			
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			
			rs.next();
			String result = rs.getString("id_usuario");
			stmt.close();
			conexionBD.desconectarBD();
			System.out.println(result);
			return (result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main inst = new Main();
				inst.setLocationRelativeTo(null);
				inst.setVisible(false);
			}
		});
		
	}
	
	public Main() {
		super();
		initGUI();
		conexionBD = new Conexion("root", "");
		login frmLogin = new login(this, conexionBD);
		frmLogin.setVisible(true);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Proyect Manager: Main");
			this.setPreferredSize(new java.awt.Dimension(242, 141));
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				btnCrearProyecto = new JButton();
				getContentPane().add(btnCrearProyecto);
				btnCrearProyecto.setText("Administrar Proyecto");
				btnCrearProyecto.setBounds(46, 12, 147, 21);
				btnCrearProyecto.setFont(new java.awt.Font("Arial",0,10));
				btnCrearProyecto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCrearProyectoActionPerformed(evt);
					}
				});
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Administrar Grupos");
				jButton1.setFont(new java.awt.Font("Arial",0,10));
				jButton1.setBounds(46, 45, 147, 21);
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Crear Reporte");
				jButton2.setFont(new java.awt.Font("Arial",0,10));
				jButton2.setBounds(46, 45, 147, 21);
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("Crear Reporte");
				jButton3.setFont(new java.awt.Font("Arial",0,10));
				jButton3.setBounds(46, 45, 147, 21);
			}
			{
				jButton4 = new JButton();
				getContentPane().add(jButton4);
				jButton4.setText("Crear Reporte");
				jButton4.setFont(new java.awt.Font("Arial",0,10));
				jButton4.setBounds(46, 45, 147, 21);
			}
			{
				btn = new JButton();
				getContentPane().add(btn);
				btn.setText("Crear Reporte");
				btn.setBounds(46, 78, 147, 21);
				btn.setFont(new java.awt.Font("Arial",0,10));
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnCrearProyectoActionPerformed(ActionEvent evt) {
		Proyecto frmProyecto = new Proyecto(this, conexionBD);
		this.setVisible(false);
		frmProyecto.setVisible(true);
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		this.dispose();
	}

}
