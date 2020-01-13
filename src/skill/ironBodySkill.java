package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.Hunt;
import playerAttack.IronBodyAttack;
import playerAttack.PlayerAttack;

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
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new IronBodyAttack(hunt, attacker, opponent, this);
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
