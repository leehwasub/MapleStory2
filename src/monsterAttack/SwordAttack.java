package monsterAttack;

import attack.Damage;
import attack.Property;
import attackImage.SwordHitImage;
import attackImage.SwordUseImage;
import character.Character;
import component.StateBox;
import hunt.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class SwordAttack extends MonsterAttack {
	
	public SwordAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		MusicUtils.startEffectSound("attack");
		addSkillImageThread(new SwordUseImage(hunt, attacker, opponent));
		sleep(200);
		Character opponentCh = this.opponent.getCharacter();
		int damage = opponentCh.hit(new Damage(this.attacker.getCharacter(), Property.PROPERTY_NOTHING, this.attacker.getCharacter().calNormalDamge(1.2d), 0));
		addSkillImageThread(new SwordHitImage(hunt, opponent, opponent));
		sleep(200);
		this.hunt.addDamageText(damage, opponent, 0);
		this.opponent.updateStateBox(); 
		this.attacker.attackBackMotion();
		afterAttackDelay();
		wakeUpThread();
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 5;
	}
}
