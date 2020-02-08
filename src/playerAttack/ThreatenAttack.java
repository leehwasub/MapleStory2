package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.ThreatenUseImage;
import buff.BuffFactory;
import character.Monster;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.ActiveSkill;
import skill.ThreatenSkill;
import utils.CalUtils;

public class ThreatenAttack extends PlayerAttack {
	
	private boolean isSucceed;
	
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
		int deBuffRate = ((ThreatenSkill)activeSkill).getRate(activeSkill.getPoint());
		if(CalUtils.calPercent(deBuffRate)) {
			((ThreatenSkill)activeSkill).setPhysicalDamageDecre((Monster)opponent.getCharacter());
			((ThreatenSkill)activeSkill).setMagicDamageDecre((Monster)opponent.getCharacter());
			((ThreatenSkill)activeSkill).setAccuracyRateDecre((Monster)opponent.getCharacter());
			((ThreatenSkill)activeSkill).setMagicDefenseDecre((Monster)opponent.getCharacter());
			((ThreatenSkill)activeSkill).setPhysicalDefenseDecre((Monster)opponent.getCharacter());
			opponent.getCharacter().addBuff(BuffFactory.makeAdventurerBuff(activeSkill));
			isSucceed = true;
		} else {
			isSucceed = false;
		}
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
	@Override
	public String attackInfor() {
		if(!isSucceed) {
			return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 아무 피해를 입히지 못했다.";
		}
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 물리마법 공격력, 물리마법 방어력을 줄이는 버프를 걸었다.";
	}

}
