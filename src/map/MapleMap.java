package map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import maplestory.MainMapleInterface;
import maplestory.Player;
import utils.FontUtils;
import utils.MusicUtils;
import utils.ResourceLoader;

public class MapleMap implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String island;
	private int maxX;
	private int maxY;
	private String music;
	private transient Image background;
	private transient String backgroundUrl;
	private int[][] map;
	private int mapType;
	private ArrayList<Portal> portalList = new ArrayList<Portal>();
	private Point basePoint = new Point(0, 0);
	public static final int MAP_EMPTY_STATE = 0;
	public static final int MAP_WALL_STATE = 1;
	public static final int MAP_NPC_STATE = 2;
	public static final int MAP_PORTAL_STATE = 3;
	public static final int MAP_STORE_STATE = 4;
	public static final int MAP_HEAL_STATE = 5;
	public static final int MAP_GUARD_STATE = 6;
	public static final int MAP_START_POINT = 7;
	public static final int MAP_VILLAGE_TYPE = 0;
	public static final int MAP_HUNTING_TYPE = 1;
	public static final int MAP_BOSS_TYPE = 2;
	private static final Point[][] calMapPosition;
	private static final int MINI_POINT = 5;
	private static Image mapPanelImage = ResourceLoader.getImage("componentImage", "mapPanelImage.png");
	private static Image mapImage = ResourceLoader.getImage("componentImage", "mapImage.png");
	private static Image mapPositionImage = ResourceLoader.getImage("componentImage", "mapPositionImage.png");

	static {
		calMapPosition = new Point[101][101];
		calMapPositonXY();
	}

	public MapleMap() {
	}

	public MapleMap(String name, String island, int maxX, int maxY, String music, String backgroundUrl, int mapType) {
		this.name = name;
		this.island = island;
		this.maxX = maxX;
		this.maxY = maxY;
		this.music = music;
		this.backgroundUrl = backgroundUrl;
		MapleMapBackgroundInit();
		this.map = new int[maxX][maxY];
		this.mapType = mapType;
	}

	public void MapleMapBackgroundInit() {
		this.background = ResourceLoader.getImage("backgroundImage", this.background + "BackgroundImage.png");
	}

	public void drawMap(Graphics2D g, Player player) {
		if ((player.isConversation()) || (player.isHunt())) {
			return;
		}
		g.drawImage(mapPanelImage, 10, 10, null);
		g.drawImage(mapImage, 20, 40, null);
		Point point = calMapPosition[Math.max(player.getCurX() - this.basePoint.getX(), 0)][Math
				.max(player.getCurY() - this.basePoint.getY(), 0)];
		g.drawImage(mapPositionImage, point.getY(), point.getX(), null);
		for (int i = this.basePoint.getX(); i < Math.min(this.basePoint.getX() + 10, this.maxX); i++) {
			for (int j = this.basePoint.getY(); j < Math.min(this.basePoint.getY() + 10, this.maxY); j++) {
				int mapinfo = this.map[i][j];
				Point point2 = calMapPosition[(i - this.basePoint.getX())][(j - this.basePoint.getY())];
				g.setFont(FontUtils.generalFont);
				int y = point2.getY() + 3;
				int x = point2.getX() + 15;
				if (mapinfo == 2) {
					g.setColor(Color.RED);
					g.drawString("N", y, x);
				} else if (mapinfo == 1) {
					g.setColor(Color.black);
					g.drawString("X", y, x);
				} else if (mapinfo == 3) {
					g.setColor(Color.BLUE);
					g.drawString("P", y, x);
				} else if (mapinfo == 4) {
					g.setColor(Color.MAGENTA);
					g.drawString("S", y, x);
				} else if (mapinfo == 5) {
					g.setColor(Color.YELLOW);
					g.drawString("H", y, x);
				} else if (mapinfo == 6) {
					g.setColor(Color.CYAN);
					g.drawString("G", y, x);
				}
			}
		}
		g.setFont(FontUtils.SMALL_FONT);
		g.setColor(Color.YELLOW);
		g.drawString(player.get_curMap().getIsland(), 20, 28);
		g.setColor(Color.CYAN);
		g.drawString("- " + player.get_curMap().getName(), 20 + player.get_curMap().getIsland().length() * 14, 28);
	}

	public void drawMiniMap(Graphics2D g, Player player) {
		if ((player.isConversation()) || (player.isHunt())) {
			return;
		}
		int startY = 370;
		int startX = 20;
		int getMaxX = this.maxX;
		int getMaxY = this.maxY;
		for (int i = 0; i < getMaxX; i++) {
			for (int j = 0; j < getMaxY; j++) {
				int mapinfo = this.map[i][j];
				Point point2 = new Point(startX + i * 5, startY + j * 5);
				g.setFont(FontUtils.generalFont);
				if (mapinfo == 2) {
					g.setColor(Color.RED);
					g.fillRect(point2.getY(), point2.getX(), 5, 5);
				} else if (mapinfo == 1) {
					g.setColor(Color.black);
					g.fillRect(point2.getY(), point2.getX(), 5, 5);
				} else if (mapinfo == 3) {
					g.setColor(Color.BLUE);
					g.fillRect(point2.getY(), point2.getX(), 5, 5);
				} else if (mapinfo == 4) {
					g.setColor(Color.MAGENTA);
					g.fillRect(point2.getY(), point2.getX(), 5, 5);
				} else if (mapinfo == 5) {
					g.setColor(Color.YELLOW);
					g.fillRect(point2.getY(), point2.getX(), 5, 5);
				} else if (mapinfo == 6) {
					g.setColor(Color.CYAN);
					g.fillRect(point2.getY(), point2.getX(), 5, 5);
				} else {
					g.setColor(Color.WHITE);
					g.fillRect(point2.getY(), point2.getX(), 5, 5);
				}
			}
		}
		Point point = new Point(startX + player.getCurX() * 5, startY + player.getCurY() * 5);
		g.setColor(Color.GREEN);
		g.fillRect(point.getY(), point.getX(), 5, 5);
	}

	private static void calMapPositonXY() {
		int x = 46;
		int y = 25;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				int xx = x;
				int yy = y;
				if (i - 1 >= 0) {
					xx = calMapPosition[(i - 1)][j].getX();
					if (i % 2 == 0) {
						xx += 32;
					} else {
						xx += 31;
					}
				}
				if (j - 1 >= 0) {
					yy = calMapPosition[i][(j - 1)].getY();
					if (j % 2 == 0) {
						yy += 32;
					} else {
						yy += 31;
					}
				}
				calMapPosition[i][j] = new Point(xx, yy);
			}
		}
	}

	public void moveOtherMap(Player player, MainMapleInterface mainMapleInterface) {
		for (int i = 0; i < this.portalList.size(); i++) {
			Portal portal = (Portal) this.portalList.get(i);
			PointMapName currentMapInfor = portal.getNowMapInfor();
			PointMapName nextMapInfor = portal.getNextMapInfor();
			PointMapName playerMapInfor = player.getPlayerPointMapName();
			if (currentMapInfor.equals(playerMapInfor)) {
				MapleMap curMap = MapleMapList.getMap(currentMapInfor.getMapName());
				MapleMap nextMap = MapleMapList.getMap(nextMapInfor.getMapName());
				if (!curMap.getMusic().equals(nextMap.getMusic())) {
					MusicUtils.changeMusic(nextMap.getMusic());
				}
				if (!curMap.getBackground().equals(nextMap.getBackground())) {
					mainMapleInterface.changeBackground(nextMap.getBackground());
				}
				player.set_curMap(MapleMapList.getMap(nextMapInfor.getMapName()));
				player.setCurX(nextMapInfor.getX());
				player.setCurY(nextMapInfor.getY());
				calLoc(player, nextMap);
				break;
			}
		}
		mainMapleInterface.myRepaint();
	}

	public void calLoc(Player player, MapleMap mapleMap) {
		for (int i = 0; i < mapleMap.getMaxX() - 9; i++) {
			for (int j = 0; j < mapleMap.getMaxY() - 9; j++) {
				int midX = (i + 9) / 2;
				int midY = (j + 9) / 2;
				boolean ret = isIncludePlayer(player.getCurX(), player.getCurY(), i, j);
				if (ret) {
					if (midX < player.getCurX()) {
						mapleMap.getBasePoint().setX(i);
					}
					if (midY < player.getCurY()) {
						mapleMap.getBasePoint().setY(j);
					}
				}
			}
		}
	}

	public boolean isIncludePlayer(int curX, int curY, int x, int y) {
		if ((x <= curX) && (curX < x + 10) && (y <= curY) && (curY < y + 10)) {
			return true;
		}
		return false;
	}

	public void initMap(int maxX, int maxY) {
		this.map = new int[maxX][maxY];
	}

	public String getName() {
		return this.name;
	}

	public String getIsland() {
		return this.island;
	}

	public int getMaxX() {
		return this.maxX;
	}

	public int getMaxY() {
		return this.maxY;
	}

	public String getMusic() {
		return this.music;
	}

	public Image getBackground() {
		return this.background;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsland(String island) {
		this.island = island;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public void setBackground(String background) {
		this.background = ResourceLoader.getImage("backgroundImage", background + "BackgroundImage.png");
	}

	public int[][] getMap() {
		return this.map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getMap(int x, int y) {
		return this.map[x][y];
	}

	public void setMap(int x, int y, int c) {
		this.map[x][y] = c;
	}

	public ArrayList<Portal> getPortalList() {
		return this.portalList;
	}

	public void setPortalList(ArrayList<Portal> portalList) {
		this.portalList = portalList;
	}

	public void addPortal(Portal portal) {
		this.portalList.add(portal);
	}

	public int getMapType() {
		return this.mapType;
	}

	public void setMapType(int mapType) {
		this.mapType = mapType;
	}

	public Point getBasePoint() {
		return this.basePoint;
	}

	public void setBasePoint(Point basePoint) {
		this.basePoint = basePoint;
	}

	public void setBasePointX(int x) {
		this.basePoint.setX(x);
	}

	public void setBasePointY(int y) {
		this.basePoint.setY(y);
	}

	public String toString() {
		return "MapleMap [name=" + this.name + ", _island=" + this.island + ", maxX=" + this.maxX + ", maxY="
				+ this.maxY + ", music=" + this.music + ", background=" + this.background + "]";
	}
}
