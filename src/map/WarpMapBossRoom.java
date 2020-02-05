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
		case "엘리자":
			return new PointMapName(8, 39, "하늘계단2");
		case "자쿰":
			return new PointMapName(3, 13, "자쿰의제단입구");
		case "데우":
			return new PointMapName(0, 20, "선인장사막");
		case "루루모":
			return new PointMapName(4, 29, "연구소102호");
		case "프랑켄로이드":
			return new PointMapName(3, 7, "비밀연구소3구역");
		case "혼테일":
			return new PointMapName(5, 0, "혼테일동굴입구");
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
		case "엘리자":
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(8, 39, "하늘계단2"), MapleMap.MAP_EMPTY_STATE));
			break; 
		case "자쿰":
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(3, 13, "자쿰의제단입구"), MapleMap.MAP_EMPTY_STATE));
			break;
		case "데우":
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(0, 20, "선인장사막"), MapleMap.MAP_EMPTY_STATE));
			break;
		case "루루모":
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(4, 29, "연구소102호"), MapleMap.MAP_EMPTY_STATE));
			break;
		case "프랑켄로이드":
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(1, 9, "비밀연구소3구역"), MapleMap.MAP_EMPTY_STATE));
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(2, 9, "비밀연구소3구역"), MapleMap.MAP_EMPTY_STATE));
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(3, 9, "비밀연구소3구역"), MapleMap.MAP_EMPTY_STATE));
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(4, 9, "비밀연구소3구역"), MapleMap.MAP_EMPTY_STATE));
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(5, 9, "비밀연구소3구역"), MapleMap.MAP_EMPTY_STATE));
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(3, 7, "비밀연구소3구역"), MapleMap.MAP_EMPTY_STATE));
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(4, 29, "C-1구역"), MapleMap.MAP_EMPTY_STATE));
			break;
		case "혼테일":
			player.addUpdatedMap(new UpdatedMapInfor(new PointMapName(5, 0, "혼테일동굴입구"), MapleMap.MAP_EMPTY_STATE));
			break;
		default:
			JOptionPane.showMessageDialog(null, "보스 종료후 보스 워프 닫기 실패!!", "오류", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
