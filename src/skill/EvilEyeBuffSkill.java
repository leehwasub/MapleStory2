package skill;

import character.Adventurer;
import item.EquipmentItem;
import item.WeaponItem;
import item.WeaponType;

public class EvilEyeBuffSkill extends PassiveSkill{

	private static final long serialVersionUID = 1L;
	private int evilEyeCoolTime;

	public EvilEyeBuffSkill(String imageUrl, String name, int maxPoint, String infor) {
		super(imageUrl, name, maxPoint, infor);
	}

	@Override
	public void skillUpEffect(Adventurer adventurer) {
		
	}

	@Override
	public int getEffect(int point) {
		return 6 + 2 * point;
	}
	
	public int getEveryTurn(int point) {
		return 8 - (point / 4);
	}
	
	public int getLast(int point) {
		return 2 + (point / 5);
	}
	
	public int getPhysicalDamageEffect(int point) {
		return 2;
	}
	
	public int getDefenceEffect(int point) {
		return 10 * point;
	}
	
	public int getCriticalEffect(int point) {
		return ((point+1) / 2);
	}
	
	public int getEvilEyeCoolTime() {
		return evilEyeCoolTime;
	}
	
	public void resetEvilEyeCoolTime() {
		evilEyeCoolTime = getEveryTurn(point);
	}
	
	public void setEvilEyeCoolTime(int time) {
		evilEyeCoolTime = time;
	}

	public void subEvilEyeCoolTime() {
		if(evilEyeCoolTime >= 1) {
			evilEyeCoolTime--;
		}
	}

	@Override
	public String getEffectDetail(int point) {
		return "비홀더가 직접시전, " + getEveryTurn(point) + "턴 간격으로 " + getLast(point) + "턴간 물리데미지 +" + getPhysicalDamageEffect(point)
			+ ", 물리마법방어력 +" + getDefenceEffect(point) + ", 크리티컬 확률 +" + getCriticalEffect(point) + "% 증가";
	}

	@Override
	public void calStateEffect(Adventurer adventurer) {
		
	}

}
