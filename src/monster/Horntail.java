package monster;

import character.Monster;
import character.MonsterSkillInfor;
import character.Resistance;
import character.Strength;
import maplestory.Main;

public final class Horntail extends Monster {

	private static final long serialVersionUID = 1L;

	public Horntail() {
		super("혼테일", "horntail",
				new Strength(new Resistance(150, 50, 100, 100, 150, 50), 80, 4500000, 120000, 20, 20, 40, 40), 1123, 1244, 1305, 1362,
				200000 * Main.EXP_BONUS, 500000 * Main.MONEY_BONUS, true);
		initSkillList();
	}
	
	@Override
	public void initSkillList() {
		skillList.add(new MonsterSkillInfor(0, 150, "공격력강화", strength.getMaxHp(), 10));
		skillList.add(new MonsterSkillInfor(100, 250, "인피니티", strength.getMaxHp(), 2));
		skillList.add(new MonsterSkillInfor(200, 400, "플레임배리어", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(400, 700, "플레임바이트", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(700, 900, "강화된플레임샷", strength.getMaxHp(), 3));
		skillList.add(new MonsterSkillInfor(900, 1000, "더블슬래쉬", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 100, "블레이징익스팅션", strength.getMaxHp(), 1));
		skillList.add(new MonsterSkillInfor(0, 1000, "몸통박치기", strength.getMaxHp(), 0));
	}

}