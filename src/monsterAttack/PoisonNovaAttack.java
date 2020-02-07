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
import attackImage.PoisonNovaHitImage;
import attackImage.PoisonNovaUseImage;
import attackImage.SwordHitImage;
import attackImage.SwordUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import skill.ShoutSkill;
import utils.CalUtils;

public class PoisonNovaAttack extends MonsterAttack {
	
	public PoisonNovaAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new PoisonNovaUseImage(hunt, opponent, opponent, makeAttackInfor()), new PoisonNovaHitImage(hunt, opponent, opponent, null), true);
		makePoisonBuff();
		afterAttack();
	}
	
	private void makePoisonBuff() {
		int poisonRate = 70 + monsterSkill.getSkillPoint() * 3;
		int poisonLast = 6 + (monsterSkill.getSkillPoint() / 4);
		if(CalUtils.calPercent(poisonRate)) {
			double burnDamageRate = 0.3 + (monsterSkill.getSkillPoint() * 0.07);
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("중독", poisonLast, attacker.getCharacter().calMagicDamge(burnDamageRate)));
		}
	}
	
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.9f + (double)monsterSkill.getSkillPoint() * 0.05f;
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
