package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class PinkBean extends Monster {

	private static final long serialVersionUID = 1L;

	public PinkBean() {
		super("핑크빈", "pinkBean",
				new Strength(new Resistance(120, 120, 120, 120, 120, 120), 90, 9000000, 300000, 20, 20, 40, 40), 1348, 1423, 1480, 1557,
				500000 * Main.EXP_BONUS, 1000000 * Main.MONEY_BONUS, true);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 12));
		skillList.add(new MonsterSkillInfor(100, 250, "소울인듀어", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(200, 350, "에테리얼폼", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(0, 100, "제네시스", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(200, 350, "블리자드", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(350, 450, "아마겟돈", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(450, 600, "블레이징익스팅션", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(600, 750, "포이즌노바", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(750, 900, "녹스피어", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}