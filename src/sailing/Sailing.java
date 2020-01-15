package sailing;

import map.MapleMapList;
import map.PointMapName;
import maplestory.MainMapleInterface;
import maplestory.Player;
import utils.MusicUtils;
import utils.ResourceLoader;

public class Sailing extends Thread{
	
	private Player player;
	private MainMapleInterface mainMapleInterface;
	private String music;
	private String background;
	private PointMapName destination;
	private int time;
	
	public Sailing(Player player, MainMapleInterface mainMapleInterface, String music, String background, PointMapName destination, int time) {
		this.player = player;
		this.mainMapleInterface = mainMapleInterface;
		this.music = music;
		this.background = background;
		this.destination = destination;
		this.time = time;
	}

	@Override
	public void run() {
		player.setCanSave(false);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mainMapleInterface.changeBackground(ResourceLoader.getImage("backgroundImage", background+"BackgroundImage.png"));
		MusicUtils.changeMusic(music);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MapleMapList.getInstance().getMap(destination.getMapName()).warp(player, destination, mainMapleInterface);
		player.setCanSave(true);
	}

	@Override
	public String toString() {
		return "Sailing [player=" + player + ", mainMapleInterface=" + mainMapleInterface + ", music=" + music
				+ ", background=" + background + ", destination=" + destination + ", time=" + time + "]";
	}
	

}
