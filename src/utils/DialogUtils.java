package utils;

import javax.swing.JOptionPane;

public class DialogUtils {
	public static void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(null, message, "오류", JOptionPane.ERROR_MESSAGE);
	}
}
