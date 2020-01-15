package character;

public class MonsterSkillInfor {
	
	private int percentSt;
	private int percentEd;
	private String skillName;
	private int underHpCondition;
	private int skillPoint;
	
	/**
	 * 
	 * @param percentSt 퍼센트 최소
	 * @param percentEd 퍼센트 최대
	 * @param skillName 스킬 이름
	 * @param underHpCondition 체력 조건(이보다 낮을시 발동)
	 * @param skillPoint 스킬포인트
	 */
	public MonsterSkillInfor(int percentSt, int percentEd, String skillName, int underHpCondition, int skillPoint) {
		this.percentSt = percentSt;
		this.percentEd = percentEd;
		this.skillName = skillName;
		this.underHpCondition = underHpCondition;
		this.skillPoint = skillPoint;
	}
	
	public int getPercentSt() {
		return percentSt;
	}
	public int getPercentEd() {
		return percentEd;
	}
	public String getSkillName() {
		return skillName;
	}
	public int getUnderHpCondition() {
		return underHpCondition;
	}
	public void setPercentSt(int percentSt) {
		this.percentSt = percentSt;
	}
	public void setPercentEd(int percentEd) {
		this.percentEd = percentEd;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public void setUnderHpCondition(int underHpCondition) {
		this.underHpCondition = underHpCondition;
	}
	public int getSkillPoint() {
		return skillPoint;
	}
	public void setSkillPoint(int skillPoint) {
		this.skillPoint = skillPoint;
	}
	
}
