package lastingImage;

import java.util.ArrayList;

import attack.AttackInfor;
import attackImage.SkillImage;
import character.Monster;
import component.StateBox;
import hunt.HuntComponent.Hunt;

public abstract class LastingSkillImage extends SkillImage{
	
	protected boolean isCanLast;
	
	public LastingSkillImage(String root, Hunt hunt, StateBox attacker, StateBox opponent, ArrayList<AttackInfor> attackInfor, int modifyX, int modifyY) {
		super(root, hunt, attacker, opponent, attackInfor, modifyX, modifyY);
		this.isCanLast = true;
	}
	
	public void run() {
		setChangedPoint();
		while(isCanLast) {
			for (int i = 0; i < this.imageList.size() && isCanLast; i++) {
				this.index = i;
				try {
					Thread.sleep(delayList.get(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void setChangedPoint() {
		Thread thread = new Thread(){
			public void run() {
				while(isCanLast) {
					if(attacker.getCharacter() instanceof Monster) {
						point.setXY(attacker.getX() + 65 - imageList.get(0).getWidth(null)/2 + modifyX, attacker.getY() + 65 - imageList.get(0).getHeight(null)/2 + modifyY);
					} else {
						point.setXY(attacker.getX() + 300 - imageList.get(0).getWidth(null)/2 + modifyX, attacker.getY() + 65 - imageList.get(0).getHeight(null)/2 + modifyY);
					}
				}
			}
		};
		thread.start();
	}
	
	public abstract boolean isCanLast();

}
