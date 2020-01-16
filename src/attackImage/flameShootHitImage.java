package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class flameShootHitImage extends SkillImage {
	public flameShootHitImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/flameShootHit", hunt, attacker, opponent, attackInfor, 60, 0);
	}

	public void run() {
		MusicUtils.startEffectSound("flameShootHit");
		hit();
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}