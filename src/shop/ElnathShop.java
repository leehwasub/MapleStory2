package shop;

import item.ItemPool;
import map.PointMapName;
import utils.ResourceLoader;

public class ElnathShop extends Shop {
	public ElnathShop() {
		this.pointMapName = new PointMapName(2, 12, "엘나스");
		this.npcImage = ResourceLoader.getImage("npcImage", "vogenNpcImage.png");
		weaponItemList.add(ItemPool.getItem("커틀러스", 1));
		weaponItemList.add(ItemPool.getItem("트라우스", 1));
		weaponItemList.add(ItemPool.getItem("장팔사모", 1));
		weaponItemList.add(ItemPool.getItem("나카마키", 1));
		equipmentItemList.add(ItemPool.getItem("자진일갑주(남)", 1));
		equipmentItemList.add(ItemPool.getItem("흑진월갑주(여)", 1));
		equipmentItemList.add(ItemPool.getItem("백진일갑주바지(남)", 1));
		equipmentItemList.add(ItemPool.getItem("황진월갑주바지(여)", 1));
		equipmentItemList.add(ItemPool.getItem("노르만헬름", 1));
		equipmentItemList.add(ItemPool.getItem("타워실드", 1));
		consumableItemList.add(ItemPool.getItem("하얀포션", 1));
		consumableItemList.add(ItemPool.getItem("레몬", 1));
		consumableItemList.add(ItemPool.getItem("새우튀김", 1));
		consumableItemList.add(ItemPool.getItem("장어구이", 1));
		consumableItemList.add(ItemPool.getItem("쭈쭈바", 1));
		consumableItemList.add(ItemPool.getItem("살살녹는치즈", 1));
		consumableItemList.add(ItemPool.getItem("마나엘릭서", 1));
		consumableItemList.add(ItemPool.getItem("맑은물", 1));
		consumableItemList.add(ItemPool.getItem("전사의물약", 1));
		consumableItemList.add(ItemPool.getItem("명사수의물약", 1));
		consumableItemList.add(ItemPool.getItem("민첩함의물약", 1));
		consumableItemList.add(ItemPool.getItem("전사의알약", 1));
		consumableItemList.add(ItemPool.getItem("사미인탕", 1));
		consumableItemList.add(ItemPool.getItem("마을귀환주문서", 1));
	}
}
