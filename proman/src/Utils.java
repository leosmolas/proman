import javax.swing.*;

public class Utils {
	
	public static boolean esBisiesto(int year) {
	    return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}
	
	public void updateDiasInicio(JComboBox cbxDia,JComboBox cbxMes,JComboBox cbxa�o){
		String mes = cbxMes.getModel().getElementAt(cbxMes.getSelectedIndex()).toString(); 
		if(mes == "Enero" || mes == "Marzo" || mes == "Mayo" || mes == "Julio" || mes == "Agosto" || mes == "Octubre" || mes == "Diciembre"){
			String dias[] = new String[31];
			for(int i = 1; i<=31;i++){
				dias[i-1] = "" + i;
			}
			cbxDia.setModel(new DefaultComboBoxModel(dias));
		}else{
			if(mes == "Abril" || mes == "Junio" || mes == "Septiembre" || mes == "Noviembre"){
				String dias[] = new String[30];
				for(int i = 1; i<=30;i++){
					dias[i-1] = "" + i;
				}
				cbxDia.setModel(new DefaultComboBoxModel(dias));
			}else{
				if (Utils.esBisiesto(Integer.parseInt(cbxa�o.getModel().getElementAt(cbxa�o.getSelectedIndex()).toString()))){
					String dias[] = new String[29];
					for(int i = 1; i<=29;i++){
						dias[i-1] = "" + i;
					}
					cbxDia.setModel(new DefaultComboBoxModel(dias));
				}else{
					String dias[] = new String[28];
					for(int i = 1; i<=28;i++){
						dias[i-1] = "" + i;
					}
					cbxDia.setModel(new DefaultComboBoxModel(dias));
				}
			}
		}
	}
}