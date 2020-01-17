package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.BrandishHitImage;
import attackImage.BrandishUseImage;
import attackImage.FlameChargeHitImage;
import attackImage.FlameChargeUseImage;
import attackImage.PowerStrikeHitImage;
import attackImage.PowerStrikeUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import skill.FlameChargeSkill;

public class FlameChargeAttack extends PlayerAttack {
	
	public FlameChargeAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();

		addSkillImageThread(new FlameChargeUseImage(hunt, attacker, opponent, makeAttackInfor()),
				new FlameChargeHitImage(hunt, opponent, opponent, null));
		makeBurnBuff();
		afterAttack();
	}
	
	private void makeBurnBuff() {
		double burnRate = ((FlameChargeSkill)activeSkill).burnRate(activeSkill.getPoint());
		int burnLast = ((FlameChargeSkill)activeSkill).getLast(activeSkill.getPoint());
		int burn100Rate = (int)(Math.random() *  99) + 1;
		if(burn100Rate <= burnRate) {
			double burnDamageRate = ((FlameChargeSkill)activeSkill).burnEffect(activeSkill.getPoint()) / 100.0;
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("화상", burnLast, attacker.getCharacter().calNormalDamge(burnDamageRate)));
		}
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 3; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
