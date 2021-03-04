package org.iit.healthcare.mmp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;



public class Utility {
	
	static Random rand;
	String input = "somedata";
	
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

	// This is to generate a random string for input data
		public static String getRandomString(int noOfChars) {

			Random rand = new Random();
			String s = "";
			int bound = noOfChars;
			for (int i = 0; i < bound; i++) {
				char c = (char) ('a' + rand.nextInt(26));
				s = s + c;
			}
			System.out.println("getRandomString Method returning " + s);
			return s;
		}
		
		public static int getRandomNoofDigits(int noOfDigits) {
			rand = new Random();
			int addend1 = 0, addend2 = 0;
			String zero = "";
			String bound = "";
			int result = 0;
			for (int i = 1; i < (noOfDigits) - 1; i++) {
				zero = zero + 0;
			}
			addend1 = Integer.parseInt(zero);
			for (int j = 1; j <= (noOfDigits - 1); j++) {
				bound = bound + 9;
			}
			bound = 8 + bound;
			addend2 = Integer.parseInt(bound);
			result = addend1 + rand.nextInt(addend2);
			System.out.println("Random " + noOfDigits + " digit number is : " + result);
			return result;
		}
			
		public static int getRandomNoofDigitsAge(int noOfDigits) {
			rand = new Random();
			int addend1 = 0, addend2 = 0;
			String zero = "";
			String bound = "";
			int result = 0;
			
			  for (int i = 1; i < 3; i++) { zero = zero + 0; }
			 
			addend1 = Integer.parseInt(zero);
			for (int j = 1; j <= 2; j++) {
				bound = bound + 9;
			}		
			addend2 = Integer.parseInt(bound);
			result = addend1 + rand.nextInt(addend2);
			return result;
		}
}
