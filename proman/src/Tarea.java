import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
public class Tarea extends javax.swing.JFrame {
	private JButton btnEliminar;
	private JLabel lblTareas;
	private JList lstTarea;
	private JLabel lblFechaDeInicio;
	private JComboBox cbxFinAño;
	private JComboBox cbxInicioAño;
	private JComboBox cbxInicioMes;
	private JComboBox cbxInicioDia;
	private JEditorPane edpDescripcion;
	private JLabel lblDescripcion;
	private JLabel lblID;
	private JTextField txtID;
	private JButton btnCancel;
	private JButton btnOk;
	private JLabel lblFechaFin;
	private JComboBox cbxFinDia;
	private JComboBox cbxFinMes;
	private JComboBox cbxGrupos;
	
	private JFrame frmParent;
	private Conexion conexionDB;
	private String idProyecto;
	private String inicioProy;
	private String finProy;
	
	public Tarea(JFrame parent,Conexion dbConnection,String proy,String id) {
		super();
		initGUI();
		
		conexionDB = dbConnection;
		frmParent = parent;
		idProyecto = id;
		populateGroups();
		populateList();
		try {
			conexionDB.conectarBD();			
			Statement stmt = conexionDB.statement();			
			String query = "select fecha_inicio,fecha_fin from proyectos where id_proyecto = "+idProyecto;
			
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			inicioProy = rs.getString("fecha_inicio");
			finProy = rs.getString("fecha_fin");
			stmt.close();
			conexionDB.desconectarBD();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.setTitle("Project Manager: Tareas del Proyecto " + proy);
	}
	
	private void populateGroups() {
		int cantResults,i;
		try {
			conexionDB.conectarBD();			
			Statement stmt = conexionDB.statement();			
			String query = "select id_grupo, descripcion from grupos where proyecto = "+idProyecto;
			
			ResultSet rs = stmt.executeQuery(query);
			
			rs.last();
			cantResults = rs.getRow();
			rs.beforeFirst();
			i=0;
			String[] stringArr = new String[cantResults+1];
			for(i=0;i<cantResults;i++){
				rs.next();
				stringArr[i] = rs.getString("id_grupo") + "-"+ rs.getString("descripcion");
			}
			stringArr[i] = "0-TODOS LOS GRUPOS";
			cbxGrupos.setModel(new DefaultComboBoxModel(stringArr));

			cbxGrupos.setSelectedIndex(0);
			stmt.close();
			conexionDB.desconectarBD();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void populateList() {
		int cantResults,i;
		String[] stringArr;
		try {
			conexionDB.conectarBD();			
			Statement stmt = conexionDB.statement();
			String idGrupo = getID(cbxGrupos.getSelectedItem()+"");
			String query = "select id_tarea, descripcion from tareas where proyecto = " + idProyecto;			
			if (!idGrupo.equals("0")) 
				query += " and grupo = " + idGrupo;

			ResultSet rs = stmt.executeQuery(query);			
			rs.last();
			cantResults = rs.getRow();
			stringArr = new String[cantResults+((idGrupo.equals("0"))?0:1)];
			rs.beforeFirst();
			for(i=0;i<cantResults;i++){
				rs.next();
				stringArr[i] = rs.getString("id_tarea") + "-"+ rs.getString("descripcion");
			}			
			if (!idGrupo.equals("0")) 
				stringArr[i] = "0-CREAR NUEVA TAREA PARA ESTE GRUPO";
			lstTarea.setModel(new DefaultComboBoxModel(stringArr));
			lstTarea.setSelectedIndex(0);
			stmt.close();
			conexionDB.desconectarBD();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String getID(String selectedItem) {
		return selectedItem.substring(0,selectedItem.indexOf('-'));
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			String [] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}; 
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("Eliminar Tarea");
				btnEliminar.setFont(new java.awt.Font("Arial",0,10));
				btnEliminar.setBounds(216, 194, 122, 21);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnEliminarActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel cbxGruposModel = 
					new DefaultComboBoxModel();
				cbxGrupos = new JComboBox();
				getContentPane().add(cbxGrupos);
				cbxGrupos.setModel(cbxGruposModel);
				cbxGrupos.setFont(new java.awt.Font("Arial",0,10));
				cbxGrupos.setBounds(312, 41, 242, 21);
				cbxGrupos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cbxGruposActionPerformed(evt);
					}
				});
			}
			{
				lblTareas = new JLabel();
				getContentPane().add(lblTareas);
				lblTareas.setText("Tareas");
				lblTareas.setFont(new java.awt.Font("Arial",0,10));
				lblTareas.setPreferredSize(new java.awt.Dimension(67,14));
				lblTareas.setBounds(312, 15, 67, 14);
			}
			{
				ListModel lstTareaModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				lstTarea = new JList();
				getContentPane().add(lstTarea);
				lstTarea.setModel(lstTareaModel);
				lstTarea.setFont(new java.awt.Font("Arial",0,10));
				lstTarea.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				lstTarea.setBounds(312, 68, 242, 105);
				lstTarea.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent evt) {
						lstTareaValueChanged(evt);
					}
				});
			}
			{
				txtID = new JTextField();
				getContentPane().add(txtID);
				txtID.setPreferredSize(new java.awt.Dimension(132,21));
				txtID.setBounds(114, 12, 132, 21);
				txtID.setFont(new java.awt.Font("Arial",0,10));
				txtID.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				txtID.setEditable(false);

			}
			{
				lblID = new JLabel();
				getContentPane().add(lblID);
				lblID.setText("ID");
				lblID.setFont(new java.awt.Font("Arial",0,10));
				lblID.setPreferredSize(new java.awt.Dimension(34,14));
				lblID.setBounds(12, 15, 34, 14);
			}
			{
				lblDescripcion = new JLabel();
				getContentPane().add(lblDescripcion);
				lblDescripcion.setText("Descripción");
				lblDescripcion.setFont(new java.awt.Font("Arial",0,10));
				lblDescripcion.setPreferredSize(new java.awt.Dimension(90,14));
				lblDescripcion.setBounds(12, 41, 90, 14);
			}
			{
				edpDescripcion = new JEditorPane();
				getContentPane().add(edpDescripcion);
				edpDescripcion.setPreferredSize(new java.awt.Dimension(186,85));
				edpDescripcion.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				edpDescripcion.setBounds(114, 39, 186, 85);
			}
			{
				ComboBoxModel cbxInicioDiaModel = 
					new DefaultComboBoxModel();
				cbxInicioDia = new JComboBox();
				getContentPane().add(cbxInicioDia);
				cbxInicioDia.setModel(cbxInicioDiaModel);
				cbxInicioDia.setFont(new java.awt.Font("Arial",0,10));
				cbxInicioDia.setPreferredSize(new java.awt.Dimension(49,21));
				cbxInicioDia.setBounds(112, 130, 49, 21);
			}
			{
				lblFechaDeInicio = new JLabel();
				getContentPane().add(lblFechaDeInicio);
				lblFechaDeInicio.setText("Fecha de Inicio");
				lblFechaDeInicio.setFont(new java.awt.Font("Arial",0,10));
				lblFechaDeInicio.setPreferredSize(new java.awt.Dimension(88,14));
				lblFechaDeInicio.setBounds(12, 133, 88, 14);
			}
			{
				ComboBoxModel cbxInicioMesModel = 
					new DefaultComboBoxModel(meses);
				cbxInicioMes = new JComboBox();
				getContentPane().add(cbxInicioMes);
				cbxInicioMes.setModel(cbxInicioMesModel);
				cbxInicioMes.setFont(new java.awt.Font("Arial",0,10));
				cbxInicioMes.setPreferredSize(new java.awt.Dimension(61,21));
				cbxInicioMes.setBounds(173, 130, 61, 21);
				cbxInicioMes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cbxInicioActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel cbxInicioAñoModel = 
					new DefaultComboBoxModel(Utils.anios());
				cbxInicioAño = new JComboBox();
				getContentPane().add(cbxInicioAño);
				cbxInicioAño.setModel(cbxInicioAñoModel);
				cbxInicioAño.setFont(new java.awt.Font("Arial",0,10));
				cbxInicioAño.setPreferredSize(new java.awt.Dimension(54,21));
				cbxInicioAño.setBounds(246, 130, 54, 21);
				cbxInicioAño.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cbxInicioActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel cbxFinAñoModel = 
					new DefaultComboBoxModel(Utils.anios());
				cbxFinAño = new JComboBox();
				getContentPane().add(cbxFinAño);
				cbxFinAño.setModel(cbxFinAñoModel);
				cbxFinAño.setFont(new java.awt.Font("Arial",0,10));
				cbxFinAño.setPreferredSize(new java.awt.Dimension(54,21));
				cbxFinAño.setBounds(246, 156, 54, 21);
				cbxFinAño.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cbxFinActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel cbxFinMesModel = 
					new DefaultComboBoxModel(meses);
				cbxFinMes = new JComboBox();
				getContentPane().add(cbxFinMes);
				cbxFinMes.setModel(cbxFinMesModel);
				cbxFinMes.setFont(new java.awt.Font("Arial",0,10));
				cbxFinMes.setPreferredSize(new java.awt.Dimension(61,21));
				cbxFinMes.setBounds(173, 156, 61, 21);
				cbxFinMes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cbxFinActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel cbxFinDiaModel = 
					new DefaultComboBoxModel();
				cbxFinDia = new JComboBox();
				getContentPane().add(cbxFinDia);
				cbxFinDia.setModel(cbxFinDiaModel);
				cbxFinDia.setFont(new java.awt.Font("Arial",0,10));
				cbxFinDia.setPreferredSize(new java.awt.Dimension(49,21));
				cbxFinDia.setBounds(112, 156, 49, 21);
			}
			{
				lblFechaFin = new JLabel();
				getContentPane().add(lblFechaFin);
				lblFechaFin.setText("Fecha de Fin");
				lblFechaFin.setFont(new java.awt.Font("Arial",0,10));
				lblFechaFin.setPreferredSize(new java.awt.Dimension(94,14));
				lblFechaFin.setBounds(12, 159, 94, 14);
			}
			{
				btnOk = new JButton();
				getContentPane().add(btnOk);
				btnOk.setText("Guardar Tarea");
				btnOk.setFont(new java.awt.Font("Arial",0,10));
				btnOk.setBounds(350, 194, 121, 21);
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnOkActionPerformed(evt);
					}
				});
			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("Cancelar");
				btnCancel.setFont(new java.awt.Font("Arial",0,10));
				btnCancel.setBounds(477, 194, 77, 21);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancelActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(574, 266);
			Utils.updateDias(cbxInicioDia,cbxInicioMes,cbxInicioAño);
			Utils.updateDias(cbxFinDia,cbxFinMes,cbxFinAño);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cbxGruposActionPerformed(ActionEvent evt) {
		boolean enable = !getID(cbxGrupos.getSelectedItem().toString()).equals("0");

		populateList();
		setButtons();
	}
	
	private void setButtons() {
		boolean allGrupos = getID(cbxGrupos.getSelectedItem().toString()).equals("0");
		boolean newTarea = false;
		if (lstTarea.getSelectedIndices().length>0) {
			 newTarea = getID(lstTarea.getSelectedValue().toString()).equals("0");
		}		
		btnOk.setEnabled(newTarea || !allGrupos);
		btnEliminar.setEnabled((!newTarea && !allGrupos)||(allGrupos && lstTarea.getSelectedIndices().length>0));		
	}

	private void thisWindowClosed(WindowEvent evt) {
		frmParent.setVisible(true);
	}
	
	private void btnCancelActionPerformed(ActionEvent evt) {
		frmParent.setVisible(true);
		this.dispose();
	}
	
	private void lstTareaValueChanged(ListSelectionEvent evt) {
		String evID;
		
		if (lstTarea.getSelectedIndices().length>0) {

			evID   = getID(lstTarea.getSelectedValue().toString());
	
			if (evID.equals("0")){
				//si seleccionó para crear una nueva tarea
				cleanForm();				
			} else {
				try {
					conexionDB.conectarBD();
					Statement stmt = conexionDB.statement();
					
					String query = "select descripcion, fecha_inicio, fecha_fin, descripcion from tareas where id_tarea = " + evID;
					ResultSet rs = stmt.executeQuery(query);
					
					if(rs.next()){
						txtID.setText(evID);						
						edpDescripcion.setText(rs.getString("descripcion"));
						Utils.setDate(rs.getString("fecha_inicio"), cbxInicioDia, cbxInicioMes, cbxInicioAño);
						Utils.setDate(rs.getString("fecha_fin"), cbxFinDia, cbxFinMes, cbxFinAño);						
					}else{
						cleanForm();
					}
					rs.close();
					conexionDB.desconectarBD();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		setButtons();
	}

	private void cleanForm() {
		Utils.setDate(Utils.getCurrentDate(), cbxInicioDia, cbxInicioMes, cbxInicioAño);
		Utils.setDate(Utils.getCurrentDate(), cbxFinDia, cbxFinMes, cbxFinAño);
		edpDescripcion.setText("");
		txtID.setText("");
	}

	private void cbxInicioActionPerformed(ActionEvent evt) {
		Utils.updateDias(cbxInicioDia,cbxInicioMes,cbxInicioAño);
	}
	
	private void cbxFinActionPerformed(ActionEvent evt) {
		Utils.updateDias(cbxFinDia,cbxFinMes,cbxFinAño);
	}
	
	private void btnEliminarActionPerformed(ActionEvent evt) {
		String tareaID = getID(lstTarea.getSelectedValue().toString());
		
		int ok;
		if (tareaID.equals("0")) {
			JOptionPane.showMessageDialog(this, "No ha seleccionado ningún evento para eliminar!.", "¡Cuidado!", JOptionPane.WARNING_MESSAGE);
		}
		else {
			ok = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el evento?", "Project Manager", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (ok == JOptionPane.OK_OPTION) {
				try {
					conexionDB.conectarBD();
					Statement stmt = conexionDB.statement();
					String query = "DELETE FROM tareas WHERE id_tarea = " + tareaID;
					System.out.println("delete: " + query);
					stmt.executeUpdate(query);
					stmt.close();
					conexionDB.desconectarBD();
					populateList();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void btnOkActionPerformed(ActionEvent evt) {
		String fechaInicio = Utils.makeDate(cbxInicioDia,cbxInicioMes,cbxInicioAño);
		String fechaFin = Utils.makeDate(cbxFinDia,cbxFinMes,cbxFinAño);
		String tareaID = getID(lstTarea.getSelectedValue().toString());
		int ok;
		
		if (tareaID.equals("0")){
			//estamos creando un proyecto nuevo
			try {					
				if (inicioProy.compareTo(fechaInicio) <= 0){
					if (fechaInicio.compareTo(fechaFin) <= 0) {
						if (fechaFin.compareTo(finProy) <= 0) {
							//System.out.println("Fechita re ok");
							ok = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea crear la tarea?", "Project Manager", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (ok == JOptionPane.OK_OPTION) {
								conexionDB.conectarBD();
								Statement stmt = conexionDB.statement();
								String query = "insert into tareas (descripcion, fecha_inicio, fecha_fin, grupo, proyecto) values ("+
									"'" + edpDescripcion.getText() + "'," +
									"'" + Utils.makeDate(cbxInicioDia, cbxInicioMes, cbxInicioAño) + "'," + 
									"'" + Utils.makeDate(cbxFinDia, cbxFinMes, cbxFinAño) + "'," + 
									getID(cbxGrupos.getSelectedItem().toString()) + "," + 
									idProyecto + ")";
								System.out.println("query: " + query);
								stmt.executeUpdate(query);
								stmt.close();
								conexionDB.desconectarBD();
							}
						}
						else {
							JOptionPane.showMessageDialog(this, "La fecha de fin de la tarea no puede ser posterior al fin del proyecto	.", "Error: fecha inválida", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(this, "La fecha de inicio de la tarea no puede ser posterior al fin de la tarea", "Error: fecha inválida", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(this, "La fecha de inicio de la tarea no puede ser anterior al comienzo del proyecto	.", "Error: fecha inválida", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		else{
			try {
				if (inicioProy.compareTo(fechaInicio) <= 0){
					if (fechaInicio.compareTo(fechaFin) <= 0) {
						if (fechaFin.compareTo(finProy) <= 0) {
							//System.out.println("Fechita re ok");
							ok = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea modificar tarea?", "Project Manager", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (ok == JOptionPane.OK_OPTION) {
								conexionDB.conectarBD();
								Statement stmt = conexionDB.statement();
								String query ="update tareas set "+ 
									"descripcion = '" + edpDescripcion.getText() + "', " +
									"fecha_inicio = '" + Utils.makeDate(cbxInicioDia, cbxInicioMes, cbxInicioAño) + "', " +
									"fecha_fin = '" + Utils.makeDate(cbxFinDia, cbxFinMes, cbxFinAño) + "'" +
									" where id_tarea = " + tareaID;
								System.out.println("query: " + query);
								stmt.executeUpdate(query);
								stmt.close();
								conexionDB.desconectarBD();
							}
						}
						else {
							JOptionPane.showMessageDialog(this, "La fecha de fin de la tarea no puede ser posterior al fin del proyecto	.", "Error: fecha inválida", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(this, "La fecha de inicio de la tarea no puede ser posterior al fin dela tarea.", "Error: fecha inválida", JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(this, "La fecha de inicio de la tarea no puede ser anterior al comienzo del proyecto	.", "Error: fecha inválida", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		populateList();
	}

}
