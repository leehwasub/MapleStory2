package shop;

import item.ItemPool;
import map.PointMapName;
import utils.ResourceLoader;

public class MapleIslandShop extends Shop {
	public MapleIslandShop() {
		this.pointMapName = new PointMapName(2, 9, "암허스트");
		this.npcImage = ResourceLoader.getImage("npcImage", "lucyNpcImage.png");
		this.shareItemList.add(ItemPool.getItem("검", 1));
		this.shareItemList.add(ItemPool.getItem("도루커대거", 1));
		this.shareItemList.add(ItemPool.getItem("하얀반팔면티(남)", 1));
		this.shareItemList.add(ItemPool.getItem("노란반팔면티(여)", 1));
		this.shareItemList.add(ItemPool.getItem("파란청반바지(남)", 1));
		this.shareItemList.add(ItemPool.getItem("빨간미니스커트(여)", 1));
		this.consumableItemList.add(ItemPool.getItem("초보모험가의빨간포션", 1));
		this.consumableItemList.add(ItemPool.getItem("초보모험가의파란포션", 1));
	}
}
