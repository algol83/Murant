package net.algol83.murant;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.sun.istack.internal.NotNull;

import net.algol83.murant.things.Thing;

public class World {

	private final List<Thing> things = new LinkedList<Thing>();
	
	public void addThing(@NotNull Thing thing) {
		things.add(thing);
	}
	
	public List<Thing> getThings() {
		return Collections.unmodifiableList(things);
	}
	
}
