package com.doctoranywhere.doctoranywhere.util;

public class DataUtils {

	public static boolean isEmpty(String s,boolean trim) {
		if(s == null)
			return true;
		if(trim)
			s = s.trim();
		return "".equals(s);
	}
}
