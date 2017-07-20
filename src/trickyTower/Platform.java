package trickyTower;

import java.awt.Color;
import java.awt.Graphics;

public class Platform {
	int height;
	int width;
	Color color;
	int X = 1;
	int speed;
	int Y = 700;

	public Platform(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
		setup();
	}

	void setup() {
		speed = 5;
	}

	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(X, Y, width, height);
		X = X + speed;
		if (X + width >= trickyTower.frameW) {
			speed = -speed;
		} else if (X <= 0) {
			speed = -speed;
		}
	}
}
