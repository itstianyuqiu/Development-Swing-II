package ictgradschool.industry.lab12.bounce;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


/**
 * Simple GUI program to show an animation of shapes. Class ictgradschool.industry.lab12.bounce.AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * ictgradschool.industry.lab12.bounce.AnimationViewer can be added to a JFrame object. A JFrame object is a
 * window that can be closed, minimised, and maximised. The state of a
 * ictgradschool.industry.lab12.bounce.AnimationViewer object comprises a list of Shapes and a Timer object. An
 * ictgradschool.industry.lab12.bounce.AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the ictgradschool.industry.lab12.bounce.AnimationViewer iterates
 * through a list of Shapes requesting that each ictgradschool.industry.lab12.bounce.Shape paints and moves itself.
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
	 * Creates an ictgradschool.industry.lab12.bounce.AnimationViewer instance with a list of ictgradschool.industry.lab12.bounce.Shape objects and
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
	 * Called by the Swing framework whenever this ictgradschool.industry.lab12.bounce.AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this ictgradschool.industry.lab12.bounce.AnimationViewer
	 * object has been exposed after being hidden by another window. 
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);


		// Create a ictgradschool.industry.lab12.bounce.GraphicsPainter that ictgradschool.industry.lab12.bounce.Shape objects will use for drawing.
		// The ictgradschool.industry.lab12.bounce.GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		
		// Draw all shapes
		for(Shape s : shapes) {
			s.paint(painter);
		}
	}

	/**
	 * Notifies this ictgradschool.industry.lab12.bounce.AnimationViewer object of an ActionEvent.
	 */
	public void actionPerformed(ActionEvent e) {

        // Calculate bounds of animation screen area.
        int width = getWidth();
        int height = getHeight();

        // Move all shapes
        for(Shape s : shapes) {
            s.move(width, height);
        }

        // Request that the ictgradschool.industry.lab12.bounce.AnimationViewer repaints itself. The call to
        // repaint() will cause the ictgradschool.industry.lab12.bounce.AnimationViewer's paintComponent() to be
        // called.
		repaint();
	}
	
	/**
	 * Main program method to create an ictgradschool.industry.lab12.bounce.AnimationViewer object and display this
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
