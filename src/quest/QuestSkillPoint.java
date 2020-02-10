package quest;

import maplestory.Player;

public class QuestSkillPoint extends QuestCondition {

	private int level;
	private static final long serialVersionUID = 1L;
	
	public QuestSkillPoint(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String checkState(Player player) {
		int playerLevel = player.getMainAdventurer().getAdventurerLevel();
		int curSkillPoint = player.getMainAdventurer().getSkillPoint();
		int needToSpendSkillPoint = (4 + (playerLevel - level) * 4);
		return "써야 하는 스킬 포인트 : " + ((curSkillPoint - needToSpendSkillPoint < 0 ? 0 : curSkillPoint - needToSpendSkillPoint)) + "";
	}

	@Override
	public boolean checkClear(Player player) {
		int playerLevel = player.getMainAdventurer().getAdventurerLevel();
		return (player.getMainAdventurer().getSkillPoint() <= (4 + (playerLevel - level) * 4));
	}

}
