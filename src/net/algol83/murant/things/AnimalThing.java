package net.algol83.murant.things;

import com.sun.istack.internal.NotNull;

import net.algol83.murant.base.Path;

public class AnimalThing extends Thing {

	private final Path path = new Path();
	
	public @NotNull Path getPath() {
		return path;
	}
	
}
