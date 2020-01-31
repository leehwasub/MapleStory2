package shop;

import item.ItemPool;
import map.PointMapName;
import utils.ResourceLoader;

public class MagatiaShop extends Shop {
	public MagatiaShop() {
		this.pointMapName = new PointMapName(10, 28, "마가티아");
		this.npcImage = ResourceLoader.getImage("npcImage", "jerryNpcImage.png");
		weaponItemList.add(ItemPool.getItem("네오코라", 1));
		weaponItemList.add(ItemPool.getItem("쥬얼쿠아다라", 1));
		weaponItemList.add(ItemPool.getItem("스파타", 1));
		weaponItemList.add(ItemPool.getItem("레드카타나", 1));
		weaponItemList.add(ItemPool.getItem("십자창", 1));
		weaponItemList.add(ItemPool.getItem("스페판", 1));
		weaponItemList.add(ItemPool.getItem("호진공창", 1));
		weaponItemList.add(ItemPool.getItem("페어프로즌", 1));
		equipmentItemList.add(ItemPool.getItem("숄더메일(남)", 1));
		equipmentItemList.add(ItemPool.getItem("숄더메일(여)", 1));
		equipmentItemList.add(ItemPool.getItem("오리엔타이칸(남)", 1));
		equipmentItemList.add(ItemPool.getItem("트란도트(여)", 1));
		equipmentItemList.add(ItemPool.getItem("숄더메일바지(남)", 1));
		equipmentItemList.add(ItemPool.getItem("숄더메일바지(여)", 1));
		equipmentItemList.add(ItemPool.getItem("오리엔타이칸바지(남)", 1));
		equipmentItemList.add(ItemPool.getItem("트란도트치마(여)", 1));
		equipmentItemList.add(ItemPool.getItem("돔", 1));
		equipmentItemList.add(ItemPool.getItem("레전드실드", 1));
		equipmentItemList.add(ItemPool.getItem("에이전트실드", 1));
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
		consumableItemList.add(ItemPool.getItem("만병통치약", 1));
	}
}
