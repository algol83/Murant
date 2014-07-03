package net.algol83.murant.base;

public class Point {

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
	
}
