package net.algol83.murant.base;

public class Point {

	private static double MinDifference = 0.0001;
	
	private double x = 0;
	private double y = 0;
	
	public Point() {
	}
	
	public Point(double x, double y) {
		setX(x);
		setY(y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public Point append(Point point) {
		x += point.x;
		y += point.y;
		return this;
	}
	
	public Point negative() {
		return new Point(-x, -y);
	}
	
	public boolean isSame(Point point) {
		return Math.abs(x - point.x) < MinDifference &&
				 Math.abs(y - point.y) < MinDifference;
	}
	
	public double getLength() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public Polar toPolar() {
		return new Polar(getLength(), (float) Math.atan(y / x));
	}
	
	public String toString() {
		return String.format("<base.Point (%.3g, %.3g)>", x, y);
	}
}
