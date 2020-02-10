package hunt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

import attack.Attack;
import attack.AttackInfor;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.EnrageAttack;
import playerAttack.IncisingAttack;
import playerAttack.IronBodyAttack;
import playerAttack.MagicCrashAttack;
import playerAttack.PanicAttack;
import playerAttack.PlayerAttack;
import playerAttack.RageAttack;
import playerAttack.ShoutAttack;
import skill.AdvancedComboSkill;
import skill.CombatOrdersSkill;
import skill.ComboAttackSkill;
import skill.ComboSynergySkill;
import skill.ElementalChargeSkill;
import skill.PanicSkill;
import skill.ShoutSkill;
import utils.CalUtils;
import utils.ColorUtils;
import utils.FontUtils;

public class FighterHuntEvent implements HuntEvent, Serializable{

	private static final long serialVersionUID = 1L;
	private static final int LINE_THINKNESS = 2;

	@Override
	public void drawObject(Graphics2D g, Hunt hunt) {
		
	}

	@Override
	public void drawInfor(Graphics2D g, Hunt hunt) {
		Adventurer adventurer = hunt.getAdventurer();
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
	public void endHunt(Hunt hunt) {
		Adventurer adventurer = hunt.getAdventurer();
		ComboAttackSkill skill = (ComboAttackSkill)adventurer.getSkillWithName("콤보어택");
		if(skill != null && skill.getPoint() >= 1) {
			skill.setComboNum(0);
		}
	}

	@Override
	public void startHunt(Hunt hunt) {
		
	}

	@Override
	public void startTurn(Hunt hunt) {
		
	}

	@Override
	public void startAttack(Hunt hunt) {
		
		Adventurer adventurer = hunt.getAdventurer();
		Attack attack = hunt.getPlayerAttack();
		
		ComboAttackSkill comboAttack = (ComboAttackSkill)adventurer.getSkillWithName("콤보어택");
		if(comboAttack == null || comboAttack.getPoint() == 0) return;
		
		if(attack instanceof ShoutAttack) {
			comboAttack.subComboNum();
		} else if(attack instanceof PanicAttack) {
			comboAttack.subComboNum();
			comboAttack.subComboNum();
		} else if(attack instanceof EnrageAttack) {
			comboAttack.subComboNum();
		} else if(attack instanceof IncisingAttack) {
			comboAttack.subComboNum();
		}
		
		int rate = comboAttack.getEffect(comboAttack.getPoint());
		
		ComboSynergySkill comboSynergyAttack = (ComboSynergySkill)adventurer.getSkillWithName("콤보시너지");
		if(comboSynergyAttack != null && comboSynergyAttack.getPoint() >= 1) {
			rate += comboSynergyAttack.getEffect(comboSynergyAttack.getPoint());
		}
		
		int randomRate = (int)(Math.random() * 99) + 1;
 		if(randomRate <= rate && !(attack instanceof IronBodyAttack) && !(attack instanceof RageAttack)
 				&& !(attack instanceof EnrageAttack) && !(attack instanceof MagicCrashAttack)) {
 			comboAttack.addComboNum();
 			AdvancedComboSkill advancedComboSkill = (AdvancedComboSkill)adventurer.getSkillWithName("어드밴스드콤보");
 			if(advancedComboSkill != null && advancedComboSkill.getPoint() >= 1) {
 				if(CalUtils.calPercent(advancedComboSkill.getDoubleGetEffect(advancedComboSkill.getPoint()))){
 					comboAttack.addComboNum();
 				}
 			}
 		}

	}

	@Override
	public void afterAttack(Hunt hunt) {
	
		
	}

	@Override
	public int hit(Adventurer adventurer, AttackInfor attackInfor) {
		return attackInfor.getTotalDamage();
	}
	
}
