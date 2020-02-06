package map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import character.Guard;
import maplestory.MainMapleInterface;
import maplestory.Player;
import npc.Npc;
import npc.NpcList;
import utils.ColorUtils;
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
	private String backgroundUrl;
	private int[][] map;
	private int mapType;
	private ArrayList<Portal> portalList = new ArrayList<Portal>();
	private Point basePoint = new Point(0, 0);
	private String warpMapName;
	private String tileMapName;
	private int[][] tileMap;
	
	private ArrayList<Guard> guardList = new ArrayList<Guard>();
	
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
	public static final int MAP_SAILING_TYPE = 3;
	public static final int MAP_HARBOR_TYPE = 4;
	public static final int MAP_DUNGEON_ENTER_TYPE = 5;
	public static final int MAP_DUNGEON_TYPE = 6;
	
	private static final Point[][] calMapPosition;
	private static final int MINI_POINT = 5;
	private static Image mapPositionImage = ResourceLoader.getImage("componentImage", "mapPositionImage.png");
	
	public static final int MAX_MAP_VIEW_X = 12;
	public static final int MAX_MAP_VIEW_Y = 20;

	static {
		calMapPosition = new Point[101][101];
		calMapPositonXY();
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

	public MapleMap() {

	}

	public void MapleMapBackgroundInit() {
		this.background = ResourceLoader.getImage("backgroundImage", this.backgroundUrl + "BackgroundImage.png");
	}
	
	public void drawMapImage(Graphics2D g) {
		int startX = 20;
		int startY = 40;
		g.setColor(ColorUtils.WHITE_0);
		g.fillRect(startX, startY, 32*Math.min(maxY, MAX_MAP_VIEW_Y), 32*Math.min(maxX, MAX_MAP_VIEW_X));
		g.setColor(Color.YELLOW);
		for(int i = 1; i < Math.min(maxY, MAX_MAP_VIEW_Y); i++) {
			//g.drawLine(startX + 32*i, startY, startX + 32*i, startY+32*Math.min(maxX, MAX_MAP_VIEW_X));
		}
		for(int i = 1; i < Math.min(maxX, MAX_MAP_VIEW_X); i++) {
			//g.drawLine(startX, startY + 32*i, startX + 32*Math.min(maxY, MAX_MAP_VIEW_Y), startY+32*i);
		}
	}
	
	public void drawMapPanelImage(Graphics2D g) {
		int startX = 10;
		int startY = 10;
		if(tileMapName != null && tileMapName.length() != 0) {
			g.setColor(TileMapList.getInstance().getFloorColor(tileMapName));
		} else {
			g.setColor(ColorUtils.WHITE_40);
		}
		g.fillRect(startX, startY, 32*Math.min(maxY, MAX_MAP_VIEW_Y) + 20, 32*Math.min(maxX, MAX_MAP_VIEW_X) + 40);
		g.setColor(ColorUtils.BLACK_80);
		g.fillRect(startX, startY, 32*Math.min(maxY, MAX_MAP_VIEW_Y) + 20, 28);
	}

	public void drawMap(Graphics2D g, Player player) {
		if ((player.isConversation()) || (player.isHunt())) {
			return;
		}
		drawMapPanelImage(g);
		//g.drawImage(mapImage, 20, 40, null);
		Point point = calMapPosition[Math.max(player.getCurX() - this.basePoint.getX(), 0)][Math
				.max(player.getCurY() - this.basePoint.getY(), 0)];
		drawMapImage(g);
		
		
		for (int i = this.basePoint.getX(); i < Math.min(this.basePoint.getX() + MAX_MAP_VIEW_X, this.maxX); i++) {
			for (int j = this.basePoint.getY(); j < Math.min(this.basePoint.getY() + MAX_MAP_VIEW_Y, this.maxY); j++) {
				int mapinfo = this.map[i][j];
				Point point2 = calMapPosition[(i - this.basePoint.getX())][(j - this.basePoint.getY())];
				g.setFont(FontUtils.generalFont);
				int y = point2.getY() + 4;
				int x = point2.getX() + 15;
				//9 21
				if (mapinfo == 2) {
					g.setColor(Color.RED);
					g.drawString("N", y, x);
					Npc npc = NpcList.getInstance().getNpc(new PointMapName(i, j, name));
					if(npc != null) {
						g.drawImage(npc.getMiniImage(), y - 9, x - 21, null);
					}
				} else if (mapinfo == 1) {
					g.setColor(Color.black);
					g.drawString("X", y, x);
					if(tileMapName != null && tileMapName.length() != 0) {
						g.drawImage(TileMapList.getInstance().getTileImage(tileMapName), y - 9, x - 21, null);
					}
				} else if (mapinfo == 3) {
					g.setColor(Color.BLUE);
					g.drawImage(MapleMapList.getPortalImage(), y - 9, x - 21, null);
				} else if (mapinfo == 4) {
					g.setColor(Color.MAGENTA);
					g.drawImage(MapleMapList.getStoreImage(), y - 9, x - 21, null);
				} else if (mapinfo == 5) {
					g.setColor(Color.YELLOW);
					g.drawImage(MapleMapList.getHealImage(), y - 9, x - 21, null);
				} else if (mapinfo == 6) {
					g.setColor(Color.CYAN);
					g.drawImage(MapleMapList.getGuardImage(), y - 9, x - 21, null);
				} 
			}
		}
		g.drawImage(mapPositionImage, point.getY(), point.getX(), null);
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
		int startY = 40 + 32*Math.min(maxY, MAX_MAP_VIEW_Y);
		int startX = 20;
		int getMaxX = this.maxX;
		int getMaxY = this.maxY;
		for (int i = 0; i < getMaxX; i++) {
			for (int j = 0; j < getMaxY; j++) {
				int mapinfo = this.map[i][j];
				Point point2 = new Point(startX + i * MINI_POINT, startY + j * MINI_POINT);
				g.setFont(FontUtils.generalFont);
				if (mapinfo == 2) {
					g.setColor(Color.RED);
					g.fillRect(point2.getY(), point2.getX(), MINI_POINT, MINI_POINT);
				} else if (mapinfo == 1) {
					g.setColor(Color.black);
					g.fillRect(point2.getY(), point2.getX(), MINI_POINT, MINI_POINT);
				} else if (mapinfo == 3) {
					g.setColor(Color.BLUE);
					g.fillRect(point2.getY(), point2.getX(), MINI_POINT, MINI_POINT);
				} else if (mapinfo == 4) {
					g.setColor(Color.MAGENTA);
					g.fillRect(point2.getY(), point2.getX(), MINI_POINT, MINI_POINT);
				} else if (mapinfo == 5) {
					g.setColor(Color.YELLOW);
					g.fillRect(point2.getY(), point2.getX(), MINI_POINT, MINI_POINT);
				} else if (mapinfo == 6) {
					g.setColor(Color.CYAN);
					g.fillRect(point2.getY(), point2.getX(), MINI_POINT, MINI_POINT);
				} else {
					g.setColor(Color.WHITE);
					g.fillRect(point2.getY(), point2.getX(), MINI_POINT, MINI_POINT);
				}
			}
		}
		Point point = new Point(startX + player.getCurX() * MINI_POINT, startY + player.getCurY() * MINI_POINT);
		g.setColor(Color.GREEN);
		g.fillRect(point.getY(), point.getX(), MINI_POINT, MINI_POINT);
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
						xx += 32;
					}
				}
				if (j - 1 >= 0) {
					yy = calMapPosition[i][(j - 1)].getY();
					if (j % 2 == 0) {
						yy += 32;
					} else {
						yy += 32;
					}
				}
				calMapPosition[i][j] = new Point(xx, yy);
			}
		}
	}
	
	public void warp(Player player, PointMapName nextP, MainMapleInterface mainMapleInterface) {
		MapleMap curMap = MapleMapList.getInstance().getMap(player.get_curMap().getName());
		MapleMap nextMap = MapleMapList.getInstance().getMap(nextP.getMapName());
		if (!curMap.getMusic().equals(nextMap.getMusic())) {
			MusicUtils.changeMusic(nextMap.getMusic());
		}
		if (!curMap.getBackground().equals(nextMap.getBackground())) {
			mainMapleInterface.changeBackground(nextMap.getBackground());
		}
		player.set_curMap(nextMap);
		player.setCurX(nextP.getX());
		player.setCurY(nextP.getY());
		calLoc(player, nextMap);
		mainMapleInterface.myRepaint();
	}
	
	
	public void warp(Player player, String nextMapName, MainMapleInterface mainMapleInterface) {
		MapleMap curMap = MapleMapList.getInstance().getMap(player.get_curMap().getName());
		MapleMap nextMap = MapleMapList.getInstance().getMap(nextMapName);
		if (!curMap.getMusic().equals(nextMap.getMusic())) {
			MusicUtils.changeMusic(nextMap.getMusic());
		}
		if (!curMap.getBackground().equals(nextMap.getBackground())) {
			mainMapleInterface.changeBackground(nextMap.getBackground());
		}
		Point nextPoint = setWarpPoint(nextMapName);
		player.set_curMap(nextMap);
		player.setCurX(nextPoint.getX());
		player.setCurY(nextPoint.getY());
		calLoc(player, nextMap);
		mainMapleInterface.myRepaint();
	}
	
	
	public Point setWarpPoint(String mapName) {
		MapleMap map = MapleMapList.getInstance().getMap(mapName);
		int X = map.getMaxX() / 2;
		int Y = map.getMaxY() / 2;
		for(int i = map.getMaxY() / 2, j = map.getMaxY() / 2; (i < map.getMaxY() && j >= 0); i++, j--) {
			if(map.getMap(X, i) == MapleMap.MAP_EMPTY_STATE) {
				Y = i;
				break;
			} else if(map.getMap(X, j) == MapleMap.MAP_EMPTY_STATE) {
				Y = j;
				break;
			}
		}
		return new Point(X, Y);
	}

	/**
	 *  현재 지점에서 포탈이 있을경우 다른 맵으로 이동하고 음악과 배경사진을 변경
	 * @param player 유저 위치이동을 위한 Player
	 * @param mainMapleInterface background 사진을 바꾸기위한 interface
	 */
	public void moveOtherMap(Player player, MainMapleInterface mainMapleInterface) {
		for (int i = 0; i < this.portalList.size(); i++) {
			Portal portal = (Portal) this.portalList.get(i);
			PointMapName currentMapInfor = portal.getNowMapInfor();
			PointMapName nextMapInfor = portal.getNextMapInfor();
			PointMapName playerMapInfor = player.getPlayerPointMapName();
			if (currentMapInfor.equals(playerMapInfor)) {
				MapleMap curMap = MapleMapList.getInstance().getMap(currentMapInfor.getMapName());
				MapleMap nextMap = MapleMapList.getInstance().getMap(nextMapInfor.getMapName());
				if (!curMap.getMusic().equals(nextMap.getMusic())) {
					MusicUtils.changeMusic(nextMap.getMusic());
				}
				if (!curMap.getBackground().equals(nextMap.getBackground())) {
					mainMapleInterface.changeBackground(nextMap.getBackground());
				}
				player.set_curMap(MapleMapList.getInstance().getMap(nextMapInfor.getMapName()));
				player.setCurX(nextMapInfor.getX());
				player.setCurY(nextMapInfor.getY());
				calLoc(player, nextMap);
				break;
			}
		}
		mainMapleInterface.myRepaint();
	}

	/**
	 *  다른맵 이동시 basePoint을 계산하여 유저가 맵위에서 잘 보이도록 함
	 * @param player
	 * @param mapleMap
	 */
	public void calLoc(Player player, MapleMap mapleMap) {
		mapleMap.setBasePointXY(0, 0);
		for (int i = 0; i < mapleMap.getMaxX() - Math.min(mapleMap.getMaxX(), MAX_MAP_VIEW_X) + 1; i++) {
			for (int j = 0; j < mapleMap.getMaxY() - Math.min(mapleMap.getMaxY(), MAX_MAP_VIEW_Y) + 1; j++) {
				int midX = (i + Math.min(mapleMap.getMaxX(), MAX_MAP_VIEW_X) + i) / 2;
				int midY = (j + Math.min(mapleMap.getMaxY() , MAX_MAP_VIEW_Y) + j) / 2;
				boolean ret = isIncludePlayer(mapleMap, player.getCurX(), player.getCurY(), i, j);
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

	/**
	 *  현재 계산한 BasePoint를 기준으로 보이는 맵이 유저가 포함되는 위치인지 계산
	 * @param mapleMap
	 * @param curX
	 * @param curY
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isIncludePlayer(MapleMap mapleMap, int curX, int curY, int x, int y) {
		if ((x <= curX) && (curX < x + Math.min(mapleMap.getMaxX(), MAX_MAP_VIEW_X)) && (y <= curY) && (curY < y + Math.min(mapleMap.getMaxY(), MAX_MAP_VIEW_Y))) {
			return true;
		}
		return false;
	}

	public void initMap(int maxX, int maxY) {
		this.map = new int[maxX][maxY];
	}
	
	public void removeGuard() {
		for(int i = 0; i < guardList.size(); i++) {
			guardList.get(i).setEnd(true);
			guardList.remove(i);
		}
		guardList.clear();
	}

	public void makeGuard(Player player, MainMapleInterface mainMapleInterface) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == MapleMap.MAP_GUARD_STATE) {
					Guard guard = new Guard(player, new PointMapName(i, j, name), mainMapleInterface);
					guard.start();
					guardList.add(guard);
				}
			}
		}
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
		this.backgroundUrl = background;
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

	public void setBasePointXY(int x, int y) {
		this.basePoint.setX(x);
		this.basePoint.setY(y);
	}
	
	public String getWarpMapName() {
		return warpMapName;
	}

	public void setWarpMapName(String warpMapName) {
		this.warpMapName = warpMapName;
	}

	public String getTileMapName() {
		return tileMapName;
	}

	public void setTileMapName(String tileMapName) {
		this.tileMapName = tileMapName;
	}

	public int[][] getTileMap() {
		return tileMap;
	}

	public void setTileMap(int[][] tileMap) {
		this.tileMap = tileMap;
		for(int i = 0; i < tileMap.length; i++) {
			for(int j = 0; j < tileMap[i].length; j++) {
				System.out.print(tileMap[i][j] + " ");
			}
			System.out.println();
		}
	}

	public String toString() {
		return "MapleMap [name=" + this.name + ", _island=" + this.island + ", maxX=" + this.maxX + ", maxY="
				+ this.maxY + ", music=" + this.music + ", background=" + this.background + "]";
	}
	
}
