package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Rurumo extends Monster {

	private static final long serialVersionUID = 1L;

	public Rurumo() {
		super("루루모", "rurumo",
				new Strength(new Resistance(100, 100, 170, 100, 100, 100), 58, 420000, 28000, 0, 0, 800, 800, 40, 40, 0), 770, 791, 870, 910,
				22000 * Main.EXP_BONUS, 60000 * Main.MONEY_BONUS, true);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "공격력강화", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(300, 600, "서클오브마나", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(600, 800, "포이즌미스트", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(800, 1000, "더블슬래쉬", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}