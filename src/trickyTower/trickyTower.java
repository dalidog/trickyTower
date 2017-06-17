package trickyTower;

import java.awt.Graphics;

import javax.swing.JFrame;

public class trickyTower {
	static final int frameW = 500;
	static final int frameH = 800;
	JFrame frame = new JFrame();
	GamePanel panel = new GamePanel();

	public static void main(String[] args) {
		trickyTower TT = new trickyTower();
		TT.setup();
	}

	void setup() {
		frame.add(panel);
		frame.setSize(frameW, frameH);
		frame.show();
		frame.addMouseMotionListener(panel);
		frame.addMouseListener(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void draw(Graphics g) {

	}
}