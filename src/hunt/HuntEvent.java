package hunt;

import java.awt.Graphics2D;

import attack.AttackInfor;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.PlayerAttack;

public interface HuntEvent {
	public void drawObject(Graphics2D g, Hunt hunt);
	public void drawInfor(Graphics2D g, Hunt hunt);
	public void endHunt(Hunt hunt);
	public void startHunt(Hunt hunt);
	public void startTurn(Hunt hunt);
	public void startAttack(Hunt hunt);
	public void afterAttack(Hunt hunt);
	public void hit(Adventurer adventurer, AttackInfor attackInfor);
}