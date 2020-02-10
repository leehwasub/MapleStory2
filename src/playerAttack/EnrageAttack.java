package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttackImage.EnrageUseImage;
import playerAttackImage.MagicCrashUse1Image;
import skill.ActiveSkill;
import utils.MusicUtils;

public class EnrageAttack extends PlayerAttack {
	
	public EnrageAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		attackMoveDelay();
		
		addSkillImageThread(new EnrageUseImage(hunt, attacker, opponent, null), true);
		attacker.getCharacter().addBuff(BuffFactory.makeSpecialBuff("인레이지", activeSkill.getLast(activeSkill.getPoint())));
		attacker.updateStateBox();
		
		this.attacker.attackBackMotion();
		afterAttackDelay();
		
		wakeUpThread();
	}

	@Override
	public ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " +activeSkill.getName() + "를 사용. 자신에게 물리마법 방어력을 강화시키는 버프를 걸었다.";
	}

}
