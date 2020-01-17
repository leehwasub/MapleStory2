package maplestory;

import java.awt.Image;

import attack.DamageText;
import component.StateBox;

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
	public void nextTurn();
	public void playerUseSkill(String skillName);
	public void setQuickSkillImage();
	public void mainStateBarUpdate();
	public void setQuickSkillEnabled();
}
