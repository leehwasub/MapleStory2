package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.AdvancedFlameShootBallMovableImage;
import attackImage.AdvancedFlameShootHitImage;
import attackImage.AdvancedFlameShootUseImage;
import attackImage.PoisonBreathBallMovableImage;
import attackImage.PoisonBreathHitImage;
import attackImage.PoisonBreathUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.CalUtils;

public class PoisonBreathAttack extends MonsterAttack {
	public PoisonBreathAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new PoisonBreathUseImage(hunt, attacker, opponent, null), true);
		addSkillImageThread(new PoisonBreathBallMovableImage(hunt, attacker, opponent, makeAttackInfor()), new PoisonBreathHitImage(hunt, opponent, opponent, null), true);
		makePoisonBuff();
		afterAttack();
	}
	
	
	private void makePoisonBuff() {
		int poisonRate = 50 + monsterSkill.getSkillPoint() * 2;
		int poisonLast = 4 + (monsterSkill.getSkillPoint() / 4);
		if(CalUtils.calPercent(poisonRate)) {
			double poisonDamageRate = 0.2 + (monsterSkill.getSkillPoint() * 0.07);
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("중독", poisonLast, attacker.getCharacter().calMagicDamge(poisonDamageRate)));
		}
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		double percent = 1.2f + (double)monsterSkill.getSkillPoint() * 0.1f;
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), monsterSkill.getProperty(), 0, this.attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 25 + monsterSkill.getSkillPoint() * 5;
	}
	
}
