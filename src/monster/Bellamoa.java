package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Bellamoa extends Monster {

	private static final long serialVersionUID = 1L;

	public Bellamoa() {
		super("벨라모아", "bellamoa",
				new Strength(new Resistance(150, 50, 100, 100, 100, 100), 44, 19700, 400, 10, 10, 37, 37), 517, 530, 530, 550,
				302 * Main.EXP_BONUS, 675 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "공격력강화", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 6));
		skillList.add(new MonsterSkillInfor(700, 1000, "플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}