package skill;

import attack.Attack;
import attack.AttackType;
import attack.Property;
import component.StateBox;

public class ironBodySkill extends ActiveSkill{

	public ironBodySkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 8 + ((point / 5) * 2);
	}

	@Override
	public int getLast(int point) {
		return 6 + (point / 4);
	}

	@Override
	public Attack skillUse(StateBox attacker, StateBox opponent) {
		return null;
	}

	@Override
	public int getEffect(int point) {
		return 5 + point * 5;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getLast(point) + "턴간 물리방어력 " + getEffect(point) + " 증가";
	}

}
