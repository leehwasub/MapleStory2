package hunt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

import character.Adventurer;
import component.StateBox;
import skill.ComboAttackSkill;
import skill.ElementalChargeSkill;
import utils.ColorUtils;
import utils.FontUtils;

public class FighterHuntEvent extends EmptyHuntEvent implements HuntEvent, Serializable{

	private static final long serialVersionUID = 1L;
	private static final int LINE_THINKNESS = 2;

	@Override
	public void drawObject(Graphics2D g, StateBox stateBox) {
		
	}

	@Override
	public void drawInfor(Graphics2D g, Adventurer adventurer) {
		ComboAttackSkill skill = (ComboAttackSkill)adventurer.getSkillWithName("콤보어택");
		if(skill != null && skill.getPoint() >= 1) {
			g.setColor(ColorUtils.BLACK_80);
			g.fillRect(280, 20, 200, 40);
			g.setColor(ColorUtils.SEA);
			g.fillRect(280, 20, 200, LINE_THINKNESS);
			g.fillRect(280, 60 - LINE_THINKNESS, 200, LINE_THINKNESS);
			g.fillRect(280, 20, LINE_THINKNESS, 40);
			g.fillRect(480 - LINE_THINKNESS, 20, LINE_THINKNESS, 40);
			g.setFont(FontUtils.SMALL_FONT);
			g.setColor(Color.YELLOW);
			g.drawString("콤보어택 : ", 300, 44);
			g.setColor(Color.WHITE);
			g.drawString(skill.getComboNum()+"", 380, 44);
		}
	}

	@Override
	public void endHunt(Adventurer adventurer) {
		ComboAttackSkill skill = (ComboAttackSkill)adventurer.getSkillWithName("콤보어택");
		if(skill != null && skill.getPoint() >= 1) {
			skill.setComboNum(0);
		}
	}

	@Override
	public void startHunt(Adventurer adventurer) {
		
	}

	@Override
	public void startTurn(Adventurer adventurer) {
		
	}
	
}
