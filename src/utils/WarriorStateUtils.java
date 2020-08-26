package utils;

public class WarriorStateUtils {
	private static final int[] MAX_HP = new int[ExpUtils.MAX_LEVEL + 1];
	private static final int[] MAX_MP = new int[ExpUtils.MAX_LEVEL + 1];

	static {
		int b = 0;
		int c = 0;
		for (int i = 1; i <= ExpUtils.MAX_LEVEL; i++) {
			b = b + 35 + (i - 1) * 2;
			MAX_HP[i] = b;
			c = c + 4 + (i - 1) / 13;
			MAX_MP[i] = c;
			//System.out.println("MAX_HP["+i+"] = "+ MAX_HP[i] +", MAX_MP["+i+"] = " + MAX_MP[i]);
		}
	}

	public static int[] getMaxHp() {
		return MAX_HP;
	}

	public static int[] getMaxMp() {
		return MAX_MP;
	}

	public static int getMaxHpByIndex(int index) {
		return MAX_HP[index];
	}

	public static int getMaxMpByIndex(int index) {
		return MAX_MP[index];
	}
}
