package hunt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import attack.DamageText;
import attack.Hit;
import attackImage.EvilEyeShockUseImage;
import attackImage.SkillImage;
import character.Adventurer;
import character.AdventurerFactory;
import character.Character;
import character.Monster;
import component.MapleButton;
import component.StateBox;
import lastingImage.LastingSkillImage;
import map.WarpMapBossRoom;
import maplestory.MainMapleInterface;
import maplestory.Message;
import maplestory.Player;
import monster.MonsterFactory;
import monsterAttack.MonsterAttack;
import panel.MainPanel;
import playerAttack.PlayerAttack;
import skill.ActiveSkill;
import skill.Skill;
import skill.SkillFactory;
import skill.SkillValid;
import utils.CalUtils;
import utils.ResourceLoader;

public class HuntComponent {
	
	private ImageIcon attackButtonBasicImage = new ImageIcon(ResourceLoader.getImage("componentImage", "attackButtonBasic.png"));
	private ImageIcon attackButtonEnteredImage = new ImageIcon( ResourceLoader.getImage("componentImage", "attackButtonEntered.png"));
	private ImageIcon runButtonBasicImage = new ImageIcon( ResourceLoader.getImage("componentImage", "runButtonBasic.png"));
	private ImageIcon runButtonEnteredImage = new ImageIcon( ResourceLoader.getImage("componentImage", "runButtonEntered.png"));
	
	private MapleButton attackButton = new MapleButton(attackButtonBasicImage, attackButtonEnteredImage, false);
	private MapleButton runButton = new MapleButton(runButtonBasicImage, runButtonEnteredImage, false);
	private JPanel mainPanel;
	private MainMapleInterface mainMapleInterface;
	private StateBox adventurerState;
	private StateBox monsterState;
	private Hunt hunt;

	private boolean isbuttonAdapterSeted;
	
	public HuntComponent(JPanel panel, MainMapleInterface mainMapleInterface) {
		
		this.mainPanel = panel;
		this.mainMapleInterface = mainMapleInterface;
		
		attackButton.setBounds(20, 20, 120, 40);
		panel.add(attackButton);

		runButton.setBounds(150, 20, 120, 40);
		panel.add(runButton);
		
		adventurerState = new StateBox(StateBox.STATE_BOX_LEFT_X, StateBox.STATE_BOX_Y[1], 
				AdventurerFactory.makeAdventurer("INIT", "남자초보모험가"), 0, panel, mainMapleInterface);
		monsterState = new StateBox(StateBox.STATE_BOX_RIGHT_X, StateBox.STATE_BOX_Y[1], 
				MonsterFactory.makeMonster("파란달팽이"), 1, panel, mainMapleInterface);
		adventurerState.barSetVisibleFalse();
		monsterState.barSetVisibleFalse();
	}
	
	public void playerSetAttack(String skillName) {
		hunt.playerSetAttack(skillName);
	}
	
	public void runEvent() {
		hunt.runEvent();
	}
	
	public void potionUsed() {
		hunt.potionUsed();
	}
	
