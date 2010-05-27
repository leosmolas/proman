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
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingUtilities;

import java.util.Calendar;
import java.util.Date;


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
public class Evento extends javax.swing.JFrame {
	
	private JButton btnCancel;
	private JButton btnOk;
	private JEditorPane edpDescripcion;
	private JLabel lblEvento;
	private JLabel lblID;
	private JButton btnEliminar;
	private JList lstEventos;
	private JTextField txtID;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDescripcion;
	private JLabel lblFechaDeInicio;
	private JComboBox cbxFechaDia;
	private JComboBox cbxFechaMes;
	private JComboBox cbxFechaAño;
	
	private Conexion conexionDB;
	private JFrame frmParent;

//	/**
//	* Auto-generated main method to display this JFrame
//	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				Evento inst = new Evento();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
//	
	public Evento(JFrame parent,Conexion dbConnection) {
		super();
		initGUI();
		
		conexionDB = dbConnection;
		frmParent = parent;
		populateList();
	}
	
	private void populateList() {
		int cantResults,i;
		try {
			conexionDB.conectarBD();			
			Statement stmt = conexionDB.statement();			
			String query = "select id_evento, nombre from eventos";
			
			ResultSet rs = stmt.executeQuery(query);
			
			rs.last();
			cantResults = rs.getRow();
			rs.beforeFirst();
			i=0;
			String[] stringArr = new String[cantResults+1];
			for(i=0;i<cantResults;i++){
				rs.next();
				stringArr[i] = rs.getString("id_evento") + "-"+ rs.getString("nombre");
			}
			
			stringArr[i] = "0-CREAR NUEVO EVENTO"; 
			
			lstEventos.setModel(new DefaultComboBoxModel(stringArr));
			
			stmt.close();
			conexionDB.desconectarBD();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Proyect Manager: Eventos del Proyecto SAP Librería");
			this.setPreferredSize(new java.awt.Dimension(483, 252));
			String[] anios = new String[90];
			for(int i=0;i<90;i++){
				int aux = i+2010;
				anios[i] = ""+ aux;
			}
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("Cancelar");
				btnCancel.setBounds(377, 189, 86, 21);
				btnCancel.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				btnOk = new JButton();
				getContentPane().add(btnOk);
				btnOk.setText("Guardar Evento");
				btnOk.setBounds(218, 189, 147, 21);
				btnOk.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				ComboBoxModel cbxInicioAñoModel = 
					new DefaultComboBoxModel(anios);
				cbxFechaAño = new JComboBox();
				getContentPane().add(cbxFechaAño);
				cbxFechaAño.setModel(cbxInicioAñoModel);
				cbxFechaAño.setBounds(230, 156, 54, 21);
				cbxFechaAño.setFont(new java.awt.Font("Arial",0,10));
				cbxFechaAño.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cbxFechaMesActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel cbxInicioMesModel = 
					new DefaultComboBoxModel(
							new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"});
				cbxFechaMes = new JComboBox();
				getContentPane().add(cbxFechaMes);
				cbxFechaMes.setModel(cbxInicioMesModel);
				cbxFechaMes.setBounds(157, 156, 61, 21);
				cbxFechaMes.setFont(new java.awt.Font("Arial",0,10));
				cbxFechaMes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cbxFechaMesActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel cbxInicioDiaModel = 
					new DefaultComboBoxModel(
							new String[] { "1", "Item Two" });
				cbxFechaDia = new JComboBox();
				getContentPane().add(cbxFechaDia);
				cbxFechaDia.setModel(cbxInicioDiaModel);
				cbxFechaDia.setBounds(96, 156, 49, 21);
				cbxFechaDia.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				lblFechaDeInicio = new JLabel();
				getContentPane().add(lblFechaDeInicio);
				lblFechaDeInicio.setText("Fecha");
				lblFechaDeInicio.setBounds(18, 159, 72, 14);
				lblFechaDeInicio.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				lblDescripcion = new JLabel();
				getContentPane().add(lblDescripcion);
				lblDescripcion.setText("Descripción");
				lblDescripcion.setBounds(18, 67, 68, 14);
				lblDescripcion.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				edpDescripcion = new JEditorPane();
				getContentPane().add(edpDescripcion);
				edpDescripcion.setBounds(98, 65, 186, 85);
				edpDescripcion.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			}
			{
				txtNombre = new JTextField();
				getContentPane().add(txtNombre);
				txtNombre.setBounds(98, 38, 132, 21);
			}
			{
				lblNombre = new JLabel();
				getContentPane().add(lblNombre);
				lblNombre.setText("Nombre");
				lblNombre.setBounds(18, 41, 46, 14);
				lblNombre.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				txtID = new JTextField();
				getContentPane().add(txtID);
				txtID.setBounds(98, 12, 132, 21);
			}
			{
				lblID = new JLabel();
				getContentPane().add(lblID);
				lblID.setText("ID");
				lblID.setBounds(18, 15, 34, 14);
				lblID.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				lblEvento = new JLabel();
				getContentPane().add(lblEvento);
				lblEvento.setText("Eventos");
				lblEvento.setBounds(296, 15, 75, 14);
				lblEvento.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				ListModel lstEventosModel = 
					new DefaultComboBoxModel(
							new String[] { "Comienzo Sprint 1", "Fin Sprint 1","--Nuevo Evento--" });
				lstEventos = new JList();
				getContentPane().add(lstEventos);
				lstEventos.setModel(lstEventosModel);
				lstEventos.setBounds(296, 41, 167, 136);
				lstEventos.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				lstEventos.setFont(new java.awt.Font("Arial",0,10));
				lstEventos.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent evt) {
						lstEventosValueChanged(evt);
					}
				});
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("Eliminar Evento");
				btnEliminar.setFont(new java.awt.Font("Arial",0,10));
				btnEliminar.setBounds(52, 189, 154, 21);
			}
			updateDias();
			pack();
			this.setSize(483, 252);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void thisWindowClosing(WindowEvent evt) {
		frmParent.setVisible(true);
		this.dispose();
	}
	
	private void lstEventosValueChanged(ListSelectionEvent evt) {
//		System.out.println("lstEventos.valueChanged, event="+evt);
		String evName = getCurrentEventName();
		String evID   = getCurrentEventtID();
		Date fecha;
		Calendar cal;
		if (evID.equals("0")){
			//si seleccionó para crear un nuevo evento
			cleanForm();
		} else {			
			try {
				conexionDB.conectarBD();
				Statement stmt = conexionDB.statement();
				
				String query = "select fecha, hora_inicio, nombre, descripcion from eventos where id_evento = " + evID;
				ResultSet rs = stmt.executeQuery(query);
				
				if(rs.next()){
					txtID.setText(evID);
					txtNombre.setText(evName);
					edpDescripcion.setText(rs.getString("descripcion"));
					fecha = rs.getDate("fecha");
					cal = Calendar.getInstance();
					cal.setTime(fecha);
					cbxFechaDia.setSelectedIndex(cal.DAY_OF_MONTH-1);
					cbxFechaMes.setSelectedIndex(cal.MONTH-1);
					cbxFechaAño.setSelectedItem(cal.YEAR +"");
				}else{
					txtID.setText("");
					txtNombre.setText("Nuevo Evento");
					edpDescripcion.setText("");
				}
				rs.close();
				conexionDB.desconectarBD();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void cleanForm() {
		txtID.setText("");
		txtNombre.setText("");
		edpDescripcion.setText("");
		cbxFechaDia.setSelectedIndex(0);
		cbxFechaMes.setSelectedIndex(0);
		cbxFechaAño.setSelectedIndex(0);		
	}

	private String getCurrentEventtID() {
		String selectedEv = lstEventos.getModel().getElementAt(lstEventos.getSelectedIndex()).toString();
		String evName = selectedEv.substring(0,selectedEv.indexOf('-'));
		return evName;
	}

	private String getCurrentEventName() {
		String selectedEv = lstEventos.getModel().getElementAt(lstEventos.getSelectedIndex()).toString();
		String projName = selectedEv.substring(selectedEv.indexOf('-')+1);
		return projName;
	}
	
	private void updateDias(){
		String mes = cbxFechaMes.getModel().getElementAt(cbxFechaMes.getSelectedIndex()).toString(); 
		if(mes == "Enero" || mes == "Marzo" || mes == "Mayo" || mes == "Julio" || mes == "Agosto" || mes == "Octubre" || mes == "Diciembre"){
			String dias[] = new String[31];
			for(int i = 1; i<=31;i++){
				dias[i-1] = "" + i;
			}
			cbxFechaDia.setModel(new DefaultComboBoxModel(dias));
		}else{
			if(mes == "Abril" || mes == "Junio" || mes == "Septiembre" || mes == "Noviembre"){
				String dias[] = new String[30];
				for(int i = 1; i<=30;i++){
					dias[i-1] = "" + i;
				}
				cbxFechaDia.setModel(new DefaultComboBoxModel(dias));
			}else{
				if (Proyecto.esBisiesto(Integer.parseInt(cbxFechaAño.getModel().getElementAt(cbxFechaAño.getSelectedIndex()).toString()))){
					String dias[] = new String[29];
					for(int i = 1; i<=29;i++){
						dias[i-1] = "" + i;
					}
					cbxFechaDia.setModel(new DefaultComboBoxModel(dias));
				}else{
					String dias[] = new String[28];
					for(int i = 1; i<=28;i++){
						dias[i-1] = "" + i;
					}
					cbxFechaDia.setModel(new DefaultComboBoxModel(dias));
				}
			}
		}
	}
	
	private void cbxFechaMesActionPerformed(ActionEvent evt) {
		updateDias();
	}
	

}
