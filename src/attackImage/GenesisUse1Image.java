package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class GenesisUse1Image extends SkillImage {
	public GenesisUse1Image(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/genesisUse1", hunt, attacker, opponent, attackInfor, 0, -90);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("genesisUse");
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