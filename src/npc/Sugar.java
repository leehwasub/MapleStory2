package npc;

import java.io.Serializable;

import map.MapleMap;
import map.PointMapName;
import map.UpdatedMapInfor;
import maplestory.Player;

public class Sugar extends Npc implements Serializable {
	private static final long serialVersionUID = 1L;

	public Sugar(String image, String name, PointMapName pointMapName) {
		super(image, name, pointMapName);
	}

	public void clearEvent(Player player) {
	}

	public void requestQuest(Player player) {
	}

	@Override
	public void normalEvent(Player player) {
		if(process == 25) {
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(4, 9, "초보자의숲1"), MapleMap.MAP_PORTAL_STATE));
		}
	}
}
