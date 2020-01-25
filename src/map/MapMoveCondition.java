package map;

import javax.swing.JOptionPane;

import maplestory.Player;
import utils.DialogUtils;

public class MapMoveCondition {
	public static boolean checkCanMove(Player player) {
		if(player.get_curMap().getName().equals("아리안트궁전입구") && player.getNextMapName().equals("아리안트궁전복도")) {
			if(player.getMaterialItemNum("출입증") == 0) {
				DialogUtils.showWarningDialog("출입증이 없어 입장이 불가능합니다.");
				return false;
			}
		}
		return true;
	}
}
