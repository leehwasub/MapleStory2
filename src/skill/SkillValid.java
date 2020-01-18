package skill;

public class SkillValid {
	
	private boolean isCanUse;
	private String message;
	
	public SkillValid(boolean isCanUse, String message) {
		this.isCanUse = isCanUse;
		this.message = message;
	}
	
	public boolean isCanUse() {
		return isCanUse;
	}
	public String getMessage() {
		return message;
	}
	public void setCanUse(boolean isCanUse) {
		this.isCanUse = isCanUse;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
