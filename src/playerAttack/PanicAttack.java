package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.PanicHitImage;
import attackImage.PanicUse2Image;
import attackImage.PanicUseImage;
import buff.BuffFactory;
import character.Monster;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.ActiveSkill;
import skill.PanicSkill;

public class PanicAttack extends PlayerAttack {
	
	public PanicAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();

		addNoDelaySkillImageThread(new PanicUse2Image(hunt, attacker, opponent, null));
		addSkillImageThread(new PanicUseImage(hunt, attacker, opponent, makeAttackInfor()), 
				new PanicHitImage(hunt, opponent, opponent, null), true);
		makePanicBuff();
		afterAttack();
	}
	
	private void makePanicBuff() {
		double deBuffRate = ((PanicSkill)activeSkill).deBuffRate(activeSkill.getPoint());
		int debuff00Rate = (int)(Math.random() *  99) + 1;
		if(debuff00Rate <= deBuffRate) {
			((PanicSkill)activeSkill).setPhysicalDamageDecre((Monster)opponent.getCharacter());
			((PanicSkill)activeSkill).setMagicDamageDecre((Monster)opponent.getCharacter());
			((PanicSkill)activeSkill).setAccuracyRateDecre((Monster)opponent.getCharacter());
			opponent.getCharacter().addBuff(BuffFactory.makeAdventurerBuff(activeSkill));
		}
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
