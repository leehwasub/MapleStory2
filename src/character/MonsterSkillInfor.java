package character;

public class MonsterSkillInfor {
	
	private int percentSt;
	private int percentEd;
	private String skillName;
	private int underHpCondition;
	
	public MonsterSkillInfor(int percentSt, int percentEd, String skillName, int underHpCondition) {
		this.percentSt = percentSt;
		this.percentEd = percentEd;
		this.skillName = skillName;
		this.underHpCondition = underHpCondition;
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
	
}
