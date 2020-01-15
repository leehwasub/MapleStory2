package skill;

import character.Adventurer;

public class ComboAttackSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;
	private static final int MAX_COMBO_NUM = 5;
	private int comboNum;

	public ComboAttackSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 8 * point;
	}

	@Override
	public String getEffectDetail(int point) {
		return "공격시 "+ getEffect(point) +"% 확률로 콤보어택 생성, 최대 5개 충전 가능";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		
	}
	
	public boolean isHaveMaxComboNum() {
		return (comboNum == MAX_COMBO_NUM);
	}
	
	/**
	 * 
	 * @param 몇개이상?
	 * @return num개이상 콤보어택을 가지고 있는지
	 */
	public boolean isHaveComboNum(int num) {
		return comboNum >= num;
	}

	public int getComboNum() {
		return comboNum;
	}
	
	public void addComboNum() {
		this.comboNum += 1;
	}
	
	public void subComboNum() {
		this.comboNum -= 1;
	}

	public void setComboNum(int comboNum) {
		this.comboNum = comboNum;
	}

}
