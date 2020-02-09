package npc;

import map.PointMapName;
import maplestory.Player;

public class TreasureBox extends Npc{

	private static final long serialVersionUID = 1L;

	public TreasureBox(String imageUrl, String name, PointMapName pointMapName) {
		super(imageUrl, name, pointMapName);
	}

	@Override
	public void clearEvent(Player player) {
		
	}

	@Override
	public void requestQuest(Player player) {
		
	}

	@Override
	public void normalEvent(Player player) {
		if(process == 1) {
			player.addMoney(20000);
		}
	}

}
