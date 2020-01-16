package hunt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import attack.AttackFactory;
import attack.DamageText;
import attack.Hit;
import attackImage.SkillImage;
import character.Adventurer;
import character.Character;
import character.Monster;
import component.MapleButton;
import component.StateBox;
import map.WarpMapBossRoom;
import maplestory.MainMapleInterface;
import maplestory.Message;
import maplestory.Player;
import monsterAttack.MonsterAttack;
import playerAttack.PlayerAttack;
import skill.ActiveSkill;
import utils.ResourceLoader;

public class Hunt extends Thread {
	private ImageIcon attackButtonBasicImage = new ImageIcon(ResourceLoader.getImage("componentImage", "attackButtonBasic.png"));
	private ImageIcon attackButtonEnteredImage = new ImageIcon( ResourceLoader.getImage("componentImage", "attackButtonEntered.png"));
	private ImageIcon runButtonBasicImage = new ImageIcon( ResourceLoader.getImage("componentImage", "runButtonBasic.png"));
	private ImageIcon runButtonEnteredImage = new ImageIcon( ResourceLoader.getImage("componentImage", "runButtonEntered.png"));
	private StateBox adventurerState;
	private StateBox monsterState;
	private Monster monster;
	private Queue<StateBox> turnQueue = new LinkedList<StateBox>();
	private MapleButton attackButton = new MapleButton(this.attackButtonBasicImage, this.attackButtonEnteredImage,
			false);
	private MapleButton runButton = new MapleButton(this.runButtonBasicImage, this.runButtonEnteredImage, false);
	private MainMapleInterface mInterface;
	StateBox nowStateBox;
	boolean isEnd;
	private int playerDead;
	private int monsterDead;
	private boolean winFlag;
	private JPanel panel;
	private Player player;
	private MonsterAttack monsterAttack;
	private PlayerAttack playerAttack;
	private MouseListener m;
	private ArrayList<SkillImage> skillImageList = new ArrayList<SkillImage>();

