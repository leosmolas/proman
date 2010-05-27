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

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Evento inst = new Evento();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Evento() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Proyect Manager: Eventos del Proyecto SAP Librería");
			this.setPreferredSize(new java.awt.Dimension(483, 264));
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("Cancelar");
				btnCancel.setBounds(377, 201, 86, 21);
				btnCancel.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				btnOk = new JButton();
				getContentPane().add(btnOk);
				btnOk.setText("Guardar Evento");
				btnOk.setBounds(218, 201, 147, 21);
				btnOk.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				ComboBoxModel cbxInicioAñoModel = 
					new DefaultComboBoxModel(
							new String[] { "2010", "Item Two" });
				cbxFechaAño = new JComboBox();
				getContentPane().add(cbxFechaAño);
				cbxFechaAño.setModel(cbxInicioAñoModel);
				cbxFechaAño.setBounds(230, 156, 54, 21);
				cbxFechaAño.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				ComboBoxModel cbxInicioMesModel = 
					new DefaultComboBoxModel(
							new String[] { "Enero", "Item Two" });
				cbxFechaMes = new JComboBox();
				getContentPane().add(cbxFechaMes);
				cbxFechaMes.setModel(cbxInicioMesModel);
				cbxFechaMes.setBounds(157, 156, 61, 21);
				cbxFechaMes.setFont(new java.awt.Font("Arial",0,10));
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
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("Eliminar Evento");
				btnEliminar.setFont(new java.awt.Font("Arial",0,10));
				btnEliminar.setBounds(52, 201, 154, 21);
			}
			pack();
			this.setSize(483, 264);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
