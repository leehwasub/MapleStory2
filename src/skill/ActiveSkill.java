package skill;

import java.awt.Image;

import attack.Attack;
import component.StateBox;

public abstract class ActiveSkill extends Skill {


	public ActiveSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}
	
	public abstract int getNeedMp(int point);
	public abstract int getLast(int point);
	public abstract Attack skillUse(StateBox attacker, StateBox opponent);
	
	
}
