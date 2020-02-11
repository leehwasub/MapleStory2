package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attackImage.BrandishHitImage;
import attackImage.BrandishUseImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttackImage.DarkImpaleHitImage;
import playerAttackImage.DarkImpaleUseImage;
import playerAttackImage.GungnirDescentHitImage;
import playerAttackImage.GungnirDescentUseImage;
import skill.ActiveSkill;
import skill.GungnirDescentSkill;

public class GungnirDescentAttack extends PlayerAttack {
	
	public GungnirDescentAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		attacker.attackForwardMotion();
		addNoDelaySkillImageThread(new GungnirDescentUseImage(hunt, attacker, opponent, null));
		addSkillImageThread(new GungnirDescentHitImage(hunt, opponent, opponent, makeAttackInfor()), true);
		afterAttack();
	}

	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		int extraDamage = ((GungnirDescentSkill)activeSkill).getMaxHpDamageEffect(activeSkill.getPoint()) * attacker.getCharacter().getMaxHp() / 100;
		for(int i = 0; i < 6; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), activeSkill.getProperty(), attacker.getCharacter().calNormalDamge(rate) + extraDamage, 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}
	
	@Override
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName()  + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
