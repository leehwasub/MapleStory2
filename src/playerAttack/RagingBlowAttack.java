package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttackImage.RagingBlowHit1Image;
import playerAttackImage.RagingBlowHit2Image;
import playerAttackImage.RagingBlowUse1Image;
import playerAttackImage.RagingBlowUse2Image;
import skill.ActiveSkill;
import skill.EnrageSkill;
import skill.RagingBlowSkill;

public class RagingBlowAttack extends PlayerAttack {
	
	public RagingBlowAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();
		if(!attacker.getCharacter().isAlreadyBuffed("인레이지")) {
			addSkillImageThread(new RagingBlowUse1Image(hunt, attacker, opponent, makeAttackInfor()), 
					new RagingBlowHit1Image(hunt, opponent, opponent, null), true);
		} else {
			addSkillImageThread(new RagingBlowUse2Image(hunt, attacker, opponent, makeAttackInfor()), 
					new RagingBlowHit2Image(hunt, opponent, opponent, null), true);
		} 
		afterAttack();
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		double extraRate = 0.0;
		if(attacker.getCharacter().isAlreadyBuffed("인레이지")) {
			rate += ((RagingBlowSkill)activeSkill).getEnrageEffect(activeSkill.getPoint()) / 100.0;
		}
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 5; i++) {
			AttackInfor attackInfor = new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate + extraRate), 0, DamageType.DAMAGE_HP_TYPE);
			if(i == 4) {
				attackInfor.setMustCritical(true);
			} else if(i == 3 && attacker.getCharacter().isAlreadyBuffed("인레이지")) {
				attackInfor.setMustCritical(true);
			}
			ret.add(attackInfor);
		}
		return ret;
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
