package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.BrandishAttack;
import playerAttack.DarkImpaleAttack;
import playerAttack.PlayerAttack;

public class DarkImpaleSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public DarkImpaleSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 23 + ((point / 4) * 4);
	}
	
	public int getHitNum(int point) {
		return 5 + (point / 16);
	}

	@Override
	public int getLast(int point) {
		return 0;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new DarkImpaleAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 160 + point * 4;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getEffect(point) + "% 물리데미지로 "+getHitNum(point)+"번공격";
	}
}
