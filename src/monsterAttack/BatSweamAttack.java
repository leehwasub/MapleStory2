package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.BatSweamHitImage;
import attackImage.BatSweamMovableImage;
import attackImage.BatSweamUseImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;

public class BatSweamAttack extends MonsterAttack {
	public BatSweamAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new BatSweamUseImage(hunt, attacker, opponent, null), true);
		addSkillImageThread(new BatSweamMovableImage(hunt, attacker, opponent, makeAttackInfor()), new BatSweamHitImage(hunt, opponent, opponent, null), true);
		afterAttack();
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.2f + (double)monsterSkill.getSkillPoint() * 0.05f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 2; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), monsterSkill.getProperty(), 0, this.attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 16 + monsterSkill.getSkillPoint() * 4;
	}
	
}