	public Hunt(Player player, JPanel panel, MainMapleInterface mainMapleInterface, Adventurer adventurer, Monster monster) {
		this.isEnd = true;
		this.panel = panel;
		this.mInterface = mainMapleInterface;
		this.player = player;
		
		StateBox stateBoxAdventurer = new StateBox(40, StateBox.STATE_BOX_Y[1], adventurer, 0, panel, mainMapleInterface);
		this.adventurerState = stateBoxAdventurer;
		this.turnQueue.add(stateBoxAdventurer);
		
		StateBox stateBoxMonster = new StateBox(870, StateBox.STATE_BOX_Y[1], monster, 1, panel, mainMapleInterface);
		this.monster = monster;
		this.monsterState = stateBoxMonster;
		this.turnQueue.add(stateBoxMonster);

		mainMapleInterface.loadStateBoxOnQuickButton(stateBoxAdventurer);
		setVisibleTrueComponent();

		this.attackButton.setBounds(20, 20, 120, 40);
		this.attackButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(attackButton.isVisible()) {
					playerSetAttack("일반공격");
				}
			}
		});
		panel.add(this.attackButton);

		this.runButton.setBounds(150, 20, 120, 40);
		this.runButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(runButton.isVisible()) {
					
				}
			}
		});
		panel.add(this.runButton);
	}

	public void draw(Graphics2D g, JPanel panel) {
		if (!this.isEnd) {
			adventurerState.draw(g, panel);
			monsterState.draw(g, panel);
			/*
			if (this.quickButtons.isVisible()) {
				this.quickButtons.draw(g);
			}
			*/
			if (this.skillImageList != null) {
				for (int i = this.skillImageList.size() - 1; i >= 0; i--) {
					System.out.println(((SkillImage) this.skillImageList.get(i)).isAlive());
					if (((SkillImage) this.skillImageList.get(i)).isAlive()) {
						((SkillImage) this.skillImageList.get(i)).draw(g);
					} else {
						this.skillImageList.remove(i);
					}
				}
			}
			if (this.monsterAttack != null) {
				this.monsterAttack.draw(g);
			}
			if (this.playerAttack != null) {
				this.playerAttack.draw(g);
			}
		}
	}
	
	public void addSkillImageList(SkillImage image) {
		image.start();
		skillImageList.add(image);
	}

	public int isCheckEnd() {
		if (this.monsterDead == 1) {
			this.winFlag = true;
			return 1;
		}
		if (this.playerDead == 1) {
			return 2;
		}
		return 0;
	}

	public void run() {
		while(true) {
			if (this.turnQueue.peek().getCharacter().isDead()) {
				if (this.turnQueue.peek().getCharacter() instanceof Monster) {
					this.monsterDead += 1;
				} else {
					this.playerDead += 1;
				}
				this.turnQueue.poll();
			}
			if (isCheckEnd() != 0) {
				break;
			}
			Character character = turnQueue.peek().getCharacter();
			nowStateBox = turnQueue.peek();
			turnQueue.add(turnQueue.peek());
			turnQueue.poll();
			nowStateBox.getCharacter().buffLastOneTurn();
			nowStateBox.getCharacter().calState();
			if ((character instanceof Monster)) {
				Monster turnMonster = (Monster) character;
				this.monsterAttack = turnMonster.attack(this, this.nowStateBox, this.adventurerState);
				this.monsterAttack.start();
				waitForAttack();
				this.mInterface.pushMessage(new Message(this.monsterAttack.attackInfor(), Color.CYAN, true));
			} else if ((character instanceof Adventurer)) {

				playerAttack = null;
				player.setCanUsePortion(true);
				player.setCanUseSkill(true);

				this.attackButton.setVisible(true);
				this.runButton.setVisible(true);

				waitForAttack();
				if(playerAttack != null) {
					this.playerAttack.start();
					waitForAttack();
					this.mInterface.pushMessage(new Message(this.playerAttack.attackInfor(), Color.CYAN, true));
				} else {
					attackButton.setVisible(false);
					runButton.setVisible(false);
					//this.mInterface.pushMessage(new Message(this.playerAttack.attackInfor(), Color.CYAN, true));
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			nowStateBox.getCharacter().calState();
		}
		
		this.isEnd = true;
		String getItemInfor = null;
		if (this.winFlag) {
			getItemInfor = this.player.getSpoils(this.monster);
			this.mInterface.pushMessage(new Message("승리하였습니다!", Color.CYAN, false));
		} else {
			this.mInterface.pushMessage(new Message("패배하였습니다!", Color.CYAN, false));
		}
		dispose();
		try {
			sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		end();
		if (getItemInfor != null) {
			this.mInterface.pushMessage(new Message(getItemInfor, Color.MAGENTA, true));
		}
		interrupt();
	}

	public void playerSetAttack(String skillName) {
		if (!this.attackButton.isVisible()) {
			return;
		}
		if(skillName.equals("일반공격")) {
			playerAttack = AttackFactory.makeAdventurerAttack(this, nowStateBox, monsterState, "일반공격", 0);
		} else {
			playerAttack = ((ActiveSkill)player.getMainAdventurer().getSkillWithName(skillName)).skillUse(this, nowStateBox, monsterState);
			int needMp = playerAttack.getActiveSkill().getNeedMp(playerAttack.getActiveSkill().getPoint());
			if(player.getMainAdventurer().getCurMp() < needMp) {
				this.mInterface.pushMessage(new Message("마나가 부족합니다.", Color.RED, true));
				playerAttack = null;
				return;
			}
			player.getMainAdventurer().spendMp(needMp);
			adventurerState.updateStateBox();
		}
		player.setCanUseSkill(false);
		player.setCanUsePortion(false);
		attackButton.setVisible(false);
		runButton.setVisible(false);
		wakeUp();
	}

	public void wakeUp() {
		synchronized (this) {
			notifyAll();
		}
	}

	public void waitForAttack() {
		synchronized (this) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void end() {
		this.mInterface.endHunt();
	}

	public void setVisibleTrueComponent() {
		adventurerState.barSetVisibleTrue();
		monsterState.barSetVisibleTrue();
		this.isEnd = false;
		this.attackButton.setVisible(true);
		this.runButton.setVisible(true);
	}

	public void dispose() {
		if (!this.winFlag) {
			adventurerState.getCharacter().setCurHp(1);
			adventurerState.getCharacter().setCurMp(1);
		}
		if(monster.isBoss()) {
			this.player.get_curMap().warp(player, WarpMapBossRoom.warpFromMapBossRoom(monster.getName()), mInterface);
			if(winFlag) {
				WarpMapBossRoom.closeMapAfterClear(player, monster.getName());
			}
		}
		adventurerState.barSetVisibleFalse();
		adventurerState.removeFromPanel(this.panel);
		monsterState.barSetVisibleFalse();
		monsterState.removeFromPanel(panel);
		this.panel.removeMouseListener(this.m);
		this.turnQueue.clear();
		this.monster = null;
		this.adventurerState = null;
		this.monsterState = null;
		this.attackButton.remove(this.panel);
		this.attackButton.invalidate();
		this.runButton.remove(this.panel);
		this.runButton.invalidate();
	}

	public void addDamageText(Hit hit, StateBox opponent) {
		this.mInterface.addDamageText(new DamageText(hit, opponent));
	}

	public void updateMainStateBar() {
		this.mInterface.updateMainStateBar();
	}
}
