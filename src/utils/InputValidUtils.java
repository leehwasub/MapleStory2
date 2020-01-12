package utils;

public class InputValidUtils {
	public static boolean isValidIntString(String s) {
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
}
