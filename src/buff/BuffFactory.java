package buff;

import attack.DamageType;
import attack.Property;
import buff.StrengthBuff.StrengthBuffType;
import character.Resistance;
import character.Strength;
import skill.ActiveSkill;
import skill.EvilEyeBuffSkill;
import skill.HyperBodySkill;
import skill.PanicSkill;
import skill.Skill;
import skill.ThreatenSkill;
import utils.DialogUtils;

public class BuffFactory {
	public static Buff makeMonsterBuff(String buffName, int skillPoint) {
		switch(buffName) {
		case "공격력강화":
			return new StrengthBuff("damageIncreasing", "공격력강화", 6 + skillPoint / 5, "물리 공격력과 마법 공격력을 일정시간 동안 강화한다.", 
					new Strength(new Resistance(), 0, 0, 0, skillPoint * 20, skillPoint * 20, 0, 0, 0, 0, 0), StrengthBuffType.SKILL_BUFF);
		case "방어력강화":
			return new StrengthBuff("guardIncreasing", "방어력강화", 6 + skillPoint / 5, "마법 방어력과 마법 방어력을 일정시간 동안 강화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, skillPoint * 20, skillPoint * 20, 0, 0, 0), StrengthBuffType.SKILL_BUFF);
		case "적중률강화":
			return new StrengthBuff("accuracyRateIncreasing", "적중률강화", 6 + skillPoint / 5, "적중률을 일정시간 동안 강화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, 0, 0, 4 + skillPoint, 0, 0), StrengthBuffType.SKILL_BUFF);
		case "회피율강화":
			return new StrengthBuff("evasionRateIncreasing", "회피율강화", 6 + skillPoint / 5, "회피율을 일정시간 동안 강화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, 0, 0, 0, 4 + skillPoint, 0), StrengthBuffType.SKILL_BUFF);
		case "공격력약화":
			return new StrengthBuff("damageDecreasing", "공격력약화", 6 + skillPoint / 5, "물리 공격력과 마법 공격력을 일정시간 동안 약화한다.", 
					new Strength(new Resistance(), 0, 0, 0, -(4 + skillPoint), -(4 + skillPoint), 0, 0, 0, 0, 0), StrengthBuffType.SKILL_BUFF);
		case "방어력약화":
			return new StrengthBuff("guardDecreasing", "방어력약화", 6 + skillPoint / 5, "마법 방어력과 마법 방어력을 일정시간 동안 약화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, -(skillPoint * 10), -(skillPoint * 10), 0, 0, 0), StrengthBuffType.SKILL_BUFF);
		case "적중률약화":
			return new StrengthBuff("accuracyRateDecreasing", "적중률약화", 6 + skillPoint / 5, "적중률을 일정시간 동안 약화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, 0, 0, -(4 + skillPoint), 0, 0), StrengthBuffType.SKILL_BUFF);
		case "회피율약화":
			return new StrengthBuff("evasionRateDecreasing", "회피율약화", 6 + skillPoint / 5, "회피율을 일정시간 동안 약화한다", 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, 0, 0, 0, -(4 + skillPoint), 0), StrengthBuffType.SKILL_BUFF);
		}
		DialogUtils.showErrorDialog("BuffFactory.makeMonsterBuff("+buffName+") 버프 생성 실패!");
		return null;
	}
	
	public static Buff makeAbnormalBuff(String buffName, int last, int damage) {
		switch(buffName) {
		case "화상":
			return new AbnormalBuff("burn", "화상", last, "일정 시간동안 화상 상태가 되어 불속성 데미지를 입는다", Property.PROPERTY_FIRE, damage, DamageType.DAMAGE_HP_TYPE);
		case "동상":
			return new AbnormalBuff("frostBite", "동상", last, "일정 시간동안 동상 상태가 되어 얼음속성 데미지를 입는다", Property.PROPERTY_ICE, damage, DamageType.DAMAGE_HP_TYPE);
		}
		DialogUtils.showErrorDialog("BuffFactory.makeAbnormalBuff("+buffName+") 버프 생성 실패!");
		return null;
	}
	
	public static Buff makeSpecialBuff(String buffName, int last) {
		switch(buffName) {
		case "스턴":
			return new SpecialBuff("stun", "스턴", last, "일정 시간 동안 기절하여 행동 불능 상태가 된다.", true);
		case "컴뱃오더스":
			return new SpecialBuff("combatOrders", "컴뱃오더스", last, "일정 시간 동안 모든 스킬래벨이 증가하고 플레임차지와 블리자드 차지의 효과가 증대된다", false);
		case "크로스오버체인":
			return new SpecialBuff("crossSurge", "크로스오버체인", last, "일정 시간 동안 HP비율에 따라 물리데미지가 증가하고 피격시 일정 데미지를 회복한다", false);
		}
		DialogUtils.showErrorDialog("BuffFactory.makeSpecialBuff("+buffName+") 버프 생성 실패!");
		return null;
	}
	
	public static Buff makeAdventurerBuff(Skill skill) {
		switch(skill.getName()) {
		case "아이언바디":
			return new StrengthBuff(skill.getImageUrl(), skill.getName(), ((ActiveSkill)skill).getLast(skill.getPoint()), skill.getInfor(), 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, skill.getEffect(skill.getPoint()), 0, 0, 0, 0), StrengthBuffType.SKILL_BUFF);
		case "분노":
			return new StrengthBuff(skill.getImageUrl(), skill.getName(), ((ActiveSkill)skill).getLast(skill.getPoint()), skill.getInfor(), 
					new Strength(new Resistance(), 0, 0, 0, skill.getEffect(skill.getPoint()), 0, 0, 0, 0, 0, 0), StrengthBuffType.SKILL_BUFF);
		case "하이퍼바디":
			return new StrengthBuff(skill.getImageUrl(), skill.getName(), ((ActiveSkill)skill).getLast(skill.getPoint()), skill.getInfor(), 
					new Strength(new Resistance(), 0, ((HyperBodySkill)skill).getCreHp(), ((HyperBodySkill)skill).getCreMp(), 0, 0, 0, 0, 0, 0, 0)
					, StrengthBuffType.SKILL_BUFF);
		case "아이언월":
			return new StrengthBuff(skill.getImageUrl(), skill.getName(), ((ActiveSkill)skill).getLast(skill.getPoint()), skill.getInfor(), 
					new Strength(new Resistance(), 0, 0, 0, 0, 0, skill.getEffect(skill.getPoint()), skill.getEffect(skill.getPoint()), 0, 0, 0)
					, StrengthBuffType.SKILL_BUFF);
		case "패닉":
			return new StrengthBuff(skill.getImageUrl(), skill.getName(), ((ActiveSkill)skill).getLast(skill.getPoint()), skill.getInfor(), 
					new Strength(new Resistance(), 0, 0, 0, -((PanicSkill)skill).getDecrePhysicalDamage(), -((PanicSkill)skill).getDecreMagicDamage()
					, 0, 0, -((PanicSkill)skill).getDecreAccuracyRate(), 0, 0), StrengthBuffType.SKILL_BUFF);
		case "위협":
			return new StrengthBuff(skill.getImageUrl(), skill.getName(), ((ActiveSkill)skill).getLast(skill.getPoint()), skill.getInfor(), 
					new Strength(new Resistance(), 0, 0, 0, -((ThreatenSkill)skill).getDecrePhysicalDamage(), -((ThreatenSkill)skill).getDecreMagicDamage()
					, -((ThreatenSkill)skill).getDecrePhysicalDefense(), -((ThreatenSkill)skill).getDecreMagicDefense(), -((ThreatenSkill)skill).getDecreAccuracyRate(), 0, 0)
					, StrengthBuffType.SKILL_BUFF);
		case "비홀더스버프":
			return new StrengthBuff(skill.getImageUrl(), skill.getName(), ((EvilEyeBuffSkill)skill).getLast(skill.getPoint()), skill.getInfor(), 
					new Strength(new Resistance(), 0, 0, 0, ((EvilEyeBuffSkill)skill).getPhysicalDamageEffect(skill.getPoint()), 0
					, ((EvilEyeBuffSkill)skill).getDefenceEffect(skill.getPoint()), ((EvilEyeBuffSkill)skill).getDefenceEffect(skill.getPoint()), 0, 0, ((EvilEyeBuffSkill)skill).getCriticalEffect(skill.getPoint()))
					, StrengthBuffType.SKILL_BUFF);
		}
		DialogUtils.showErrorDialog("BuffFactory.makeAdventurerBuff("+skill.getName()+") 버프 생성 실패!");
		return null;
	}
}
