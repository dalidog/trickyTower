package trickyTower;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Block {
	ArrayList<Block> ArrayBlocks = new ArrayList();
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

	public Block(int X, int Y, Color color) {
		this.X = X;
		this.Y = Y;
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

			ArrayBlocks.add(new Block(X, Y, color));
		}
		if (moveWithPlatform) {

			X = platform.X + difference;

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
		if (X > 400) {
			X = 400;
		}
		if (isFalling == false) {
			Block b2 = new Block(mouseX, mouseY, Color.ORANGE);
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
