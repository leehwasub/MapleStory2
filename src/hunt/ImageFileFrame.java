package hunt;

public class ImageFileFrame implements Comparable<ImageFileFrame> {
	int frame;
	String extension;

	public ImageFileFrame(int frame, String extension) {
		this.frame = frame;
		this.extension = extension;
	}

	public int getFrame() {
		return this.frame;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String toString() {
		return "ImageFileFrame [frame=" + this.frame + ", extension=" + this.extension + "]";
	}

	public int compareTo(ImageFileFrame o) {
		if (this.frame < o.frame) {
			return -1;
		}
		if (this.frame > o.frame) {
			return 1;
		}
		return 0;
	}
}
