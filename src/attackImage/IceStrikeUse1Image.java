package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class IceStrikeUse1Image extends SkillImage {
	public IceStrikeUse1Image(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/iceStrikeUse1", hunt, attacker, opponent, attackInfor, 0, 0);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("iceStrikeUse");
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