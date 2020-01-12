package attack;

import component.StateBox;
import hunt.Hunt;
import monsterAttack.FlashAttack;
import monsterAttack.MonsterAttack;
import monsterAttack.PhysicalDamageUpAttack;
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
			return new PhysicalDamageUpAttack(hunt, attacker, opponents, new MonsterSkill("공격력강화", Property.PROPERTY_NOTHING, skillPoint, AttackType.MYSELF));
		}
		DialogUtils.showErrorDialog("AttackFactory.makeMonsterAttack(...) 몬스터 공격 실패!");
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
