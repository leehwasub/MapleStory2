package attack;

import component.StateBox;
import hunt.HuntComponent.Hunt;
import monsterAttack.AccuracyRateDownAttack;
import monsterAttack.AccuracyRateUpAttack;
import monsterAttack.AdvancedFlameShootAttack;
import monsterAttack.BatSweamAttack;
import monsterAttack.BlowBeastAttack;
import monsterAttack.ColdBeamAttack;
import monsterAttack.DamageDownAttack;
import monsterAttack.DamageUpAttack;
import monsterAttack.DefenceDownAttack;
import monsterAttack.DefenceUpAttack;
import monsterAttack.DevilScytheAttack;
import monsterAttack.DoubleSlashAttack;
import monsterAttack.EvasionRateDownAttack;
import monsterAttack.EvasionRateUpAttack;
import monsterAttack.FlameShootAttack;
import monsterAttack.FlashAttack;
import monsterAttack.HpHealAttack;
import monsterAttack.MonsterAttack;
import monsterAttack.MoonlightSpearAttack;
import monsterAttack.ShadowShellAttack;
import monsterAttack.ShiningBusterAttack;
import monsterAttack.SkillLockAttack;
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
			return new DamageDownAttack(hunt, attacker, opponents, new MonsterSkill("공격력약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "방어력약화":
			return new DefenceDownAttack(hunt, attacker, opponents, new MonsterSkill("방어력약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "적중률약화":
			return new AccuracyRateDownAttack(hunt, attacker, opponents, new MonsterSkill("적중률약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "회피율약화":
			return new EvasionRateDownAttack(hunt, attacker, opponents, new MonsterSkill("회피율약화", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "베기":
			return new SwordAttack(hunt, attacker, opponents, new MonsterSkill("베기", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "더블슬래쉬":
			return new DoubleSlashAttack(hunt, attacker, opponents, new MonsterSkill("더블슬래쉬", Property.PROPERTY_DARK, skillPoint, AttackType.OPPONENT));
		case "플레임샷":
			return new FlameShootAttack(hunt, attacker, opponents, new MonsterSkill("플레임샷", Property.PROPERTY_FIRE, skillPoint, AttackType.OPPONENT));
		case "안티매직쉘":
			return new ShadowShellAttack(hunt, attacker, opponents, new MonsterSkill("안티매직쉘", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "데빌사이더":
			return new DevilScytheAttack(hunt, attacker, opponents, new MonsterSkill("데빌사이더", Property.PROPERTY_DARK, skillPoint, AttackType.OPPONENT));
		case "스킬잠금":
			return new SkillLockAttack(hunt, attacker, opponents, new MonsterSkill("스킬잠금", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "샤이닝버스터":
			return new ShiningBusterAttack(hunt, attacker, opponents, new MonsterSkill("샤이닝버스터", Property.PROPARTY_HOLY, skillPoint, AttackType.OPPONENT));
		case "체력회복":
			return new HpHealAttack(hunt, attacker, opponents, new MonsterSkill("체력회복", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		case "콜드빔":
			return new ColdBeamAttack(hunt, attacker, opponents, new MonsterSkill("콜드빔", Property.PROPERTY_ICE, skillPoint, AttackType.OPPONENT));
		case "맹수의일격":
			return new BlowBeastAttack(hunt, attacker, opponents, new MonsterSkill("맹수의일격", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT));
		case "강화된플레임샷":
			return new AdvancedFlameShootAttack(hunt, attacker, opponents, new MonsterSkill("강화된플레임샷", Property.PROPERTY_FIRE, skillPoint, AttackType.OPPONENT));
		case "베츠스웜":
			return new BatSweamAttack(hunt, attacker, opponents, new MonsterSkill("베츠스웜", Property.PROPERTY_DARK, skillPoint, AttackType.OPPONENT));
		case "녹스피어":
			return new MoonlightSpearAttack(hunt, attacker, opponents, new MonsterSkill("녹스피어", Property.PROPERTY_DARK, skillPoint, AttackType.OPPONENT));
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
