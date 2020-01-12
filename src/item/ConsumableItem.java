package item;

import java.io.Serializable;
import character.Character;

public abstract class ConsumableItem extends Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int level;

	public ConsumableItem(String name, int cost, String imageUrl, int num, int level) {
		super(name, cost, imageUrl, num);
		this.level = level;
	}

	public abstract void use(Character paramCharacter);

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
