package net.algol83.murant.things;

import net.algol83.murant.base.Point;

public class Thing {

	private Point position = new Point();
	private double radius = 0;
	private float angle = 0;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Point getPosition() {
		return position;
	}
	
	public void setPosition(Point position) {
		if (position == null)
			throw new IllegalArgumentException();
		this.position = position;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
	
}
