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
	int difference;
	boolean moveWithPlatform = false;
	int width;
	int height;
	boolean touchingPlatform= false;
	

	public Block(int X, int Y,int width, int height, Color color) {
		this.X = X;
		this.Y = Y;
		this.width=width;
		this.height=height;
		this.color = color;
	}

	void setup() {

		X = mouseX;
		Y = mouseY;
	}
	
	
	

	void update() {

	}

	void draw(Graphics g) {
		if (X + 50 > platform.X && X < platform.X + 200 && Y > platform.Y - 100 && Y < platform.Y + 200) {
			Yvel = 0;
			gravity = 0;
			moveWithPlatform = true;

		}
		if (moveWithPlatform) {

			X = platform.X + difference;
touchingPlatform = true;
		}

		if (isFalling) {
			Y = Y + Yvel;
			Yvel = Yvel + gravity;

			if (platform.Y == Y + 89) {
				if (X > platform.X) {
					difference = X - platform.X;
				} else if (X <= platform.X) {
					difference = platform.X - X;
				}

			}

		}
		if (X > 400) { //stops falling
			X = 400;
			
		}

		g.setColor(color);
		g.fillRect(X, Y, width, height);
	
	
	}
	void newblock(){
		
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

	public void setX(int x) {
		// TODO Auto-generated method stub
		this.X = x;
	}
}
