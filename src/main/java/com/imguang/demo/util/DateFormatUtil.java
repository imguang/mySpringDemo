package com.imguang.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd/");

	public static String getFormat(Date date) {
		return dateFormat.format(date);
	}
}
