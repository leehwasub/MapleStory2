package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Hit;
import attack.Property;
import character.Character;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import utils.MusicUtils;

public class HpHealAttack extends MonsterAttack {
	
	public HpHealAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		
		MusicUtils.startEffectSound("monsterHeal");
		attacker.getCharacter().healHp(monsterSkill.getSkillPoint() * 1000);
		attacker.updateStateBox(); 
		afterAttack();
	}
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 1; i++) {
			ret.add(new AttackInfor(this.attacker.getCharacter(), Property.PROPERTY_NOTHING, this.attacker.getCharacter().calNormalDamge(1.0d), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. 자신의 체력을 " + (monsterSkill.getSkillPoint() * 1000) + " 회복했다.";
	}

	public int calNeedMp() {
		return 15 + (monsterSkill.getSkillPoint() / 2);
	}
	
}
