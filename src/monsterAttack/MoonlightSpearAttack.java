package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.BatSweamHitImage;
import attackImage.BatSweamMovableImage;
import attackImage.BatSweamUseImage;
import attackImage.MoonlightSpearHit1Image;
import attackImage.MoonlightSpearHit2Image;
import attackImage.MoonlightSpearHit3Image;
import attackImage.MoonlightSpearUseImage;
import attackImage.SkillImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;

public class MoonlightSpearAttack extends MonsterAttack {
	public MoonlightSpearAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addMutlipleMovableSkillImageThread(new MoonlightSpearUseImage(hunt, attacker, opponent, null)
				, makeHitImageList(), null, 300, true);
		afterAttack();
	}
	
	public ArrayList<SkillImage> makeHitImageList() {
		ArrayList<SkillImage> ret = new ArrayList<SkillImage>();
		ret.add(new MoonlightSpearHit1Image(hunt, opponent, opponent, makeAttackInfor()));
		ret.add(new MoonlightSpearHit2Image(hunt, opponent, opponent, makeAttackInfor()));
		ret.add(new MoonlightSpearHit3Image(hunt, opponent, opponent, makeAttackInfor()));
		return ret;
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 1.0f + (double)monsterSkill.getSkillPoint() * 0.1f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), monsterSkill.getProperty(), this.attacker.getCharacter().calNormalDamge(percent), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 50 + monsterSkill.getSkillPoint() * 8;
	}
	
}
