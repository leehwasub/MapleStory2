package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Homunscullo extends Monster {

	private static final long serialVersionUID = 1L;

	public Homunscullo() {
		super("호문스큘러", "homunscullo",
				new Strength(new Resistance(100, 100, 150, 100, 100, 100), 60, 67000, 2800, 10, 10, 40, 40), 732, 750, 775, 794,
				820 * Main.EXP_BONUS, 2340 * Main.MONEY_BONUS, false);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 300, "공격력약화", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(200, 400, "안티매직쉘", strength.getMaxHp(), 8));
		skillList.add(new MonsterSkillInfor(200, 500, "서클오브마나", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(500, 750, "포이즌미스트", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(750, 900, "체력회복", strength.getMaxHp() - 32000, 22));
		skillList.add(new MonsterSkillInfor(850, 1000, "더블슬래쉬", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}