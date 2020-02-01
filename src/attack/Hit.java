package attack;

public class Hit {

	private int damage;
	private DamageType type;
	private boolean isCritical;
	private boolean isMiss;
	
	public Hit(int damage, DamageType type, boolean isCritical, boolean isMiss) {
		this.damage = damage;
		this.type = type;
		this.isCritical = isCritical;
		this.isMiss = isMiss;
	}
	
	public int getDamage() {
		return damage;
	}
	public DamageType getType() {
		return type;
	}
	public boolean isCritical() {
		return isCritical;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setType(DamageType type) {
		this.type = type;
	}
	public void setCritical(boolean isCritical) {
		this.isCritical = isCritical;
	}
	public boolean isMiss() {
		return isMiss;
	}
	public void setMiss(boolean isMiss) {
		this.isMiss = isMiss;
	}

	@Override
	public String toString() {
		return "Hit [damage=" + damage + ", type=" + type + ", isCritical=" + isCritical + ", isMiss=" + isMiss + "]";
	}
	
}
