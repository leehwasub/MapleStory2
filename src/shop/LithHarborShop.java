package shop;

import item.ItemPool;
import map.PointMapName;
import utils.ResourceLoader;

public class LithHarborShop extends Shop {
	public LithHarborShop() {
		this.pointMapName = new PointMapName(18, 10, "리스항구");
		this.npcImage = ResourceLoader.getImage("npcImage", "sidNpcImage.png");
		weaponItemList.add(ItemPool.getItem("도루커대거", 1));
		equipmentItemList.add(ItemPool.getItem("파란색원라인티셔츠(남)", 1));
		equipmentItemList.add(ItemPool.getItem("분홍별무늬티셔츠(여)", 1));
		consumableItemList.add(ItemPool.getItem("빨간포션", 1));
		consumableItemList.add(ItemPool.getItem("파란포션", 1));
		consumableItemList.add(ItemPool.getItem("주황포션", 1));
		consumableItemList.add(ItemPool.getItem("레몬", 1));
	}
}
