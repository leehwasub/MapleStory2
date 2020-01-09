package skill;

import java.awt.Image;

import attack.Attack;
import component.StateBox;

public abstract class ActiveSkill extends Skill {


	public ActiveSkill(Image image, String name, int maxPoint, String infor) {
		super(image, name, maxPoint, infor);
	}
	
	public abstract int getLast(int point);
	public abstract Attack skillUse(StateBox attacker, StateBox opponent);
	
	
}
