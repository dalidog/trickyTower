package trickyTower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	static Platform p = new Platform(20, 200, Color.gray);
	Block b = new Block(50, 50, Color.BLUE);
	Timer t = new Timer(1000 / 60, this);

	public GamePanel() {
		t.start();
	}

	protected void paintComponent(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(0, 0, 500, 800);
		p.draw(g);
		b.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (b.isFalling() == false) {
			blockcollided();
		}
		b.update();
		repaint();
	}

	public void blockcollided() {
		b = new Block(50, 50, Color.ORANGE);
		System.out.println(" hi ");
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		b.X = e.getX();
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
