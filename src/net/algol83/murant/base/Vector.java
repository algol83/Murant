package net.algol83.murant.base;

import com.sun.istack.internal.NotNull;

public class Vector {

	public static final Vector EMPTY = new Vector();
	
	private final Point begin;
	private final Point end;
	
	private Vector() {
		this(Point.EMPTY, Point.EMPTY);
	}
	
	public Vector(@NotNull Vector vector) {
		this(vector.getBegin(), vector.getEnd());
	}
	
	public Vector(@NotNull Point begin, @NotNull Point end) {
		this.begin = begin;
		this.end = end;
	}
	
	public Vector(@NotNull Point begin, @NotNull Polar polar) {
		this(begin, begin.addition(polar.toPoint()));
	}

	public @NotNull Point getBegin() {
		return begin;
	}
	
	public @NotNull Point getEnd() {
		return end;
	}

	public boolean isEmpty() {
		return getBegin().isEmpty() || getEnd().isEmpty();
	}
	
	public boolean isNormalized() {
		return !(getBegin().getX() > getEnd().getX());
	}

	public @NotNull Vector normalize() {
		return isNormalized() ? this : new Vector(getEnd(), getBegin());
	}
	
	public double getLength() {
		return getBegin().subtracting(getEnd()).getLength();
	}
	
	public @NotNull Point getCross(@NotNull Vector obj) {
		final double thisK = getK();
		final double thisC = getC();
		final double objK = obj.getK(); 
		final double objC = obj.getC();
		if (Point.equals(thisK, objK)) {
			if (Point.equals(thisC, objC)) {
				final double crossX = new Vector1D(getBegin().getX(), getEnd().getX()).getCross(
						new Vector1D(obj.getBegin().getX(), obj.getEnd().getX()));
				if (Double.isNaN(crossX))
					return Point.EMPTY;
				return new Point(crossX, thisK * crossX + thisC);
			} else {
				return Point.EMPTY;
			}
		}
		
		final double crossX = (objC - thisC) / (thisK - objK);
		final Vector1D crossXVector = new Vector1D(crossX, crossX);
		if (crossXVector.isCross(new Vector1D(getBegin().getX(), getEnd().getX())) &&
				crossXVector.isCross(new Vector1D(obj.getBegin().getX(), obj.getEnd().getX()))) {
			return new Point(crossX, thisK * crossX + thisC);
		}
		return Point.EMPTY;
	}
	
	public boolean isCross(@NotNull Vector obj) {
		return getCross(obj) == Point.EMPTY;
	}
	
	public double getK() {
		return (getBegin().getY() - getEnd().getY()) / 
				(getBegin().getX() - getEnd().getX());
	}
	
	public double getC() {
		return getBegin().getY() - getK() * getBegin().getX();
	}
	
}
