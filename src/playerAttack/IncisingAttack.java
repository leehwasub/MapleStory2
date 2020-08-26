package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttackImage.IncisingHitImage;
import playerAttackImage.IncisingUseImage;
import playerAttackImage.RagingBlowHit1Image;
import playerAttackImage.RagingBlowHit2Image;
import playerAttackImage.RagingBlowUse1Image;
import playerAttackImage.RagingBlowUse2Image;
import skill.ActiveSkill;
import skill.BlizzardChargeSkill;
import skill.IncisingSkill;
import skill.RagingBlowSkill;
import utils.CalUtils;

public class IncisingAttack extends PlayerAttack {
	
	public IncisingAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new IncisingUseImage(hunt, attacker, opponent, makeAttackInfor()), new IncisingHitImage(hunt, opponent, opponent, null), true);
		makeIncisingBuff();
		afterAttack();
	}

	private void makeIncisingBuff() {
		int debuffRate = ((IncisingSkill)activeSkill).getDebuffRate(activeSkill.getPoint());
		int debuffLast = ((IncisingSkill)activeSkill).getDebuffLast(activeSkill.getPoint());
		if(CalUtils.calPercent(debuffRate)) {
			double damageRate = ((IncisingSkill)activeSkill).getDebuffDamage(activeSkill.getPoint()) / 100.0;
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("인사이징", debuffLast, attacker.getCharacter().calNormalDamge(damageRate)));
		}
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 4; i++) {
			AttackInfor attackInfor = new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE);
			ret.add(attackInfor);
		}
		return ret;
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
