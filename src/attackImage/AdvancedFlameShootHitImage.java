package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class AdvancedFlameShootHitImage extends SkillImage {
	public AdvancedFlameShootHitImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/advancedFlameShootHit", hunt, attacker, opponent, attackInfor, 0, 0);
	}

	public void run() {
		MusicUtils.startEffectSound("advancedFlameShootHit");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}