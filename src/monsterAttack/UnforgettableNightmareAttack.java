package monsterAttack;

import java.util.ArrayList;

import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.ChainLightningHitImage;
import attackImage.ChainLightningUseImage;
import attackImage.CombatSwitchingUseImage;
import attackImage.SwordHitImage;
import attackImage.SwordUseImage;
import attackImage.UnforgettableNightmareHitImage;
import attackImage.UnforgettableNightmareUseImage;
import buff.BuffFactory;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import skill.MonsterSkill;
import skill.ShoutSkill;
import utils.CalUtils;

public class UnforgettableNightmareAttack extends MonsterAttack {
	
	public UnforgettableNightmareAttack(Hunt hunt, StateBox attacker, StateBox opponent, MonsterSkill monsterSkill) {
		super(hunt, attacker, opponent, monsterSkill);
	}

	public void run() {
		this.attacker.attackForwardMotion();
		addSkillImageThread(new UnforgettableNightmareUseImage(hunt, attacker, opponent, makeAttackInfor()), 
				new UnforgettableNightmareHitImage(hunt, opponent, opponent, null), true);
		makeConfusionBuff();
		afterAttack();
	}
	
	private void makeConfusionBuff() {
		int confusionRate = 30 + monsterSkill.getSkillPoint() * 3;
		if(CalUtils.calPercent(confusionRate)) {
			opponent.getCharacter().addBuff(BuffFactory.makeMonsterBuff("혼란", monsterSkill.getSkillPoint()));
		}
	}
	
	
	@Override
	protected ArrayList<AttackInfor> makeAttackInfor() {
		double percent = 0.7f + (double)monsterSkill.getSkillPoint() * 0.05f;
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 4; i++) {
			ret.add(new AttackInfor(attacker.getCharacter(), monsterSkill.getProperty(), 0, attacker.getCharacter().calMagicDamge(percent), DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
	}

	public String attackInfor() {
		return this.attacker.getCharacterName() + "는 " + this.monsterSkill.getAttackName() + "을 사용. " + this.opponent.getCharacterName() + "에게 " + this.damage + "의 피해를 주었다.";
	}

	public int calNeedMp() {
		return 55 + monsterSkill.getSkillPoint() * 8;
	}

}
