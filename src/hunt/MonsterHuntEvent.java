package hunt;

import java.awt.Graphics2D;
import java.io.Serializable;

import attack.AttackInfor;
import character.Adventurer;
import character.Monster;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.PlayerAttack;

public class MonsterHuntEvent implements HuntEvent, Serializable {

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
		Monster monster = hunt.getMonster();
		if(monster.isAlreadyBuffed("인피니티")) {
			int skillPoint = monster.getMonsterSkillInforWithName("인피니티").getSkillPoint();
			monster.healHp(skillPoint * 3000);
		}
	}
	
	@Override
	public void startAttack(Hunt hunt) {
		
	}

	@Override
	public void afterAttack(Hunt hunt) {
		
	}

	@Override
	public int hit(Adventurer adventurer, AttackInfor attackInfor) {
		return attackInfor.getTotalDamage();
	}

}
