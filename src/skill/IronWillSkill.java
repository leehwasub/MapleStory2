package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.Hunt;
import playerAttack.IronWillAttack;
import playerAttack.PlayerAttack;

public class IronWillSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public IronWillSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 18 + (point / 5);
	}

	@Override
	public int getLast(int point) {
		return 8 + (point / 3);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new IronWillAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return point * 15;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getLast(point) + "턴간 물리방어력, 마법방어력 +" + getEffect(point);
	}

}
