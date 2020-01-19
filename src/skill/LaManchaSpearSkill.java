package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.FlameChargeAttack;
import playerAttack.LaManchaSpearAttack;
import playerAttack.PlayerAttack;

public class LaManchaSpearSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public LaManchaSpearSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 5 + (point / 7);
	}

	@Override
	public int getLast(int point) {
		return 0;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new LaManchaSpearAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 540 + (point * 10);
	}
	
	public int getPreEffect(int point) {
		return 131 + point;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, 공격전 " + getPreEffect(point) + "% 물리데미지로 타격후,  " + getEffect(point) + "% "
				+ "물리 데미지로 1번 공격";
	}

}
