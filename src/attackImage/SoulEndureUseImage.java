package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class SoulEndureUseImage extends SkillImage {
	public SoulEndureUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/soulEndureUse", hunt, attacker, opponent, attackInfor, 0, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("soulEndureUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}