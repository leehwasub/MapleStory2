package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class EvasionRateDownAttack extends MonsterAttack {
	
	public EvasionRateDownAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		attackMoveDelay();
		MusicUtils.startEffectSound("monsterBuff");
		opponent.getCharacter().addBuff(BuffFactory.makeMonsterBuff("회피율약화", monsterSkill.getSkillPoint()));
		this.opponent.updateStateBox(); 
		afterAttack();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 적중률을 약화하는 버프를 걸었다.";
	}

	public int calNeedMp() {
		return 10 + monsterSkill.getSkillPoint() * 3;
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
}
