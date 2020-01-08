package utils;

import maplestory.Music;

public class MusicUtils {
	private static Music music;

	public static void changeMusic(String s) {
		if (music != null) {
			music.close();
		}
		music = new Music(s + "Music.mp3", true);
		music.start();
	}

	public static void startEffectSound(String s) {
		Music sound = new Music(s + "Sound.mp3", false);
		sound.start();
	}
}
