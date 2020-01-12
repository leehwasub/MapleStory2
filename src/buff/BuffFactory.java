package buff;

import attack.Property;
import character.Resistance;
import character.Strength;
import skill.Skill;

public class BuffFactory {
	public static Buff makeMonsterBuff(String buffName, int skillPoint) {
		switch(buffName) {
		case "공격력강화":
			return new StrengthBuff("damageIncreasing", "공격력강화", 6 + skillPoint / 5, "물리 공격력과 마법 공격력을 일정시간 동안 강화한다.", 
					new Strength(new Resistance(), 0, 0, 0, skillPoint * 20, skillPoint * 20, 0, 0, 0, 0, 0));
		case "방어력강화":
			return new StrengthBuff("guardIncreasing", "방어력강화", 6 + skillPoint / 5, "마법 방어력과 마법 방어력을 일정시간 동안 강화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, skillPoint * 20, skillPoint * 20, 0, 0, 0));
		case "적중률강화":
			return new StrengthBuff("accuracyRateIncreasing", "적중률강화", 6 + skillPoint / 5, "적중률을 일정시간 동안 강화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, 0, 0, 4 + skillPoint, 0, 0));
		case "회피율강화":
			return new StrengthBuff("evasionRateIncreasing", "회피율강화", 6 + skillPoint / 5, "회피율을 일정시간 동안 강화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, 0, 0, 0, 4 + skillPoint, 0));
		case "공격력약화":
			return new StrengthBuff("damageDecreasing", "공격력약화", 6 + skillPoint / 5, "물리 공격력과 마법 공격력을 일정시간 동안 약화한다.", 
					new Strength(new Resistance(), 0, 0, 0, -(4 + skillPoint), -(4 + skillPoint), 0, 0, 0, 0, 0));
		case "방어력약화":
			return new StrengthBuff("guardDecreasing", "방어력약화", 6 + skillPoint / 5, "마법 방어력과 마법 방어력을 일정시간 동안 약화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, -(skillPoint * 10), -(skillPoint * 10), 0, 0, 0));
		case "적중률약화":
			return new StrengthBuff("accuracyRateDecreasing", "적중률약화", 6 + skillPoint / 5, "적중률을 일정시간 동안 약화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, 0, 0, -(4 + skillPoint), 0, 0));
		case "회피율약화":
			return new StrengthBuff("evasionRateDecreasing", "회피율약화", 6 + skillPoint / 5, "회피율을 일정시간 동안 약화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, 0, 0, 0, -(4 + skillPoint), 0));
		}
		return null;
		
	}
	
	public static Buff makeAdventurerBuff(Skill skill) {
		switch(skill.getName()) {
		
		}
		return null;
	}
}
