package maplestory;

import java.io.InputStream;
import java.net.URL;

import javax.swing.JFrame;

import utils.StringHelper;

public class Main {
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final int MONEY_BONUS = 1;
	public static final int EXP_BONUS = 1;
	public static final boolean MONSTER_TEST_MODE = false;
	public static final boolean DAMAGE_TEST_MODE = true;
	public static final boolean QUEST_TEST = true;

	public static void main(String[] args) {
		JFrame mapleStoryFrame = new MapleStoryFrame();
		mapleStoryFrame.setVisible(true);
	}

	public static InputStream accessFile(String fileName) {
		InputStream input = Main.class.getResourceAsStream("/res/" + fileName);
		if (input == null) {
			input = Main.class.getClassLoader().getResourceAsStream(fileName);
		}
		return input;
	}

	public static String findSource(Class<?> clazz) {
		String resourceToSearch = '/' + clazz.getName().replace(".", "/") + ".class";
		URL location = clazz.getResource(resourceToSearch);
		String sourcePath = location.getPath();
		String tmp = StringHelper.convertToUTF8(sourcePath.replace("file:", "").replace("!" + resourceToSearch, ""));
		int index = tmp.lastIndexOf("/");
		return tmp.substring(0, index);
	}
}
