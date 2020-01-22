package shop;

import item.ItemPool;
import map.PointMapName;
import utils.ResourceLoader;

public class OrbisShop extends Shop {
	public OrbisShop() {
		this.pointMapName = new PointMapName(16, 6, "오르비스");
		this.npcImage = ResourceLoader.getImage("npcImage", "krielNpcImage.png");
		weaponItemList.add(ItemPool.getItem("일룬", 1));
		weaponItemList.add(ItemPool.getItem("글라디우스", 1));
		weaponItemList.add(ItemPool.getItem("삼지창", 1));
		weaponItemList.add(ItemPool.getItem("제코", 1));
		equipmentItemList.add(ItemPool.getItem("마스터서전트(남)", 1));
		equipmentItemList.add(ItemPool.getItem("샤크(여)", 1));
		equipmentItemList.add(ItemPool.getItem("지장의", 1));
		equipmentItemList.add(ItemPool.getItem("마스터서전트치마(남)", 1));
		equipmentItemList.add(ItemPool.getItem("샤크치마(여)", 1));
		equipmentItemList.add(ItemPool.getItem("홍무바지", 1));
		equipmentItemList.add(ItemPool.getItem("미셀", 1));
		equipmentItemList.add(ItemPool.getItem("디펜더헬멧", 1));
		equipmentItemList.add(ItemPool.getItem("버거넷헬름", 1));
		equipmentItemList.add(ItemPool.getItem("레드크로스실드", 1));
		consumableItemList.add(ItemPool.getItem("하얀포션", 1));
		consumableItemList.add(ItemPool.getItem("레몬", 1));
		consumableItemList.add(ItemPool.getItem("새우튀김", 1));
		consumableItemList.add(ItemPool.getItem("장어구이", 1));
		consumableItemList.add(ItemPool.getItem("쭈쭈바", 1));
		consumableItemList.add(ItemPool.getItem("마나엘릭서", 1));
		consumableItemList.add(ItemPool.getItem("전사의물약", 1));
		consumableItemList.add(ItemPool.getItem("명사수의물약", 1));
		consumableItemList.add(ItemPool.getItem("민첩함의물약", 1));
		consumableItemList.add(ItemPool.getItem("전사의알약", 1));
		consumableItemList.add(ItemPool.getItem("마을귀환주문서", 1));
	}
}
