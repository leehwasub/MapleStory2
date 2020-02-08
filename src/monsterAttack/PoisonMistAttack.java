package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.PoisonMistUseImage;
import attackImage.ShadowShellUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.CalUtils;
import utils.MusicUtils;

public class PoisonMistAttack extends MonsterAttack {
	
	public PoisonMistAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new PoisonMistUseImage(hunt, attacker, opponent,  makeAttackInfor()), true);
		makePosionBuff();
		afterAttack();
	}
	
	private void makePosionBuff() {
		int posionRate = 70 + monsterSkill.getSkillPoint() * 2;
		int posionLast = 5 + (monsterSkill.getSkillPoint() / 3);
		if(CalUtils.calPercent(posionRate)) {
			double burnDamageRate = 0.4 + (monsterSkill.getSkillPoint() * 0.08);
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("중독", posionLast, attacker.getCharacter().calMagicDamge(burnDamageRate)));
		}
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 35 + monsterSkill.getSkillPoint() * 4;
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		double percent = 0.9f + (double)monsterSkill.getSkillPoint() * 0.1f;
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), monsterSkill.getProperty(), 0, this.attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}
	
}
