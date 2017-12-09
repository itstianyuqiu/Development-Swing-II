package ictgradschool.industry.lab12.bounce;

import java.awt.*;

/**
 * Implementation of the ictgradschool.industry.lab12.bounce.Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Ian Warren
 */
public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics g;

	/**
	 * Creates a ictgradschool.industry.lab12.bounce.GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this.g = g;
	}


	@Override
	public void drawRect(int x, int y, int width, int height) {
		g.drawRect(x, y, width, height);
	}


	@Override
	public void drawOval(int x, int y, int width, int height) {
		g.drawOval(x, y, width, height);
	}


	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		g.drawLine(x1, y1, x2, y2);
	}


	@Override
	public void setColor(Color color) {
		g.setColor(color);
	}


	@Override
	public Color getColor() {
		return g.getColor();
	}

    @Override
    public void drawPolygon(Polygon polygon) {
        g.drawPolygon(polygon);
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        g.fillRect(x, y, width, height);
    }
}
