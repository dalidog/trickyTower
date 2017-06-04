package trickyTower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	ArrayList<Block> ArrayBlocks = new ArrayList<Block>();
	static Platform p = new Platform(20, 200, Color.gray);
	Block b = new Block(50, 50, Color.BLUE);
	Timer t = new Timer(1000 / 60, this);

	public GamePanel() {
		ArrayBlocks.add(b);
		t.start();
	}

	protected void paintComponent(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(0, 0, 500, 800);
		p.draw(g);
		b.draw(g);
		if (ArrayBlocks.get(0).isFalling) {
			ArrayBlocks.add(new Block(10, 50, Color.CYAN));
		}
		for (int i = 0; i < ArrayBlocks.size(); i++) {
			ArrayBlocks.get(i).draw(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		b.update();
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ArrayBlocks.size(); i++) {
			ArrayBlocks.get(i).setX(e.getX());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		b.setXfalling(b.X);
		b.setFalling(true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
