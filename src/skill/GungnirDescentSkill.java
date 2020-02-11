package skill;

import attack.AttackType;
import attack.Property;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.BrandishAttack;
import playerAttack.GungnirDescentAttack;
import playerAttack.PlayerAttack;

public class GungnirDescentSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public GungnirDescentSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property, int coolTime) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
		this.coolTime = coolTime;
	}

	@Override
	public int getNeedMp(int point) {
		return 34 + (point / 2);
	}
	
	public int getMaxHpDamageEffect(int point) {
		return 10 + (point / 2);
	}

	@Override
	public int getLast(int point) {
		return 0;
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new GungnirDescentAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 292 + point * 2;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getEffect(point) + "% 물리데미지로 6번공격, 최대 HP의" + getMaxHpDamageEffect(point) + "% 만큼 타격마다 데미지 증가"
				+ "(쿨타임 " + coolTime + "턴)";
	}
}
