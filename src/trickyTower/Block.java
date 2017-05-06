package trickyTower;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
	int X;
	int Y;
	int mouseX;
	static Platform platform = GamePanel.p;
	int mouseY;
	Color color;
	int Yvel = 1;
	boolean isFalling = false;
	int gravity = 1;
	int Xfalling;
	public Block(int X, int Y, Color color){
		this.X=X;
		this.Y=Y;
		this.color=color;
	}
void setup(){

	X=mouseX;
	Y=mouseY;
	}
void update(){
	if(X>platform.X && X<platform.X + 200 && Y>  platform.Y - 100 && Y< platform.Y + 200){
		Yvel = 0;
		gravity = 0;
		X=platform.X;
	}
}
void draw(Graphics g){

	if(isFalling){
		X=Xfalling;
		Y=Y+Yvel;
		Yvel = Yvel +gravity;
	}
	if(X>400){
		X=400;
	}

	g.setColor(color);
	g.fillRect(X, Y, 100, 100);
	
}
public boolean isFalling() {
	return isFalling;
}
public void setFalling(boolean isFalling) {
	this.isFalling = isFalling;
}
public int getXfalling() {
	return Xfalling;
}
public void setXfalling(int xfalling) {
	Xfalling = xfalling;
}
}
