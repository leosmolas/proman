import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

import javax.swing.JOptionPane;
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
	private JButton btnAdminProyecto;
	private JButton btnAdminGrupos;
	private JButton btnCrearReporte;
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
				btnAdminProyecto = new JButton();
				getContentPane().add(btnAdminProyecto);
				btnAdminProyecto.setText("Administrar Proyecto");
				btnAdminProyecto.setBounds(46, 12, 147, 21);
				btnAdminProyecto.setFont(new java.awt.Font("Arial",0,10));
				btnAdminProyecto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAdminProyectoActionPerformed(evt);
					}
				});
			}
			{
				btnAdminGrupos = new JButton();
				getContentPane().add(btnAdminGrupos);
				btnAdminGrupos.setText("Administrar Grupos");
				btnAdminGrupos.setFont(new java.awt.Font("Arial",0,10));
				btnAdminGrupos.setBounds(46, 45, 147, 21);
				btnAdminGrupos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAdminGruposActionPerformed(evt);
					}
				});
			}
			{
				btnCrearReporte = new JButton();
				getContentPane().add(btnCrearReporte);
				btnCrearReporte.setText("Crear Reporte");
				btnCrearReporte.setBounds(46, 78, 147, 21);
				btnCrearReporte.setFont(new java.awt.Font("Arial",0,10));
				btnCrearReporte.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCrearReporteActionPerformed(evt);
					}
				});
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnAdminProyectoActionPerformed(ActionEvent evt) {
		Proyecto frmProyecto = new Proyecto(this, conexionBD);
		this.setVisible(false);
		frmProyecto.setVisible(true);
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		this.dispose();
	}
	
	private void btnAdminGruposActionPerformed(ActionEvent evt) {
		Grupo frmGrupo= new Grupo(this, conexionBD);
		this.setVisible(false);
		frmGrupo.setVisible(true);
	}
	
	private void btnCrearReporteActionPerformed(ActionEvent evt) {
		String esAdmin;
		try {
			conexionBD.conectarBD();
			
			
			String query = "select esAdmin from usuarios where id_usuario = " + getCurrentUserID() ;
			
			System.out.println(query);
			Statement stmt = conexionBD.statement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			rs.next();
			esAdmin = rs.getString("esAdmin");
			stmt.close();
			conexionBD.desconectarBD();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		if (esAdmin.equals("1")) {
			Reporte frmReporte = new Reporte(this, conexionBD);
			this.setVisible(false);
			frmReporte.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(this, "No tiene los permisos para realizar esta tarea.", "¡Cuidado!", JOptionPane.WARNING_MESSAGE);
		}
		
	}

}
