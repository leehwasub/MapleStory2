package sailing;

import map.PointMapName;
import maplestory.MainMapleInterface;
import maplestory.Player;

public class SailingFactory{
	
	public static Sailing makeSailing(Player player, MainMapleInterface mainMapleInterface, String mapName) {
		switch(mapName) {
		case "사우스페리":
			return new Sailing(player, mainMapleInterface, "fly1", "sailing1", new PointMapName(1, 1, "리스항구"), 60000);
		case "빅토리아->엘나스산맥승강장":
			return new Sailing(player, mainMapleInterface, "fly1", "sailing2", new PointMapName(2, 10, "오르비스"), 90000);
		case "엘나스산맥->빅토리아승강장":
			return new Sailing(player, mainMapleInterface, "fly1", "sailing2", new PointMapName(1, 1, "리스항구"), 90000);
		case "엘나스산맥->니할사막승강장":
			return new Sailing(player, mainMapleInterface, "fly2", "sailing3", new PointMapName(2, 10, "아리안트"), 90000);
		case "니할사막->엘나스산맥승강장":
			return new Sailing(player, mainMapleInterface, "fly2", "sailing3", new PointMapName(2, 10, "오르비스"), 90000);
		case "니할사막->미나르숲승강장":
			return new Sailing(player, mainMapleInterface, "fly2", "sailing3", new PointMapName(2, 10, "리프레"), 90000);
		case "미나르숲->니할사막승강장":
			return new Sailing(player, mainMapleInterface, "fly2", "sailing3", new PointMapName(2, 10, "아리안트"), 90000);
		case "미나르숲->시간의신전승강장":
			return new Sailing(player, mainMapleInterface, "fly2", "sailing5", new PointMapName(3, 12, "시간의신전"), 60000);
		case "시간의신전승강장":
			return new Sailing(player, mainMapleInterface, "fly2", "sailing5", new PointMapName(2, 10, "미나르숲"), 60000);
		}
		return null;
	}

}
