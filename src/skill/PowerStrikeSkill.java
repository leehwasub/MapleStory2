package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.Hunt;
import playerAttack.PlayerAttack;
import playerAttack.PowerStrikeAttack;

public class PowerStrikeSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public PowerStrikeSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 5 + ((point / 5) * 2);
	}

	@Override
	public int getLast(int point) {
		return 0;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new PowerStrikeAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 150 + point * 5;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getEffect(point) + "% 물리데미지";
	}
	
}
