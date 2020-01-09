package skill;

public class SkillFactory {
	
	public static Skill makeSkill(String skillName) {
		switch(skillName) {
		case "HP증가":
			return new HpIncreasingSkill("hpIncreasing", "HP증가", 10, "최대 HP가 영구적으로 증가한다");
		case "파워스트라이크":
			return new PowerStrikeSkill("powerStrike", "파워스트라이크", 20, "적에게 강력한 일격을 가한다");
		case "아이언바디":
			return new ironBodySkill("ironBody", "아이언바디", 20, "일정 시간동안 물리방어력을 강화한다");
		}
		return null;
	}

}
