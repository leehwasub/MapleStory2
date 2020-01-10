package editor;

import javax.swing.JFrame;

public class EditorFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public EditorFrame() {
		setSize(1920, 1080);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setContentPane(new EditorPanel());
	}

}
