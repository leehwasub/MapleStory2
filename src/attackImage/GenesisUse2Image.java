package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class GenesisUse2Image extends SkillImage {
	public GenesisUse2Image(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor, int modifyX, int modifyY) {
		super("monsterSkillImage/genesisUse2", hunt, attacker, opponent, attackInfor, modifyX, modifyY);
	}

	public void run() {
		attacker.updateStateBox();
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 10) hit();
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}