package npc;

import map.MapleMap;
import map.PointMapName;
import map.UpdatedMapInfor;
import maplestory.Player;
import quest.Quest;
import quest.QuestProceed;

public class ForgottenTempleKeeper extends Npc{

	private static final long serialVersionUID = 1L;

	public ForgottenTempleKeeper(String imageUrl, String name, PointMapName pointMapName) {
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
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(6, 3, "잊혀진회랑"), MapleMap.MAP_PORTAL_STATE));
		}
	}

}
