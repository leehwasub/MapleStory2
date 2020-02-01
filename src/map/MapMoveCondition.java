package map;

import java.awt.Color;

import maplestory.MainMapleInterface;
import maplestory.Message;
import maplestory.Player;
import utils.DialogUtils;

public class MapMoveCondition {
	public static boolean checkCanMove(Player player, MainMapleInterface mainMapleInterface) {
		if(player.get_curMap().getName().equals("아리안트궁전입구") && player.getNextMapName().equals("아리안트궁전복도")) {
			if(player.getMaterialItemNum("궁전출입자격증") == 0) {
				mainMapleInterface.pushMessage(new Message("출입증이 없어 입장이 불가능합니다.", Color.RED, true));
				return false;
			}
		}
		else if(player.get_curMap().getName().equals("비밀연구소1구역") && player.getCurX() == 3 && player.getCurY() == 34 
				&& player.getMaterialItemNum("비밀문서") == 0) {
			mainMapleInterface.pushMessage(new Message("이구역에 아직 발견하지 않은 문서가 있습니다.", Color.RED, true));
			return false;
		}
		else if(player.get_curMap().getName().equals("비밀연구소2구역") && player.getCurX() == 3 && player.getCurY() == 34 
				&& player.getMaterialItemNum("비밀문서") != 3) {
			mainMapleInterface.pushMessage(new Message("이구역에 아직 발견하지 않은 문서가 있습니다.", Color.RED, true));
			return false;
		}
		else if(player.get_curMap().getName().equals("C-1구역") && player.getCurX() == 4 && player.getCurY() == 29) {
			String input = DialogUtils.showInputDialog("비밀번호를 입력하세요.");
			if(input == null || !input.equals("276410")) {
				mainMapleInterface.pushMessage(new Message("비밀번호가 틀립니다.", Color.RED, true));
				return false;
			}
		}
		return true;
	}
}
