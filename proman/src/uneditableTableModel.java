import javax.swing.table.DefaultTableModel;

public class uneditableTableModel extends DefaultTableModel {
	   
	   public boolean isCellEditable (int row, int column)
	   {
	       return false;
	   }
}
