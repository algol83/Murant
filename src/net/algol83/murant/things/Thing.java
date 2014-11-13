package net.algol83.murant.things;

import com.sun.istack.internal.NotNull;

import net.algol83.murant.base.Point;

public class Thing {

	private @NotNull Point position = new Point(0.0, 0.0);
	private double radius = 0;
	private float angle = 0;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public @NotNull Point getPosition() {
		return position;
	}
	
	public void setPosition(@NotNull Point position) {
		this.position = position;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
	
}
