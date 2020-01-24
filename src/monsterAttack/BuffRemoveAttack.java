package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.DevilScytheHitImage;
import attackImage.DevilScytheMovableImage;
import attackImage.DevilScytheUseImage;
import attackImage.FlashBallMovableImage;
import attackImage.FlashHitImage;
import attackImage.FlashUseImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class BuffRemoveAttack extends MonsterAttack {
	public BuffRemoveAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		MusicUtils.startEffectSound("monsterBuffCancel");
		opponent.getCharacter().removeOneEffectBuff();
		afterAttack();
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "의 버프 효과중 한개를 해제했다.";
	}

	public int calNeedMp() {
		return 40;
	}
	
}
