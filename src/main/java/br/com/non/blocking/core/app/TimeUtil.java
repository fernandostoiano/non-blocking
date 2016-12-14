package br.com.non.blocking.core.app;

import java.util.Calendar;

public class TimeUtil {

	public static String getTime() {
		long time = System.currentTimeMillis();
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(time);
		return now.getTime().toString();
	}
	
}
