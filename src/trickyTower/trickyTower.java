package trickyTower;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class trickyTower {
	JFrame frame = new JFrame();
	GamePanel panel = new GamePanel();
public static void main(String[] args) {
	trickyTower TT = new trickyTower();
	TT.setup();
}
void setup(){
frame.add(panel);
frame.setSize(500, 800);
frame.show();
}
void draw(){
	
}
}