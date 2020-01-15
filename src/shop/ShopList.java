package shop;

import java.util.ArrayList;

import map.PointMapName;

public class ShopList {
	private static ArrayList<Shop> shopList = new ArrayList<Shop>();

	static {
		shopList.add(new MapleIslandShop());
		shopList.add(new PellionShop());
		shopList.add(new LithHarborShop());
	}

	public static Shop getShop(PointMapName m) {
		for (int i = 0; i < shopList.size(); i++) {
			if (((Shop) shopList.get(i)).getPointMapName().equals(m)) {
				return (Shop) shopList.get(i);
			}
		}
		return null;
	}
}