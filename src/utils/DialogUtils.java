package utils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class DialogUtils {
	
	private static void dialogSetFont() {
		UIManager.put("OptionPane.messageFont", FontUtils.SMALL_FONT);
	}
	
	public static void showErrorDialog(String message) {
		dialogSetFont();
		JOptionPane.showMessageDialog(null, message, "오류", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showWarningDialog(String message) {
		dialogSetFont();
		JOptionPane.showMessageDialog(null, message, "경고", JOptionPane.WARNING_MESSAGE);
	}
	
}
