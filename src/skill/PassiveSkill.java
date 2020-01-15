package skill;

import character.Adventurer;

public abstract class PassiveSkill extends Skill{

	private static final long serialVersionUID = 1L;
	
	public PassiveSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	public abstract void skillUpEffect(Adventurer adventurer);
	public abstract void calStateEffect(Adventurer adventurer);
	
}
