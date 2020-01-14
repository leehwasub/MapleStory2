package monsterAttack;

import attack.AttackInfor;
import attack.DamageType;
import attack.Hit;
import attack.Property;
import character.Character;
import component.StateBox;
import hunt.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class TackleAttack extends MonsterAttack {
	
	public TackleAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		
		Character opponentCh = this.opponent.getCharacter();
		Hit hit = opponentCh.hit(makeAttackInfor());
		MusicUtils.startEffectSound("monsterAttack1");
		this.hunt.addDamageText(hit, opponent);
		this.opponent.updateStateBox(); 
		sleep(250);
		afterAttack();
	}
	
	@Override
	protected AttackInfor makeAttackInfor() {
		return new AttackInfor(this.attacker.getCharacter(), Property.PROPERTY_NOTHING, this.attacker.getCharacter().calNormalDamge(1.0d), 0, DamageType.DAMAGE_HP_TYPE);
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 0;
	}
	
}
