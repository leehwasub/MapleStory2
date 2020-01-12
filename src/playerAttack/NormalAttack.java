package playerAttack;

import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import skill.NormalSkill;
import utils.MusicUtils;
import attack.Attack;
import attack.AttackType;
import attack.Damage;
import attack.Property;
import character.Character;

public class NormalAttack extends PlayerAttack {
	
	public NormalAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		Character opponentCh = this.opponent.getCharacter();
		int damage = opponentCh.hit(new Damage(this.attacker.getCharacter(), Property.PROPERTY_NOTHING,
				this.attacker.getCharacter().calNormalDamge(1.0D), 0));
		MusicUtils.startEffectSound("attack");
		this.damage = damage;
		this.hunt.addDamageText(damage, this.opponent, 0);
		opponent.updateStateBox();
		attackMoveDelay();
		this.attacker.attackBackMotion();
		
		afterAttackDelay();
		wakeUpThread();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
