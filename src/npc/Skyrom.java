package npc;

import item.ItemPool;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class Skyrom extends Npc{

	private static final long serialVersionUID = 1L;

	public Skyrom(String imageUrl, String name, PointMapName pointMapName) {
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
			player.removeItem("가짜스카이롬", 1);
			player.addItem(ItemPool.getItem("스카이롬", 1));
		}
	}

}
