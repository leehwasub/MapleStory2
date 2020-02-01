package skill;

import java.util.HashMap;
import java.util.Map.Entry;

import attack.AttackType;
import attack.Property;
import character.Adventurer;
import component.StateBox;
import hunt.HuntComponent.Hunt;
import playerAttack.CombatOrdersAttack;
import playerAttack.PlayerAttack;

public class CombatOrdersSkill extends ActiveSkill{

	private static final long serialVersionUID = 1L;
	private HashMap<String, Integer> originalSkillInfor;

	public CombatOrdersSkill(String imageUrl, String name, int maxPoint, String infor, AttackType attackType, Property property, int coolTime) {
		super(imageUrl, name, maxPoint, infor, attackType, property, coolTime);
	}
	
	public void updateToOriginalSkillPoint(Adventurer adventurer) {
		if(originalSkillInfor == null) return;
		for(Entry<String, Integer> it : originalSkillInfor.entrySet()) {
			adventurer.getSkillWithName(it.getKey()).setPoint(it.getValue());
		}
		originalSkillInfor = null;
	}
	
	public void upSkillPointForCombatOrders(Adventurer adventurer) {
		if(originalSkillInfor != null) {
			updateToOriginalSkillPoint(adventurer);
		}
		originalSkillInfor = adventurer.getAllSkillInfor();
		System.out.println(originalSkillInfor);
		int upPointEffect = getEffect(point);
		for(Entry<String, Integer> it : originalSkillInfor.entrySet()) {
			adventurer.getSkillWithName(it.getKey()).addSkillPointForCombatOrders(upPointEffect);
		}
	}
	
	public int getExtraChargeEffect(int point) {
		return 30 + (point * 4);
	}

	@Override
	public int getNeedMp(int point) {
		return 24 + ((point / 6) * 4);
	}

	@Override
	public int getLast(int point) {
		return 8 + (point / 5);
	}

	@Override
	public PlayerAttack skillUse(Hunt hunt, StateBox attacker, StateBox opponent) {
		return new CombatOrdersAttack(hunt, attacker, opponent, this);
	}
	
	@Override
	public int getEffect(int point) {
		return 1 + (point / 10);
	}

	@Override
	public String getEffectDetail(int point) {
		return "MP " + getNeedMp(point) + " 소비, " + getLast(point) + "턴간 모든 스킬포인트 " + getEffect(point) + "증가(쿨타임" + coolTime + "턴)[패시브효과 : "
				+ " 블리자드 차지와 플레임 차지의 데미지" + getExtraChargeEffect(point) + "% 추가 증가]";
	}

}
