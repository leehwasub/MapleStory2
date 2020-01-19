package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.BrandishHitImage;
import attackImage.BrandishUseImage;
import attackImage.EvilEyeShockHitImage;
import attackImage.EvilEyeShockUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.ActiveSkill;
import skill.EvilEyeShockSkill;
import skill.ShoutSkill;
import utils.CalUtils;

public class EvilEyeShockAttack extends PlayerAttack {
	
	public EvilEyeShockAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();

		addSkillImageThread(new EvilEyeShockUseImage(hunt, attacker, opponent, makeAttackInfor()), 
				new EvilEyeShockHitImage(hunt, opponent, opponent, null), true);
		makeStunBuff();
		afterAttack();
	}
	
	private void makeStunBuff() {
		int stunRate = ((EvilEyeShockSkill)activeSkill).getStunRate(activeSkill.getPoint());
		int stunLast = ((EvilEyeShockSkill)activeSkill).getStunLast(activeSkill.getPoint());
		if(CalUtils.calPercent(stunRate)) {
			opponent.getCharacter().addBuff(BuffFactory.makeSpecialBuff("스턴", stunLast));
		}
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 2; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
