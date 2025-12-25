package com.orangehrm.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int randomNum(int num) {
		Random r = new Random();
		return r.nextInt(num);
	}
	public String currentTime() {
//		Calendar cal = Calendar.getInstance();
//		Date d = cal.getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh-mm-ss");
//		String value = sdf.format(d);
//		return value;
		return new SimpleDateFormat("dd-MM-yy hh-mm-ss").format(new Date());
	}
}