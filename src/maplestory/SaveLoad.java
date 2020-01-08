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
import npc.Npc;
import npc.NpcList;

public class SaveLoad {
	public static final String filename = Main.findSource(Main.class) + "/mapleData/playerinfo.dat";
	public static final String dirname = Main.findSource(Main.class) + "/mapleData";

	public static void savePlayer(Serializable player) {
		FileOutputStream fos = null;
		File dir = new File(dirname);

		File[] dirs = dir.listFiles();
		for (int i = 0; i < dirs.length; i++) {
			JOptionPane.showMessageDialog(null, dirs[i].getName());
		}
		System.out.println(dirname);
		dir.mkdirs();
		try {
			fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(player);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkFileExists1() {
		System.out.println(filename);
		return new File(filename).isFile();
	}

	public static Player loadPlayer() {
		Player player = null;
		if (checkFileExists1()) {
			InputStream fis = null;
			try {
				fis = new FileInputStream(filename);
				ObjectInputStream ois = new ObjectInputStream(fis);
				player = (Player) ois.readObject();
				ois.close();
				initImage(player);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return player;
	}

	private static void initImage(Player player) {
		Inventory inven = player.getInventory();
		ArrayList<EquipmentItem> eqipmentInven = inven.getEquipmentInventory();
		for (int i = 0; i < eqipmentInven.size(); i++) {
			((EquipmentItem) eqipmentInven.get(i)).setImageWithInstanceForInit();
		}
		ArrayList<ConsumableItem> consumableInven = inven.getConsumableInventory();
		for (int i = 0; i < consumableInven.size(); i++) {
			((ConsumableItem) consumableInven.get(i)).setImageWithInstanceForInit();
		}
		ArrayList<MaterialItem> materialInven = inven.getMaterialInventory();
		for (int i = 0; i < materialInven.size(); i++) {
			((MaterialItem) materialInven.get(i)).setImageWithInstanceForInit();
		}
		NpcList npcList = player.getNpcList();
		ArrayList<Npc> npcs = npcList.getNpcListArray();
		for (int i = 0; i < npcs.size(); i++) {
			((Npc) npcs.get(i)).setImageForInit();
		}
		player.getMainAdventurer().setImageWithInstanceForInit();
		player.get_curMap().MapleMapBackgroundInit();
	}
}