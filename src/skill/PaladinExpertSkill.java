package skill;

import character.Adventurer;

public class PaladinExpertSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;

	public PaladinExpertSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 1 + (point / 10);
	}
	
	public int getCriticalRateEffect(int point) {
		return 10 + point;
	}
	
	public int getCriticalDamageEffect(int point) {
		return 10 + point;
	}
	
	public int getDefenceEffect(int point) {
		return point * 10;
	}
	
	public int getProficiencyEffect(int point) {
		return 15 + (point / 2);
	}

	@Override
	public String getEffectDetail(int point) {
		return "영구적으로 무기 숙련도 +" + getProficiencyEffect(point) + ", 물리마법 방어력 +" + getDefenceEffect(point) + ", 크리티컬확률 +" + getCriticalRateEffect(point) + "%, 크리티컬 데미지 +" + getCriticalDamageEffect(point) + "%";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		if(point >= 1) {
			adventurer.addProficiency(getProficiencyEffect(point));
			adventurer.addCriticalExtraDamageRate(getCriticalDamageEffect(point));
			adventurer.getStrength().addCriticalRate(getCriticalRateEffect(point));
			adventurer.getStrength().addMagicDefense(getDefenceEffect(point));
			adventurer.getStrength().addPhysicalDefense(getDefenceEffect(point));
		}
	}

}
