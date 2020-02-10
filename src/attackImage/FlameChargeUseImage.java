package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.AdvancedChargeSkill;
import utils.MusicUtils;

public class FlameChargeUseImage extends SkillImage {
	public FlameChargeUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/flameChargeUse", hunt, attacker, opponent, attackInfor, 200, 0);
		getAdvancedChargeEffect();
	}
	
	private int canMoreHit = 0; 
	
	private void getAdvancedChargeEffect() {
		AdvancedChargeSkill advancedChargeSkill = (AdvancedChargeSkill)((Adventurer)attacker.getCharacter()).getSkillWithName("어드밴스드차지");
		if(advancedChargeSkill != null && advancedChargeSkill.getPoint() >= 1) {
			canMoreHit = advancedChargeSkill.getEffect(advancedChargeSkill.getPoint());
		}
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("flameChargeUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 3 || i == 4 || i == 5) {
				hit();
			}
			if(i == 7 && canMoreHit >= 1) hit();
			if(i == 8 && canMoreHit >= 2) hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}