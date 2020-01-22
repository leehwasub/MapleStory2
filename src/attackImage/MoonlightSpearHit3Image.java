package attackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class MoonlightSpearHit3Image extends SkillImage {
	public MoonlightSpearHit3Image(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("monsterSkillImage/moonlightSpearHit3", hunt, attacker, opponent, attackInfor, 120, 0, 0);
	}

	public void run() {
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			System.out.println(this.index);
			if(i == 3) {
				MusicUtils.startEffectSound("moonlightSpearHit");
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