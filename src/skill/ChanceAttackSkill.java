package skill;

import character.Adventurer;
import item.EquipmentItem;
import item.WeaponItem;
import item.WeaponType;

public class ChanceAttackSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public ChanceAttackSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 5 + (point * 2);
	}
	
	public int accuracyEffect(int point) {
		return point;
	}

	@Override
	public String getEffectDetail(int point) {
		return "크리티컬 확률 +" + getEffect(point) + "%, 명중률 +" + accuracyEffect(point);
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		if(point >= 1) {
			adventurer.getStrength().addAccuracyRate(accuracyEffect(point));
			adventurer.getStrength().addCriticalRate(getEffect(point));
		}
	}

}
