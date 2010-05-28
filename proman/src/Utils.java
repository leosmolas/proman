import javax.swing.*;

public class Utils {
	
	public static boolean esBisiesto(int year) {
	    return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}
	
	public void updateDias(JComboBox cbxDia,JComboBox cbxMes,JComboBox cbxaño){
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
				if (Utils.esBisiesto(Integer.parseInt(cbxaño.getModel().getElementAt(cbxaño.getSelectedIndex()).toString()))){
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
	
	public static void setDate(String yyyyMMdd, JComboBox cbxDia, JComboBox cbxMes, JComboBox cbxAnio){
		//formato de fecha de entrada: yyyy-MM-dd
		cbxAnio.setSelectedItem(yyyyMMdd.substring(0, 4));
		cbxMes.setSelectedIndex(Integer.parseInt(yyyyMMdd.substring(5,7))-1);
		cbxDia.setSelectedIndex(Integer.parseInt(yyyyMMdd.substring(8))-1);
	}
	
	public static String makeDate(JComboBox cbxDia, JComboBox cbxMes, JComboBox cbxAño){
		return (cbxAño.getModel().getElementAt(cbxAño.getSelectedIndex()).toString() +"-"+ (cbxMes.getSelectedIndex()+1) + "-" + (cbxDia.getSelectedIndex()+1));
	}
}
