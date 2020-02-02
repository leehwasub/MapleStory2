package npc;

import map.MapleMap;
import map.PointMapName;
import map.UpdatedMapInfor;
import maplestory.Player;

public class ExplosiveDevice extends Npc{

	private static final long serialVersionUID = 1L;

	public ExplosiveDevice(String imageUrl, String name, PointMapName pointMapName) {
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
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(3, 14, "비밀연구소3구역"), MapleMap.MAP_PORTAL_STATE));
		}
	}

}
