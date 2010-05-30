import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
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
	private JButton btnOk;
	private JButton btnCancel;
	private JButton btnAIzq;
	private JButton btnADer;
	private JLabel lblGrupo;
	private JLabel lblID;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JButton btnEliminar;
	private JTextField txtID;
	private JLabel lblDescripcion;
	
	public Grupo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Proyect Manager: Grupo");
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(560, 371));
			{
				edpDescripcion = new JEditorPane();
				getContentPane().add(edpDescripcion);
				edpDescripcion.setBounds(92, 66, 277, 58);
				edpDescripcion.setFont(new java.awt.Font("Arial",0,10));
				edpDescripcion.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			}
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
				btnADer = new JButton();
				getContentPane().add(btnADer);
				btnADer.setText("Agregar");
				btnADer.setBounds(287, 159, 82, 21);
				btnADer.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				btnAIzq = new JButton();
				getContentPane().add(btnAIzq);
				btnAIzq.setText("Eliminar");
				btnAIzq.setBounds(287, 192, 82, 21);
				btnAIzq.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("Cancelar");
				btnCancel.setBounds(458, 308, 82, 21);
				btnCancel.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				btnOk = new JButton();
				getContentPane().add(btnOk);
				btnOk.setText("Guardar Grupo");
				btnOk.setBounds(327, 308, 119, 21);
				btnOk.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				btnEditarRol = new JButton();
				getContentPane().add(btnEditarRol);
				btnEditarRol.setText("Editar Rol");
				btnEditarRol.setBounds(287, 225, 82, 21);
				btnEditarRol.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				TableModel tblUsuariosModel = 
					new DefaultTableModel(
							new String[][] { { "Juan Perez", "Jefe" }, { "Jose Gonzalez", "Diseñador" } },
							new String[] { "Column 1", "Column 2" });
				tblUsuarios = new JTable();
				getContentPane().add(tblUsuarios);
				tblUsuarios.setModel(tblUsuariosModel);
				tblUsuarios.setBounds(12, 159, 263, 137);
				tblUsuarios.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
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
			}
			{
				lblGrupos = new JLabel();
				getContentPane().add(lblGrupos);
				lblGrupos.setText("Grupos");
				lblGrupos.setBounds(381, 15, 71, 14);
				lblGrupos.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				btnEliminar = new JButton();
				getContentPane().add(btnEliminar);
				btnEliminar.setText("Eliminar Grupo");
				btnEliminar.setFont(new java.awt.Font("Arial",0,10));
				btnEliminar.setBounds(194, 308, 121, 21);
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
				txtNombre.setBounds(92, 39, 132, 21);
				txtNombre.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
