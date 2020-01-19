package playerAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.HpRecoveryUseImage;
import attackImage.RageUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.Hunt;
import skill.ActiveSkill;
import skill.HpRecoverySkill;
import utils.MusicUtils;

public class HpRecoveryAttack extends PlayerAttack {
	
	public HpRecoveryAttack(Hunt hunt, StateBox attacker, StateBox opponent, ActiveSkill activeSkill) {
		super(hunt, attacker, opponent, activeSkill);
	}
	
	public void run() {
		this.attacker.attackForwardMotion();
		
		addSkillImageThread(new HpRecoveryUseImage(hunt, attacker, opponent, null), true);
		hpRecovery();
		removeAbnormalBuff();
		afterAttack();
	}
	
	private void hpRecovery() {
		double hpRecoveryRate = activeSkill.getEffect(activeSkill.getPoint()) / 100.0;
		attacker.getCharacter().healHp((int)(attacker.getCharacter().getMaxHp() / hpRecoveryRate));
		attacker.updateStateBox();
	}
	
	private void removeAbnormalBuff() {
		int removeAbnormalRate = ((HpRecoverySkill)activeSkill).removeAbnormalRate(activeSkill.getPoint());
		int removeAbnormalRate100 = (int)(Math.random() * 99) + 1;
		if(removeAbnormalRate100 <= removeAbnormalRate) {
			attacker.getCharacter().removeAllAbnormalBuff();
		}
	}

	@Override
	public ArrayList<AttackInfor> makeAttackInfor() {
		return null;
	}
	
	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " +activeSkill.getName() + "를 사용. 자신에게 물리방어력을 강화시키는 버프를 걸었다.";
	}

}
