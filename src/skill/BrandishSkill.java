package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.Hunt;
import playerAttack.BrandishAttack;
import playerAttack.PlayerAttack;

public class BrandishSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public BrandishSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 10 + (point / 3);
	}

	@Override
	public int getLast(int point) {
		return 0;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new BrandishAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 220 + point * 3;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getEffect(point) + "% 물리데미지로 두번공격";
	}

}
