package utils;

import java.util.regex.Pattern;

public class InputValidUtils {
	public static boolean isValidIntString(String s) {
		if(s == null || s.length() == 0) return false;
		for (int i = 0; i < s.length(); i++) {
			if (('0' > s.charAt(i)) || (s.charAt(i) > '9')) {
				return false;
			}
		}
		int num = Integer.parseInt(s);
		if (num == 0 || num > 1000) {
			return false;
		}
		return true;
	}
	
	/**
	 * 한글,영어 숫자 가능
	 * @param 
	 * @return
	 */
	public static boolean isValidName(String s) {
		if(s == null || s.length() == 0 || s.length() < 3 || s.length() > 12) return false;
		return Pattern.matches("^[ㄱ-ㅎ가-힣a-zA-Z0-9]*$", s);
	}
	
}
