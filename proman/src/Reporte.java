import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Object;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

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

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Reporte inst = new Reporte();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Reporte() {
		super();
		initGUI();
		cargarTabla();
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
			pack();
			this.setSize(795, 704);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cargarTabla(){

		String b;
		String[][] t = new String[500][];
		int k=0;
		
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("src/reporte.csv"));
			while (in.ready()){
				b = in.readLine();
				t[k]=b.split(";");
				k++;
				
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 71, 763, 591);
				{
					TableModel tableEventosModel = 
						new DefaultTableModel(t,new String[] { "1", "2" ,"3","4","5"});
					tableEventos = new JTable();
					jScrollPane1.setViewportView(tableEventos);
					tableEventos.setModel(tableEventosModel);
					tableEventos.setBounds(12, 32, 748, 574);
					tableEventos.setPreferredSize(new java.awt.Dimension(745, 711));
				}
			}
			{
				ComboBoxModel cbxProyectosModel = 
					new DefaultComboBoxModel(
							new String[] { "SAP Librería", "Item Two" });
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
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
