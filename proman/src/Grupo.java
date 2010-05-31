import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class Grupo extends javax.swing.JFrame {
	private JEditorPane edpDescripcion;
	private JLabel lblGrupos;
	private JList lstGrupos;
	private JTable tblUsuarios;
	private JButton btnEditarRol;
	private JButton btnGuardarGrupo;
	private JButton btnCancel;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JLabel lblGrupo;
	private JLabel lblID;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JButton btnEliminarGrupo;
	private JTextField txtID;
	private JLabel lblDescripcion;

	private Conexion conexionDB;
	private Main frmPrincipal;
	private int currentProjectID;
	private Proyecto frmProyecto;
	
	
	public Grupo(Main parent, Conexion dbConnection) {
		super();
		initGUI();
		
		currentProjectID = -1;
		
		conexionDB   = dbConnection;
		frmPrincipal = parent;
		/*
		 * si fue llamado desde la pantalla main,
		 * tiene que mostrar los grupos asociados a los proyectos de los cuales el usuario es jefe
		 */
		populateList();
	}
	
	public Grupo(Main mainFrame, Proyecto parent, Conexion dbConnection, String proyectID) {
		super();
		initGUI();
		
		currentProjectID = Integer.parseInt(proyectID);
		conexionDB   = dbConnection;
		frmPrincipal = mainFrame;
		
		frmProyecto = parent;
		
		/*
		 * si fue llamado desde la pantalla de proyecto
		 * tiene que mostrar los grupos asociados al proyecto seleccionado en la pantalla de proyecto
		 * */
		populateList();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Proyect Manager: Grupo");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(560, 371));
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				lblDescripcion = new JLabel();
				getContentPane().add(lblDescripcion);
				lblDescripcion.setText("Descripción");
				lblDescripcion.setBounds(12, 68, 74, 14);
				lblDescripcion.setFont(new java.awt.Font("Arial",0,10));
			}
			{

				txtID = new JTextField();
				getContentPane().add(txtID);
				txtID.setBounds(92, 12, 132, 21);
				txtID.setFont(new java.awt.Font("Arial",0,10));
				txtID.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				txtID.setEditable(false);
			}
			{

				lblID = new JLabel();
				getContentPane().add(lblID);
				lblID.setText("ID");
				lblID.setBounds(12, 15, 60, 14);
				lblID.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				lblGrupo = new JLabel();
				getContentPane().add(lblGrupo);
				lblGrupo.setText("Grupo");
				lblGrupo.setBounds(12, 133, 148, 14);
				lblGrupo.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				lblGrupos = new JLabel();
				getContentPane().add(lblGrupos);
				lblGrupos.setText("Grupos");
				lblGrupos.setBounds(381, 15, 71, 14);
				lblGrupos.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				lblNombre = new JLabel();
				getContentPane().add(lblNombre);
				lblNombre.setText("Nombre");
				lblNombre.setBounds(12, 42, 37, 14);
				lblNombre.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				txtNombre = new JTextField();
				getContentPane().add(txtNombre);
				txtNombre.setBounds(92, 38, 132, 21);
				txtNombre.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				txtNombre.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				edpDescripcion = new JEditorPane();
				getContentPane().add(edpDescripcion);
				edpDescripcion.setBounds(92, 66, 277, 58);
				edpDescripcion.setFont(new java.awt.Font("Arial",0,10));
				edpDescripcion.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			}
			{
				btnAgregar = new JButton();
				getContentPane().add(btnAgregar);
				btnAgregar.setText("Agregar");
				btnAgregar.setBounds(287, 159, 82, 21);
				btnAgregar.setFont(new java.awt.Font("Arial",0,10));
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAgregarActionPerformed(evt);
					}
				});
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("Eliminar");
				btnEliminar.setBounds(287, 192, 82, 21);
				btnEliminar.setFont(new java.awt.Font("Arial",0,10));
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnEliminarActionPerformed(evt);
					}
				});
			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("Cancelar");
				btnCancel.setBounds(458, 308, 82, 21);
				btnCancel.setFont(new java.awt.Font("Arial",0,10));
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelActionPerformed(evt);
					}
				});
			}
			{
				btnEditarRol = new JButton();
				getContentPane().add(btnEditarRol);
				btnEditarRol.setText("Editar Rol");
				btnEditarRol.setBounds(287, 225, 82, 21);
				btnEditarRol.setFont(new java.awt.Font("Arial",0,10));
				btnEditarRol.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnEditarRolActionPerformed(evt);
					}
				});
			}
			{
				btnGuardarGrupo = new JButton();
				getContentPane().add(btnGuardarGrupo);
				btnGuardarGrupo.setText("Guardar Grupo");
				btnGuardarGrupo.setBounds(327, 308, 119, 21);
				btnGuardarGrupo.setFont(new java.awt.Font("Arial",0,10));
				btnGuardarGrupo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnGuardarGrupoActionPerformed(evt);
					}
				});
			}
			{
				btnEliminarGrupo = new JButton();
				getContentPane().add(btnEliminarGrupo);
				btnEliminarGrupo.setText("Eliminar Grupo");
				btnEliminarGrupo.setFont(new java.awt.Font("Arial",0,10));
				btnEliminarGrupo.setBounds(194, 308, 121, 21);
				btnEliminarGrupo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnEliminarGrupoActionPerformed(evt);
					}
				});
			}
			{
				TableModel tblUsuariosModel = 
					new uneditableTableModel();
				tblUsuarios = new JTable();
				getContentPane().add(tblUsuarios);
				tblUsuarios.setModel(tblUsuariosModel);
				tblUsuarios.setBounds(12, 159, 263, 137);
				tblUsuarios.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				tblUsuarios.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				ListModel lstGruposModel = 
					new DefaultComboBoxModel(
							new String[] { "Grupo de Programación 1", "Grupo de Programación 2", "--Nuevo Grupo--" });
				lstGrupos = new JList();
				getContentPane().add(lstGrupos);
				lstGrupos.setModel(lstGruposModel);
				lstGrupos.setBounds(381, 39, 159, 257);
				lstGrupos.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				lstGrupos.setFont(new java.awt.Font("Arial",0,10));
				lstGrupos.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent evt) {
						lstGruposValueChanged(evt);
					}
				});
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getSelectedGroupID(){
		if (lstGrupos.getSelectedIndex() != -1){
			String selectedLine = lstGrupos.getModel().getElementAt(lstGrupos.getSelectedIndex()).toString(); 
			return selectedLine.substring(0, selectedLine.indexOf('-'));
		} else return "-1";
	}
	
	private void btnAgregarActionPerformed(ActionEvent evt) {
		String selectedLine = lstGrupos.getModel().getElementAt(lstGrupos.getSelectedIndex()).toString();
		String idGrupo =  selectedLine.substring(0,selectedLine.indexOf('-'));	
		CrearRol crearRol = new CrearRol(this, conexionDB, Integer.parseInt(idGrupo));
		crearRol.setVisible(true);
		this.setVisible(false);
	}
	
	private void btnEliminarActionPerformed(ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(this, "Está seguro de que desea eliminar el usuario del grupo?", "Project Manager - Eliminar Rol", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (result == JOptionPane.YES_OPTION){
			String queryRol = "delete from rol using rol join usuarios where id_usuario = usuario and grupo = " + getSelectedGroupID() + " and nombre = '" + tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0) + "'";
			System.out.println(queryRol);
			
			try {
				conexionDB.conectarBD();
				Statement stmt = conexionDB.statement();
				
				stmt.execute(queryRol);
			
				stmt.close();
				conexionDB.desconectarBD();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			lstGruposValueChanged(null);
		}
	}
	
	private void btnEditarRolActionPerformed(ActionEvent evt) {
		@SuppressWarnings("unused")
		Rol frmRol;
		String selectedLine = lstGrupos.getModel().getElementAt(lstGrupos.getSelectedIndex()).toString();
		String idGrupo =  selectedLine.substring(0,selectedLine.indexOf('-'));		
		frmRol = new Rol(this, conexionDB, Integer.parseInt(idGrupo));
		frmRol.setVisible(true);
		this.setVisible(false);
	}
	
	
	
	private void btnEliminarGrupoActionPerformed(ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(this, "Está seguro de que desea eliminar el grupo?", "Project Manager - Eliminar Grupo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (result == JOptionPane.YES_OPTION){
			String queryRol = "delete from rol where grupo = " + getSelectedGroupID();
			String queryTarea = "delete from tareas where grupo = " + getSelectedGroupID();
			String queryGrupo = "delete from grupos where id_grupo = " + getSelectedGroupID();
			
			try {
				conexionDB.conectarBD();
				Statement stmt = conexionDB.statement();
				
				stmt.execute(queryRol);
				stmt.execute(queryTarea);
				stmt.execute(queryGrupo);
				
				stmt.close();
				conexionDB.desconectarBD();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			populateList();
		}
	}
	
	private void populateList(){
		if (currentProjectID == (-1)){
			//si vinimos de Main
			Statement stmt;
			String    query, currentUID;
			ResultSet rs;
			String[]  stringArr;
			int cantResults, i; 
			try {
				currentUID = frmPrincipal.getCurrentUserID();
				conexionDB.conectarBD();
				stmt  = conexionDB.statement();			
				query = "select distinct id_grupo, grupos.descripcion, grupos.nombre from grupos join proyectos where ((id_proyecto = proyecto) and (jefe = " + currentUID + ")) or (proyecto is null)";
				System.out.println(query);
				rs    = stmt.executeQuery(query);
				rs.last();
				cantResults = rs.getRow();
				rs.beforeFirst();
				i = 0;
				stringArr = new String[cantResults + 1];
				for(i = 0; i < cantResults; i++) {
					rs.next();
					stringArr[i] = rs.getString("id_grupo") + "-" + rs.getString("nombre");
					System.out.println("Cargando "+stringArr[i]);
				}
				stringArr[i] = "0-CREAR NUEVO GRUPO"; 
				lstGrupos.setModel(new DefaultComboBoxModel(stringArr));
				lstGrupos.setSelectedIndex(0);
				stmt.close();
				conexionDB.desconectarBD();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			lstGrupos.setSelectedIndex(0);
		} else {
			//si vinimos de Proyecto
			Statement stmt;
			String    query;
			ResultSet rs;
			String[]  stringArr;
			int cantResults, i; 
			try {
				String currentUID = frmPrincipal.getCurrentUserID();
				conexionDB.conectarBD();			
				stmt  = conexionDB.statement();			
				query = "select distinct id_grupo, grupos.descripcion, grupos.nombre from grupos join proyectos where ((id_proyecto = proyecto) and (jefe = " + currentUID + ")) and proyecto = " + currentProjectID;
				rs    = stmt.executeQuery(query);
				rs.last();
				cantResults = rs.getRow();
				rs.beforeFirst();
				i = 0;
				stringArr = new String[cantResults + 1];
				for(i = 0; i < cantResults; i++) {
					rs.next();
					stringArr[i] = rs.getString("id_grupo") + "-" + rs.getString("nombre");
				}
				stringArr[i] = "0-CREAR NUEVO GRUPO"; 
				lstGrupos.setModel(new DefaultComboBoxModel(stringArr));
				lstGrupos.setSelectedIndex(0);
				stmt.close();
				conexionDB.desconectarBD();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			lstGrupos.setSelectedIndex(0);
		}
		
	}
	
	public void refreshRoles(){
		lstGruposValueChanged(null);
	}
	
	private void btnGuardarGrupoActionPerformed(ActionEvent evt) {
		String selectedLine = lstGrupos.getModel().getElementAt(lstGrupos.getSelectedIndex()).toString();
		String idGrupo =  selectedLine.substring(0,selectedLine.indexOf('-'));
		String nombreGrupo = selectedLine.substring(selectedLine.indexOf('-')+1);
		
		if(idGrupo.equals("0")){
			//alta
			String query;
			if(currentProjectID == (-1)){
				query = "insert into grupos (nombre, descripcion) values ('" + txtNombre.getText() + "', '" + edpDescripcion.getText() + "')";
			} else {
				query = "insert into grupos (nombre, descripcion, proyecto) values ('" + txtNombre.getText() + "', '" + edpDescripcion.getText() + "', " + currentProjectID + ")";
			}
			
			System.out.println(query);
			try {
				conexionDB.conectarBD();
				Statement stmt = conexionDB.statement();
				
				stmt.execute(query);
				
				stmt.close();
				conexionDB.desconectarBD();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			//modificación
			String query = "update grupos set nombre = '" + txtNombre.getText() + "', descripcion = '" + edpDescripcion.getText() + "' where id_grupo = " + idGrupo;
			try {
				conexionDB.conectarBD();
				Statement stmt = conexionDB.statement();
				
				stmt.execute(query);
				
				stmt.close();
				conexionDB.desconectarBD();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		populateList();
	}
	
	private void btnCancelActionPerformed(ActionEvent evt) {
		if (currentProjectID == (-1)){
			System.out.println("Me voy a main");
			frmPrincipal.setVisible(true);
		} else {
			System.out.println("¬ me voy a main");
			frmProyecto.setVisible(true);
		}
		this.dispose();
	}
	
	private void setUserControls(boolean enable){
		btnAgregar.setEnabled(enable);
		btnEliminar.setEnabled(enable);
		btnEditarRol.setEnabled(enable);
		btnEliminarGrupo.setEnabled(enable);
	}
	
	private void lstGruposValueChanged(ListSelectionEvent evt) {		
		if (lstGrupos.getSelectedIndex() != (-1)){
			String selectedLine = lstGrupos.getModel().getElementAt(lstGrupos.getSelectedIndex()).toString();
			String idGrupo =  selectedLine.substring(0,selectedLine.indexOf('-'));
			String nombreGrupo = selectedLine.substring(selectedLine.indexOf('-')+1);
			
			if (idGrupo.equals("0")){
				setUserControls(false);
				edpDescripcion.setText("");
				txtID.setText("");
				txtNombre.setText("Nuevo grupo");
				tblUsuarios.setModel(new uneditableTableModel());
			} else {
				setUserControls(true);
				String query = "select descripcion from grupos where id_grupo = " + idGrupo;
				
				try {
					conexionDB.conectarBD();
					Statement stmt = conexionDB.statement();
					
					ResultSet rs = stmt.executeQuery(query);
					
					if(rs.next()){
						edpDescripcion.setText(rs.getString("descripcion"));
						txtID.setText(idGrupo);
						txtNombre.setText(nombreGrupo);
						rs.close();
						
						String queryUsuarios = "select nombre, descripcion from rol join usuarios where grupo = " + idGrupo + " and usuario = id_usuario";
						ResultSet rsUsuarios = stmt.executeQuery(queryUsuarios);
						
						uneditableTableModel tableModel = new uneditableTableModel();
						tableModel.addColumn("Nombre");
						tableModel.addColumn("Rol");
						while (rsUsuarios.next()){
							String[] rowData = { rsUsuarios.getString("nombre"), rsUsuarios.getString("descripcion") };
							tableModel.addRow(rowData);
						}
						
						rsUsuarios.close();
						
						tblUsuarios.setModel(tableModel);					
					}
					
					conexionDB.desconectarBD();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		if (currentProjectID == (-1)){
			frmPrincipal.setVisible(true);
		} else {
			frmProyecto.setVisible(true);
		}
		this.dispose();
	}

}
