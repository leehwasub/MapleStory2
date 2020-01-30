package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.ChainLightningHitImage;
import attackImage.ChainLightningUseImage;
import attackImage.SwordHitImage;
import attackImage.SwordUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.CalUtils;

public class ChainLightningAttack extends MonsterAttack {
	
	public ChainLightningAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new ChainLightningUseImage(hunt, attacker, opponent, makeAttackInfor()), new ChainLightningHitImage(hunt, opponent, opponent, null), false);
		makeShockBuff();
		afterAttack();
	}
	
	
	private void makeShockBuff() {
		int shockRate = 40 + monsterSkill.getSkillPoint() * 5;
		int shockLast = 4 + (monsterSkill.getSkillPoint() / 4);
		if(CalUtils.calPercent(shockRate)) {
			double shockDamageRate = 0.1 + (monsterSkill.getSkillPoint() * 0.05);
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("감전", shockLast, attacker.getCharacter().calNormalDamge(shockDamageRate)));
		}
	}
	
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), monsterSkill.getProperty(), this.attacker.getCharacter().calNormalDamge(1.3d), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 15 + monsterSkill.getSkillPoint();
	}

}
