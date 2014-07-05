package net.algol83.murant.base;

public class Polar {

	private double length = 0;
	private float angle = 0;
	
	public Polar() {
	}
	
	public Polar(double length, float angle) {
		setLength(length);
		setAngle(angle);
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
	
	public Point toPoint() {
		return new Point(Math.cos(angle) * length, Math.sin(angle) * length);
	}
	
}
