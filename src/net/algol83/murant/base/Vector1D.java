package net.algol83.murant.base;

import com.sun.istack.internal.NotNull;

public class Vector1D {

	public static final Vector1D EMPTY = new Vector1D();
	
	private final double begin;
	private final double end;
	
	private Vector1D() {
		this(Double.NaN, Double.NaN);
	}
	
	public Vector1D(@NotNull Vector1D vector) {
		this(vector.getBegin(), vector.getEnd());
	}
	
	public Vector1D(double begin, double end) {
		this.begin = begin;
		this.end = end;
	}

	public double getBegin() {
		return begin;
	}
	
	public double getEnd() {
		return end;
	}

	public boolean isNormalized() {
		return !(getBegin() > getEnd());
	}
	
	public @NotNull Vector1D normalize() {
		return isNormalized() ? this : new Vector1D(getEnd(), getBegin());
	}
	
	public double getLength() {
		return Math.abs(getBegin() - getEnd());
	}
		
	public double getCross(@NotNull Vector1D obj) {
		final Vector1D nthis = normalize();
		final Vector1D nobj = obj.normalize();
		final double begin = Math.max(nthis.getBegin(), nobj.getBegin());
		final double end = Math.max(nthis.getEnd(), nobj.getEnd());
		if (begin > end)
			return Double.NaN;
		return (begin + end) / 2;
	}
	
	public boolean isCross(@NotNull Vector1D obj) {
		return Double.isNaN(getCross(obj));
	}
	
	
}
