package ictgradschool.industry.lab_swingii.bounce;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


/**
 * Simple GUI program to show an animation of shapes. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * AnimationViewer can be added to a JFrame object. A JFrame object is a
 * window that can be closed, minimised, and maximised. The state of a
 * AnimationViewer object comprises a list of Shapes and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates
 * through a list of Shapes requesting that each Shape paints and moves itself.
 * 
 * @author Ian Warren
 */
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds to generate ActionEvents.
	private final int DELAY = 20;

	// Collection of Shapes to animate.
	private List<Shape> shapes;

	private Timer timer = new Timer(DELAY, this);

	/**
	 * Creates an AnimationViewer instance with a list of Shape objects and
	 * starts the animation.
	 */
	public AnimationViewer() {
		shapes = new ArrayList<Shape>();
	
		// Populate the list of Shapes.
		shapes.add(new RectangleShape(0, 0, 2, 3));
		shapes.add(new RectangleShape(10, 10, 5, 7));

		// TODO Add your own shapes here, once you've made them!

		// Start the animation.
		timer.start();
	}

	/**
	 * Called by the Swing framework whenever this AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this AnimationViewer
	 * object has been exposed after being hidden by another window. 
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);


		// Create a GraphicsPainter that Shape objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		ictgradschool.industry.lab_swingii.bounce.Painter painter = new GraphicsPainter(g);
		
		// Draw all shapes
		for(Shape s : shapes) {
			s.paint(painter);
		}
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent.
	 */
	public void actionPerformed(ActionEvent e) {

        // Calculate bounds of animation screen area.
        int width = getWidth();
        int height = getHeight();

        // Move all shapes
        for(Shape s : shapes) {
            s.move(width, height);
        }

        // Request that the AnimationViewer repaints itself. The call to
        // repaint() will cause the AnimationViewer's paintComponent() to be
        // called.
		repaint();
	}
	
	/**
	 * Main program method to create an AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Animation viewer");
                frame.add(new AnimationViewer());

                // Set window properties.
                frame.setSize(500, 500);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
	}
}
