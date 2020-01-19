package skill;

import attack.AttackType;
import attack.Property;
import utils.DialogUtils;

public class SkillFactory {
	
	public static Skill makeSkill(String skillName) {
		switch(skillName) {
		case "일반공격":
			return new NormalSkill("hpIncreasing", "일반공격증가", 10, "일반공격이다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "HP증가":
			return new HpIncreasingSkill("hpIncreasing", "HP증가", 10, "최대 HP가 영구적으로 증가한다");
		case "파워스트라이크":
			return new PowerStrikeSkill("powerStrike", "파워스트라이크", 20, "적에게 강력한 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "아이언바디":
			return new IronBodySkill("ironBody", "아이언바디", 20, "일정 시간동안 물리방어력을 강화한다", AttackType.MYSELF, Property.PROPERTY_NOTHING);
		case "검마스터리":
			return new SwordMasterySkill("swordMastery", "검마스터리", 20, "검의 숙련도와 명중률을 증가시킨다");
		case "피지컬트레이닝":
			return new PhysicalTrainingSkill("physicalTraining", "피지컬트레이닝", 10, "STR을 영구히 증가시킨다");
		case "분노":
			return new RageSkill("rage", "분노", 20, "일정 시간동안 물리공격력을 강화한다", AttackType.MYSELF, Property.PROPERTY_NOTHING);
		case "브랜디쉬":
			return new BrandishSkill("brandish", "브랜디쉬", 20, "적에게 두번의 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "콤보어택":
			return new ComboAttackSkill("comboAttack", "콤보어택", 5, "공격시 일정 확률로 콤보어택이 생성되어 고급 기술을 사용할 수 있다. 또한 콤보 시너지와 연계하여 공격력을 증가시킬 수 있다.");
		case "플레임차지":
			return new FlameChargeSkill("flameCharge", "플레임차지", 20, "무기에 일시적으로 불속성을 부여한뒤 강력한 일격을 가한다.", AttackType.OPPONENT, Property.PROPERTY_FIRE);
		case "블리자드차지":
			return new BlizzardChargeSkill("blizzardCharge", "블리자드차지", 20, "무기에 일시적으로 얼음속성을 부여한뒤 강력한 일격을 가한다.", AttackType.OPPONENT, Property.PROPERTY_ICE);
		case "엘리멘탈차지":
			return new ElementalChargeSkill("elementalCharge", "엘리멘탈차지", 5, "차지 스킬을 사용한 직후 다른 차지스킬을 사용할때 엘리멘탈 차지가 충전된다. 충전할때 마다 강력한 방어 능력을 가질수 있다.");
		case "피어싱쓰루":
			return new PiercingDriveSkill("piercingDrive", "피어싱쓰루", 20, "적에게 암흑 속성의 강력한 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_DARK);
		case "창마스터리":
			return new SpearMasterySkill("spearMastery", "창마스터리", 20, "창의 숙련도와 명중률을 증가시킨다");
		case "아이언월":
			return new IronWillSkill("ironWill", "아이언월", 15, "일정 시간동안 물리방어력과 마법방어력을 강화한다", AttackType.MYSELF, Property.PROPERTY_NOTHING);
		case "하이퍼바디":
			return new HyperBodySkill("hyperBody", "하이퍼바디", 10, "일정 시간동안 최대 HP와 최대 MP를 일정량 증가시킨다", AttackType.MYSELF, Property.PROPERTY_NOTHING);
		case "브레이브슬래시":
			return new IntrepidSlashSkill("intrepidSlash", "브레이브슬래시", 20, "적에게 세번의 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "패닉":
			return new PanicSkill("panic", "패닉", 20, "콤보어택을 사용하여 강력한 일격을 가한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 3);
		case "샤우트":
			return new ShoutSkill("shout", "샤우트", 20, "콤보어택을 사용하여 강력한 포효로 적에게 데미지를 주고 일정 확률로 적을 기절시킨다", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 2);
		case "콤보시너지":
			return new ComboSynergySkill("comboSynergy", "콤보시너지", 20, "공격시 콤보어택을 얻을 수있는 확률를 높이고 콤보어택 개수마다 물리 데미지를 일정량 증가시킨다");
		case "찬스어택":
			return new ChanceAttackSkill("chanceAttack", "찬스어택", 10, "영구히 크리티컬 확률을 증가시킨다");
		case "실드마스터리":
			return new ShieldMasterySkill("shieldMastery", "실드마스터리", 10, "방패 착용시 방패 방어 효과가 증가되고 물리 공격력, 속성저항 내성이 증가된다. 또한 일정 확률로 적의 공격을 가드후 적을 기절시킬 수 있다");
		case "라이트닝차지":
			return new LightningChargeSkill("lightningCharge", "라이트닝차지", 20, "무기에 일시적으로 전기속성을 부여한뒤 강력한 일격을 가한다.", AttackType.OPPONENT, Property.PROPERTY_THUNDER);
		case "리스토네이션":
			return new HpRecoverySkill("hpRecovery", "리스토네이션", 10, "체력을 일정량 회복후 일정 확률로 모든 상태이상 디버프를 해제한다", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 3);
		case "위협":
			return new ThreatenSkill("threaten", "위협", 20, "적을 위협하여 일정 확률로 물리마법 공격력, 물리마법방어력, 적중률을 감소시킨다", AttackType.OPPONENT, Property.PROPERTY_NOTHING);
		case "컴뱃오더스":
			return new CombatOrdersSkill("combatOrders", "컴뱃오더스", 20, "일정 시간동안 모든 스킬포인트 증가, 플레임차지와 라이트닝 차지의 효과를 증대시키는 버프를 건다.", AttackType.OPPONENT, Property.PROPERTY_NOTHING, 5);
		}
		DialogUtils.showErrorDialog("SkillFactory.makeSkill("+skillName+") 새로운 스킬 생성 실패!");
		return null;
	}

}
