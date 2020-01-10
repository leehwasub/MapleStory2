package skill;

import attack.Attack;
import attack.AttackType;
import attack.Property;
import component.StateBox;

public abstract class ActiveSkill extends Skill {

	protected AttackType attackType;
	protected Property property;

	public ActiveSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor);
		this.attackType = attackType;
		this.property = property;
	}
	
	public abstract int getNeedMp(int point);
	public abstract int getLast(int point);
	public abstract Attack skillUse(StateBox attacker, StateBox opponent);
	
	
}
