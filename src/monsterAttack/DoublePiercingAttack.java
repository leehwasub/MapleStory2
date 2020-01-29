package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.DoublePiercingHitImage;
import attackImage.DoublePiercingUseImage;
import attackImage.SwordHitImage;
import attackImage.SwordUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.CalUtils;

public class DoublePiercingAttack extends MonsterAttack {
	
	public DoublePiercingAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new DoublePiercingUseImage(hunt, attacker, opponent, makeAttackInfor()), new DoublePiercingHitImage(hunt, opponent, opponent, null), true);
		makePosionBuff();
		afterAttack();
	}
	
	private void makePosionBuff() {
		int posionRate = 35 + monsterSkill.getSkillPoint() * 2;
		int posionLast = 4 + (monsterSkill.getSkillPoint() / 4);
		if(CalUtils.calPercent(posionRate)) {
			double burnDamageRate = 0.1 + (monsterSkill.getSkillPoint() * 0.05);
			opponent.getCharacter().addBuff(BuffFactory.makeAbnormalBuff("중독", posionLast, attacker.getCharacter().calNormalDamge(burnDamageRate)));
		}
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 2; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), Property.PROPERTY_NOTHING, this.attacker.getCharacter().calNormalDamge(0.8d), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 6 + monsterSkill.getSkillPoint();
	}

}
