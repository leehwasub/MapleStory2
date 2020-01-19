package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.PlayerAttack;
import playerAttack.RageAttack;

public class RageSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public RageSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 12 + ((point / 11) * 8);
	}

	@Override
	public int getLast(int point) {
		return 8 + (point / 5);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new RageAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 10 + point;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getLast(point) + "턴간 물리공격력 " + getEffect(point) + " 증가";
	}

}
