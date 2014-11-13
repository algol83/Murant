package net.algol83.murant;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

import net.algol83.murant.base.Point;
import net.algol83.murant.base.Vector;
import net.algol83.murant.things.Thing;

import com.sun.istack.internal.NotNull;

public class WorldScene  implements GLEventListener {
	
	private static final int NUM_VERTICES = 30;
	private static final double ANGLE_INCREMENT = 2.0 * Math.PI / NUM_VERTICES;
	
	private final Logger logger = Logger.getLogger("Scene");
	
	private final @NotNull World world;
	private @NotNull Point position = new Point(0, 0);
	
	private double aspect = 1.0;
	private double zoom = 1.0;
	
    public WorldScene(@NotNull World world) {
    	this.world = world;
    }
    
    @Override
    public void display(GLAutoDrawable drawable) {
    	/*logger.log(Level.INFO, "display");*/
    	
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        final List<Thing> things = world.getThings();
        for (Thing thing : things) {
        	drawThing(gl, thing);
        }
    }

	@Override
    public void dispose(GLAutoDrawable drawable) {
    	logger.log(Level.INFO, "dispose");
    }

    @Override
    public void init(GLAutoDrawable drawable) {
    	logger.log(Level.INFO, "init");
    	
    	final GL2 gl = drawable.getGL().getGL2();
    	gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    	/*logger.log(Level.INFO, 
    			String.format("reshape: %d %d %d %d", x, y, w, h));*/
    	
    	final GL2 gl = drawable.getGL().getGL2();
        gl.glViewport(0, 0, w, h);
        
        setAspect((double) w / (double) h);
    }
    
    private @NotNull Point toDrawPoint(@NotNull Point point) {
    	final Point bufPoint = point.subtracting(getPosition());
    	if (getAspect() >= 1.0)
    		return new Point(bufPoint.getX() * getZoom() / getAspect(),
    				bufPoint.getY() * getZoom());
    	else 
    		return new Point(bufPoint.getX() * getZoom(),
    				bufPoint.getY() * getZoom() * getAspect());
    }
    
    public boolean isVisibleThing(@NotNull Thing thing) {
    	final Point drawPosition = toDrawPoint(thing.getPosition());
    	final double distance = new Vector(drawPosition, new Point(0.0, 0.0)).getLength();
    	return distance < new Point(1.0, 1.0).getLength() + thing.getRadius() * getZoom();
    }

    private void drawThing(GL2 gl, @NotNull Thing thing) {
    	if (!isVisibleThing(thing))
    		return;
    	
        final double radius = thing.getRadius();
        final Point drawPosition = toDrawPoint(thing.getPosition());
    	
        gl.glTranslated(drawPosition.getX(), drawPosition.getY(), 0.0);
        gl.glBegin(GL2.GL_LINE_LOOP);
    	gl.glColor3f(0.0f, 0.0f, 0.0f);
        for(int i = 0; i < NUM_VERTICES; i++) {
        	final double angle = i * ANGLE_INCREMENT;
        	final Point drawPoint = toDrawPoint(
        			new Point(radius * Math.cos(angle), radius * Math.sin(angle)));
        	gl.glVertex2d(drawPoint.getX(), drawPoint.getY());
        }
        gl.glEnd();
	}
    
    public void setZoom(double zoom) {
    	if (zoom <= 0.0)
    		throw new IllegalArgumentException();
    	this.zoom = zoom;
    }
    
    public double getZoom() {
    	return zoom;
    }

    private void setAspect(double aspect) {
    	if (aspect <= 0.0)
    		throw new IllegalArgumentException();
    	this.aspect = aspect;
    }
    
    public double getAspect() {
    	return aspect;
    }
    
    public void setPosition(@NotNull Point position) {
    	if (position.isEmpty())
    		throw new IllegalArgumentException();
    	this.position = position;
    }
    
    public Point getPosition() {
    	return position;
    }
    
}
