package hunt;

import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import attack.Attack;
import attack.AttackInfor;
import attack.DamageType;
import attack.Property;
import attackImage.EvilEyeBuffEffectedImage;
import attackImage.EvilEyeBuffUseImage;
import attackImage.EvilEyeShockUseImage;
import buff.BuffFactory;
import character.Adventurer;
import character.Character;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.PlayerAttack;
import playerAttackImage.RevengeOfTheEvilEyeHealImage;
import playerAttackImage.RevengeOfTheEvilEyeHitImage;
import playerAttackImage.RevengeOfTheEvilEyeUseImage;
import skill.CrossSurgeSkill;
import skill.EvilEyeBuffSkill;
import skill.EvilEyeShockSkill;
import skill.IronBodySkill;
import skill.IronWillSkill;
import skill.RevengeOfTheEvilEyeSkill;
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
		Adventurer adventurer = hunt.getAdventurer();
		EvilEyeBuffSkill evilEyeBuffSkill = (EvilEyeBuffSkill)adventurer.getSkillWithName("비홀더스버프");
		if(evilEyeBuffSkill != null && evilEyeBuffSkill.getPoint() >= 1) {
			evilEyeBuffSkill.setEvilEyeCoolTime(0);
		}
		RevengeOfTheEvilEyeSkill revengeOfTheEvilEyeSkill = (RevengeOfTheEvilEyeSkill)adventurer.getSkillWithName("비홀더스리벤지");
		if(revengeOfTheEvilEyeSkill != null && revengeOfTheEvilEyeSkill.getPoint() >= 1) {
			revengeOfTheEvilEyeSkill.setHit(false);
		}
	}

	@Override
	public void startTurn(Hunt hunt) {
		Adventurer adventurer = hunt.getAdventurer();
		EvilEyeBuffSkill evilEyeBuffSkill = (EvilEyeBuffSkill)adventurer.getSkillWithName("비홀더스버프");
		if(evilEyeBuffSkill != null && evilEyeBuffSkill.getPoint() >= 1) {
			evilEyeBuffSkill.subEvilEyeCoolTime();
			if(evilEyeBuffSkill.getEvilEyeCoolTime() == 0) {
				hunt.addSkillImageWithAffectedImage(new EvilEyeBuffUseImage(hunt, hunt.getAdventurerState(), hunt.getMonsterState(), null)
						, new EvilEyeBuffEffectedImage(hunt, hunt.getAdventurerState(), hunt.getMonsterState(), null), 720);
				hunt.getAdventurer().addBuff(BuffFactory.makeAdventurerBuff(evilEyeBuffSkill));
				evilEyeBuffSkill.resetEvilEyeCoolTime();
			}
		}
		RevengeOfTheEvilEyeSkill revengeOfTheEvilEyeSkill = (RevengeOfTheEvilEyeSkill)adventurer.getSkillWithName("비홀더스리벤지");
		if(revengeOfTheEvilEyeSkill != null && revengeOfTheEvilEyeSkill.getPoint() >= 1 && revengeOfTheEvilEyeSkill.isHit()) {
			int point = revengeOfTheEvilEyeSkill.getPoint();
			hunt.addSkillImageWithHitImage(new RevengeOfTheEvilEyeUseImage(hunt, hunt.getAdventurerState(), hunt.getMonsterState(), makeAttackInfor(adventurer, revengeOfTheEvilEyeSkill.getEffect(point)/100.0)), 
					new RevengeOfTheEvilEyeHitImage(hunt, hunt.getMonsterState(), hunt.getMonsterState(), null));
			hunt.addSkillImage(new RevengeOfTheEvilEyeHealImage(hunt, hunt.getAdventurerState(), hunt.getMonsterState(), null));
			double rate = revengeOfTheEvilEyeSkill.getHpRecoverRate(point) / 100.0;
			adventurer.healHp((int)(adventurer.getMaxHp() * rate));
			try {
				hunt.sleep(1200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private ArrayList<AttackInfor> makeAttackInfor(Character attacker, double rate) {
		ArrayList<AttackInfor> ret = new ArrayList<AttackInfor>();
		for(int i = 0; i < 5; i++) {
			ret.add(new AttackInfor(attacker, Property.PROPERTY_NOTHING, attacker.calNormalDamge(rate), 0, DamageType.DAMAGE_HP_TYPE));
		}
		return ret;
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
		RevengeOfTheEvilEyeSkill revengeOfTheEvilEyeSkill = (RevengeOfTheEvilEyeSkill)adventurer.getSkillWithName("비홀더스리벤지");
		if(revengeOfTheEvilEyeSkill != null && revengeOfTheEvilEyeSkill.getPoint() >= 1) {
			revengeOfTheEvilEyeSkill.setHit(false);
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
		RevengeOfTheEvilEyeSkill revengeOfTheEvilEyeSkill = (RevengeOfTheEvilEyeSkill)adventurer.getSkillWithName("비홀더스리벤지");
		if(revengeOfTheEvilEyeSkill != null && revengeOfTheEvilEyeSkill.getPoint() >= 1) {
			revengeOfTheEvilEyeSkill.setHit(true);
		}
		return attackInfor.getTotalDamage();
	}
	
}
