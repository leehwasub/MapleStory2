package playerAttackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.SkillImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class RagingBlowUse2Image extends SkillImage {
	public RagingBlowUse2Image(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor) {
		super("playerSkillImage/ragingBlowUse2", hunt, attacker, opponent, attackInfor, 100, -30);
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("ragingBlowUse2");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i == 3 || i == 6 || i == 8 || i == 10 || i == 11) {
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