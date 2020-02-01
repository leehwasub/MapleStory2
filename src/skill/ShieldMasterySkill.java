package skill;

import character.Adventurer;
import item.EquipmentItem;
import item.WeaponItem;
import item.WeaponType;

public class ShieldMasterySkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public ShieldMasterySkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 10 + (point * 2);
	}
	
	public int getDefenseUpRate(int point) {
		return 100 + (point * 15);
	}
	
	public int getDamageEffect(int point) {
		return 1 + point;
	}
	
	public int guardRate(int point) {
		return 10 + point;
	}
	
	public int stunRate(int point) {
		return 15 + point;
	}
	
	public int stunTurn(int point) {
		return 2;
	}

	@Override
	public String getEffectDetail(int point) {
		return "방패 착용시 모든 속성 저항 +"+ getEffect(point) + ", 방패 무기의 방어력 " + getDefenseUpRate(point) + "% 증가, 물리 공격력 +" + getDamageEffect(point)
				+ ", " + guardRate(point) + "% 확률로 적 공격 방어, 방어시 " + stunRate(point) + "% 확률로 " + stunTurn(point) + "턴간 적 스턴";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		EquipmentItem shieldItem = (EquipmentItem)adventurer.getWearEquipmentByIndex(EquipmentItem.EQUIPMENT_TYPE_SHIELD);
		if(shieldItem != null) {
			adventurer.getStrength().getResistance().addAllResistance(getEffect(point));
			double defenseRate = ((getDefenseUpRate(point) - 100) / 100.0);
			adventurer.getStrength().addPhysicalDefense((int)(shieldItem.getStrength().getPhysicalDefense() * defenseRate));
			adventurer.getStrength().addMagicDefense((int)(shieldItem.getStrength().getMagicDefense() * defenseRate));
			adventurer.getStrength().addPhysicalDamage(getDamageEffect(point));
		}
	}

}
