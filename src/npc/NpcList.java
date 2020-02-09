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
		npcList.add(new Blackbull("blackbull", "돼지와함께춤을", new PointMapName(5, 15, "페리온")));
		npcList.add(new TreasureBox("treasureBox", "보물상자", new PointMapName(2, 32, "와일드보어의땅2")));
		npcList.add(new Ayan("ayan", "이얀", new PointMapName(16, 2, "페리온")));
		npcList.add(new TenBoogies("tenBoogies", "열마리의부기", new PointMapName(16, 13, "페리온")));
		npcList.add(new Manji("manji", "만지", new PointMapName(23, 18, "페리온동쪽길목")));
		npcList.add(new Winston("winston", "윈스턴", new PointMapName(6, 2, "유적발굴캠프장")));
		npcList.add(new Shuang("shuang", "슈앵", new PointMapName(8, 2, "유적발굴캠프장")));
		npcList.add(new Starling("starling", "세릴", new PointMapName(10, 19, "폐쇄구역")));
		npcList.add(new Trina("trina", "티나", new PointMapName(14, 16, "오르비스")));
		npcList.add(new Lisa("lisa", "리사", new PointMapName(6, 8, "오르비스")));
		npcList.add(new Scadur("scadur", "스카두르", new PointMapName(8, 8, "엘나스")));
		npcList.add(new SergeantBravo("sergeantBravo", "브라보중사", new PointMapName(2, 14, "빙판길")));
		npcList.add(new Alcaster("alcaster", "알케스터", new PointMapName(2, 23, "엘나스")));
		npcList.add(new Tylus("tylus", "타일러스", new PointMapName(9, 20, "엘나스")));
		npcList.add(new HiddenRock("hiddenRock", "숨겨진바위", new PointMapName(10, 0, "위험한골짜기2")));
		npcList.add(new Jeff("jeff", "제프", new PointMapName(4, 1, "늑대의영역")));
		npcList.add(new Adobis("adobis", "아도비스", new PointMapName(3, 7, "자쿰의제단입구")));
		npcList.add(new Byron("byron", "바이런", new PointMapName(6, 26, "아리안트")));
		npcList.add(new Jiyur("jiyur", "지유르", new PointMapName(9, 14, "아리안트")));
		npcList.add(new Tigun("tigun", "티건", new PointMapName(2, 3, "아리안트궁전입구")));
		npcList.add(new Sejan("sejan", "세잔", new PointMapName(4, 13, "아리안트마을")));
		npcList.add(new Ardin("ardin", "아딘", new PointMapName(8, 21, "선인장사막")));
		npcList.add(new Jano("jano", "자노", new PointMapName(2, 1, "빈집6")));
		npcList.add(new Sirin("sirin", "시린", new PointMapName(5, 25, "아리안트마을")));
		npcList.add(new Sheherazard("sheherazard", "세헤라자드", new PointMapName(1, 5, "아리안트궁전")));
		npcList.add(new Areda("areda", "아레다", new PointMapName(2, 14, "아리안트궁전")));
		npcList.add(new Skyrom("skyrom", "스카이롬", new PointMapName(26, 11, "아리안트궁전지하2층")));
		npcList.add(new HanBroker("hanBroker", "한브로커", new PointMapName(7, 10, "마가티아")));
		npcList.add(new Keeny("keeny", "키니", new PointMapName(6, 22, "마가티아")));
		npcList.add(new Maed("maed", "매드", new PointMapName(0, 4, "알카드노연구소")));
		npcList.add(new Russellon("russellon", "러셀론", new PointMapName(5, 5, "연구소중앙게이트")));
		npcList.add(new Carson("carson", "카슨", new PointMapName(1, 4, "제뉴미스트연구소")));
		npcList.add(new Bedin("bedin", "베딘", new PointMapName(3, 14, "연구소1층복도")));
		npcList.add(new Phyllia("phyllia", "필리아", new PointMapName(1, 23, "마가티아")));
		npcList.add(new RealConfidentialDocument("realConfidentialDocument", "기밀문서1", new PointMapName(0, 8, "비밀연구소1구역")));
		npcList.add(new FakeConfidentialDocument("fakeConfidentialDocument", "기밀문서2", new PointMapName(0, 25, "비밀연구소1구역")));
		npcList.add(new FakeConfidentialDocument("fakeConfidentialDocument", "기밀문서3", new PointMapName(6, 17, "비밀연구소1구역")));
		npcList.add(new RealConfidentialDocument("realConfidentialDocument", "기밀문서4", new PointMapName(0, 6, "비밀연구소2구역")));
		npcList.add(new FakeConfidentialDocument("fakeConfidentialDocument", "기밀문서5", new PointMapName(1, 33, "비밀연구소2구역")));
		npcList.add(new RealConfidentialDocument("realConfidentialDocument", "기밀문서6", new PointMapName(6, 17, "비밀연구소2구역")));
		npcList.add(new ExplosiveDevice("explosiveDevice", "폭발장치", new PointMapName(3, 13, "비밀연구소3구역")));
		npcList.add(new Kupo("kupo", "쿠포", new PointMapName(4, 8, "리프레")));
		npcList.add(new Dame("dame", "데임", new PointMapName(6, 24, "리프레")));
		npcList.add(new MysteriousMagic("mysteriousMagician", "수상한마법사", new PointMapName(10, 4, "용의협곡")));
		npcList.add(new Tatamo("tatamo", "타타모", new PointMapName(10, 17, "리프레")));
		npcList.add(new Koscu("koscu", "코스쿠", new PointMapName(5, 3, "혼테일동굴입구")));
		npcList.add(new Crow("crow", "크로우", new PointMapName(10, 23, "리프레")));
		npcList.add(new Athena("athena", "헬레나", new PointMapName(5, 6, "시간의신전")));
		npcList.add(new TempleKeeper("templeKeeper", "신전관리인", new PointMapName(1, 18, "시간의신전")));
		npcList.add(new ForgottenTempleKeeper("forgottenTempleKeeper", "잊혀진신전관리인", new PointMapName(4, 3, "잊혀진회랑")));
	}

	public ArrayList<Npc> getNpcListArray() {
		return npcList;
	}
	
	public int getNpcProcess(String npcName) {
		for(int i = 0; i < npcList.size(); i++) {
			if(npcList.get(i).getName().equals(npcName)) {
				return npcList.get(i).getProcess();
			}
		}
		return -1;
	}
	
	public void setNpcProcess(String npcName, int process) {
		for(int i = 0; i < npcList.size(); i++) {
			if(npcList.get(i).getName().equals(npcName)) {
				npcList.get(i).setProcess(process);
			}
		}
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
			Npc npc = getNpcWithName(savedNpc.get(i).getName());
			if(npc != null) {
				npc.setProcess(savedNpc.get(i).getProcess());
				npc.setClearNum(savedNpc.get(i).getClearNum());
				npc.setQuestNum(savedNpc.get(i).getQuestNum());
				System.out.println(npc.getName() + " : " + npc.getProcess());
			}
		}
		ArrayList<UpdatedNpcInfor> updatedNpcList = player.getUpdatedNpcList();
		for(int i = 0; i < updatedNpcList.size(); i++) {
			updateLocNpc(updatedNpcList.get(i));
		}
	}
	
	public void saveNpcData(Player player) {
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
