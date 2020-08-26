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
import attackImage.GenesisHitImage;
import attackImage.GenesisUse1Image;
import attackImage.GenesisUse2Image;
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

public class GenesisAttack extends MonsterAttack {
	public GenesisAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		//70 -100
		addNoDelaySkillImageThread(new GenesisUse1Image(hunt, attacker, opponent, null));
		for(int i = 0; i < 6; i++) {
			int delay = 70 + (int)(Math.random() * 100);
			int modifyX = (int)(Math.random() * 600);
			int modifyY = (int)(Math.random() * 100);
			addSkillImageThread(new GenesisUse2Image(hunt, opponent, opponent, makeAttackInfor(), -300 + modifyX, -120 + modifyY), new GenesisHitImage(hunt, opponent, opponent, null), true, delay);
		}
		sleep(new GenesisUse2Image(hunt, opponent, opponent, makeAttackInfor(), 0, 0).getTotalDelay());
		afterAttack();
	}

	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 1.1f + (double)monsterSkill.getSkillPoint() * 0.1f;
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
		return 200 + monsterSkill.getSkillPoint() * 30;
	}
	
}
