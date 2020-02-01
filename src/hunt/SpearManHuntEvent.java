package hunt;

import java.awt.Graphics2D;
import java.io.Serializable;

import attack.Attack;
import attack.AttackInfor;
import attack.DamageType;
import attackImage.EvilEyeBuffUseImage;
import attackImage.EvilEyeShockUseImage;
import buff.BuffFactory;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.PlayerAttack;
import skill.CrossSurgeSkill;
import skill.EvilEyeBuffSkill;
import skill.EvilEyeShockSkill;
import skill.IronBodySkill;
import skill.IronWillSkill;
import skill.Skill;

public class SpearManHuntEvent implements HuntEvent, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public void drawObject(Graphics2D g, Hunt hunt) {
		
	}

	@Override
	public void drawInfor(Graphics2D g, Hunt hunt) {
		
	}

	@Override
	public void endHunt(Hunt hunt) {
		
	}

	@Override
	public void startHunt(Hunt hunt) {
		EvilEyeBuffSkill evilEyeBuffSkill = (EvilEyeBuffSkill)hunt.getAdventurer().getSkillWithName("비홀더스버프");
		if(evilEyeBuffSkill != null && evilEyeBuffSkill.getPoint() >= 1) {
			evilEyeBuffSkill.setEvilEyeCoolTime(0);
		}
	}

	@Override
	public void startTurn(Hunt hunt) {
		EvilEyeBuffSkill evilEyeBuffSkill = (EvilEyeBuffSkill)hunt.getAdventurer().getSkillWithName("비홀더스버프");
		if(evilEyeBuffSkill != null && evilEyeBuffSkill.getPoint() >= 1) {
			evilEyeBuffSkill.subEvilEyeCoolTime();
			if(evilEyeBuffSkill.getEvilEyeCoolTime() == 0) {
				hunt.addSkillImage(new EvilEyeBuffUseImage(hunt, hunt.getAdventurerState(), hunt.getMonsterState(), null));
				hunt.getAdventurer().addBuff(BuffFactory.makeAdventurerBuff(evilEyeBuffSkill));
				evilEyeBuffSkill.resetEvilEyeCoolTime();
			}
		}
	}

	@Override
	public void startAttack(Hunt hunt) {
		
	}

	@Override
	public void afterAttack(Hunt hunt) {
		Skill skill = hunt.getPlayerAttack().getActiveSkill();
		Adventurer adventurer = hunt.getAdventurer();
		if(skill instanceof IronWillSkill && adventurer.isAlreadyBuffed("아이언바디")) {
			adventurer.removeBuff("아이언바디");
		} else if(skill instanceof IronBodySkill && adventurer.isAlreadyBuffed("아이언월")) {
			adventurer.removeBuff("아이언월");
		}
	}

	@Override
	public int hit(Adventurer adventurer, AttackInfor attackInfor) {
		CrossSurgeSkill crossSurgeSkill = (CrossSurgeSkill)adventurer.getSkillWithName("크로스오버체인");
		if(crossSurgeSkill != null && crossSurgeSkill.getPoint() >= 1 && adventurer.isAlreadyBuffed("크로스오버체인") 
				&& attackInfor.getDamageType() == DamageType.DAMAGE_HP_TYPE) {
			int point = crossSurgeSkill.getPoint();
			int damage = attackInfor.getPhysicalDamage();
			damage += attackInfor.getMagicDamage();
			double rate = crossSurgeSkill.getRecoveryRate(point) / 100.0;
			adventurer.healHp(Math.min(crossSurgeSkill.getMaxRecovery(point), (int)(damage * rate)));
		}
		return attackInfor.getTotalDamage();
	}
	
}
