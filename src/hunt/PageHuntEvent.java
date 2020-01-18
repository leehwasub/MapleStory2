package hunt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

import character.Adventurer;
import component.StateBox;
import playerAttack.PlayerAttack;
import skill.BlizzardChargeSkill;
import skill.ElementalChargeSkill;
import skill.FlameChargeSkill;
import utils.ColorUtils;
import utils.FontUtils;

public class PageHuntEvent implements HuntEvent, Serializable{

	private static final long serialVersionUID = 1L;
	private static final int LINE_THINKNESS = 2;

	@Override
	public void drawObject(Graphics2D g, StateBox stateBox) {
		
	}

	@Override
	public void drawInfor(Graphics2D g, Adventurer adventurer) {
		ElementalChargeSkill skill = (ElementalChargeSkill)adventurer.getSkillWithName("엘리멘탈차지");
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
			g.drawString("엘리멘탈 차지 : ", 300, 44);
			g.setColor(Color.WHITE);
			g.drawString(skill.getChargeNum()+"", 400, 44);
		}
	}

	@Override
	public void endHunt(Adventurer adventurer) {
		ElementalChargeSkill skill = (ElementalChargeSkill)adventurer.getSkillWithName("엘리멘탈차지");
		if(skill != null && skill.getPoint() >= 1) {
			System.out.println("머지?????");
			skill.setChargeNum(0);
		}
	}

	@Override
	public void startHunt(Adventurer adventurer) {
		
	}

	@Override
	public void startTurn(Adventurer adventurer) {
		ElementalChargeSkill skill = (ElementalChargeSkill)adventurer.getSkillWithName("엘리멘탈차지");
		if(skill != null && skill.getPoint() >= 1) {
			double hpRate = (double)skill.recoveryEffect(skill.getPoint()) / 100.0;
			adventurer.healHp((int)(hpRate * (double)adventurer.getMaxHp()));
		}
		adventurer.calState();
	}

	@Override
	public void startAttack(Adventurer adventurer, PlayerAttack attack) {
		ElementalChargeSkill elementalCharge = (ElementalChargeSkill)adventurer.getSkillWithName("엘리멘탈차지");
		if(adventurer.getUsedSkill() == null ||elementalCharge == null || 
				elementalCharge.getPoint() == 0 || elementalCharge.isHaveMaxChargeNum()) return;
		
		if(adventurer.getUsedSkill() instanceof FlameChargeSkill && attack.getActiveSkill() instanceof BlizzardChargeSkill) {
			elementalCharge.addChargeNum();
		}
		else if(adventurer.getUsedSkill() instanceof BlizzardChargeSkill && attack.getActiveSkill() instanceof FlameChargeSkill) {
			elementalCharge.addChargeNum();
		}
	}
	
}
