package net.algol83.murant.base;

import com.sun.istack.internal.NotNull;

public class Polar {

	public static final Polar EMPTY = new Polar();
	
	private final double length;
	private final float angle;
	
	private Polar() {
		this(Double.NaN, Float.NaN);
	}
	
	public Polar(double length, float angle) {
		this.length = length;
		this.angle = angle;
	}

	public double getLength() {
		return length;
	}

	public float getAngle() {
		return angle;
	}

	public boolean isEmpty() {
		return Double.isNaN(getLength()) || Float.isNaN(getAngle());
	}
	
	public @NotNull Point toPoint() {
		return new Point(Math.cos(getAngle()) * getLength(), 
				Math.sin(getAngle()) * getLength());
	}
	
}
