package monster;

import attack.Attack;
import attack.AttackFactory;
import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import component.StateBox;
import hunt.Hunt;

public class Mano extends Monster {

	private static final long serialVersionUID = 1L;

	public Mano() {
		super("마노", "mano",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 5, 400, 100, 0, 0, 2, 2, 10, 0, 0), 20, 23, 30,
				33, 100, 300, true);
		initSkillList();
	}

	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 400, "플래쉬", strength.getMaxHp()));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp()));
	}
}
