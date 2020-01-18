package skill;

import character.Adventurer;

public class ComboSynergySkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;
	private static final int MAX_COMBO_NUM = 5;

	public ComboSynergySkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 2 * point;
	}
	
	public int getDamageEffect(int point) {
		return 1 + (point / 5);
	}

	@Override
	public String getEffectDetail(int point) {
		return "공격시 콤보어택 생성확률 추가 + "+ getEffect(point) +"%, 콤보 어택 한개당 물리데미지 +" + getDamageEffect(point) + "%";
	}
	
	@Override
	public void afterCalStateEffect(Adventurer adventurer) {
		double increRate = (double)getDamageEffect(point) / 100.0;
		
		ComboAttackSkill comboAttackSkill = (ComboAttackSkill)adventurer.getSkillWithName("콤보어택");
		ComboSynergySkill comboSynergySkill = (ComboSynergySkill)adventurer.getSkillWithName("콤보시너지");
		if(comboAttackSkill != null && comboAttackSkill.getComboNum() >= 1
				&& comboSynergySkill != null && comboSynergySkill.getPoint() >= 1) {
			increRate = increRate * comboAttackSkill.getComboNum();
			adventurer.addMinPhysicalDamage((int)(adventurer.getMinPhysicalDamage() * increRate));
			adventurer.addMaxPhysicalDamage((int)(adventurer.getMaxPhysicalDamage() * increRate));
		}
	}
	
	@Override
	public String requiredSkillInfor() {
		return "선행 스킬 : 콤보어택 마스터";
	}
	
	@Override
	public boolean isCanUpgrade(Adventurer adventurer) {
		PassiveSkill comboAttackSkill = (PassiveSkill)adventurer.getSkillWithName("콤보어택");
		if(comboAttackSkill == null || comboAttackSkill.getPoint() < 5) return false;
		return true;
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		
	}
	

}
