package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.BlizzardChargeAttack;
import playerAttack.PlayerAttack;

public class BlizzardChargeSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public BlizzardChargeSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
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
	
	public int frostBiteRate(int point) {
		return 30 + point * 3;
	}
	
	public int frostBiteEffect(int point) {
		return 15 + point;
	}

	public int extraEffect(int point) {
		return 106 + (point / 2);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new BlizzardChargeAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 100 + point * 2;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getEffect(point) + "% 얼음속성 물리데미지로 3번 공격,  "+ frostBiteRate(point) + "% 확률로 " + getLast(point) + "턴간 적 동상, 매턴마다 " 
				+ frostBiteEffect(point) + "% 지속 데미지, 화상 상태의 적 공격시 " + extraEffect(point) + "% 추가데미지";
	}

}
