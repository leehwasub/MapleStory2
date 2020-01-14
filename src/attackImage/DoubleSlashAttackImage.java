package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.Hit;
import component.StateBox;
import hunt.Hunt;
import utils.MusicUtils;

public class DoubleSlashAttackImage extends SkillImage {
	public DoubleSlashAttackImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/doubleSlash", hunt, attacker, opponent, attackInfor, 120);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("doubleSlash");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			if(i == 1 || i == 4) {
				hit();
			}
			try {
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}