package attack;

import component.StateBox;
import hunt.Hunt;
import monsterAttack.AccuracyRateDownAttack;
import monsterAttack.AccuracyRateUpAttack;
import monsterAttack.DamageDownAttack;
import monsterAttack.DamageUpAttack;
import monsterAttack.DefenceDownAttack;
import monsterAttack.DefenceUpAttack;
import monsterAttack.EvasionRateDownAttack;
import monsterAttack.EvasionRateUpAttack;
import monsterAttack.FlashAttack;
import monsterAttack.MonsterAttack;
import monsterAttack.SwordAttack;
import monsterAttack.TackleAttack;
import playerAttack.NormalAttack;
import playerAttack.PlayerAttack;
import skill.MonsterSkill;
import skill.NormalSkill;
import utils.DialogUtils;

public class AttackFactory {
	public static MonsterAttack makeMonsterAttack(Hunt hunt, StateBox attacker, StateBox opponents, String attackName,
			int skillPoint) {
		switch (attackName) {
		case "몸통박치기":
			return new TackleAttack(hunt, attacker, opponents, new MonsterSkill("몸통박치기", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "플래쉬":
			return new FlashAttack(hunt, attacker, opponents, new MonsterSkill("플래쉬", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "공격력강화":
			return new DamageUpAttack(hunt, attacker, opponents, new MonsterSkill("공격력강화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "방어력강화":
			return new DefenceUpAttack(hunt, attacker, opponents, new MonsterSkill("방어력강화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "적중률강화":
			return new AccuracyRateUpAttack(hunt, attacker, opponents, new MonsterSkill("적중률강화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "회피율강화":
			return new EvasionRateUpAttack(hunt, attacker, opponents, new MonsterSkill("회피율강화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "공격력약화":
			return new DamageDownAttack(hunt, attacker, opponents, new MonsterSkill("공격력약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "방어력약화":
			return new DefenceDownAttack(hunt, attacker, opponents, new MonsterSkill("방어력약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "적중률약화":
			return new AccuracyRateDownAttack(hunt, attacker, opponents, new MonsterSkill("적중률약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "회피율약화":
			return new EvasionRateDownAttack(hunt, attacker, opponents, new MonsterSkill("회피율약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "베기":
			return new SwordAttack(hunt, attacker, opponents, new MonsterSkill("베기", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		}
		DialogUtils.showErrorDialog("AttackFactory.makeMonsterAttack("+attackName+") 몬스터 공격 실패!");
		return null;
	}
	
	public static PlayerAttack makeAdventurerAttack(Hunt hunt, StateBox attacker, StateBox opponents, String attackName,
			int skillPoint) {
		switch (attackName) {
		case "일반공격":
			return new NormalAttack(hunt, attacker, opponents, new NormalSkill(null, "일반공격", 0, "일반공격이다.", AttackType.OPPONENT, Property.PROPERTY_NOTHING));
		}
		DialogUtils.showErrorDialog("AttackFactory.makeAdventurerAttack(...) 플레이어 공격 실패!");
		return null;
	}
	
}
