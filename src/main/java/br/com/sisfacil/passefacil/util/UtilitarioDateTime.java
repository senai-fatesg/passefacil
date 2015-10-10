package br.com.sisfacil.passefacil.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilitarioDateTime {

	public static Date ToHoraAtual(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date hora;
		return hora = Calendar.getInstance().getTime();
	}
	
}
