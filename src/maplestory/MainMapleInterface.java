package maplestory;

import java.awt.Image;

import attack.DamageText;
import buff.Buff;
import component.StateBox;
import map.Point;

public interface MainMapleInterface {
	public void myRepaint();
	public void changeBackground(Image paramImage);
	public void addDamageText(DamageText paramDamageText);
	public void pushMessage(Message paramMessage);
	public void endHunt();
	public void updateMainStateBar();
	public void toMainMenu();
	public void loadStateBoxOnQuickButton(StateBox statebox);
	public void setQuickItemImage();
	public void potionUsed();
	public void playerUseSkill(String skillName);
	public void setQuickSkillImage();
	public void mainStateBarUpdate();
	public void setQuickSkillEnabled();
	public void renewStoreInventory();
}
