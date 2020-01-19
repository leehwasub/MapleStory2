package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.IntrepidSlashHitImage;
import attackImage.IntrepidSlashUseImage;
import attackImage.PanicHitImage;
import attackImage.PanicUse2Image;
import attackImage.PanicUseImage;
import attackImage.ShoutHitImage;
import attackImage.ShoutUseImage;
import attackImage.ThreatenUseImage;
import buff.BuffFactory;
import character.Monster;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import skill.FlameChargeSkill;
import skill.PanicSkill;
import skill.ThreatenSkill;

public class ThreatenAttack extends PlayerAttack {
	
	public ThreatenAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();

		addSkillImageThread(new ThreatenUseImage(hunt, attacker, opponent, null), true);
		makeThreatenBuff();
		afterAttack();
	}
	
	private void makeThreatenBuff() {
		double deBuffRate = ((ThreatenSkill)activeSkill).getRate(activeSkill.getPoint());
		int debuff00Rate = (int)(Math.random() *  99) + 1;
		if(debuff00Rate <= deBuffRate) {
			((ThreatenSkill)activeSkill).setPhysicalDamageDecre((Monster)opponent.getCharacter());
			((ThreatenSkill)activeSkill).setMagicDamageDecre((Monster)opponent.getCharacter());
			((ThreatenSkill)activeSkill).setAccuracyRateDecre((Monster)opponent.getCharacter());
			((ThreatenSkill)activeSkill).setMagicDefenseDecre((Monster)opponent.getCharacter());
			((ThreatenSkill)activeSkill).setPhysicalDefenseDecre((Monster)opponent.getCharacter());
			opponent.getCharacter().addBuff(BuffFactory.makeAdventurerBuff(activeSkill));
		}
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
