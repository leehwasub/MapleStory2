package skill;

import character.Adventurer;
import item.EquipmentItem;
import item.WeaponItem;
import item.WeaponType;

public class DivineShieldSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;
	private int divineShieldCoolTime;

	public DivineShieldSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 5 + point;
	}
	
	public int getLast(int point) {
		return 5 + (point / 4);
	}
	
	public int getEveryTurn(int point) {
		return 10 - (point / 4);
	}
	
	public int getDamageEffect(int point) {
		return 1 + (point / 2);
	}
	
	public int guardRate(int point) {
		return 10 + point;
	}

	public int getDivineShieldCoolTime() {
		return divineShieldCoolTime;
	}
	
	public void resetDivineShieldCoolTime() {
		divineShieldCoolTime = getEveryTurn(point);
	}
	
	public void setDivineShieldCoolTime(int time) {
		divineShieldCoolTime = time;
	}

	public void subDivineShieldCoolTime() {
		if(divineShieldCoolTime >= 1) {
			divineShieldCoolTime--;
		}
	}

	@Override
	public String getEffectDetail(int point) {
		return "피격시 " + guardRate(point) + "% 확률로 보호막 생성, " + getLast(point) + "턴간 지속, "
				+ "보호막 쿨타임 " + getEveryTurn(point) + "턴, 보호막 효과 : 데미지 무시 " + getEffect(point) + "%, 물리공격력 +" + getDamageEffect(point);
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		if(adventurer.isAlreadyBuffed("블레싱아머")) {
			adventurer.getStrength().addPhysicalDamage(getDamageEffect(point));
			adventurer.addIgnoreDamageRate(getEffect(point));
		}
	}

}
