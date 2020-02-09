package npc;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

import character.AdventurerFactory;
import dialog.JobSelectDialog;
import map.PointMapName;
import maplestory.MainMapleInterface;
import maplestory.Message;
import maplestory.Player;
import utils.FileLoader;
import utils.FontUtils;
import utils.MusicUtils;
import utils.ResourceLoader;

public abstract class Npc implements Serializable {
	private static final long serialVersionUID = 1L;
	private transient Image image;
	private transient Image miniImage;
	private String imageUrl;
	protected String name;
	protected int process;
	private ArrayList<Talk> talkList = new ArrayList<Talk>();
	private PointMapName pointMapName;
	protected int questNum;
	protected int clearNum;

	public Npc(String imageUrl, String name, PointMapName pointMapName) {
		this.imageUrl = imageUrl;
		setImageForInit();
		this.name = name;
		this.pointMapName = pointMapName;
		try {
			initTalkList(this.imageUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setImageForInit() {
		this.image = ResourceLoader.getImage("npcImage", this.imageUrl + "NpcImage.png");
		this.miniImage = ResourceLoader.getImage("npcMiniImage", this.imageUrl + "NpcImage.png");
	}

	public void initTalkList(String engName) throws Exception {
		InputStream in = new FileLoader().getFileStream("text", engName + ".txt");
		BufferedReader bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));

		int lineNum = 0;
		Talk talk = null;
		String line;
		while ((line = bf.readLine()) != null) {
			if (lineNum % 2 == 0) {
				talk = new Talk(line);
			} else {
				String[] property = line.split(" ");
				talk.setType(Integer.parseInt(property[0]));
				talk.setCanTalkMore(Boolean.parseBoolean(property[1]));
				talk.setProceed(Boolean.parseBoolean(property[2]));
				this.talkList.add(talk);
			}
			lineNum++;
		}
		bf.close();
	}

	public PointMapName getPointMapName() {
		return this.pointMapName;
	}

	public void setPointMapName(PointMapName pointMapName) {
		this.pointMapName = pointMapName;
	}

	public boolean equals(Object obj) {
		PointMapName obj2 = (PointMapName) obj;
		if ((obj2.getMapName().equals(this.pointMapName.getMapName())) && (obj2.getX() == this.pointMapName.getX())
				&& (obj2.getY() == this.pointMapName.getY())) {
			return true;
		}
		return false;
	}

	public void setTalk(Talk talk, MainMapleInterface m, Player player) {
		mappingMessage(player, talk);
		Color color = Color.WHITE;
		if (talk.getType() == Talk.REWARD_TALK_TYPE) {
			color = Color.MAGENTA;
			System.out.println(player.getQuest().getRewardString());
			m.pushMessage(new Message(player.getQuest().getRewardString(), color, !talk.isCanTalkMore()));
			return;
		} else if(talk.getType() == Talk.UPGRADE_TYPE) {
			color = Color.MAGENTA;
			MusicUtils.startEffectSound("getCareer");
			player.questClear();
			clearEvent(player);
			this.clearNum += 1;
		} else if(talk.getType() == Talk.WHISPER_TALK_TYPE) {
			color = Color.CYAN;
		}
		m.pushMessage(new Message(talk.getMessage(), color, !talk.isCanTalkMore()));
	}
	
	private void mappingMessage(Player player, Talk talk) {
		String message = talk.getMessage();
		if(message.indexOf("<name>") != -1) {
			message = message.replace("<name>", player.getMainAdventurer().getName());
		}
		if(message.indexOf("<sex>") != -1) {
			message = message.replace("<sex>", player.getMainAdventurer().getSex().equals("남자") ? "그" : "그녀");
		}
		talk.setMessage(message);
	}

	public boolean process(Player player, MainMapleInterface m) {
		Talk talk = (Talk) this.talkList.get(this.process);
		setTalk(talk, m, player);
		if (talk.getType() == Talk.QUEST_CLEAR_CHECK_TYPE && player.getQuest() != null && player.isQuestsClear()) {
			this.process += 1;
			talk = (Talk) this.talkList.get(this.process);
			setTalk(talk, m, player);
		}
		if(talk.getType() == Talk.JOB_SELECTION_TALK_TYPE) {
			JobSelectDialog dialog = new JobSelectDialog();
			dialog.setVisible(true);
			if(dialog.getReturnIndex() != -1) {
				this.process += 1;
				talk = (Talk) this.talkList.get(this.process);
				talk.setCanTalkMore(true);
				talk.setProceed(true);
				AdventurerFactory.upgradeAdventurer(dialog.getSelectedJobName(), player.getMainAdventurer());
			} else {
				talk.setCanTalkMore(false);
				talk.setProceed(false);
			}
			setTalk(talk, m, player);
		}
		doEventWithType(talk, player);
		System.out.println(this.process + " " + talk);
		if (talk.isProceed()) {
			this.process += 1;
		}
		return talk.isCanTalkMore();
	}

	public void doEventWithType(Talk talk, Player player) {
		if (talk.getType() == 1) {
			player.questClear();
			clearEvent(player);
			this.clearNum += 1;
		} else if (talk.getType() == 2) {
			requestQuest(player);
			this.questNum += 1;
		}
		normalEvent(player);
	}

	public abstract void normalEvent(Player player);
	public abstract void clearEvent(Player player);
	public abstract void requestQuest(Player player);

	public void draw(Graphics2D g) {
		npcDraw(this.image, g);
		g.setFont(FontUtils.generalFont);
		g.setColor(Color.BLUE);
		g.drawString(this.name, 500, 140);
	}

	private void npcDraw(Image image, Graphics2D g) {
		g.drawImage(image, (300 - image.getWidth(null)) / 2 + 480, (300 - image.getHeight(null)) / 2 + 100, null);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProcess() {
		return this.process;
	}

	public ArrayList<Talk> getTalkList() {
		return this.talkList;
	}

	public void setProcess(int process) {
		this.process = process;
	}

	public void setTalkList(ArrayList<Talk> talkList) {
		this.talkList = talkList;
	}

	public int getQuestNum() {
		return questNum;
	}

	public int getClearNum() {
		return clearNum;
	}

	public void setQuestNum(int questNum) {
		this.questNum = questNum;
	}

	public void setClearNum(int clearNum) {
		this.clearNum = clearNum;
	}
	
	public Image getMiniImage() {
		return miniImage;
	}

	@Override
	public String toString() {
		return "Npc [imageUrl=" + imageUrl + ", name=" + name + ", process=" + process + ", talkList=" + talkList
				+ ", pointMapName=" + pointMapName + ", questNum=" + questNum + ", clearNum=" + clearNum + "]";
	}
	
}
