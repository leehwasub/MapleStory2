package map;

import javax.swing.JOptionPane;

import maplestory.Player;

public class WarpMapBossRoom {
	public static PointMapName warpFromMapBossRoom(String monsterName) {
		switch(monsterName) {
		case "마노":
			return new PointMapName(14, 6, "달팽이의숲");
		case "에레고스":
			return new PointMapName(0, 24, "폐쇄구역");
		default:
			JOptionPane.showMessageDialog(null, "보스 종료후 워프 실패!!", "오류", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return null;
	}

	public static void closeMapAfterClear(Player player, String monsterName) {
		switch(monsterName) {
		case "마노":
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(14, 6, "달팽이의숲"), MapleMap.MAP_EMPTY_STATE));
			break;
		case "에레고스":
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(0, 24, "폐쇄구역"), MapleMap.MAP_EMPTY_STATE));
			break;
		default:
			JOptionPane.showMessageDialog(null, "보스 종료후 보스 워프 닫기 실패!!", "오류", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
