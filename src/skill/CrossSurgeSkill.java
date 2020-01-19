package skill;

import attack.AttackType;
import attack.Property;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.CrossSurgeAttack;
import playerAttack.FlameChargeAttack;
import playerAttack.PlayerAttack;

public class CrossSurgeSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;

	public CrossSurgeSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property) {
		super(imageUrl, name, maxPoint, infor, attackType, property);
	}

	@Override
	public int getNeedMp(int point) {
		return 10 + (point / 2);
	}

	@Override
	public int getLast(int point) {
		return 8 + (point / 5);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new CrossSurgeAttack(hunt, attacker, opponent, this);
	}

	@Override
	public int getEffect(int point) {
		return 10 + point;
	}
	
	public int extraEffect(int point) {
		return 2;
	}
	
	public int getRecoveryRate(int point) {
		return 2 + (point / 4);
	}
	
	public int getMaxRecovery(int point) {
		return 4000;
	}
	
	public int getStunLast(int point) {
		return 3;
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + "소비, "+getLast(point)+"턴간 체력 100%를 기준으로 " + getEffect(point) + "% 물리데미지가 증가되고 체력이 10% 낮아질때마다 +" + extraEffect(point) +
				"%씩 물리데미지 추가 증가, 또한 받은데미지의 " + getRecoveryRate(point) + "% 만큼 체력 회복(최대회복량" + getMaxRecovery(point) + ")";
	}
	
	@Override
	public void afterCalStateEffect(Adventurer adventurer) {
		if(adventurer.isAlreadyBuffed("크로스오버체인") && point >= 1) {
			int calMaxHp = adventurer.getMaxHp() / 10;
			double calEffect = getEffect(point);
			for(int i = 1; i < 10; i++) {
				if(calMaxHp * (10 - i) > adventurer.getCurHp()) {
					calEffect += extraEffect(point);
				}
			}
			calEffect = calEffect / 100.0;
			adventurer.addMinPhysicalDamage((int)(adventurer.getMinPhysicalDamage() * calEffect));
			adventurer.addMaxPhysicalDamage((int)(adventurer.getMaxPhysicalDamage() * calEffect));
		}
	}

}
