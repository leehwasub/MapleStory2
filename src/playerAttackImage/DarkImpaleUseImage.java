package playerAttackImage;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.SkillImage;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import utils.MusicUtils;

public class DarkImpaleUseImage extends SkillImage {
	
	private int skillPoint;
	
	public DarkImpaleUseImage(Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor, int skillPoint) {
		super("playerSkillImage/darkImpaleUse", hunt, attacker, opponent, attackInfor, 150, 0);
		this.skillPoint = skillPoint;
	}

	public void run() {
		attacker.updateStateBox();
		MusicUtils.startEffectSound("darkImpaleUse");
		for (int i = 0; i < this.imageList.size(); i++) {
			this.index = i;
			if(i >= 3 && i <= 7 + (skillPoint >= 16 ? 1 : 0)) {
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