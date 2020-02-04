package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class MoonlightSpearHit2Image extends SkillImage {
	public MoonlightSpearHit2Image(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/moonlightSpearHit2", hunt, attacker, opponent, attackInfor, 0, 0);
	}

	public void run() {
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 3) {
				MusicUtils.startEffectSound("moonlightSpearHit");
				hit();
			}
			try {
				Thread.sleep(delayList.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}