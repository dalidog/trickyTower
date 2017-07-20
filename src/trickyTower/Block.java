package trickyTower;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
	int X;
	int Y;
	int mouseX;
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
	boolean touchingPlatform = false;

	public Block(int X, int Y, int width, int height, Color color) {
		this.X = X;
		this.Y = Y;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	void setup() {

		X = mouseX;
		Y = mouseY;
	}

	void update(Platform platform) {
		if (moveWithPlatform) {

			X = platform.X + difference;
			touchingPlatform = true;
		}

		if (isFalling) {
			Y = Y + Yvel;
			Yvel = Yvel + gravity;

			if (Y - height > platform.Y) {
				if (X > platform.X) {
					difference = X - platform.X;
				} else if (X <= platform.X) {
					difference = platform.X - X;
				}

			}

		}
		if (X > 400) { // stops falling
			X = 400;

		}
	}

	void draw(Graphics g) {

		g.setColor(color);
		g.fillRect(X, Y, width, height);

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

	public void iscollision(Platform platform) {
		if (X + width > platform.X && X < platform.X + platform.width && Y > platform.Y - height
				&& Y < platform.Y + platform.height) {
			Yvel = 0;
			gravity = 0;
			moveWithPlatform = true;

		}

	}

	public void blockcollision(Block b) {
		if (X + width > b.X && X < b.X + b.width && Y > b.Y - height && Y < b.Y + b.height) {
			Yvel = 0;
			gravity = 0;
			moveWithPlatform = true;
		}
	}
}
