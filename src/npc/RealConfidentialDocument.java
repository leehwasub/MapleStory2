package npc;

import item.ItemPool;
import map.PointMapName;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class RealConfidentialDocument extends Npc{

	private static final long serialVersionUID = 1L;

	public RealConfidentialDocument(String imageUrl, String name, PointMapName pointMapName) {
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
			player.addItem(ItemPool.getItem("비밀문서", 1));
		}
	}

}
