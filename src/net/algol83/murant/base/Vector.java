package net.algol83.murant.base;

public class Vector {

	private Point begin = new Point();
	private Point end = new Point();
	
	public Vector() {
	}
	
	public Vector(Vector vector) {
		setBegin(new Point(vector.getBegin()));
		setEnd(new Point(vector.getEnd()));
	}
	
	public Vector(Point begin, Point end) {
		setBegin(begin);
		setEnd(end);
	}
	
	public Vector(Point begin, Polar polar) {
		setBegin(begin);
		setEnd(begin);
		end.addition(polar.toPoint());
	}

	public Point getBegin() {
		return begin;
	}
	
	public void setBegin(Point begin) {
		if (begin == null)
			throw new NullPointerException();
		this.begin = begin;
	}
	
	public Point getEnd() {
		return end;
	}
	
	public void setEnd(Point end) {
		if (end == null)
			throw new NullPointerException();
		this.end = end;
	}
	
	public double getLength() {
		return new Point(begin).subtracting(end).getLength();
	}
	
}
