package attack;

public class Hit {

	private int damage;
	private DamageType type;
	private boolean isCritical;
	
	public Hit(int damage, DamageType type, boolean isCritical) {
		this.damage = damage;
		this.type = type;
		this.isCritical = isCritical;
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
	
}
