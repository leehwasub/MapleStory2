package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import buff.BuffFactory;
import component.StateBox;
import hunt.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class EvasionRateUpAttack extends MonsterAttack {
	
	public EvasionRateUpAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		attackMoveDelay();
		MusicUtils.startEffectSound("monsterBuff");
		attacker.getCharacter().addBuff(BuffFactory.makeMonsterBuff("회피율강화", monsterSkill.getSkillPoint()));
		this.opponent.updateStateBox(); 
		this.attacker.attackBackMotion();
		afterAttackDelay();
		wakeUpThread();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. 자신에게  회피율을 강화하는 버프를 걸었다.";
	}

	public int calNeedMp() {
		return 10 * monsterSkill.getSkillPoint();
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
}
