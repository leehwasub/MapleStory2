package skill;

import java.awt.Image;

import character.Adventurer;

public abstract class PassiveSkill extends Skill{

	public PassiveSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	public abstract void skillUpEffect(Adventurer adventurer);
	
}
