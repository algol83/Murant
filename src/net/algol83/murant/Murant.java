package net.algol83.murant;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

import com.jogamp.opengl.util.FPSAnimator;

@SuppressWarnings("serial")
public final class Murant extends Frame {

	public class SimpleScene implements GLEventListener {
	    private double theta = 0;
	    private double s = 0;
	    private double c = 0;
	
	    @Override
	    public void display(GLAutoDrawable drawable) {
	        update();
	        render(drawable);
	    }

	    @Override
	    public void dispose(GLAutoDrawable drawable) {
	    }
	
	    @Override
	    public void init(GLAutoDrawable drawable) {
	    }
	
	    @Override
	    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
	    }

	    private void update() {
	        theta += 0.01;
	        s = Math.sin(theta);
	        c = Math.cos(theta);
	    }
	
	    private void render(GLAutoDrawable drawable) {
	        GL2 gl = drawable.getGL().getGL2();
	        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
	
	        // draw a triangle filling the window
	        gl.glBegin(GL.GL_TRIANGLES);
	        gl.glColor3f(1, 0, 0);
	        gl.glVertex2d(-c, -c);
	        gl.glColor3f(0, 1, 0);
	        gl.glVertex2d(0, c);
	        gl.glColor3f(0, 0, 1);
	        gl.glVertex2d(s, -s);
	        gl.glEnd();
	    }
	}

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

        canvas.addGLEventListener(new SimpleScene());
        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
    }
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Murant murant = new Murant();
		murant.setVisible(true);
	}

}
