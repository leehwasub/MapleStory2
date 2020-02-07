package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.BlizzardHitImage;
import attackImage.BlizzardUseImage;
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

public class BlizzardAttack extends MonsterAttack {
	public BlizzardAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		//70 -100
		for(int i = 0; i < 6; i++) {
			int delay = 100 + (int)(Math.random() * 140);
			int modifyX = (int)(Math.random() * 140);
			int modifyY = (int)(Math.random() * 140);
			addSkillImageThread(new BlizzardUseImage(hunt, opponent, opponent, makeAttackInfor(), modifyX, -170 + modifyY), new BlizzardHitImage(hunt, opponent, opponent, null), true, delay);
		}
		sleep(new BlizzardUseImage(hunt, opponent, opponent, makeAttackInfor(), 0, 0).getTotalDelay());
		makeFrostBiteBuff();
		afterAttack();
	}
	
	
	private void makeFrostBiteBuff() {
		int frostRate = 60 + monsterSkill.getSkillPoint() * 2;
		int frostLast = 4 + (monsterSkill.getSkillPoint() / 4);
		if(CalUtils.calPercent(frostRate)) {
			double frostDamageRate = 0.2 + (monsterSkill.getSkillPoint() * 0.05);
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("동상", frostLast, attacker.getCharacter().calMagicDamge(frostDamageRate)));
		}
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.7f + (double)monsterSkill.getSkillPoint() * 0.05f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), monsterSkill.getProperty(), 0, attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 70 + monsterSkill.getSkillPoint() * 7;
	}
	
}
