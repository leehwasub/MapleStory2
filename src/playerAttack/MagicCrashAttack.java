package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.ThreatenUseImage;
import buff.BuffFactory;
import character.Monster;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttackImage.MagicCrashUse1Image;
import playerAttackImage.MagicCrashUse2Image;
import skill.ActiveSkill;
import skill.IncisingSkill;
import skill.MagicCrashSkill;
import skill.ThreatenSkill;
import utils.CalUtils;

public class MagicCrashAttack extends PlayerAttack {
	
	private boolean isSucceed;
	
	public MagicCrashAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new MagicCrashUse2Image(hunt, opponent, opponent, null), true, 90);
		addSkillImageThread(new MagicCrashUse1Image(hunt, opponent, opponent, null), true);
		opponent.getCharacter().removeAllEffectBuff();
		makeMagicCrashBuff();
		afterAttack();
	}
	
	private void makeMagicCrashBuff() {
		int debuffRate = ((MagicCrashSkill)activeSkill).getEffect(activeSkill.getPoint());
		int debuffLast = ((MagicCrashSkill)activeSkill).getLast(activeSkill.getPoint());
		if(CalUtils.calPercent(debuffRate)) {
			isSucceed = true;
			opponent.getCharacter().addBuff(BuffFactory.makeSpecialBuff("매직크래쉬", debuffLast));
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
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "의 모든 버프를 해제하고 버프 사용을 제한하는 버프를 걸었다.";
	}

}
