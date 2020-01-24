package shop;

import item.ItemPool;
import map.PointMapName;
import utils.ResourceLoader;

public class AriantShop extends Shop {
	public AriantShop() {
		this.pointMapName = new PointMapName(11, 4, "아리안트");
		this.npcImage = ResourceLoader.getImage("npcImage", "muhamadNpcImage.png");
		weaponItemList.add(ItemPool.getItem("커틀러스", 1));
		weaponItemList.add(ItemPool.getItem("트라우스", 1));
		weaponItemList.add(ItemPool.getItem("네오코라", 1));
		weaponItemList.add(ItemPool.getItem("쥬얼쿠아다라", 1));
		weaponItemList.add(ItemPool.getItem("장팔사모", 1));
		weaponItemList.add(ItemPool.getItem("나카마키", 1));
		weaponItemList.add(ItemPool.getItem("십자창", 1));
		weaponItemList.add(ItemPool.getItem("스페판", 1));
		equipmentItemList.add(ItemPool.getItem("자진일갑주(남)", 1));
		equipmentItemList.add(ItemPool.getItem("흑진월갑주(여)", 1));
		equipmentItemList.add(ItemPool.getItem("숄더메일(남)", 1));
		equipmentItemList.add(ItemPool.getItem("숄더메일(여)", 1));
		equipmentItemList.add(ItemPool.getItem("백진일갑주바지(남)", 1));
		equipmentItemList.add(ItemPool.getItem("황진월갑주바지(여)", 1));
		equipmentItemList.add(ItemPool.getItem("숄더메일바지(남)", 1));
		equipmentItemList.add(ItemPool.getItem("숄더메일바지(여)", 1));
		equipmentItemList.add(ItemPool.getItem("노르만헬름", 1));
		equipmentItemList.add(ItemPool.getItem("타워실드", 1));
		equipmentItemList.add(ItemPool.getItem("레전드실드", 1));
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
		consumableItemList.add(ItemPool.getItem("마을귀환주문서", 1));
	}
}
