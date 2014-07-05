package net.algol83.murant.base;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolarTest {

	@Test
	public void testBase() {
		final Point ptr = new Point(1, 1);
		assertTrue(ptr.isSame(ptr));
	}
	
	@Test
	public void testToPoint() {
		final Point ptr0 = new Point(1, 2);
		final Point ptr1 = ptr0.toPolar().toPoint();
		assertEquals(ptr0.toString(), ptr1.toString());
		assertTrue(ptr0.isSame(ptr1));
	}

}
