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
	ArrayList<Block> arrayBlocks = new ArrayList<Block>();
	Platform p = new Platform(200, 20, Color.gray);

	Timer t = new Timer(1000 / 60, this);
	int counter = 0;
	int counter2 = 0;

	public GamePanel() {
		arrayBlocks.add(new Block(50, 50, 100, 100, Color.BLUE));

		t.start();

	}

	protected void paintComponent(Graphics g) {
		drawBackground(g);
		p.draw(g);
		drawBlocks(g);
	}

	public void drawBlocks(Graphics g) {
		for (int i = 0; i < arrayBlocks.size(); i++) {
			arrayBlocks.get(i).draw(g);
		}

		if (arrayBlocks.get(counter2).touchingPlatform) {
			System.out.println(counter2);
			arrayBlocks.add(new Block(50, 50, 50, 50, Color.CYAN));
			arrayBlocks.get(counter2).touchingPlatform = false;
			counter2++;
		}

	}

	public void drawBackground(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(0, 0, 500, 800);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < arrayBlocks.size(); i++) {
			if (i > 0) {
				arrayBlocks.get(i).blockcollision(arrayBlocks.get(i - 1));
			} else {
				arrayBlocks.get(i).iscollision(p);
			}
			arrayBlocks.get(i).update(p);

		}
		repaint();

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arrayBlocks.size(); i++) {
			arrayBlocks.get(i).setX(e.getX());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		arrayBlocks.get(counter2).setXfalling(arrayBlocks.get(counter2).X);
		arrayBlocks.get(counter2).setFalling(true);

		// arrayBlocks.get(1).setXfalling(arrayBlocks.get(1).X);
		// arrayBlocks.get(1).setFalling(true);
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
