package item;

import java.util.HashMap;

import character.Resistance;
import character.SexType;
import character.Strength;

public class ItemPool {
	private static HashMap<String, Item> items = new HashMap<String, Item>();
	private static int[] startPrice = {140, 140, 170, 130, 130, 110, 110};
	private static int[][] priceTable = new int[7][20];
	//상의, 하의, 무기, 방패, 핼멧, 신발, 장갑
	
	static {
		for(int i = 0; i < 7; i++) {
			calCostItem(i);
		}
		initWeaponItem();
		initClothsItem();
		initPantsItem();
		initComsumableItem();
		initShoesItem();
		initHelmetItem();
		initGloveItem();
		initTitleItem();
		initMaterialItem();
	}
	
	public static int getPrice(int type, int level) {
		return priceTable[type][level/5];
	}
	
	
	private static void calCostItem(int type) {
		double price = startPrice[type];
		double rate = 2.0;
		priceTable[type][0] = (int)price;
		for(int i = 1; i < 20; i++) {
			priceTable[type][i] = (int)(price * rate);
			price = priceTable[type][i];
			rate -= 0.05;
		}
		for(int i = 0; i < 20; i++) {
			int copyTable = priceTable[type][i];
			int r = 0;
			while(copyTable != 0) {
				r++;
				copyTable /= 10;
			}
			for(int j = 0; j < r - 2; j++) {
				priceTable[type][i] /= 10;
			}
			for(int j=0; j<r-2; j++) {
				priceTable[type][i] *= 10;
			}
		}
	}

