package npc;

import java.io.Serializable;

import map.PointMapName;
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
}
