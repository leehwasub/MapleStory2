package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Hit;
import attack.Property;
import character.Character;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import utils.MusicUtils;

public class NormalAttack extends PlayerAttack {
	
	public NormalAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		
		Character opponentCh = this.opponent.getCharacter();
		Hit damage = opponentCh.hit(makeAttackInfor().get(0));
		MusicUtils.startEffectSound("attack");
		this.damage = damage.getDamage();
		this.hunt.addDamageText(damage, this.opponent);
		opponent.updateStateBox();
		afterAttack();
	}

	@Override
	public ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 1; i++) {
			ret.add( new AttackInfor(attacker.getCharacter(), Property.PROPERTY_NOTHING, attacker.getCharacter().calNormalDamge(1.0d), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + activeSkill.getName() + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
