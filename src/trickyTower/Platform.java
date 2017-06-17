package trickyTower;

import java.awt.Color;
import java.awt.Graphics;

public class Platform {
	int length;
	int width;
	Color color;
	int X = 1;
	int speed;
	int Y = 700;

	public Platform(int length, int width, Color color) {
		this.length = length;
		this.width = width;
		this.color = color;
		setup();
	}

	void setup() {
		speed = 5;
	}

	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(X, Y, width, length);
		X = X + speed;
		if (X + width >= trickyTower.frameW) {
			speed = -speed;
		} else if (X <= 0) {
			speed = -speed;
		}
	}
}
