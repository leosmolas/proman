import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

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
public class CrearRol extends javax.swing.JFrame {
	private JComboBox cmbUsuarios;
	private JButton btnCancel;
	private JButton btnOk;
	private JEditorPane edpDescripcion;
	private Conexion conexionBD;
	private JFrame frame;
	private ResultSet rs;
	private int idGrupo;
	Statement stmt;

	public CrearRol(JFrame parent, Conexion conn, int grupo) {
		super();
		initGUI();
		conexionBD = conn;
		frame = parent;
		idGrupo = grupo;
		populateList();
	}
	
	
	private void populateList(){
		try {
			conexionBD.conectarBD();			
			stmt = conexionBD.statement();			
			String query = "select id_usuario,nombre from usuarios as t1 left join (select usuario from rol where grupo = " + idGrupo + ") as t2 ON usuario=id_usuario WHERE usuario is null;";
			
			rs = stmt.executeQuery(query);
			
			rs.last();
			int cantResults = rs.getRow();
			rs.beforeFirst();
			int i=0;
			DefaultComboBoxModel model = new DefaultComboBoxModel();
			for(i=0;i<cantResults;i++){
				rs.next();
				model.addElement(rs.getString("nombre"));
				//System.out.println(stringArr[i]);
			}
			
			//model.addElement("0-CREAR NUEVO PROYECTO"); 
			
			//stmt.close();
			//conexionBD.desconectarBD();
			cmbUsuarios.setModel(model);
			//lstProyectos.setModel(model);
			cmbUsuarios.setSelectedIndex(0);
			//lstProyectos.setSelectedIndex(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(259, 240));
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				ComboBoxModel cmbUsuariosModel = 
					new DefaultComboBoxModel(
							new String[] {});
				cmbUsuarios = new JComboBox();
				getContentPane().add(cmbUsuarios);
				cmbUsuarios.setModel(cmbUsuariosModel);
				cmbUsuarios.setBounds(12, 12, 219, 23);
				cmbUsuarios.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				edpDescripcion = new JEditorPane();
				getContentPane().add(edpDescripcion);
				edpDescripcion.setBounds(12, 47, 219, 108);
				edpDescripcion.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				btnOk = new JButton();
				getContentPane().add(btnOk);
				btnOk.setText("Guardar");
				btnOk.setBounds(12, 167, 81, 23);
				btnOk.setFont(new java.awt.Font("Arial",0,10));
				btnOk.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						btnOkMouseClicked(evt);
					}
				});
			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("Volver");
				btnCancel.setBounds(144, 167, 87, 23);
				btnCancel.setFont(new java.awt.Font("Arial",0,10));
				btnCancel.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						btnCancelMouseClicked(evt);
					}
				});
			}
			pack();
			this.setSize(259, 240);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnOkMouseClicked(MouseEvent evt) {
		//System.out.println("btnOk.mouseClicked, event="+evt);
		//TODO add your code for btnOk.mouseClicked
		try{
			int i = 0;
			rs.first();
			for(i=0;i<cmbUsuarios.getSelectedIndex();i++){
				rs.next();
			}
			String query = "insert into rol (usuario, grupo, descripcion) values (" + rs.getString("id_usuario") + "," + idGrupo + ",'" + edpDescripcion.getText() + "')";
			
			System.out.println(query);
			
			stmt.executeUpdate(query);
			
			populateList();
			edpDescripcion.setText("");
		}catch(SQLException e) {
			e.printStackTrace();		
			
		}	
	}
	
	private void btnCancelMouseClicked(MouseEvent evt) {
		//System.out.println("btnCancel.mouseClicked, event="+evt);
		//TODO add your code for btnCancel.mouseClicked
		close();
	}

	private void close(){
		try{
			stmt.close();
			conexionBD.desconectarBD();
			frame.setVisible(true);
			this.dispose();
		}catch(SQLException e) {
			e.printStackTrace();		
			
		}	
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		//System.out.println("this.windowClosing, event="+evt);
		//TODO add your code for this.windowClosing
		//close();
	}
}
