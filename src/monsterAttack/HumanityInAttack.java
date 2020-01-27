package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.HumanityInHitImage;
import attackImage.HumanityInUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.CalUtils;

public class HumanityInAttack extends MonsterAttack {
	public HumanityInAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new HumanityInUseImage(hunt, attacker, opponent, makeAttackInfor()), new HumanityInHitImage(hunt, opponent, opponent, null), true);
		makeThirsityBuff();
		afterAttack();
	}
	
	
	private void makeThirsityBuff() {
		int ThirsityRate = 50 + monsterSkill.getSkillPoint() * 5;
		int ThirsityLast = 4 + (monsterSkill.getSkillPoint() / 4);
		if(CalUtils.calPercent(ThirsityRate)) {
			int ThirsityDamage = 50 + monsterSkill.getSkillPoint() * 5;
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("갈증", ThirsityLast, ThirsityDamage));
		}
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.6f + (double)monsterSkill.getSkillPoint() * 0.1f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 2; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), monsterSkill.getProperty(), 0, attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 25 + monsterSkill.getSkillPoint() * 4;
	}
	
}
