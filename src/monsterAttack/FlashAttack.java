package monsterAttack;

import attack.Damage;
import attack.Property;
import attackImage.FlashAttackImage;
import character.Character;
import component.StateBox;
import hunt.Hunt;
import skill.MonsterSkill;

public class FlashAttack extends MonsterAttack {
	public FlashAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		Character opponentCh = this.opponent.getCharacter();
		double percent = 0.9f + (double)monsterSkill.getSkillPoint() * 0.1f;
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
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return monsterSkill.getSkillPoint()*10;
	}
}
