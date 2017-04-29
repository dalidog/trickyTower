package trickyTower;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
	int X;
	int Y;
	int mouseX;
	int mouseY;
	Color color;
	public Block(int X, int Y, Color color){
		this.X=X;
		this.Y=Y;
		this.color=color;
	}
void setup(){
	X=mouseX;
	Y=mouseY;
}
void draw(Graphics g){
	g.setColor(color);
	g.fillRect(X, Y, 100, 100);

}
}
