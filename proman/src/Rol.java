import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
public class Rol extends javax.swing.JFrame {
	private JList lstUsuarios;
	private JLabel lblUsuarios;
	private JLabel lblDescripción;
	private JEditorPane edpDescripción;
	private JButton btnOk;
	private JButton btnCancel;
	private Conexion conexionBD;
	private Grupo frmGrupo;
	private int idGrupo;
	private ResultSet rs;
	Statement stmt;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		/*SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Rol inst = new Rol(null,null,1);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});*/
		Main.main(null);
	}
	
	public Rol(Grupo parent, Conexion conexion, int idGrupo) {
		super();
		initGUI();
		conexionBD = conexion;
		frmGrupo = parent;
		this.idGrupo = idGrupo;
		//frmGrupo.SetVisible(false);
		populateList();
	}
	
	
	public void populateList(){
		try {
			conexionBD.conectarBD();			
			stmt = conexionBD.statement();			
			String query = "select * from rol join usuarios where grupo = " + idGrupo + " and usuario = id_usuario";
			
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
			lstUsuarios.setModel(model);
			//lstProyectos.setModel(model);
			lstUsuarios.setSelectedIndex(0);
			//lstProyectos.setSelectedIndex(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Proyect Manager: Rol");
			this.setPreferredSize(new java.awt.Dimension(400, 260));
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				ListModel lstUsuariosModel = 
					new DefaultComboBoxModel(
							new String[] {});
				lstUsuarios = new JList();
				getContentPane().add(lstUsuarios);
				lstUsuarios.setModel(lstUsuariosModel);
				lstUsuarios.setBounds(12, 32, 130, 153);
				lstUsuarios.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				lstUsuarios.setFont(new java.awt.Font("Arial",0,10));
				lstUsuarios.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent evt) {
						lstUsuariosValueChanged(evt);
					}
				});
			}
			{
				lblUsuarios = new JLabel();
				getContentPane().add(lblUsuarios);
				lblUsuarios.setText("Usuarios");
				lblUsuarios.setBounds(12, 12, 41, 14);
				lblUsuarios.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				lblDescripción = new JLabel();
				getContentPane().add(lblDescripción);
				lblDescripción.setText("Descripción");
				lblDescripción.setBounds(165, 12, 88, 14);
				lblDescripción.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				edpDescripción = new JEditorPane();
				getContentPane().add(edpDescripción);
				edpDescripción.setBounds(165, 32, 215, 153);
				edpDescripción.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				edpDescripción.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				btnOk = new JButton();
				getContentPane().add(btnOk);
				btnOk.setText("Guardar");
				btnOk.setBounds(210, 197, 81, 21);
				btnOk.setFont(new java.awt.Font("Arial",0,10));
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnOkActionPerformed(evt);
					}
				});
			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("Volver");
				btnCancel.setBounds(303, 197, 77, 21);
				btnCancel.setFont(new java.awt.Font("Arial",0,10));
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(400, 260);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void lstUsuariosValueChanged(ListSelectionEvent evt) {
		try{
			//System.out.println("lstUsuarios.valueChanged, event="+evt);
			//TODO add your code for lstUsuarios.valueChanged
			int i = 0;
			rs.first();
			for(i=0;i<lstUsuarios.getSelectedIndex();i++){
				rs.next();
			}
			
			//System.out.println(rs.getString("descripcion"));
			edpDescripción.setText(rs.getString("descripcion"));
		}catch(SQLException e) {
			e.printStackTrace();		
			
		}
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		System.out.println("this.windowClosing, event="+evt);
		//TODO add your code for this.windowClosing
		close();
	}

	private void close(){
		try{
			stmt.close();
			conexionBD.desconectarBD();
			frmGrupo.setVisible(true);
			frmGrupo.refreshRoles();
			this.dispose();
		}catch(SQLException e) {
			e.printStackTrace();		
			
		}	
	}
	
	private void btnOkActionPerformed(ActionEvent evt) {
		try {
			String query = "update rol set descripcion = '" + edpDescripción.getText() + "' where usuario = " + rs.getString("id_usuario") + " and grupo = " + idGrupo;
			stmt.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();		
			
		}
		populateList();
	}
	
	private void btnCancelActionPerformed(ActionEvent evt) {
		close();
	}

}
