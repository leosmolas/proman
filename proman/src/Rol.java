import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
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
public class Rol extends javax.swing.JFrame {
	private JList lstUsuarios;
	private JLabel lblUsuarios;
	private JLabel lblDescripción;
	private JEditorPane edpDescripción;
	private JButton btnOk;
	private JButton btnCancel;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Rol inst = new Rol();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Rol() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Proyect Manager: Rol");
			this.setPreferredSize(new java.awt.Dimension(400, 260));
			{
				ListModel lstUsuariosModel = 
					new DefaultComboBoxModel(
							new String[] { "Juan Perez", "Fernando Sisul", "Jose Gonzalez" });
				lstUsuarios = new JList();
				getContentPane().add(lstUsuarios);
				lstUsuarios.setModel(lstUsuariosModel);
				lstUsuarios.setBounds(12, 32, 130, 153);
				lstUsuarios.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
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
			}
			{
				btnOk = new JButton();
				getContentPane().add(btnOk);
				btnOk.setText("Ok");
				btnOk.setBounds(236, 197, 55, 21);
				btnOk.setFont(new java.awt.Font("Arial",0,10));
			}
			{
				btnCancel = new JButton();
				getContentPane().add(btnCancel);
				btnCancel.setText("Cancelar");
				btnCancel.setBounds(303, 197, 77, 21);
				btnCancel.setFont(new java.awt.Font("Arial",0,10));
			}
			pack();
			this.setSize(400, 260);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
