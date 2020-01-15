package maplestory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import item.ConsumableItem;
import item.EquipmentItem;
import item.MaterialItem;

public class SaveLoad {
	public static final String filename[];
	//이클립스
	public static final String dirname = Main.findSource(Main.class) + "/../../mapleData";
	//jar
	//public static final String dirname = Main.findSource(Main.class) + "/mapleData";
	public static final int DATA_NUM = 10;
	
	static {
		filename = new String[DATA_NUM];
		for(int i = 0; i < DATA_NUM; i++) {
			//filename[i] = Main.findSource(Main.class) + "/mapleData/playerinfo"+i+".dat";
			filename[i] = Main.findSource(Main.class) + "/../../mapleData/playerinfo"+i+".dat";
		}
	}
	
	
	private static void makeDir(File dir) {
		if(!dir.exists()) {
			try {
				dir.mkdirs();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "폴더 생성 오류!!");
			}
		}
	}

	public static void savePlayer(int index, Serializable player) {
		FileOutputStream fos = null;
		File dir = new File(dirname);
		JOptionPane.showMessageDialog(null, dirname);
		makeDir(dir);
		File[] dirs = dir.listFiles();
		for (int i = 0; i < dirs.length; i++) {
			JOptionPane.showMessageDialog(null, dirs[i].getName());
		}
		try {
			fos = new FileOutputStream(filename[index]);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(player);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkFileExists1(int index) {
		return new File(filename[index]).isFile();
	}

	public static Player loadPlayer(int index) {
		Player player = null;
		if (checkFileExists1(index)) {
			InputStream fis = null;
			try {
				fis = new FileInputStream(filename[index]);
				ObjectInputStream ois = new ObjectInputStream(fis);
				player = (Player) ois.readObject();
				ois.close();
				if(player != null) {
					initImageForLoad(player);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return player;
	}

	private static void initImageForLoad(Player player) {
		Inventory inven = player.getInventory();
		ArrayList<EquipmentItem> eqipmentInven = inven.getEquipmentInventory();
		for (int i = 0; i < eqipmentInven.size(); i++) {
			((EquipmentItem) eqipmentInven.get(i)).setImageWithTypeForInit();
		}
		ArrayList<ConsumableItem> consumableInven = inven.getConsumableInventory();
		for (int i = 0; i < consumableInven.size(); i++) {
			((ConsumableItem) consumableInven.get(i)).setImageWithInstanceForInit();
		}
		ArrayList<MaterialItem> materialInven = inven.getMaterialInventory();
		for (int i = 0; i < materialInven.size(); i++) {
			((MaterialItem) materialInven.get(i)).setImageWithInstanceForInit();
		}
		EquipmentItem[] wearEqipmentArray = player.getMainAdventurer().getWearEquipment();
		for(int i = 0; i < wearEqipmentArray.length; i++) {
			if(wearEqipmentArray[i] != null) {
				((EquipmentItem) wearEqipmentArray[i]).setImageWithTypeForInit();
			}
		}
		player.getMainAdventurer().setImageWithInstanceForInit();
		player.get_curMap().MapleMapBackgroundInit();
		player.getMainAdventurer().setAllSkillImageForInit();
	}
}