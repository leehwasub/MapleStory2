package npc;

import java.io.Serializable;
import java.util.ArrayList;

import map.PointMapName;
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
		npcList.add(new Lucas("lucas", "루카스", new PointMapName(9, 6, "암허스트")));
		npcList.add(new Rain("rain", "레인", new PointMapName(4, 13, "암허스트")));
		npcList.add(new Biggs("biggs", "빅스", new PointMapName(2, 12, "사우스페리")));
		npcList.add(new Parbell("parbell", "파벨", new PointMapName(15, 2, "리스항구")));
		npcList.add(new Jane("jane", "제인", new PointMapName(11, 6, "리스항구")));
		npcList.add(new DancesWithBalrog("dancesWithBalrog", "주먹펴고일어서", new PointMapName(10, 9, "페리온")));
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
