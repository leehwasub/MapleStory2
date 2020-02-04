package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class CombatSwitchingUseImage extends SkillImage {
	public CombatSwitchingUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/combatSwitchingUse", hunt, attacker, opponent, attackInfor, -250, -25);
	}

	public void run() {
		MusicUtils.startEffectSound("combatSwitchingUse");
		attacker.updateStateBox();
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 12 || i == 13 || i == 14 || i == 15) hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}