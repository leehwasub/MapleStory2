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
import attackImage.PowerStrikeHitImage;
import attackImage.PowerStrikeUseImage;
import attackImage.SkillImage;
import character.Character;

public class PowerStrikeAttack extends PlayerAttack {
	
	public PowerStrikeAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		Character opponentCh = this.opponent.getCharacter();
		
		double rate = (double)activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		
		Thread thread1 = new Thread(()-> {
			PowerStrikeUseImage image = new PowerStrikeUseImage(hunt, attacker, opponent);
			addSkillImage(image);
			image.start();
		});
		thread1.start();
		sleep(360);
		int damage = opponentCh.hit(new Damage(this.attacker.getCharacter(), activeSkill.getProperty(),
				this.attacker.getCharacter().calNormalDamge(rate), 0));
		this.damage = damage;
		hunt.addDamageText(damage, opponent, 0);
		opponent.updateStateBox();
		Thread thread2 = new Thread(()-> {
			PowerStrikeHitImage image = new PowerStrikeHitImage(hunt, opponent, opponent);
			addSkillImage(image);
			image.start();
		});
		thread2.start();
		sleep(360);
		attackMoveDelay();
		this.attacker.attackBackMotion();
		
		afterAttackDelay();
		wakeUpThread();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this + "를 사용. " + opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

}
