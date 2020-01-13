package shop;

import item.ItemPool;
import map.PointMapName;
import utils.ResourceLoader;

public class PellionShop extends Shop {
	public PellionShop() {
		this.pointMapName = new PointMapName(4, 5, "페리온");
		this.npcImage = ResourceLoader.getImage("npcImage", "riverNpcImage.png");
		weaponItemList.add(ItemPool.getItem("카알대검", 1));
		weaponItemList.add(ItemPool.getItem("샤브르", 1));
		weaponItemList.add(ItemPool.getItem("바이킹소드", 1));
		weaponItemList.add(ItemPool.getItem("일룬", 1));
		equipmentItemList.add(ItemPool.getItem("로리카아머(남)", 1));
		equipmentItemList.add(ItemPool.getItem("스퀘이머(여)", 1));
		equipmentItemList.add(ItemPool.getItem("코퍼럴", 1));
		equipmentItemList.add(ItemPool.getItem("서전트(남)", 1));
		equipmentItemList.add(ItemPool.getItem("라멜(여)", 1));
		equipmentItemList.add(ItemPool.getItem("마스터서전트(남)", 1));
		equipmentItemList.add(ItemPool.getItem("샤크(여)", 1));
		equipmentItemList.add(ItemPool.getItem("로리카바지(남)", 1));
		equipmentItemList.add(ItemPool.getItem("소피아바지(여)", 1));
		equipmentItemList.add(ItemPool.getItem("코퍼럴바지", 1));
		equipmentItemList.add(ItemPool.getItem("서전트치마(남)", 1));
		equipmentItemList.add(ItemPool.getItem("라멜치마(여)", 1));
		equipmentItemList.add(ItemPool.getItem("마스터서전트치마(남)", 1));
		equipmentItemList.add(ItemPool.getItem("샤크치마(여)", 1));
		consumableItemList.add(ItemPool.getItem("빨간포션", 1));
		consumableItemList.add(ItemPool.getItem("파란포션", 1));
		consumableItemList.add(ItemPool.getItem("주황포션", 1));
		consumableItemList.add(ItemPool.getItem("레몬", 1));
		consumableItemList.add(ItemPool.getItem("하얀포션", 1));
		consumableItemList.add(ItemPool.getItem("새우튀김", 1));
	}
}
