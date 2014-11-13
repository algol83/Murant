package net.algol83.murant;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

import net.algol83.murant.base.Point;
import net.algol83.murant.things.AnimalThing;
import net.algol83.murant.things.Thing;

import com.jogamp.opengl.util.FPSAnimator;

@SuppressWarnings("serial")
public final class Murant extends Frame {

	private final World world = new World();
	private final WorldScene scene = new WorldScene(world);
	
	public Murant() {
        super("Murant");

		GLProfile glp = GLProfile.getDefault();
	    GLCapabilities caps = new GLCapabilities(glp);
	    GLCanvas canvas = new GLCanvas(caps);
	    
	    caps.setDoubleBuffered(true);
	    caps.setHardwareAccelerated(true);
	    
        setSize(600, 600);
        setLocation(40, 40);
        add(canvas);

        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addGLEventListener(scene);
        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
    }
	
	public static void main(String[] args) {		
		final Murant murant = new Murant();
		
		Thing thing;
		
		thing = new AnimalThing();
		thing.setRadius(0.2);
		thing.setPosition(new Point(0.1, 0.1));
		murant.world.addThing(thing);
		
		thing = new AnimalThing();
		thing.setRadius(0.3);
		thing.setPosition(new Point(-0.1, -0.1));
		murant.world.addThing(thing);
		
		murant.setVisible(true);
	}

}
