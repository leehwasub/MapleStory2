package skill;

import attack.AttackType;
import attack.Property;
import character.Adventurer;
import component.StateBox;
import hunt.Hunt;
import playerAttack.BlizzardChargeAttack;
import playerAttack.HpRecoveryAttack;
import playerAttack.PlayerAttack;

public class HpRecoverySkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public HpRecoverySkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property, int coolTime) {
		super(imageUrl, name, maxPoint, infor, attackType, property, coolTime);
	}

	@Override
	public int getNeedMp(int point) {
		return 24 + point * 4;
	}

	@Override
	public int getLast(int point) {
		return 4 + (point / 5);
	}
	
	public int removeAbnormalRate(int point) {
		return 40 + point * 3;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new HpRecoveryAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 30 + point * 3;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, HP " + getEffect(point) + "% 회복" + removeAbnormalRate(point) + "% 확률로 모든 상태이상 해제(쿨타임 " + coolTime + "턴)";
	}

}
