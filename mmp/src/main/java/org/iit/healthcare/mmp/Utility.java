package org.iit.healthcare.mmp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {
	
	public static String getFutureDate(int days)
	{
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,days);
		Date    d=	 cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		return sdf.format(d);
	}
	public static String[][] readXLS(String fileName)
	{
			return new String[5][5];
	}
	public static String[][] readXLSX(String fileName)
	{
		return new String[5][5];
	}

}
