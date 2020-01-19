package hunt;

import java.awt.Graphics2D;
import java.io.Serializable;

import attack.AttackInfor;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.PlayerAttack;

public class EmptyHuntEvent implements HuntEvent, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void drawObject(Graphics2D g, Hunt hunt) {
		
	}

	@Override
	public void drawInfor(Graphics2D g, Hunt hunt) {
		
	}

	@Override
	public void endHunt(Hunt hunt) {
		
	}

	@Override
	public void startHunt(Hunt hunt) {
		
	}

	@Override
	public void startTurn(Hunt hunt) {
		
	}
	
	@Override
	public void startAttack(Hunt hunt) {
		
	}

	@Override
	public void afterAttack(Hunt hunt) {
		
	}

	@Override
	public void hit(Adventurer adventurer, AttackInfor attackInfor) {
		
	}

}
