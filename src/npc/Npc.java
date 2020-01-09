package npc;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

import map.PointMapName;
import maplestory.MainMapleInterface;
import maplestory.Message;
import maplestory.Player;
import utils.FileLoader;
import utils.FontUtils;
import utils.ResourceLoader;

public abstract class Npc implements Serializable {
	private static final long serialVersionUID = 1L;
	private transient Image image;
	private String imageUrl;
	private String name;
	private int process;
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
		Color color = Color.WHITE;
		if (talk.getType() == 1) {
			color = Color.MAGENTA;
			System.out.println(player.getQuest().getRewardString());
			m.pushMessage(new Message(player.getQuest().getRewardString(), color, true));
			return;
		}
		m.pushMessage(new Message(talk.getMessage(), color, true));
	}

	public boolean process(Player player, MainMapleInterface m) {
		Talk talk = (Talk) this.talkList.get(this.process);
		setTalk(talk, m, player);
		boolean ret = talk.isCanTalkMore();
		int type = talk.getType();
		System.out.println(type);
		if ((type == 3) && (player.getQuest() != null) && (player.isQuestsClear())) {
			this.process += 1;
			talk = (Talk) this.talkList.get(this.process);
			setTalk(talk, m, player);
			ret = talk.isCanTalkMore();
		}
		doEventWithType(type, player);
		System.out.println(this.process + " " + talk);
		if (talk.isProceed()) {
			this.process += 1;
		}
		return ret;
	}

	public void doEventWithType(int type, Player player) {
		if (type == 1) {
			player.questClear();
			clearEvent(player);
			this.clearNum += 1;
		} else if (type == 2) {
			requestQuest(player);
			this.questNum += 1;
		}
	}

	public abstract void clearEvent(Player paramPlayer);

	public abstract void requestQuest(Player paramPlayer);

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
}
