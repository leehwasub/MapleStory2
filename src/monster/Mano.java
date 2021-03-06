package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;

public class Mano extends Monster {

	private static final long serialVersionUID = 1L;

	public Mano() {
		super("마노", "mano",
				new Strength(new Resistance(100, 100, 100, 100, 100, 100), 5, 300, 100, 10, 10, 10, 0), 17, 20, 19,
				23, 100, 300, true);
		initSkillList();
	}

	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "플래쉬", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}
}
