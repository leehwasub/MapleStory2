package item;

import java.io.Serializable;

import buff.Buffable;
import character.Character;
import maplestory.Main;
import maplestory.MainMapleInterface;
import maplestory.MapleInterface;
import maplestory.Player;

public abstract class ConsumableItem extends Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int level;

	public ConsumableItem(String name, int cost, String imageUrl, int num, int level) {
		super(name, cost, imageUrl, num);
		this.level = level;
	}

	public abstract void use(Player player, MainMapleInterface mainMapleInterface);
	public abstract boolean isNeedQuickReigster();

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
