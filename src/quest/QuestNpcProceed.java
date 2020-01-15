package quest;

import java.io.Serializable;

public class QuestNpcProceed implements Serializable {
	private static final long serialVersionUID = 1L;
	private String npcName;
	private int npcProceed;

	public QuestNpcProceed(String npcName, int npcProceed) {
		this.npcName = npcName;
		this.npcProceed = npcProceed;
	}

	public String getNpcName() {
		return this.npcName;
	}

	public int getNpcProceed() {
		return this.npcProceed;
	}

	public void setNpcName(String npcName) {
		this.npcName = npcName;
	}

	public void setNpcProceed(int npcProceed) {
		this.npcProceed = npcProceed;
	}

	
}