package trickyTower;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	ArrayList<Block> arrayBlocks = new ArrayList<Block>();
	Platform p = new Platform(200, 20, Color.gray);
		 int blockwidth = 100;
		 int blockheight = 100;
	Timer t = new Timer(1000 / 60, this);
	int counter = 0;
	int counter2 = 0;

	public GamePanel() {
		arrayBlocks.add(new Block(50, 50, blockwidth, blockheight, Color.BLUE));

		t.start();

	}

	protected void paintComponent(Graphics g) {
		drawBackground(g);
		p.draw(g);
		drawBlocks(g);
		g.setFont(new Font("Impact" , Font.BOLD, 24));
		g.drawString("Tricky Tower", 200, 25);
		g.drawString("Move mouse to align block and click to drop.", 30, 250);
		g.drawString( "Try to stack them all!", 150, 300);
		if(checkForEndState()==true){
			drawEndState(g);
		}
		else if(checkForWin()==true){
			drawWin(g);
		}
	}

	private void drawWin(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 500, 800);
		g.setFont(new Font("Impact" , Font.BOLD, 30));
		g.setColor(Color.BLACK);
		g.drawString("You Win! You stacked "+ counter2 +" blocks!", 40, 100);
	}

	public void drawBlocks(Graphics g) {
		for (int i = 0; i < arrayBlocks.size(); i++) {
			arrayBlocks.get(i).draw(g);
		}

		if (arrayBlocks.get(counter2).touchingPlatform) {
			System.out.println(counter2);
			Random randomGenerator = new Random();
			int red = randomGenerator.nextInt(256);
			int green = randomGenerator.nextInt(256);
			int blue = randomGenerator.nextInt(256);
			Color randomcolor = new Color(red,green,blue);
			arrayBlocks.add(new Block(50, 50,blockwidth, blockheight,randomcolor));
			arrayBlocks.get(counter2).touchingPlatform = false;
			counter2++;
			blockwidth-=10;
			blockheight-=10;
		}

	}
	
	public boolean checkForEndState(){
		for (int i = 0; i < arrayBlocks.size(); i++) {
			Block block=arrayBlocks.get(i);
			if(block.Y>800){
				return true;
			}
		}
		return false;
	}
	public boolean checkForWin(){
		for (int i = 0; i < arrayBlocks.size(); i++) {
			Block block=arrayBlocks.get(i);
			if(counter2 == 11){
				return true;
			}
	}
		return false;
	
	}
	public void drawEndState(Graphics g){
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 500, 800);
			g.setFont(new Font("Impact" , Font.BOLD, 30));
			g.setColor(Color.RED);
			g.drawString("You Lose! You only stacked "+ counter2 +" blocks!", 40, 100);
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
				arrayBlocks.get(i).update(arrayBlocks.get(i-1));
			} else {
				arrayBlocks.get(i).iscollision(p);
				arrayBlocks.get(i).update(p);
			}
			
			

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
