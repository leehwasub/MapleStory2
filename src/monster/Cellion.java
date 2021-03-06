package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Cellion extends Monster {

	private static final long serialVersionUID = 1L;

	public Cellion() {
		super("샐리온", "cellion",
				new Strength(new Resistance(150, 50, 100, 100, 100, 100), 28, 3230, 600, 10, 10, 27, 27), 240, 245, 260, 271,
				110 * Main.EXP_BONUS, 182 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 4));
		skillList.add(new MonsterSkillInfor(150, 300, "회피율강화", strength.getMaxHp(), 4));
		skillList.add(new MonsterSkillInfor(900, 1000, "안티매직쉘", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(600, 900, "플래쉬", strength.getMaxHp(), 5));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}


}