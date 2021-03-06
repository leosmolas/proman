import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

public class Utils {
	public static String[] anios() {
		String[] anios = new String[90];
		for(int i=0;i<90;i++){
			int aux = i+2010;
			anios[i] = ""+ aux;
		}
		return anios;
	}
	
	public static String getCurrentDate(){
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(date);
		return currentDate;
	}
	
	public static boolean esBisiesto(int year) {
	    return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}
	
	public static void updateDias(JComboBox cbxDia,JComboBox cbxMes,JComboBox cbxa�o){
		int selectedDay = cbxDia.getSelectedIndex();
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
		
		try{
			cbxDia.setSelectedIndex(selectedDay);
		} catch (Exception e) {
			
		}
		
	}
	
	public static void setDate(String yyyyMMdd, JComboBox cbxDia, JComboBox cbxMes, JComboBox cbxAnio){
		//formato de fecha de entrada: yyyy-MM-dd
		cbxAnio.setSelectedItem(yyyyMMdd.substring(0, 4));
		cbxMes.setSelectedIndex(Integer.parseInt(yyyyMMdd.substring(5,7))-1);
		cbxDia.setSelectedIndex(Integer.parseInt(yyyyMMdd.substring(8))-1);
	}
	
	public static String makeDate(JComboBox cbxDia, JComboBox cbxMes, JComboBox cbxA�o){
		return (cbxA�o.getModel().getElementAt(cbxA�o.getSelectedIndex()).toString() +"-"+ 
				(cbxMes.getSelectedIndex()+1<10 ? "0" + (cbxMes.getSelectedIndex()+1) : (cbxMes.getSelectedIndex()+1) + "") + "-" + 
				(cbxDia.getSelectedIndex()+1<10 ? "0" + (cbxDia.getSelectedIndex()+1) : (cbxDia.getSelectedIndex()+1) + ""));
	}
	
	public static String[] horas() {
		int i;
		String [] aux = new String [24];
		for (i=0;i<24;i++) {
			aux[i] = String.valueOf(i); 
		}
		return aux;
	}
	
	public static String[] minutos() {
		int i;
		String [] aux = new String [60];
		for (i=0;i<60;i++) {
			aux[i] = String.valueOf(i); 
		}
		return aux;
	}
}
