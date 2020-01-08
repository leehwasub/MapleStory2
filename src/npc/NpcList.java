package npc;

import java.io.Serializable;
import java.util.ArrayList;

import map.PointMapName;

public class NpcList implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Npc> npcList = new ArrayList<Npc>();

	public NpcList() {
		this.npcList.add(new Sugar("sugar", "슈가", new PointMapName(6, 7, "초보자의숲1")));
		this.npcList.add(new Mai("mai", "마이", new PointMapName(3, 8, "초보자의숲2")));
	}

	public ArrayList<Npc> getNpcListArray() {
		return this.npcList;
	}

	public Npc getNpcWithName(String npcName) {
		for (int i = 0; i < this.npcList.size(); i++) {
			if (((Npc) this.npcList.get(i)).getName().equals(npcName)) {
				return (Npc) this.npcList.get(i);
			}
		}
		return null;
	}

	public Npc getNpc(PointMapName pointMapName) {
		for (int i = 0; i < this.npcList.size(); i++) {
			if (((Npc) this.npcList.get(i)).equals(pointMapName)) {
				return (Npc) this.npcList.get(i);
			}
		}
		return null;
	}
}
