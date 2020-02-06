package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.AdvancedFlameShootBallMovableImage;
import attackImage.AdvancedFlameShootHitImage;
import attackImage.AdvancedFlameShootUseImage;
import attackImage.BlazingExtinctionBallMovableImage;
import attackImage.BlazingExtinctionHitImage;
import attackImage.BlazingExtinctionUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.CalUtils;

public class BlazingExtinctionAttack extends MonsterAttack {
	public BlazingExtinctionAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new BlazingExtinctionUseImage(hunt, attacker, opponent, null), true, 1080);
		addSkillImageThread(new BlazingExtinctionBallMovableImage(hunt, attacker, opponent, makeAttackInfor()), new BlazingExtinctionHitImage(hunt, opponent, opponent, null), true);
		makeBurnBuff();
		afterAttack();
	}
	
	
	private void makeBurnBuff() {
		int burnRate = 70 + monsterSkill.getSkillPoint() * 2;
		int burnLast = 7 + (monsterSkill.getSkillPoint() / 4);
		if(CalUtils.calPercent(burnRate)) {
			double burnDamageRate = 0.3 + (monsterSkill.getSkillPoint() * 0.07);
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("화상", burnLast, attacker.getCharacter().calMagicDamge(burnDamageRate)));
		}
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		double percent = 2.6f + (double)monsterSkill.getSkillPoint() * 0.1f;
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), monsterSkill.getProperty(), 0, this.attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 80 + monsterSkill.getSkillPoint() * 8;
	}
	
}
