package skill;

import attack.AttackType;
import attack.Property;
import utils.DialogUtils;

public class SkillFactory {
	
	public static Skill makeSkill(String skillName) {
		switch(skillName) {
		case "HP증가":
			return new HpIncreasingSkill("hpIncreasing", "HP증가", 10, "최대 HP가 영구적으로 증가한다");
		case "파워스트라이크":
			return new PowerStrikeSkill("powerStrike", "파워스트라이크", 20, "적에게 강력한 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "아이언바디":
			return new IronBodySkill("ironBody", "아이언바디", 20, "일정 시간동안 물리방어력을 강화한다", AttackType.MYSELF, Property.PROPERTY_NOTHING);
		case "검마스터리":
			return new SwordMasterySkill("swordMastery", "검마스터리", 20, "검의 숙련도와 명중률을 증가시킨다");
		case "피지컬트레이닝":
			return new SwordMasterySkill("physicalTraining", "피지컬트레이닝", 10, "STR을 영구히 증가시킨다");
		case "분노":
			return new RageSkill("rage", "분노", 20, "일정 시간동안 물리공격력을 강화한다", AttackType.MYSELF, Property.PROPERTY_NOTHING);
		case "브랜디쉬":
			return new BrandishSkill("brandish", "브랜디쉬", 20, "적에게 두번의 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "콤보어택":
			return new ComboAttackSkill("comboAttack", "콤보어택", 5, "공격시 일정 확률로 콤보어택이 생성되어 고급 기술을 사용할 수 있다. 또한 콤보 시너지와 연계하여 공격력을 증가시킬 수 있다.");
		}
		DialogUtils.showErrorDialog("SkillFactory.makeSkill("+skillName+") 새로운 스킬 생성 실패!");
		return null;
	}

}
