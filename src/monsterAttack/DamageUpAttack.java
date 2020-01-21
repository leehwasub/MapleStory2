package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class DamageUpAttack extends MonsterAttack {
	
	public DamageUpAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		attackMoveDelay();
		MusicUtils.startEffectSound("monsterBuff");
		attacker.getCharacter().addBuff(BuffFactory.makeMonsterBuff("공격력강화", monsterSkill.getSkillPoint()));
		this.opponent.updateStateBox(); 
		this.attacker.attackBackMotion();
		afterAttackDelay();
		wakeUpThread();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. 자신에게  물리, 마법공격력을 강화하는 버프를 걸었다.";
	}

	public int calNeedMp() {
		return 10 + monsterSkill.getSkillPoint() * 3;
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
}
