package br.com.sisfacil.passefacil.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilitarioDateTime {

	/**Retorna a hora atual*/
	public static Date ToHoraAtual(){
		//SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return (Date)Calendar.getInstance().getTime();
	}
	
}
