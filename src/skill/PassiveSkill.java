package skill;

import java.awt.Image;

public abstract class PassiveSkill extends Skill{

	public PassiveSkill(Image image, String name, int maxPoint, String infor) {
		super(image, name, maxPoint, infor);
	}

	public abstract int skillUpEffect();
	
}
