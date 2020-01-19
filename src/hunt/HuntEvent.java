package hunt;

import java.awt.Graphics2D;

import attack.AttackInfor;
import character.Adventurer;
import component.StateBox;
import playerAttack.PlayerAttack;

public interface HuntEvent {
	public void drawObject(Graphics2D g, StateBox stateBox);
	public void drawInfor(Graphics2D g, Adventurer adventurer);
	public void endHunt(Adventurer adventurer);
	public void startHunt(Adventurer adventurer);
	public void startTurn(Adventurer adventurer);
	public void startAttack(Adventurer adventurer, PlayerAttack attack);
	public void afterAttack(Adventurer adventurer, PlayerAttack attack);
	public void hit(Adventurer adventurer, AttackInfor attackInfor);
}
