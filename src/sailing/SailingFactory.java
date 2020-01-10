package sailing;

import map.PointMapName;
import maplestory.MainMapleInterface;
import maplestory.Player;

public class SailingFactory{
	
	public static Sailing makeSailing(Player player, MainMapleInterface mainMapleInterface, String mapName) {
		switch(mapName) {
		case "사우스페리":
			return new Sailing(player, mainMapleInterface, "fly1", "sailing1", new PointMapName(1, 1, "리스항구"), 60000);
		}
		return null;
	}

}
