package shop;

import java.util.ArrayList;

import map.PointMapName;

public class ShopList {
	private static ArrayList<Shop> shopList = new ArrayList<Shop>();

	static {
		shopList.add(new MapleIslandShop());
		shopList.add(new PellionShop());
		shopList.add(new LithHarborShop());
		shopList.add(new OrbisShop());
		shopList.add(new ElnathShop());
		shopList.add(new AriantShop());
		shopList.add(new MagatiaShop());
		shopList.add(new LeafreShop());
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