package hunt;

import java.awt.Graphics2D;
import java.io.Serializable;

import character.Adventurer;
import component.StateBox;
import playerAttack.PlayerAttack;

public class SpearManHuntEvent implements HuntEvent, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public void drawObject(Graphics2D g, StateBox stateBox) {
		
	}

	@Override
	public void drawInfor(Graphics2D g, Adventurer adventurer) {
		
	}

	@Override
	public void endHunt(Adventurer adventurer) {
		
	}

	@Override
	public void startHunt(Adventurer adventurer) {
		
	}

	@Override
	public void startTurn(Adventurer adventurer) {
		
	}

	@Override
	public void startAttack(Adventurer adventurer, PlayerAttack attack) {
		
	}

	@Override
	public void afterAttack(Adventurer adventurer, PlayerAttack attack) {
		
	}
	
}
