package skill;

import attack.Attack;
import component.StateBox;

public class PowerStrikeSkill extends ActiveSkill{

	public PowerStrikeSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public int getNeedMp(int point) {
		return 5 + ((point / 5) * 2);
	}

	@Override
	public int getLast(int point) {
		return 0;
	}

	@Override
	public Attack skillUse(StateBox attacker, StateBox opponent) {
		return null;
	}

	@Override
	public int getEffect(int point) {
		return 200 + point * 5;
	}

}
