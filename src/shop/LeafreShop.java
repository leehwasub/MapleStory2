package shop;

import item.ItemPool;
import map.PointMapName;
import utils.ResourceLoader;

public class LeafreShop extends Shop {
	public LeafreShop() {
		this.pointMapName = new PointMapName(10, 9, "리프레");
		this.npcImage = ResourceLoader.getImage("npcImage", "guguNpcImage.png");
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
		consumableItemList.add(ItemPool.getItem("마을귀환주문서", 1));
		consumableItemList.add(ItemPool.getItem("만병통치약", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:브랜디쉬30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:분노30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:찬스어택20", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:브레이브슬래시30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:패닉30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:샤우트30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:콤보시너지30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:플레임차지30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:블리자드차지30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:실드마스터리20", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:라이트닝차지30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:리스토네이션20", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:위협30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:컴뱃오더스30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:피어싱쓰루30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:아이언월25", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:로드오브다크니스20", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:비홀더스버프30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:라만차스피어30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:비홀더쇼크30", 1));
		consumableItemList.add(ItemPool.getItem("마스터리북:크로스오버체인30", 1));
	}
}
