package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.EvilEyeShockAttack;
import playerAttack.FlameChargeAttack;
import playerAttack.PlayerAttack;

public class EvilEyeShockSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public EvilEyeShockSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property, int coolTime) {
		super(imageUrl, name, maxPoint, infor, attackType, property, coolTime);
	}

	@Override
	public int getNeedMp(int point) {
		return 0;
	}

	@Override
	public int getLast(int point) {
		return 0;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new EvilEyeShockAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 412 + (point * 12);
	}
	
	public int getStunRate(int point) {
		return 20 + (point * 2);
	}
	
	public int getStunLast(int point) {
		return 3;
	}

	@Override
	public String getEffectDetail(int point) {
		return "비홀더가 직접 공격, " + getEffect(point) + "% 물리데미지로 2번 타격, 맞은 대상은" + getStunRate(point) + "% 확률로 " + getStunLast(point) + "턴간 스턴 (쿨타임 "+coolTime+"턴)";
	}

}
