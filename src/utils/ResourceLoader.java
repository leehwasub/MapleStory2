package utils;

import java.awt.Image;
import java.awt.Toolkit;

public class ResourceLoader {
	static ResourceLoader rl = new ResourceLoader();

	public static Image getImage(String folder, String fileName) {
		try {
			return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource("/" + folder + "/" + fileName));
		}catch(Exception e) {
			DialogUtils.showErrorDialog(folder + " 폴더의" + fileName + " 이미지파일 로딩 실패!");
		}
		return null;
	}
}