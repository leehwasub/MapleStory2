package attack;

import attackImage.FlashAttackImage;
import attackImage.FlashAttackMovingImage;
import attackImage.SkillImage;
import character.Character;
import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class FlashAttack extends Attack {
	public FlashAttack(Hunt hunt, StateBox attacker, StateBox opponent, int skillPoint) {
		super(hunt, attacker, opponent, "플래시", Property.PROPERTY_NOTHING, 0, AttackType.OPPONENT);
	}

	public void readyForAttack() {
		
	}

	public void run() {
		this.attacker.attackForwardMotion();
		Character opponentCh = this.opponent.getCharacter();
		double percent = 0.9f + (double)skillPoint * 0.1f;
		int damage = opponentCh.hit(new Damage(this.attacker.getCharacter(), Property.PROPERTY_NOTHING,
				0, this.attacker.getCharacter().calNormalDamge(percent)));
		this.damage = damage;
		Thread thread = new Thread(()->{
			FlashAttackImage image = new FlashAttackImage(hunt, attacker, opponent);
			addSkillImage(image);
			image.start();
		});
		thread.start();
		this.hunt.addDamageText(damage, opponent, 0);
		this.opponent.updateStateBox(); 
		attackMoveDelay();
		this.attacker.attackBackMotion();
		
		afterAttackDelay();
		wakeUpThread();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.attackName + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return skillPoint*10;
	}
}
