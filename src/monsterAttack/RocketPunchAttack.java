package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.AdvancedFlameShootBallMovableImage;
import attackImage.AdvancedFlameShootHitImage;
import attackImage.AdvancedFlameShootUseImage;
import attackImage.MassiveFireBallMovableImage;
import attackImage.MassiveFireHitImage;
import attackImage.MassiveFireUseImage;
import attackImage.RocketPunchBallMovableImage;
import attackImage.RocketPunchHitImage;
import attackImage.RocketPunchUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.CalUtils;

public class RocketPunchAttack extends MonsterAttack {
	public RocketPunchAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new RocketPunchUseImage(hunt, attacker, opponent, null), true, 360);
		addSkillImageThread(new RocketPunchBallMovableImage(hunt, attacker, opponent, makeAttackInfor()), new RocketPunchHitImage(hunt, opponent, opponent, null), true);
		makeStunBuff();
		afterAttack();
	}
	
	private void makeStunBuff() {
		int stunRate = 40 + monsterSkill.getSkillPoint() * 3;
		int stunLast = 2 + (monsterSkill.getSkillPoint() / 11);
		if(CalUtils.calPercent(stunRate)) {
			opponent.getCharacter().addBuff(BuffFactory.makeSpecialBuff("스턴", stunLast));
		}
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		double percent = 1.6f + (double)monsterSkill.getSkillPoint() * 0.1f;
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), monsterSkill.getProperty(), attacker.getCharacter().calNormalDamge(percent), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + monsterSkill.getAttackName() + "을 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 30 + monsterSkill.getSkillPoint() * 4;
	}
	
}
