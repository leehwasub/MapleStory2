package npc;

import java.io.Serializable;
import java.util.ArrayList;

import map.PointMapName;
import map.UpdatedMapInfor;
import maplestory.Player;

public class NpcList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static NpcList instance;
	private ArrayList<Npc> npcList = new ArrayList<Npc>();
	
	private NpcList() {
		init();
	}
	
	public static NpcList getInstance() {
		if(instance == null) {
			instance = new NpcList();
		}
		return instance;
		
	}
	
	public void reload() {
		init();
	}

	private void init() {
		npcList.clear();
		npcList.add(new Sugar("sugar", "슈가", new PointMapName(6, 7, "초보자의숲1")));
		npcList.add(new Mai("mai", "마이", new PointMapName(3, 8, "초보자의숲2")));
	}

	public ArrayList<Npc> getNpcListArray() {
		return npcList;
	}
	
	
	private void updateLocNpc(UpdatedNpcInfor infor) {
		for(int i = 0; i < npcList.size(); i++) {
			if(npcList.get(i).getName().equals(infor.getNpcName())) {
				npcList.get(i).setPointMapName(infor.getPointMapName());
			}
		}
	}
	

	public void loadNpcData(Player player) {
		ArrayList<Npc> savedNpc = player.getNpcList();
		for(int i = 0; i < savedNpc.size(); i++) {
			for(int j = 0; j < npcList.size(); j++) {
				if(savedNpc.get(i).getName().equals(npcList.get(i).getName())){
					npcList.get(i).setProcess(savedNpc.get(i).getProcess());
					npcList.get(i).setClearNum(savedNpc.get(i).getClearNum());
					npcList.get(i).setQuestNum(savedNpc.get(i).getQuestNum());
				}
			}
		}
		ArrayList<UpdatedNpcInfor> updatedNpcList = player.getUpdatedNpcList();
		for(int i = 0; i < updatedNpcList.size(); i++) {
			updateLocNpc(updatedNpcList.get(i));
		}
	}
	
	public void saveNpcData(Player player) {
		System.out.println(npcList.size());
		player.setNpcList(npcList);
	}

	public Npc getNpcWithName(String npcName) {
		for (int i = 0; i < npcList.size(); i++) {
			if (((Npc) npcList.get(i)).getName().equals(npcName)) {
				return (Npc) npcList.get(i);
			}
		}
		return null;
	}

	public Npc getNpc(PointMapName pointMapName) {
		for (int i = 0; i < npcList.size(); i++) {
			if (((Npc) npcList.get(i)).equals(pointMapName)) {
				return (Npc) npcList.get(i);
			}
		}
		return null;
	}
	
}