	public void setMouseListener() {
		if(!isbuttonAdapterSeted) {
			isbuttonAdapterSeted = true;
			attackButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if(attackButton.isVisible()) {
						playerSetAttack("일반공격");
					}
				}
			});
			runButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if(runButton.isVisible()) {
						runEvent();
					}
				}
			});
			mainPanel.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					switch(e.getKeyCode()) {
					case KeyEvent.VK_A:
						if(attackButton.isVisible()) {
							playerSetAttack("일반공격");
						}
						break;
					case KeyEvent.VK_S:
						if(runButton.isVisible()) {
							runEvent();
						}
						break;
					}
				}
			});
		}
	}
	
	public void startHunt(Player player, Adventurer adventurer, Monster monster) {
		setMouseListener();
		hunt = new Hunt(player, adventurer, monster);
		hunt.start();
	}

	public void draw(Graphics2D g, JPanel panel) {
		if(hunt != null) {
			hunt.draw(g, panel);
		}
	}
	
	public void wakeUp() {
		hunt.wakeUp();
	}
	
	public class Hunt extends Thread {
		
		private Adventurer adventurer;
		private Monster monster;
		private Queue<StateBox> turnQueue = new LinkedList<StateBox>();
		StateBox nowStateBox;
		boolean isEnd;
		private int playerDead;
		private int monsterDead;
		private boolean winFlag;
		private Player player;
		private MonsterAttack monsterAttack;
		private PlayerAttack playerAttack;
		private ArrayList<SkillImage> skillImageList = new ArrayList<SkillImage>();
		
		private HuntEvent playerHuntEvent;
		private HuntEvent monsterHuntEvent;
		private boolean isRun;
		private boolean isRunFailed;

		public Hunt(Player player, Adventurer adventurer, Monster monster) {
			this.isEnd = true;
			this.player = player;
			playerHuntEvent = adventurer.getHuntEvent();
			disablePlayerActive();
			
			this.adventurer = adventurer;
			adventurerState.reload(adventurer);
			turnQueue.add(adventurerState);
			adventurer.resetAllSkillCoolTime();

			monsterState.reload(monster);
			this.monster = monster;
			monsterHuntEvent = monster.getHuntEvent();
			turnQueue.add(monsterState);
			
			mainMapleInterface.loadStateBoxOnQuickButton(adventurerState);
			setVisibleTrueComponent();

			if(playerHuntEvent != null) {
				playerHuntEvent.startHunt(this);
			}
			enablePlayerActive();
		}

		public void potionUsed() {
			adventurerState.updateStateBox();
			disablePlayerActive();
			hunt.wakeUp();
		}

		public void runEvent() {
			int percent = ((adventurer.getAdventurerLevel() - monster.getStrength().getLevel()) * 5) + 50;
			if(CalUtils.calPercent(percent)) {
				mainMapleInterface.pushMessage(new Message(nowStateBox.getCharacter().getName() + "는 도망에 성공했습니다!", Color.CYAN, true));
				disablePlayerActive();
				isRun = true;
				wakeUp();
			} else {
				mainMapleInterface.pushMessage(new Message(nowStateBox.getCharacter().getName() + "는 도망에 실패했습니다!", Color.CYAN, true));
				isRunFailed = true;
				disablePlayerActive();
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				player.calState();
				wakeUp();
			}
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
				if (skillImageList != null && skillImageList.size() != 0) {
					for (int i = skillImageList.size() - 1; i >= 0; i--) {
						if(skillImageList.get(i) != null) {
							skillImageList.get(i).draw(g);
						}			
					}
				}
				if (this.monsterAttack != null) {
					this.monsterAttack.draw(g);
				}
				if (this.playerAttack != null) {
					this.playerAttack.draw(g);
				}
				if(playerHuntEvent != null) {
					playerHuntEvent.drawInfor(g, this);
					playerHuntEvent.drawObject(g, this);
				}
			}
		}
		
		public void addSkillImage(SkillImage image) {
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
		
		public void rightBeforeTurn() {
			nowStateBox.getCharacter().getAbnormalBuffDamage();
			nowStateBox.getCharacter().buffLastOneTurn();
			nowStateBox.getCharacter().calState();
			nowStateBox.updateStateBox();
			if(nowStateBox.getCharacter() instanceof Adventurer) {
				((Adventurer)nowStateBox.getCharacter()).subAllSkillCoolTime();
			}
			mainMapleInterface.setQuickSkillEnabled();
			checkLastingImages();
		}

		private void checkLastingImages() {
			for(int i = skillImageList.size() - 1; i >= 0; i--) {
				if(skillImageList.get(i) instanceof LastingSkillImage) {
					LastingSkillImage skillImage = (LastingSkillImage)skillImageList.get(i);
					if(skillImage != null && !skillImage.isCanLast()) {
						skillImageList.remove(i);
					}
				} else if(!skillImageList.get(i).isAlive()){
					skillImageList.remove(i);
				}
			}
		}

		public int checkDead() {
			if (this.turnQueue.peek().getCharacter().isDead()) {
				if (this.turnQueue.peek().getCharacter() instanceof Monster) {
					this.monsterDead += 1;
				} else {
					this.playerDead += 1;
				}
				this.turnQueue.poll();
			}
			return isCheckEnd();
		}
		
		public int checkDeadBeforeTurn() {
			if(nowStateBox.getCharacter().isDead()) {
				if (nowStateBox.getCharacter() instanceof Monster) {
					this.monsterDead += 1;
				} else {
					this.playerDead += 1;
				}
			}
			return isCheckEnd();
		}

		public void run() {
			while(true) {
				if(checkDead() != 0) break;
				
				Character character = turnQueue.peek().getCharacter();
				nowStateBox = turnQueue.peek();
				turnQueue.add(turnQueue.peek());
				turnQueue.poll();
				
				rightBeforeTurn();
				
				if(checkDeadBeforeTurn() != 0) {
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}
				
				if(nowStateBox.getCharacter().isStuned()) {
					mainMapleInterface.pushMessage(new Message(nowStateBox.getCharacter().getName() + "는 스턴에 걸려 행동 불능 상태입니다.", Color.CYAN, true));
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					continue;
				}
				
				if ((character instanceof Monster)) {
					
					if(monsterHuntEvent != null) {
						monsterHuntEvent.startTurn(this);
						nowStateBox.updateStateBox();
					}
						
					Monster turnMonster = (Monster) character;
					this.monsterAttack = turnMonster.attack(this, nowStateBox, adventurerState);
					this.monsterAttack.start();
					waitForAttack();
					mainMapleInterface.pushMessage(new Message(this.monsterAttack.attackInfor(), Color.CYAN, true));
					nowStateBox.getCharacter().calState();
					nowStateBox.updateStateBox();
				} else if ((character instanceof Adventurer)) {
					//to do thing prior to an attack
					
					if(playerHuntEvent != null) {
						playerHuntEvent.startTurn(this);
						nowStateBox.updateStateBox();
					}
					
					//stand by for an attack
					playerAttack = null;

					enablePlayerActive();
					
					waitForAttack();
					
					if(isRun) {
						break;
					}
					
					
					if(playerAttack != null) {
						this.playerAttack.start();
						waitForAttack();
						mainMapleInterface.pushMessage(new Message(this.playerAttack.attackInfor(), Color.CYAN, true));
						nowStateBox.getCharacter().calState();
						nowStateBox.updateStateBox();
						
						//after attack
						if(playerHuntEvent != null) {
							playerHuntEvent.afterAttack(this);
						}
					} else {
						attackButton.setVisible(false);
						runButton.setVisible(false);
						//mainMapleInterface.pushMessage(new Message(adventurer.getName() + "는 소모품 아이템을 사용하였다.", Color.CYAN, true));
						try {
							sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					player.calState();
					adventurerState.updateStateBox();
				}
				
				
			}
			isEnd = true;
			((Adventurer)adventurerState.getCharacter()).resetAllSkillCoolTime();
			player.getMainAdventurer().removeAllBuff();
			String getItemInfor = null;
			if(!isRun) {
				if (winFlag) {
					getItemInfor = player.getSpoils(monster);
					mainMapleInterface.pushMessage(new Message("승리하였습니다!", Color.CYAN, false));
				} else {
					mainMapleInterface.pushMessage(new Message("패배하였습니다!", Color.CYAN, false));
				}
			}
			dispose();
			try {
				sleep(500L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (getItemInfor != null) {
				System.out.println("머지? : " + getItemInfor);
				mainMapleInterface.pushMessage(new Message(getItemInfor, Color.MAGENTA, true));
			}
			end();
			interrupt();
		}

		public void playerSetAttack(String skillName) {
			if (!player.isCanUseSkill()) {
				return;
			}
			if(skillName.equals("일반공격")) {
				playerAttack = ((ActiveSkill)SkillFactory.makeSkill("일반공격")).skillUse(this, nowStateBox, monsterState);
			} else {
				playerAttack = ((ActiveSkill)player.getMainAdventurer().getSkillWithName(skillName)).skillUse(this, nowStateBox, monsterState);
				int needMp = playerAttack.getActiveSkill().getNeedMp(playerAttack.getActiveSkill().getPoint());
				if(player.getMainAdventurer().getCurMp() < needMp) {
					mainMapleInterface.pushMessage(new Message("마나가 부족합니다.", Color.RED, true));
					playerAttack = null;
					return;
				}
				SkillValid skillValid = playerAttack.getActiveSkill().isCanUseSkill((Adventurer)adventurerState.getCharacter());
				if(!skillValid.isCanUse()) {
					mainMapleInterface.pushMessage(new Message(skillValid.getMessage(), Color.RED, true));
					playerAttack = null;
					return;
				}
				player.getMainAdventurer().spendMp(needMp);
				adventurerState.updateStateBox();
			}
			disablePlayerActive();
			player.calState();
			//succeed using the skill
			if(playerHuntEvent != null) {
				playerHuntEvent.startAttack(this);
			}
			playerAttack.getActiveSkill().setFullCoolTime();
			mainMapleInterface.setQuickSkillEnabled();
			player.getMainAdventurer().setUsedSkill(playerAttack.getActiveSkill());
			wakeUp();
		}
		
		public void enablePlayerActive() {
			attackButton.setVisible(true);
			player.setCanUsePortion(true);
			player.setCanUseSkill(true);
			if(!monster.isBoss() && !isRunFailed) {
				runButton.setVisible(true);
			}
		}
		
		public void disablePlayerActive() {
			player.setCanUseSkill(false);
			player.setCanUsePortion(false);
			attackButton.setVisible(false);
			runButton.setVisible(false);
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
			if(playerHuntEvent != null) {
				playerHuntEvent.endHunt(this);
			}
			mainMapleInterface.setQuickSkillEnabled();
			mainMapleInterface.endHunt();
		}

		public void setVisibleTrueComponent() {
			adventurerState.barSetVisibleTrue();
			monsterState.barSetVisibleTrue();
			this.isEnd = false;
			attackButton.setVisible(true);
			if(!monster.isBoss()) {
				runButton.setVisible(true);
			}
		}

		public void dispose() {
			if(!isRun) {
				if (!this.winFlag) {
					adventurerState.getCharacter().setCurHp(1);
					adventurerState.getCharacter().setCurMp(1);
					player.playerWarp(player.get_curMap().getWarpMapName(), mainMapleInterface);
				}
				if(monster.isBoss() && winFlag) {
					this.player.get_curMap().warp(player, WarpMapBossRoom.warpFromMapBossRoom(monster.getName()), mainMapleInterface);
					WarpMapBossRoom.closeMapAfterClear(player, monster.getName());
				}
			}
			monster.removeAllBuff();
			adventurer.removeAllBuff();
			adventurerState.barSetVisibleFalse();
			monsterState.barSetVisibleFalse();
			attackButton.setVisible(false);
			runButton.setVisible(false);
			turnQueue.clear();
			turnQueue = null;
			this.monster = null;
			checkLastingImages();
			removeAllSkillImages();
		}
		
		public SkillImage getSkillImage(Skill skill) {
			for(int i = skillImageList.size() - 1; i >= 0; i--) {
				if(skillImageList.get(i).getClass().equals(skill.getClass())) {
					return skillImageList.get(i);
				}
			}
			return null;
		}

		private void removeAllSkillImages() {
			for(int i = skillImageList.size() - 1; i >= 0; i--) {
				skillImageList.remove(i);
			}
			skillImageList = null;
		}

		public void addDamageText(Hit hit, StateBox opponent) {
			mainMapleInterface.addDamageText(new DamageText(hit, opponent));
		}

		public void updateMainStateBar() {
			mainMapleInterface.updateMainStateBar();
		}

		public Adventurer getAdventurer() {
			return adventurer;
		}

		public Monster getMonster() {
			return monster;
		}

		public PlayerAttack getPlayerAttack() {
			return playerAttack;
		}
		
		public StateBox getAdventurerState() {
			return adventurerState;
		}
		
		public StateBox getMonsterState() {
			return monsterState;
		}

	}

}
