package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.ColdBeamHitImage;
import attackImage.ColdBeamUseImage;
import attackImage.FlashBallMovableImage;
import attackImage.FlashHitImage;
import attackImage.FlashUseImage;
import attackImage.ShiningBusterHitImage;
import attackImage.ShiningBusterUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.BlizzardChargeSkill;
import skill.MonsterSkill;
import utils.CalUtils;

public class ColdBeamAttack extends MonsterAttack {
	public ColdBeamAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new ColdBeamUseImage(hunt, opponent, opponent, makeAttackInfor()), new ColdBeamHitImage(hunt, opponent, opponent, null), true);
		makeFrostBiteBuff();
		afterAttack();
	}
	
	
	private void makeFrostBiteBuff() {
		int frostRate = 20 + monsterSkill.getSkillPoint() * 2;
		int frostLast = 4 + (monsterSkill.getSkillPoint() / 4);
		if(CalUtils.calPercent(frostRate)) {
			double frostDamageRate = 0.1 + (monsterSkill.getSkillPoint() * 0.05);
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("동상", frostLast, attacker.getCharacter().calMagicDamge(frostDamageRate)));
		}
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.5f + (double)monsterSkill.getSkillPoint() * 0.05f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 3; i++) {
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
