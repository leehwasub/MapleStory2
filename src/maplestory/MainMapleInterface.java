package maplestory;

import java.awt.Image;

import attack.DamageText;

public abstract interface MainMapleInterface {
	public abstract void myRepaint();
	public abstract void changeBackground(Image paramImage);
	public abstract void addDamageText(DamageText paramDamageText);
	public abstract void pushMessage(Message paramMessage);
	public abstract void endHunt();
	public abstract void updateMainStateBar();
}
