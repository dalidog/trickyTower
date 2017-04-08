package trickyTower;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
@Override
protected void paintComponent(Graphics g) {
	g.setColor(Color.pink);
g.fillRect(0, 0, 500, 800);
}
}
