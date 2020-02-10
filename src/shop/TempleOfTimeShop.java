package shop;

import item.ItemPool;
import map.PointMapName;
import utils.ResourceLoader;

public class TempleOfTimeShop extends Shop {
	public TempleOfTimeShop() {
		this.pointMapName = new PointMapName(1, 14, "시간의신전");
		this.npcImage = ResourceLoader.getImage("npcImage", "johannaNpcImage.png");
		weaponItemList.add(ItemPool.getItem("레드카타나", 1));
		weaponItemList.add(ItemPool.getItem("프라우테", 1));
		weaponItemList.add(ItemPool.getItem("페어프로즌", 1));
		weaponItemList.add(ItemPool.getItem("피나카", 1));
		equipmentItemList.add(ItemPool.getItem("오리엔타이칸(남)", 1));
		equipmentItemList.add(ItemPool.getItem("트란도트(여)", 1));
		equipmentItemList.add(ItemPool.getItem("플라티나", 1));
		equipmentItemList.add(ItemPool.getItem("오리엔타이칸바지(남)", 1));
		equipmentItemList.add(ItemPool.getItem("트란도트치마(여)", 1));
		equipmentItemList.add(ItemPool.getItem("플라티나바지(남)", 1));
		equipmentItemList.add(ItemPool.getItem("플라티나바지(여)", 1));
		equipmentItemList.add(ItemPool.getItem("오리엔트헬멧", 1));
		equipmentItemList.add(ItemPool.getItem("에이전트실드", 1));
		equipmentItemList.add(ItemPool.getItem("아퀼라실드", 1));
		consumableItemList.add(ItemPool.getItem("장어구이", 1));
		consumableItemList.add(ItemPool.getItem("쭈쭈바", 1));
		consumableItemList.add(ItemPool.getItem("살살녹는치즈", 1));
		consumableItemList.add(ItemPool.getItem("마나엘릭서", 1));
		consumableItemList.add(ItemPool.getItem("맑은물", 1));
		consumableItemList.add(ItemPool.getItem("팥빙수", 1));
		consumableItemList.add(ItemPool.getItem("엘릭서", 1));
		consumableItemList.add(ItemPool.getItem("전사의물약", 1));
		consumableItemList.add(ItemPool.getItem("명사수의물약", 1));
		consumableItemList.add(ItemPool.getItem("민첩함의물약", 1));
		consumableItemList.add(ItemPool.getItem("전사의알약", 1));
		consumableItemList.add(ItemPool.getItem("사미인탕", 1));
		consumableItemList.add(ItemPool.getItem("마을귀환주문서", 1));
		consumableItemList.add(ItemPool.getItem("만병통치약", 1));
		consumableItemList.add(ItemPool.getItem("블레이즈캡슐", 1));
		consumableItemList.add(ItemPool.getItem("글레이스캡슐", 1));
		consumableItemList.add(ItemPool.getItem("코카콜라알약", 1));
		consumableItemList.add(ItemPool.getItem("코카콜라제로알약", 1));
	}
}
