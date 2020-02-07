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
import attackImage.IceStrikeHitImage;
import attackImage.IceStrikeUse1Image;
import attackImage.IceStrikeUse2Image;
import attackImage.ShiningBusterHitImage;
import attackImage.ShiningBusterUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.BlizzardChargeSkill;
import skill.MonsterSkill;
import utils.CalUtils;

public class IceStrikeAttack extends MonsterAttack {
	public IceStrikeAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addNoDelaySkillImageThread(new IceStrikeUse1Image(hunt, attacker, opponent, null));
		addSkillImageThread(new IceStrikeUse2Image(hunt, opponent, opponent, makeAttackInfor()), new IceStrikeHitImage(hunt, opponent, opponent, null), true);
		makeFrostBiteBuff();
		afterAttack();
	}
	
	
	private void makeFrostBiteBuff() {
		int frostRate = 45 + monsterSkill.getSkillPoint() * 2;
		int frostLast = 4 + (monsterSkill.getSkillPoint() / 4);
		if(CalUtils.calPercent(frostRate)) {
			double frostDamageRate = 0.15 + (monsterSkill.getSkillPoint() * 0.05);
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("동상", frostLast, attacker.getCharacter().calMagicDamge(frostDamageRate)));
		}
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.6f + (double)monsterSkill.getSkillPoint() * 0.05f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 4; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), monsterSkill.getProperty(), 0, attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 35 + monsterSkill.getSkillPoint() * 5;
	}
	
}
