package character;

import java.awt.Color;

import map.MapleMap;
import map.MapleMapList;
import map.PointMapName;
import maplestory.MainMapleInterface;
import maplestory.Message;
import maplestory.Player;
import utils.DialogUtils;

public class Guard extends Thread {
	private boolean isEnd;
	private Player player;
	PointMapName nowMap;
	private final int dx[] = { 0, 0, -1, 1 };
	private final int dy[] = { -1, 1, 0, 0 };
	private MainMapleInterface mainMapleInterface;
	
	private int preX;
	private int preY;

	public Guard(Player player, PointMapName nowMap, MainMapleInterface mainMapleInterface) {
		this.player = player;
		this.nowMap = nowMap;
		this.mainMapleInterface = mainMapleInterface;
	}

	boolean isGo(int x, int y) {
		MapleMap curMap = MapleMapList.getInstance().getMap(nowMap.getMapName());
		if (x >= 0 && y >= 0 && x < curMap.getMaxX() && y < curMap.getMaxY()
				&& curMap.getMap(x, y) == MapleMap.MAP_EMPTY_STATE) {
			return true;
		}
		return false;
	}

	public void run() {
		while (!isEnd) {
			MapleMapList.getInstance().getMap(nowMap.getMapName()).setMap(nowMap.getX(), nowMap.getY(), MapleMap.MAP_GUARD_STATE);
			int term = (int) (Math.random() * 3) + 1;
			term *= 400;
			for(int i = 0; i < term; i++) {
				if (player.getCurX() == nowMap.getX() && player.getCurY() == nowMap.getY() && player.get_curMap().getName().equals(nowMap.getMapName())) {
					mainMapleInterface.pushMessage(new Message("경비병에게 발각되었습니다.", Color.RED, true));
					player.playerWarp("아리안트", mainMapleInterface);
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			preX = nowMap.getX();
			preY = nowMap.getY();
			int random = (int) (Math.random() * 4);
			for (int k = 0; k < 4; k++) {
				if (random == k) {
					if (isGo(nowMap.getX() + dx[k], nowMap.getY() + dy[k])) {
						nowMap.setXY(nowMap.getX() + dx[k], nowMap.getY() + dy[k]);
					}
					break;
				}
			}
			if (preX != nowMap.getX() || preY != nowMap.getY()) {
				MapleMapList.getInstance().getMap(nowMap.getMapName()).setMap(preX, preY, MapleMap.MAP_EMPTY_STATE);
			}
		}
		this.interrupt();
	}

	public Player getPlayer() {
		return player;
	}

	public PointMapName getNowMap() {
		return nowMap;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setNowMap(PointMapName nowMap) {
		this.nowMap = nowMap;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

}
