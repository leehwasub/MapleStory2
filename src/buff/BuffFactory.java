package buff;

import attack.Property;
import character.Resistance;
import character.Strength;
import skill.ActiveSkill;
import skill.Skill;
import skill.HyperBodySkill;
import utils.DialogUtils;

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
		DialogUtils.showErrorDialog("BuffFactory.makeMonsterBuff("+buffName+") 버프 생성 실패!");
		return null;
	}
	
	public static Buff makeAbnormalBuff(String buffName, int last, int damage) {
		switch(buffName) {
		case "화상":
			return new AbnormalBuff("burn", "화상", last, "일정 시간동안 화상 상태가 되어 불속성 데미지를 입는다", Property.PROPERTY_FIRE, damage);
		}
		DialogUtils.showErrorDialog("BuffFactory.makeAbnormalBuff("+buffName+") 버프 생성 실패!");
		return null;
	}
	
	public static Buff makeAdventurerBuff(Skill skill) {
		switch(skill.getName()) {
		case "아이언바디":
			return new StrengthBuff(skill.getImageUrl(), skill.getName(), ((ActiveSkill)skill).getLast(skill.getPoint()), skill.getInfor(), 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, skill.getEffect(skill.getPoint()), 0, 0, 0, 0));
		case "분노":
			return new StrengthBuff(skill.getImageUrl(), skill.getName(), ((ActiveSkill)skill).getLast(skill.getPoint()), skill.getInfor(), 
					new Strength(new Resistance(), 0, 0, 0, skill.getEffect(skill.getPoint()), 0, 0, 0, 0, 0, 0));
		case "하이퍼바디":
			return new StrengthBuff(skill.getImageUrl(), skill.getName(), ((ActiveSkill)skill).getLast(skill.getPoint()), skill.getInfor(), 
					new Strength(new Resistance(), 0, ((HyperBodySkill)skill).getCreHp(), ((HyperBodySkill)skill).getCreMp(), 0, 0, 0, 0, 0, 0, 0));
		case "아이언월":
			return new StrengthBuff(skill.getImageUrl(), skill.getName(), ((ActiveSkill)skill).getLast(skill.getPoint()), skill.getInfor(), 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, skill.getEffect(skill.getPoint()), skill.getEffect(skill.getPoint()), 0, 0, 0));
		}
		DialogUtils.showErrorDialog("BuffFactory.makeAdventurerBuff("+skill.getName()+") 버프 생성 실패!");
		return null;
	}
}
