package net.algol83.murant.base;

import com.sun.istack.internal.NotNull;

public class Point {

	private static final double MIN_DIFFERENCE = 0.0001;
	
	public static final Point EMPTY = new Point();
	
	private final double x;
	private final double y;
	
	private Point() {
		this(Double.NaN, Double.NaN);
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(@NotNull Point begin) {
		this(begin.x, begin.y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public @NotNull Point addition(@NotNull Point point) {
		return new Point(getX() + point.getX(), getY() + point.getY());
	}
	
	public @NotNull Point subtracting(@NotNull Point point) {
		return new Point(getX() - point.getX(), getY() - point.getY());
	}
	
	public @NotNull Point negative() {
		return new Point(-getX(), -getY());
	}

	public boolean isEmpty() {
		return Double.isNaN(getX()) || Double.isNaN(getY());
	}
	
	public boolean isSame(@NotNull Point point) {
		return equals(getX(), point.getX()) && equals(getY(), point.getY());
	}
	
	public double getLength() {
		return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
	}
	
	public @NotNull Polar toPolar() {
		return new Polar(getLength(), (float) Math.atan(getY() / getX()));
	}
	
	public @NotNull String toString() {
		return String.format("<base.Point (%.3g, %.3g)>", getX(), getY());
	}
	
	static public boolean equals(double x, double y) {
		return Math.abs(x - y) < MIN_DIFFERENCE;
	}
}
