package playerAttack;

import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import skill.NormalSkill;
import utils.MusicUtils;
import attack.Attack;
import attack.AttackType;
import attack.DamageType;
import attack.Hit;
import attack.AttackInfor;
import attack.Property;
import character.Character;

public class NormalAttack extends PlayerAttack {
	
	public NormalAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		
		Character opponentCh = this.opponent.getCharacter();
		Hit damage = opponentCh.hit(makeAttackInfor());
		MusicUtils.startEffectSound("attack");
		this.damage = damage.getDamage();
		this.hunt.addDamageText(damage, this.opponent);
		opponent.updateStateBox();
		sleep(250);
		afterAttack();
	}

	@Override
	public AttackInfor makeAttackInfor() {
		return new AttackInfor(attacker.getCharacter(), Property.PROPERTY_NOTHING, attacker.getCharacter().calNormalDamge(1.0d), 
				0, DamageType.DAMAGE_HP_TYPE);
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName() + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
