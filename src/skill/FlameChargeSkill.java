package skill;

import attack.AttackType;
import attack.Property;
import character.Adventurer;
import component.StateBox;
import hunt.Hunt;
import playerAttack.FlameChargeAttack;
import playerAttack.PlayerAttack;

public class FlameChargeSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public FlameChargeSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 10 + point;
	}

	@Override
	public int getLast(int point) {
		return 3 + (point / 5);
	}
	
	public int burnRate(int point) {
		return 30 + point * 3;
	}
	
	public int burnEffect(int point) {
		return 55 + point;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		getElementalCombo(attacker);
		return new FlameChargeAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 100 + point * 2;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getEffect(point) + "% 불속성 물리데미지로 3번 공격후 " + burnRate(point) + "% 확률로 화상, 화상시 " + 
				getLast(point) + "턴간 " + burnEffect(point) + "% 지속 데미지";
	}

}
