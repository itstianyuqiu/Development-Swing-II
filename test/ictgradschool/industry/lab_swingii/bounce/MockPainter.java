package ictgradschool.industry.lab_swingii.bounce;

import java.awt.*;
import java.util.Arrays;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging the request in a buffer. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 * 
 * @author Ian Warren
 */
public class MockPainter implements Painter {

	// Internal log.
	private StringBuffer log = new StringBuffer();

	private Color color = Color.black;

	/**
	 * Returns the contents of this MockPainter's log.
	 */
    @Override
	public String toString() {
		return log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
    @Override
	public void drawRect(int x, int y, int width, int height) {
		log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}
	
	/**
	 * Logs the drawOval call.
	 */
    @Override
	public void drawOval(int x, int y, int width, int height) {
		log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
    @Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

    @Override
    public void drawPolygon(Polygon polygon) {
        log.append("(polygon xpoints: " + Arrays.toString(polygon.xpoints) + ", ypoints: " + Arrays.toString(polygon.ypoints) + ")");
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        log.append("(filledRect " + x + "," + y + "," + width + "," + height + ")");
    }
}