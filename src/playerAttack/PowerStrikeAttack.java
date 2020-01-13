package playerAttack;

import attack.Damage;
import attackImage.PowerStrikeHitImage;
import attackImage.PowerStrikeUseImage;
import character.Character;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;

public class PowerStrikeAttack extends PlayerAttack {
	
	public PowerStrikeAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		Character opponentCh = this.opponent.getCharacter();
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		addSkillImageThread(new PowerStrikeUseImage(hunt, attacker, opponent));
		attacker.updateStateBox();
		sleep(360);
		int damage = opponentCh.hit(new Damage(this.attacker.getCharacter(), activeSkill.getProperty(), this.attacker.getCharacter().calNormalDamge(rate), 0));
		this.damage = damage;
		hunt.addDamageText(damage, opponent, 0);
		opponent.updateStateBox();
		addSkillImageThread(new PowerStrikeHitImage(hunt, opponent, opponent));
		sleep(360);
		this.attacker.attackBackMotion();
		afterAttackDelay();
		wakeUpThread();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
