package attack;

import attackImage.FlashAttackImage;
import attackImage.FlashAttackMovingImage;
import attackImage.SkillImage;
import character.Character;
import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class TackleAttack extends Attack {
	public TackleAttack(Hunt hunt, StateBox attacker, StateBox opponent, int skillPoint) {
		super(hunt, attacker, opponent, "몸통박치기",Property.PROPERTY_NOTHING, 0, AttackType.OPPONENT);
	}

	public void readyForAttack() {
		
	}

	public void run() {

		this.attacker.attackForwardMotion();
		Character opponentCh = this.opponent.getCharacter();
		int damage = opponentCh.hit(new Damage(this.attacker.getCharacter(), Property.PROPERTY_NOTHING,
				this.attacker.getCharacter().calNormalDamge(1.0D), 0));
		MusicUtils.startEffectSound("monsterAttack1");
		this.damage = damage;
		this.hunt.addDamageText(damage, opponent, 0);
		Thread thread = new Thread() {
			public void run() {
				SkillImage image = new FlashAttackImage(hunt, attacker, opponent);
				skillImageList.add(image);
				image.start(); 
			}
		}; 
		thread.start(); 
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
		return 0;
	}
}
