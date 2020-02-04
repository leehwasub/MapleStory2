package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.ChainLightningHitImage;
import attackImage.ChainLightningUseImage;
import attackImage.CombatSwitchingUseImage;
import attackImage.FlameBiteHitImage;
import attackImage.FlameBiteUseImage;
import attackImage.SwordHitImage;
import attackImage.SwordUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import skill.ShoutSkill;
import utils.CalUtils;

public class FlameBiteAttack extends MonsterAttack {
	
	public FlameBiteAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new FlameBiteUseImage(hunt, attacker, opponent, makeAttackInfor()), new FlameBiteHitImage(hunt, opponent, opponent, null), true);
		makeBurnBuff();
		afterAttack();
	}
	
	private void makeBurnBuff() {
		int burnRate = 30 + monsterSkill.getSkillPoint() * 3;
		int burnLast = 5 + (monsterSkill.getSkillPoint() / 4);
		if(CalUtils.calPercent(burnRate)) {
			double burnDamageRate = 0.2 + (monsterSkill.getSkillPoint() * 0.05);
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("화상", burnLast, attacker.getCharacter().calMagicDamge(burnDamageRate)));
		}
	}
	
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 1.0f + (double)monsterSkill.getSkillPoint() * 0.05f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 3; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), monsterSkill.getProperty(), 0, attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 40 + monsterSkill.getSkillPoint() * 7;
	}

}
