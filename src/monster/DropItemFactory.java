package monster;

import java.util.ArrayList;

import character.Monster;
import item.Item;
import item.ItemPool;
import maplestory.Player;

public class DropItemFactory {
	public static boolean isRange(int mid, int low, int high) {
		return (low <= mid) && (mid < high);
	}

	public static ArrayList<Item> dropItemWithMonster(Monster monster, Player player) {
		ArrayList<Item> getItems = new ArrayList<Item>();
		int percent = (int) (Math.random() * 100.0D);
		if (isRange(percent, 0, 40)) {
			if (monster instanceof BlueSnail) {
				getItems.add(ItemPool.getItem("파란달팽이의껍질", 1));
			} else if (monster instanceof RedSnail) {
				getItems.add(ItemPool.getItem("빨간달팽이의껍질", 1));
			} else if (monster instanceof RibbonPig) {
				getItems.add(ItemPool.getItem("돼지의리본", 1));
			} else if (monster instanceof OrangeMushroom) {
				getItems.add(ItemPool.getItem("주황버섯의갓", 1));
			} else if (monster instanceof GreenMushroom) {
				getItems.add(ItemPool.getItem("초록버섯의갓", 1));
			} else if (monster instanceof Stump) {
				getItems.add(ItemPool.getItem("나뭇가지", 1));
			} else if (monster instanceof AxeStump) {
				getItems.add(ItemPool.getItem("장작", 1));
			} else if (monster instanceof WildBoar) {
				getItems.add(ItemPool.getItem("와일드보어의송곳니", 1));
			} else if (monster instanceof FireBoar) {
				getItems.add(ItemPool.getItem("파이어보어의송곳니", 1));
			} else if (monster instanceof IronHog) {
				getItems.add(ItemPool.getItem("아이언호그의철발굽", 1));
			} else if (monster instanceof IronBoar) {
				getItems.add(ItemPool.getItem("아이언보어의갑옷조각", 1));
			} else if (monster instanceof WoodenMask) {
				getItems.add(ItemPool.getItem("목판", 1));
			} else if (monster instanceof RockyMask) {
				getItems.add(ItemPool.getItem("석판", 1));
			} else if (monster instanceof Skeledog) {
				getItems.add(ItemPool.getItem("스켈독의뼈", 1));
			} else if (monster instanceof Mummydog) {
				getItems.add(ItemPool.getItem("더러운붕대", 1));
			} else if (monster instanceof SkeletonSoldier) {
				getItems.add(ItemPool.getItem("갈비뼈", 1));
			} else if (monster instanceof SkeletonOfficer) {
				getItems.add(ItemPool.getItem("골반뼈", 1));
			} else if (monster instanceof SkeletonCommander) {
				getItems.add(ItemPool.getItem("말머리뼈", 1));
			}
		}
		return getItems;
	}

	public static String dropItemWithLevel(Monster monster, Player player) {
		int percent = (int) (Math.random() * 1000.0D);
		int lv = monster.getStrength().getLevel();
		ArrayList<Item> getItems = dropItemWithMonster(monster, player);
		if (isRange(lv, 1, 5)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("초보모험가의빨간포션", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("초보모험가의파란포션", 1));
			}
		} else if(isRange(lv, 5, 10)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("빨간포션", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("파란포션", 1));
			}
		}  else if(isRange(lv, 10, 15)) {
			if (isRange(percent, 0, 100)) {
				getItems.add(ItemPool.getItem("주황포션", 1));
			} else if (isRange(percent, 100, 200)) {
				getItems.add(ItemPool.getItem("파란포션", 1));
			}
		}
		StringBuffer getItemInfor = new StringBuffer();
		for (int i = 0; i < getItems.size(); i++) {
			player.addItem((Item) getItems.get(i));
			getItemInfor.append(((Item) getItems.get(i)).toGetInfor() + " ");
		}
		return getItemInfor.toString();
	}
}
