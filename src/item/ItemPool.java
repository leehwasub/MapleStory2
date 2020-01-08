package item;

import java.util.HashMap;

import character.Resistance;
import character.SexType;
import character.Strength;

public class ItemPool {
	private static HashMap<String, Item> items = new HashMap<String, Item>();

	static {
		initWeaponItem();
		initClothsItem();
		initPantsItem();
		initComsumableItem();
		initMaterialItem();
	}

	private static void initWeaponItem() {
		items.put("검", new WeaponItem("검", 160, "sword", 1, new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 17, 0, 0, 0, 0, 0, 0), 2, SexType.ALL, false, WeaponType.SWORD));
		items.put("도루커대거", new WeaponItem("도루커대거", 300, "dorkerDagger", 1, new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 22, 0, 0, 0, 0, 0, 0), 2, SexType.ALL, false, WeaponType.SWORD));
	}

	private static void initClothsItem() {
		items.put("하얀반팔면티(남)", new EquipmentItem("하얀반팔면티(남)", 110, "shortSleeveCottonMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 3, 0, 0, 0, 0), 0, SexType.MAN, false));
		items.put("노란반팔면티(여)", new EquipmentItem("노란반팔면티(여)", 110, "shortSleeveCottonWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 3, 0, 0, 0, 0), 0, SexType.WOMAN, false));
		items.put("파란색원라인티셔츠(남)", new EquipmentItem("파란색원라인티셔츠(남)", 230, "blueOneLineTshirtMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 5, 0, 0, 0, 0, 7, 0, 0, 0, 0), 0, SexType.MAN, false));
		items.put("분홍별무늬티셔츠(여)", new EquipmentItem("분홍별무늬티셔츠(여)", 230, "pinkStarTshirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 5, 0, 0, 0, 0, 7, 0, 0, 0, 0), 0, SexType.WOMAN, false));
	}

	private static void initPantsItem() {
		items.put("파란청반바지(남)", new EquipmentItem("파란청반바지(남)", 110, "blueShortsMan", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 2, 0, 0, 0, 0), 1, SexType.MAN, false));
		items.put("빨간미니스커트(여)", new EquipmentItem("빨간미니스커트(여)", 110, "redMiniSkirtWoman", 1,
				new Strength(new Resistance(0, 0, 0, 0, 0, 0), 1, 0, 0, 0, 0, 2, 0, 0, 0, 0), 1, SexType.WOMAN, false));
	}

	private static void initComsumableItem() {
		items.put("초보모험가의빨간포션",
				new HealItem("초보모험가의빨간포션", 12, "newbieRedPortion", 1, new Heal(50, 0, 0, 0), 1));
		items.put("초보모험가의파란포션",
				new HealItem("초보모험가의파란포션", 25, "newbieBluePortion", 1, new Heal(0, 50, 0, 0), 1));
	}

	private static void initMaterialItem() {
		items.put("파란달팽이의껍질",
				new MaterialItem("파란달팽이의껍질", 10, "blueSnailSkin", 1, "파란 달팽이의 껍질을 벗긴것이다."));
		items.put("빨간달팽이의껍질",
				new MaterialItem("빨간달팽이의껍질", 20, "redSnailSkin", 1, "빨간 달팽이의 껍질을 벗긴것이다."));
		items.put("돼지의리본", new MaterialItem("돼지의리본", 30, "pigRibbon", 1, "리본돼지의 리본을 끊은 것이다."));
		items.put("������������",
				new MaterialItem("������������", 40, "orangeMushroomCap", 1, "���������� ���� ����������"));
		items.put("������������",
				new MaterialItem("������������", 50, "greenMushroomCap", 1, "���������� ���� ����������"));
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
		System.out.println(item);
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
			BuffItem e = new BuffItem(item2.getName(), item2.getCost(), item2.getImageUrl(), num, item2.getStrength(),
					item2.getLastTime(), item2.getCancelRate());
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