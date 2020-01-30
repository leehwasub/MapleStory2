package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.ChainLightningHitImage;
import attackImage.ChainLightningUseImage;
import attackImage.CombatSwitchingUseImage;
import attackImage.SwordHitImage;
import attackImage.SwordUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import skill.ShoutSkill;
import utils.CalUtils;

public class CombatSwitchingAttack extends MonsterAttack {
	
	public CombatSwitchingAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new CombatSwitchingUseImage(hunt, attacker, opponent, makeAttackInfor()), false);
		makeShockBuff();
		makeStunBuff();
		afterAttack();
	}
	
	private void makeStunBuff() {
		int stunRate = 40 + monsterSkill.getSkillPoint() * 3;
		int stunLast = 2 + (monsterSkill.getSkillPoint() / 11);
		if(CalUtils.calPercent(stunRate)) {
			opponent.getCharacter().addBuff(BuffFactory.makeSpecialBuff("스턴", stunLast));
		}
	}

	
	private void makeShockBuff() {
		int shockRate = 70 + monsterSkill.getSkillPoint() * 3;
		int shockLast = 5 + (monsterSkill.getSkillPoint() / 4);
		if(CalUtils.calPercent(shockRate)) {
			double shockDamageRate = 0.15 + (monsterSkill.getSkillPoint() * 0.08);
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("감전", shockLast, attacker.getCharacter().calNormalDamge(shockDamageRate)));
		}
	}
	
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.6f + (double)monsterSkill.getSkillPoint() * 0.1f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 4; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), monsterSkill.getProperty(), attacker.getCharacter().calNormalDamge(percent), 0, DamageType.DAMAGE_HP_TYPE));
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
