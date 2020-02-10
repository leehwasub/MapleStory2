package skill;

import character.Adventurer;

public class ElementalChargeSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;
	private static final int MAX_COMBO_NUM = 5;
	private int chargeNum;

	public ElementalChargeSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 8 * point;
	}
	
	public int resistenceEffect(int point) {
		return 1 + (point / 2);
	}
	
	public int recoveryEffect(int point) {
		return 1;
	}
	
	public int ignoreDamageEffect(int point) {
		return 1 + (point / 5);
	}
	
	public int damageEffect(int point) {
		return 1 + (point / 10);
	}

	@Override
	public String getEffectDetail(int point) {
		return "차지 스킬을 사용한 이후 곧바로 다른 차지스킬을 사용할 경우 1개의 앨리멘트 차지를 얻는다. 차지 1개당 턴마다"+ recoveryEffect(point) +"% 체력회복, "
				+ "물리 공격력 +"+ damageEffect(point) +", 모든 상태저항 +"+resistenceEffect(point) +", 데미지 무시 +" + ignoreDamageEffect(point) + "%";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		adventurer.getStrength().addPhysicalDamage(damageEffect(point) * chargeNum);
		adventurer.getStrength().getResistance().addAllResistance(resistenceEffect(point) * chargeNum);
		adventurer.addIgnoreDamageRate(ignoreDamageEffect(point) * chargeNum);
	}
	
	public boolean isHaveMaxChargeNum() {
		return (chargeNum == MAX_COMBO_NUM);
	}
	
	/**
	 * 
	 * @param 몇개이상?
	 * @return num개이상 콤보어택을 가지고 있는지
	 */
	public boolean isHaveChargeNum(int num) {
		return chargeNum >= num;
	}

	public int getChargeNum() {
		return chargeNum;
	}
	
	public void addChargeNum() {
		this.chargeNum += 1;
	}
	
	public void subChargeNum() {
		this.chargeNum -= 1;
	}

	public void setChargeNum(int chargeNum) {
		this.chargeNum = chargeNum;
	}

}
