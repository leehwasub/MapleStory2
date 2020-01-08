package maplestory;

import java.io.Serializable;
import java.net.URL;

import javazoom.jl.player.Player;

public class Music extends Thread implements Serializable {
	private static final long serialVersionUID = 1L;
	private Player player;
	private boolean isLoop;
	private URL url;

	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			if(this.isLoop) {
				this.url = Main.class.getResource("/music/" + name);
			} else {
				this.url = Main.class.getResource("/sound/" + name);
			}
			this.player = new Player(this.url.openStream());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getTime() {
		if (this.player == null) {
			return 0;
		}
		return this.player.getPosition();
	}

	public void close() {
		this.isLoop = false;
		this.player.close();
		interrupt();
	}

	public void run() {
		try {
			do {
				this.player.play();
				this.player = new Player(this.url.openStream());
			} while (this.isLoop);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
