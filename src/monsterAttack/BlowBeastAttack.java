package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Hit;
import attack.Property;
import attackImage.BlowBeastUseImage;
import buff.BuffFactory;
import character.Character;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.CalUtils;
import utils.MusicUtils;

public class BlowBeastAttack extends MonsterAttack {
	
	public BlowBeastAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		attacker.attackForwardMotion();
		addSkillImageThread(new BlowBeastUseImage(hunt, opponent, opponent, makeAttackInfor()), true);
		makeArmorBreakBuff();
		afterAttack();
	}
	

	private void makeArmorBreakBuff() {
		int armorBreakRate = (10 * (monsterSkill.getSkillPoint() - 1));
		if(CalUtils.calPercent(armorBreakRate)) {
			opponent.getCharacter().addBuff(BuffFactory.makeMonsterBuff("아머브레이크", monsterSkill.getSkillPoint()));
		}
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), monsterSkill.getProperty(), attacker.getCharacter().calNormalDamge(2.0d), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + monsterSkill.getAttackName() + "을 사용. " + opponent.getCharacterName() + "에게 " + damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 20;
	}
	
}
