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
import character.Adventurer;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import skill.CombatOrdersSkill;
import skill.FlameChargeSkill;

public class FlameChargeAttack extends PlayerAttack {
	
	public FlameChargeAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();

		addSkillImageThread(new FlameChargeUseImage(hunt, attacker, opponent, makeAttackInfor()),
				new FlameChargeHitImage(hunt, opponent, opponent, null), false);
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
	
	private double combatOrdersEffect() {
		double extraRate = 0.0;
		if(((Adventurer)attacker.getCharacter()).isAlreadyBuffed("컴뱃오더스")) {
			CombatOrdersSkill combatOrdersSkill = (CombatOrdersSkill)((Adventurer)attacker.getCharacter()).getSkillWithName("컴뱃오더스");
			if(combatOrdersSkill != null && combatOrdersSkill.getPoint() >= 1) {
				extraRate = combatOrdersSkill.getExtraChargeEffect(combatOrdersSkill.getPoint()) / 100.0;
			}
		}
		return extraRate;
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		rate += combatOrdersEffect();
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