	private static void initWeaponItem() {
		items.put("검", new WeaponItem("검", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 1), "sword", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 17, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("도루커대거", new WeaponItem("도루커대거", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 5), "dorkerDagger", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 5, 0, 0, 22, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		
		
		items.put("카알대검", new WeaponItem("카알대검", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 10), "carlGreatsword", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 10, 0, 0, 27, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("샤브르", new WeaponItem("샤브르", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 15), "saber", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 15, 0, 0, 32, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("바이킹소드", new WeaponItem("바이킹소드", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 20), "vikingSword", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 0, 0, 37, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("일룬", new WeaponItem("일룬", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 25), "lllun", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 42, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("글라디우스", new WeaponItem("글라디우스", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 30), "gradius", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 0, 0, 47, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("커틀러스", new WeaponItem("커틀러스", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 35), "cutlass", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 35, 0, 0, 52, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("트라우스", new WeaponItem("트라우스", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 40), "trous", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 57, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("네오코라", new WeaponItem("네오코라", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 45), "neokora", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 45, 0, 0, 62, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("쥬얼쿠아다라", new WeaponItem("쥬얼쿠아다라", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 50), "jeweledQuadra", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 67, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("스파타", new WeaponItem("스파타", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 55), "spata", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 55, 0, 0, 75, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("레드카타나", new WeaponItem("레드카타나", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 60), "redKatana", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 83, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
		items.put("프라우테", new WeaponItem("프라우테", getPrice(EquipmentItem.EQUIPMENT_TYPE_WAEPON, 70), "praote", 1, 
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 0, 0, 98, 0, 0, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_WAEPON, SexType.ALL, false, WeaponType.SWORD));
	}

	private static void initClothsItem() {
		items.put("하얀반팔면티(남)", new EquipmentItem("하얀반팔면티(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 1), "shortSleeveCottonMan", 1,
				new Strength(new Resistance(1, 1, 0, 0, 0, 0), 1, 0, 0, 0, 0, 3, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("노란반팔면티(여)", new EquipmentItem("노란반팔면티(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 1), "shortSleeveCottonWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 3, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("파란색원라인티셔츠(남)", new EquipmentItem("파란색원라인티셔츠(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 5), "blueOneLineTshirtMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 5, 0, 0, 0, 0, 7, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("분홍별무늬티셔츠(여)", new EquipmentItem("분홍별무늬티셔츠(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 5), "pinkStarTshirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 5, 0, 0, 0, 0, 7, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("로리카아머(남)", new EquipmentItem("로리카아머(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 10), "loricaArmorMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 10, 0, 0, 0, 0, 15, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("스퀘이머(여)", new EquipmentItem("스퀘이머(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 10), "squemmerWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 10, 0, 0, 0, 0, 15, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("코퍼럴", new EquipmentItem("코퍼럴", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 15), "corporal", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 15, 0, 0, 0, 0, 20, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.ALL, false));
		items.put("서전트(남)", new EquipmentItem("서전트(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 20), "sergeantMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 40, 0, 0, 0, 25, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("라멜(여)", new EquipmentItem("라멜(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 20), "ramelWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 40, 0, 0, 0, 25, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("마스터서전트(남)", new EquipmentItem("마스터서전트(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 25), "masterSergeantMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 50, 0, 0, 0, 30, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("샤크(여)", new EquipmentItem("샤크(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 25), "sharkWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 50, 0, 0, 0, 30, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("지장의", new EquipmentItem("지장의", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 30), "giGang", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 60, 0, 0, 0, 35, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.ALL, false));
		items.put("자진일갑주(남)", new EquipmentItem("자진일갑주(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 40), "jaJinwongArmorMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 80, 0, 0, 0, 45, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("흑진월갑주(여)", new EquipmentItem("흑진월갑주(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 40), "blackjinwongArmorWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 80, 0, 0, 0, 45, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("숄더메일(남)", new EquipmentItem("숄더메일(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 50), "shoulderMailMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 100, 0, 0, 0, 55, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("숄더메일(여)", new EquipmentItem("숄더메일(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 50), "shoulderMailWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 100, 0, 0, 0, 55, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("오리엔타이칸(남)", new EquipmentItem("오리엔타이칸(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 60), "orientTaikanMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 120, 0, 0, 0, 65, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.MAN, false));
		items.put("트란도트(여)", new EquipmentItem("트란도트(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 60), "trandotWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 120, 0, 0, 0, 65, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.WOMAN, false));
		items.put("플라티나", new EquipmentItem("플라티나", getPrice(EquipmentItem.EQUIPMENT_TYPE_CLOTHES, 70), "platinum", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 140, 0, 0, 0, 75, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_CLOTHES, SexType.ALL, false));
	}

	private static void initPantsItem() {
		items.put("파란청반바지(남)", new EquipmentItem("파란청반바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 1), "blueShortsMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 2, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("빨간미니스커트(여)", new EquipmentItem("빨간미니스커트(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 1), "redMiniSkirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 2, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("로리카바지(남)", new EquipmentItem("로리카바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 10), "loricaPantsMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 10, 0, 0, 0, 0, 12, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("소피아바지(여)", new EquipmentItem("소피아바지(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 10), "sophiaPantsWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 10, 0, 0, 0, 0, 12, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("코퍼럴바지", new EquipmentItem("코퍼럴바지", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 15), "corporalPants", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 15, 0, 0, 0, 0, 16, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.ALL, false));
		items.put("서전트치마(남)", new EquipmentItem("서전트치마(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 20), "sergeantSkirtMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 0, 0, 0, 0, 20, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("라멜치마(여)", new EquipmentItem("라멜치마(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 20), "ramelSkirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 0, 0, 0, 0, 20, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("마스터서전트치마(남)", new EquipmentItem("마스터서전트치마(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 25), "masterSergeantSkirtMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 0, 0, 24, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("샤크치마(여)", new EquipmentItem("샤크치마(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 25), "sharkSkirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 0, 0, 24, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("홍무바지", new EquipmentItem("홍무바지", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 30), "corporalPants", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 0, 0, 0, 0, 28, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.ALL, false));
		items.put("백진일갑주바지(남)", new EquipmentItem("백진일갑주바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 40), "baeJinilArmorMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 0, 0, 36, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("황진월갑주바지(여)", new EquipmentItem("황진월갑주바지(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 40), "hwangJinwolArmorWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 0, 0, 36, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("숄더메일바지(남)", new EquipmentItem("숄더메일바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 50), "shoulderMailPantsMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 0, 0, 45, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("숄더메일바지(여)", new EquipmentItem("숄더메일바지(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 50), "shoulderMailPantsWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 0, 0, 45, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("오리엔타이칸바지(남)", new EquipmentItem("오리엔타이칸바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 60), "orientTaikanPantsMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 0, 0, 52, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("트란도트치마(여)", new EquipmentItem("트란도트치마(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 60), "TrandotSkirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 0, 0, 52, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
		items.put("플라티나바지(남)", new EquipmentItem("플라티나바지(남)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 70), "platinPantsMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 0, 0, 0, 0, 60, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.MAN, false));
		items.put("플라티나바지(여)", new EquipmentItem("플라티나바지(여)", getPrice(EquipmentItem.EQUIPMENT_TYPE_PANTS, 70), "PlatinumPantsWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 0, 0, 0, 0, 60, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_PANTS, SexType.WOMAN, false));
	}

	private static void initComsumableItem() {
		items.put("초보모험가의빨간포션",
				new HealItem("초보모험가의빨간포션", 12, "newbieRedPortion", 1, new Heal(50, 0, 0, 0), 1));
		items.put("초보모험가의파란포션",
				new HealItem("초보모험가의파란포션", 25, "newbieBluePortion", 1, new Heal(0, 50, 0, 0), 1));
	}
	
	private static void initTitleItem() {
		
	}

	private static void initGloveItem() {
		items.put("미셀", new EquipmentItem("미셀", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 30), "micelle", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 0, 0, 0, 0, 13, 0, 1, 0, 0), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
		items.put("브리건", new EquipmentItem("브리건", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 35), "briggan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 35, 0, 0, 0, 0, 15, 0, 2, 0, 0), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
		items.put("너클", new EquipmentItem("너클", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 35), "knuckle", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 0, 0, 16, 0, 3, 0, 0), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
		items.put("브리스트", new EquipmentItem("브리스트", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 50), "birst", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 0, 0, 21, 0, 4, 0, 1), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
		items.put("클랜치", new EquipmentItem("클랜치", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 60), "clanchi", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 0, 0, 24, 0, 5, 0, 2), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
		items.put("허스크", new EquipmentItem("허스크", getPrice(EquipmentItem.EQUIPMENT_TYPE_GLOVE, 70), "husk", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 70, 0, 0, 0, 0, 29, 0, 6, 0, 3), EquipmentItem.EQUIPMENT_TYPE_GLOVE, SexType.ALL, false));
	}

	private static void initHelmetItem() {
		items.put("풀헬름", new EquipmentItem("풀헬름", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 15), "fullHelm", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 15, 0, 0, 0, 0, 15, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("디펜더헬멧", new EquipmentItem("디펜더헬멧", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 20), "defenderHelmet", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 20, 0, 0, 0, 0, 25, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("버거넷헬름", new EquipmentItem("버거넷헬름", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 25), "ironBurgerNet", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 0, 0, 30, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("주스창", new EquipmentItem("주스창", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 30), "juSting", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 30, 0, 0, 0, 0, 35, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("노르만헬름", new EquipmentItem("노르만헬름", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 40), "normanHelm", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 40, 0, 0, 0, 0, 45, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("돔", new EquipmentItem("돔", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 50), "dom", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 50, 0, 0, 0, 0, 60, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
		items.put("오리엔트헬멧", new EquipmentItem("오리엔트헬멧", getPrice(EquipmentItem.EQUIPMENT_TYPE_HELMET, 60), "orientHelmet", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 60, 0, 0, 0, 0, 75, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_HELMET, SexType.ALL, false));
	}

	private static void initShoesItem() {
		items.put("고무장화", new EquipmentItem("고무장화", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 1), "rubberBoots", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 2, 0, 0, 0, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("스틸그리브", new EquipmentItem("스틸그리브", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 15), "steelGrease", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 15, 0, 0, 0, 0, 9, 0, 0, 1, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("워부츠", new EquipmentItem("워부츠", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 25), "warBoots", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 25, 0, 0, 0, 0, 15, 0, 0, 2, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("배틀그리브", new EquipmentItem("배틀그리브", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 35), "battleGrease", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 35, 0, 0, 0, 0, 21, 0, 0, 3, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("힐던부츠", new EquipmentItem("힐던부츠", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 45), "hildanBoots", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 45, 0, 0, 0, 0, 30, 0, 0, 4, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("카젠부츠", new EquipmentItem("카젠부츠", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 55), "hildanBoots", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 55, 0, 0, 0, 0, 42, 0, 0, 5, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
		items.put("리버스부츠", new EquipmentItem("리버스부츠", getPrice(EquipmentItem.EQUIPMENT_TYPE_SHOES, 65), "reverseBoots", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 65, 0, 0, 0, 0, 48, 0, 0, 6, 0), EquipmentItem.EQUIPMENT_TYPE_SHOES, SexType.ALL, false));
	}

	private static void initMaterialItem() {
		items.put("파란달팽이의껍질",
				new MaterialItem("파란달팽이의껍질", 10, "blueSnailSkin", 1, "파란 달팽이의 껍질을 벗긴것이다."));
		items.put("빨간달팽이의껍질",
				new MaterialItem("빨간달팽이의껍질", 20, "redSnailSkin", 1, "빨간 달팽이의 껍질을 벗긴것이다."));
		items.put("돼지의리본", new MaterialItem("돼지의리본", 30, "pigRibbon", 1, "리본돼지의 리본을 끊은 것이다."));
		items.put("주황버섯의갓",
				new MaterialItem("주황버섯의갓", 40, "orangeMushroomCap", 1, "주황 버섯의 갓이다."));
		items.put("초록버섯의갓",
				new MaterialItem("초록버섯의갓", 50, "greenMushroomCap", 1, "초록 버섯의 갓이다."));
		items.put("��������", new MaterialItem("��������", 60, "branch", 1, "�������� ������������"));
		items.put("����", new MaterialItem("����", 70, "firewood", 1, "������������ ������ ������ ��������"));
		items.put("����������", new MaterialItem("����������", 500, "animalLeather", 1, "������ ������ ������ ������"));
		items.put("������������������",
				new MaterialItem("������������������", 90, "wildBoarCanine", 1, "������������ �������� ������ ������"));
		items.put("������������������", new MaterialItem("������������������", 100, "fireBoarCanine", 1,
				"������������ �������� ������ ������"));
		items.put("������������������", new MaterialItem("������������������", 110, "ironHoof", 1,
				"������ ������ ������ ������ ���� ������ �� ��������"));
		items.put("��������������������", new MaterialItem("��������������������", 120, "armorPiece", 1,
				"������������ �������� �������� ������ ������"));
		items.put("����", new MaterialItem("����", 130, "woodPan", 1, "���� �������� ���� ������ ���� ��������"));
		items.put("����", new MaterialItem("����", 140, "stonePan", 1, "���� �������� ���� ������ ��������"));
		items.put("����������", new MaterialItem("����������", 130, "skelDogBone", 1, "�������� ������ ������ ������"));
		items.put("����������",
				new MaterialItem("����������", 140, "dirtyBandage", 1, "�������� ���� �������� ������ ��������"));
		items.put("������", new MaterialItem("������", 150, "rib", 1, "�������� ������ ����������"));
		items.put("������", new MaterialItem("������", 160, "pelvicBone", 1, "�������� ������ ����������"));
		items.put("��������",
				new MaterialItem("��������", 200, "horseHeadBone", 1, "�������� �������� ���������� ���� ����������"));
	}

	public static Item getItem(String itemName, int num) {
		Item item = (Item) items.get(itemName);
		if ((item instanceof WeaponItem)) {
			WeaponItem item2 = (WeaponItem) item;
			WeaponItem e = new WeaponItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num,
					item2.getStrength(), item2.getType(), item2.getSex(), item2.isRare(), item2.getWeaponType());
			return e;
		}
		if ((item instanceof EquipmentItem)) {
			EquipmentItem item2 = (EquipmentItem) item;
			EquipmentItem e = new EquipmentItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num,
					item2.getStrength(), item2.getType(), item2.getSex(), item2.isRare());
			return e;
		}
		if (item instanceof BuffItem) {
			BuffItem item2 = (BuffItem) item;
			BuffItem e = new BuffItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num, item2.getLevel(), item2.getStrength(),
					item2.getLastTime());
			return e;
		}
		if (item instanceof HealItem) {
			HealItem item2 = (HealItem) item;
			HealItem e = new HealItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num, item2.getHeal(),
					item2.getLevel());
			return e;
		}
		if (item instanceof MaterialItem) {
			MaterialItem item2 = (MaterialItem) item;
			MaterialItem e = new MaterialItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num,
					item2.getInfor());
			return e;
		}
		return null;
	}
}