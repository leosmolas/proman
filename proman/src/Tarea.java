import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
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
	private JComboBox cbxTareas;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Tarea inst = new Tarea();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Tarea() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("Eliminar Tarea");
				btnEliminar.setFont(new java.awt.Font("Arial",0,10));
				btnEliminar.setPreferredSize(new java.awt.Dimension(122,21));
				btnEliminar.setBounds(118, 194, 122, 21);
			}
			{
				ComboBoxModel cbxTareasModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				cbxTareas = new JComboBox();
				getContentPane().add(cbxTareas);
				cbxTareas.setModel(cbxTareasModel);
				cbxTareas.setFont(new java.awt.Font("Arial",0,10));
				cbxTareas.setPreferredSize(new java.awt.Dimension(144,21));
				cbxTareas.setBounds(312, 41, 144, 21);
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
				lstTarea.setPreferredSize(new java.awt.Dimension(144,105));
				lstTarea.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				lstTarea.setBounds(312, 68, 144, 105);
			}
			{
				txtID = new JTextField();
				getContentPane().add(txtID);
				txtID.setPreferredSize(new java.awt.Dimension(132,21));
				txtID.setBounds(114, 12, 132, 21);
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
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
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
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				cbxInicioMes = new JComboBox();
				getContentPane().add(cbxInicioMes);
				cbxInicioMes.setModel(cbxInicioMesModel);
				cbxInicioMes.setFont(new java.awt.Font("Arial",0,10));
				cbxInicioMes.setPreferredSize(new java.awt.Dimension(61,21));
				cbxInicioMes.setBounds(173, 130, 61, 21);
			}
			{
				ComboBoxModel cbxInicioAñoModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				cbxInicioAño = new JComboBox();
				getContentPane().add(cbxInicioAño);
				cbxInicioAño.setModel(cbxInicioAñoModel);
				cbxInicioAño.setFont(new java.awt.Font("Arial",0,10));
				cbxInicioAño.setPreferredSize(new java.awt.Dimension(54,21));
				cbxInicioAño.setBounds(246, 130, 54, 21);
			}
			{
				ComboBoxModel cbxFinAñoModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				cbxFinAño = new JComboBox();
				getContentPane().add(cbxFinAño);
				cbxFinAño.setModel(cbxFinAñoModel);
				cbxFinAño.setFont(new java.awt.Font("Arial",0,10));
				cbxFinAño.setPreferredSize(new java.awt.Dimension(54,21));
				cbxFinAño.setBounds(246, 156, 54, 21);
			}
			{
				ComboBoxModel cbxFinMesModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
				cbxFinMes = new JComboBox();
				getContentPane().add(cbxFinMes);
				cbxFinMes.setModel(cbxFinMesModel);
				cbxFinMes.setFont(new java.awt.Font("Arial",0,10));
				cbxFinMes.setPreferredSize(new java.awt.Dimension(61,21));
				cbxFinMes.setBounds(173, 156, 61, 21);
			}
			{
				ComboBoxModel cbxFinDiaModel = 
					new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
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
				btnOk.setPreferredSize(new java.awt.Dimension(121,21));
				btnOk.setBounds(252, 194, 121, 21);
			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("Cancelar");
				btnCancel.setFont(new java.awt.Font("Arial",0,10));
				btnCancel.setPreferredSize(new java.awt.Dimension(77,21));
				btnCancel.setBounds(379, 194, 77, 21);
			}
			pack();
			this.setSize(482, 266);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
