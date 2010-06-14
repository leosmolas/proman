import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Object;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

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
public class Reporte extends javax.swing.JFrame {
	private JTable tableEventos;
	private JComboBox cbxProyectos;
	private JButton btnCrearReporte;
	private JScrollPane jScrollPane1;
	private JLabel lblEvento;
	private JFrame parent;
	private Conexion conexionDB;

	
	public Reporte(JFrame parent, Conexion conexion) {
		super();
		this.conexionDB = conexion;
		this.parent = parent;
		initGUI();
		populateList();
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(795, 704));
			this.setTitle("Proyect Manager: Reporte");

			{
				lblEvento = new JLabel();
				getContentPane().add(lblEvento);
				lblEvento.setText("Reporte");
				lblEvento.setBounds(12, 45, 176, 14);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 71, 763, 591);
				{
					TableModel tableEventosModel = 
						new DefaultTableModel();
					tableEventos = new JTable();
					jScrollPane1.setViewportView(tableEventos);
					tableEventos.setModel(tableEventosModel);
					tableEventos.setBounds(12, 32, 748, 574);
					tableEventos.setPreferredSize(new java.awt.Dimension(745, 711));
				}
			}
			{
				ComboBoxModel cbxProyectosModel = 
					new DefaultComboBoxModel();
				cbxProyectos = new JComboBox();
				getContentPane().add(cbxProyectos);
				cbxProyectos.setModel(cbxProyectosModel);
				cbxProyectos.setBounds(12, 12, 176, 21);
				cbxProyectos.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				btnCrearReporte = new JButton();
				getContentPane().add(btnCrearReporte);
				btnCrearReporte.setText("Crear Reporte");
				btnCrearReporte.setBounds(200, 12, 125, 21);
				btnCrearReporte.setFont(new java.awt.Font("Arial",0,10));
				btnCrearReporte.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCrearReporteActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(795, 704);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cargarTabla(){

		String b;
		String[][] t = new String[5000][];
		int k=0;
		TableModel tableEventosModel;
		
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("reporte.csv"));
			while (in.ready()){
				b = in.readLine();
				t[k]=b.split(";");
				k++;
			}
			tableEventosModel = new DefaultTableModel(t,new String[] { "1", "2" ,"3","4","5"});
			tableEventos.setModel(tableEventosModel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void populateList(){
		try {
			conexionDB.conectarBD();			
			Statement stmt = conexionDB.statement();			
			String query = "select id_proyecto, nombre from proyectos";
			
			ResultSet rs = stmt.executeQuery(query);
			
			rs.last();
			int cantResults = rs.getRow();
			rs.beforeFirst();
			int i=0;
			DefaultComboBoxModel model = new DefaultComboBoxModel();
			for(i=0;i<cantResults;i++){
				rs.next();
				model.addElement(rs.getString("id_proyecto") + "-"+ rs.getString("nombre"));
				//System.out.println(stringArr[i]);
			}
			
			model.addElement("0-TODOS LOS PROYECTOS"); 
			
			stmt.close();
			conexionDB.desconectarBD();
			
			cbxProyectos.setModel(model);
			
			cbxProyectos.setSelectedIndex(0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String getID(String selectedItem) {
		return selectedItem.substring(0,selectedItem.indexOf('-'));
	}
	
	private void btnCrearReporteActionPerformed(ActionEvent evt) {
		System.out.println("btnCrearReporte.actionPerformed, event="+evt);
		
		crearReporte(getID(cbxProyectos.getSelectedItem().toString()));
		cargarTabla();
	}

	private void crearReporte(String id) {
		try {
		    BufferedWriter reporte = new BufferedWriter(new FileWriter("reporte.csv"));
		    if (id.equals("0")) {
		    	//todos
		    }
		    else {
		    	reporteProyecto(reporte,id);
		    }
		    reporte.close();
		} catch (IOException e) {
		}
	}

	private void reporteProyecto(BufferedWriter reporte,String id) throws IOException {
		reporte.write("Proyecto\n");
		try {
			conexionDB.conectarBD();			
			Statement stmt = conexionDB.statement();			
			String query = "select * from proyectos where id_proyecto = "+id;
			
			ResultSet rs = stmt.executeQuery(query);
			
			rs.next();
			reporte.write("ID;"              + rs.getString("id_proyecto") +"\n");
			reporte.write("Nombre;"          + rs.getString("nombre") +"\n");
			reporte.write("Descripcion;"     + rs.getString("descripcion") +"\n");
			reporte.write("Fecha de Inicio;" + rs.getString("fecha_inicio") +"\n");
			reporte.write("Fecha de Fin;"    + rs.getString("fecha_fin") +"\n");
			reporte.write("Estado;"          + rs.getString("estado") +"\n");
			
			reporte.write("\n\nTareas\n");
			reporte.write("ID;Descripción;Fecha de Inicio;Fecha de Fin; Grupo Asignado\n");
			
			query = "select * from tareas where proyecto = "+id;
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				reporte.write(rs.getString("id_tarea") + ";");
				reporte.write(rs.getString("descripcion") + ";");
				reporte.write(rs.getString("fecha_inicio") + ";");
				reporte.write(rs.getString("fecha_fin") + ";");
				reporte.write(rs.getString("grupo") + "\n");
			}
			
			reporte.write("\n\nGrupos\n");
			reporte.write("ID;Nombre;Descripción\n");
			
			query = "select * from grupos where proyecto = "+id;
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				reporte.write(rs.getString("id_grupo") + ";");
				reporte.write(rs.getString("nombre") + ";");
				reporte.write(rs.getString("descripcion") + "\n");
			}
			
			reporte.write("\n\nUsuarios\n");
			reporte.write("ID;Nombre;E-mail\n");
			
			query = "select distinct usuarios.id_usuario as id,usuarios.nombre as nombre ,usuarios.email as email from usuarios,grupos,rol where proyecto = " + id + " and id_grupo = grupo and usuario = id_usuario";
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				reporte.write(rs.getString("id") + ";");
				reporte.write(rs.getString("nombre") + ";");
				reporte.write(rs.getString("email") + "\n");
			}
			
			reporte.write("\n\nRol\n");
			reporte.write("Nombre del Usuario;ID del grupo;Descripción\n");
			
			query = "select usuarios.nombre as nombre, rol.grupo as id, rol.descripcion as descripcion from usuarios,grupos,rol where proyecto = " + id + " and id_grupo = grupo and usuario = id_usuario";
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				reporte.write(rs.getString("nombre") + ";");
				reporte.write(rs.getString("id") + ";");
				reporte.write(rs.getString("descripcion") + "\n");
			}
			
			reporte.write("\n\nEventos\n");
			reporte.write("ID;Nombre;Descripción;Fecha;Hora de Inicio\n");
			
			query = "select * from eventos where proyecto = " + id ;
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				reporte.write(rs.getString("id_evento") + ";");
				reporte.write(rs.getString("nombre") + ";");
				reporte.write(rs.getString("descripcion") + ";");
				reporte.write(rs.getString("fecha") + ";");
				reporte.write(rs.getString("hora_inicio") + "\n");
			}
			
			reporte.write("\n\n\n\n");
			
			stmt.close();
			conexionDB.desconectarBD();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
