package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.BatSweamHitImage;
import attackImage.BatSweamMovableImage;
import attackImage.BatSweamUseImage;
import attackImage.DoubleShootBallMovableImage;
import attackImage.DoubleShootHitImage;
import attackImage.DoubleShootUseImage;
import attackImage.MoonlightSpearHit1Image;
import attackImage.MoonlightSpearHit2Image;
import attackImage.MoonlightSpearHit3Image;
import attackImage.MoonlightSpearUseImage;
import attackImage.SkillImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;

public class DoubleShootAttack extends MonsterAttack {
	public DoubleShootAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addMutlipleMovableSkillImageThread(new DoubleShootUseImage(hunt, attacker, opponent, null), makeMovableImage(), makeHitImage(), 120, true);
		afterAttack();
	}
	
	private ArrayList<SkillImage> makeMovableImage(){
		ArrayList<SkillImage> ret = new ArrayList<SkillImage>();
		for(int i = 0; i < 2; i++) {
			ret.add(new DoubleShootBallMovableImage(hunt, attacker, opponent, makeAttackInfor()));
		}
		return ret;
	}
	
	private ArrayList<SkillImage> makeHitImage(){
		ArrayList<SkillImage> ret = new ArrayList<SkillImage>();
		for(int i = 0; i < 2; i++) {
			ret.add(new DoubleShootHitImage(hunt, opponent, opponent, null));
		}
		return ret;
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.9f + (double)monsterSkill.getSkillPoint() * 0.1f;
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
		return 17 + monsterSkill.getSkillPoint() * 2;
	}
	
}
