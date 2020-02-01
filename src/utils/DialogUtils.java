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
	
	public static void showInfoDialog(String message) {
		dialogSetFont();
		JOptionPane.showMessageDialog(null, message, "알림", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static String showInputDialog(String message) {
		dialogSetFont();
		return JOptionPane.showInputDialog(null, message, "입력");
	}
	
	
	/**
	 *  
	 * @param message
	 * @return 확인을 선택할 경우 JOptionPane.YES_OPTION 반환
	 */
	public static int showConfirmDialog(String message) {
		dialogSetFont();
		return JOptionPane.showConfirmDialog(null, message, "확인", JOptionPane.YES_NO_OPTION);
	}
	
}
