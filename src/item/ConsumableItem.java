package item;

import java.io.Serializable;
import character.Character;

public abstract class ConsumableItem extends Item implements Serializable {
	private static final long serialVersionUID = 1L;

	public ConsumableItem(String name, int cost, String imageUrl, int num) {
		super(name, cost, imageUrl, num);
	}

	public abstract void use(Character paramCharacter);
}
