package attack;

import component.StateBox;
import hunt.Hunt;
import character.Character;

public class NormalAttack extends Attack {
	public NormalAttack(Hunt hunt, StateBox attacker, StateBox opponent, int skillPoint) {
		super(hunt, attacker, opponent, "일반공격", Property.PROPERTY_NOTHING, skillPoint, AttackType.OPPONENT);
	}

	public void readyForAttack() {
	}

	public void run() {

		this.attacker.attackForwardMotion();
		Character opponentCh = this.opponent.getCharacter();
		int damage = opponentCh.hit(new Damage(this.attacker.getCharacter(), Property.PROPERTY_NOTHING,
				this.attacker.getCharacter().calNormalDamge(1.0D), 0));
		this.damage = damage;
		this.hunt.addDamageText(damage, (StateBox) this.opponent, 0);
		opponent.updateStateBox();
		attackMoveDelay();
		this.attacker.attackBackMotion();
		
		afterAttackDelay();
		wakeUpThread();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.attackName + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public void calNeedMp() {
	}
}
