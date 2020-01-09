package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public final class GreenMushroom extends Monster {

	private static final long serialVersionUID = 1L;

	public GreenMushroom() {
		super("초록버섯", "greenMushroom",
				new Strength(new Resistance(100, 100, 150, 100, 100, 100), 9, 125, 10, 0, 0, 3, 0, 2, 2, 0), 34, 37, 0, 0,
				15, 24, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp()));
	}


}