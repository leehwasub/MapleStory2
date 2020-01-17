package hunt;

import java.awt.Graphics2D;

import character.Adventurer;
import component.StateBox;

public interface HuntEvent {
	public void drawObject(Graphics2D g, StateBox stateBox);
	public void drawInfor(Graphics2D g, Adventurer adventurer);
	public void endHunt(Adventurer adventurer);
	public void startHunt(Adventurer adventurer);
	public void startTurn(Adventurer adventurer);
}