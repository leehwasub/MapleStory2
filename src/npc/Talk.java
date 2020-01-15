package npc;

import java.io.Serializable;

public class Talk implements Serializable {
	private static final long serialVersionUID = 1L;
	private String message;
	private int type;
	private boolean isCanTalkMore;
	private boolean isProceed;
	public static final int NORMAL_TALK_TYPE = 0;
	public static final int REWARD_TALK_TYPE = 1;
	public static final int REQUEST_QUEST_TALK_TYPE = 2;
	public static final int QUEST_CLEAR_CHECK_TYPE = 3;
	public static final int UPGRADE_TYPE = 4;
	public static final int JOB_SELECTION_TALK_TYPE = 5;

	public Talk(String message) {
		this.message = message;
	}

	public Talk(String message, int type, boolean isCanTalkMore, boolean isProceed) {
		this.message = message;
		this.type = type;
		this.isCanTalkMore = isCanTalkMore;
		this.isProceed = isProceed;
	}

	public String getMessage() {
		return this.message;
	}

	public int getType() {
		return this.type;
	}

	public boolean isCanTalkMore() {
		return this.isCanTalkMore;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setCanTalkMore(boolean isCanTalkMore) {
		this.isCanTalkMore = isCanTalkMore;
	}

	public boolean isProceed() {
		return this.isProceed;
	}

	public void setProceed(boolean isProceed) {
		this.isProceed = isProceed;
	}

	public String toString() {
		return "Talk [message=" + this.message + ", type=" + this.type + ", isCanTalkMore=" + this.isCanTalkMore
				+ ", isProceed=" + this.isProceed + "]";
	}
}
