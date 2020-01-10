package maplestory;

import java.awt.Image;

import attack.DamageText;

public interface MainMapleInterface {
	public void myRepaint();
	public void changeBackground(Image paramImage);
	public void addDamageText(DamageText paramDamageText);
	public void pushMessage(Message paramMessage);
	public void endHunt();
	public void updateMainStateBar();
	public void toMainMenu();
}
