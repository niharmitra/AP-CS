import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;

import javax.swing.*;

public class FlagPanel extends JPanel {
	//Default dimension of the flag
	private static final Dimension niceSize = new Dimension(1900, 1000);
	//Height and Width of the actual flag
	private int height;
	private int width;
	//Aspect ratio of the flag (width/height)
	private static double ratio = 1.9;

	//Old Glory Red
	private static final Color red = new Color(224, 22, 43);
	//Old Glory Blue
	private static final Color blue = new Color(0, 38, 100);

	//Sets the default size of the flag, then paints it.
	public FlagPanel() {
		this.setPreferredSize(niceSize);
		repaint();
		setDimensions();
	}
	
	@Override
	//Sets dimensions of the flag to draw, then draw the components of the flag
	public void paint(Graphics g) {
		setDimensions();
		drawStripes(g);
		drawUnion(g);
		drawStars(g);
	}
	
	//Finds what the height and width of the flag should be and sets instance variable values
	private void setDimensions() {
		//Find what the screen has been resized to
		//Find which dimension is "smaller" and use that for bounds
		if(this.getHeight()*ratio < this.getWidth()) {
			height = (int) Math.round(this.getHeight());
			width = (int) Math.round(this.getHeight()*ratio);
		}
		else {
			height = (int) Math.round(this.getWidth()/ratio);
			width = (int) Math.round(this.getWidth());
		}
	}
	
	//drawStripes() takes the parameter Graphics (g)
	//Using Graphics, it draws the red stripes of the flag
	//The white background means that those "stripes" don't need to be drawn
	private void drawStripes(Graphics g) {
		g.setColor(red);
		int h = height;
		int w = width;
		for(int i=0; i<13; i++) {
			if(i%2 == 0) {
				g.fillRect(0, h*i/13, w, h/13);
			}
		}
	}
	
	//drawUnion() takes Graphics (g) as the parameter
	//Using g.fillRect(), it draws the blue union (the blue rectangle in the upper-left)
	private void drawUnion(Graphics g) {
		g.setColor(blue);
		int h = height;
		int w = width;

		g.fillRect(0, 0, (int) Math.round(0.76*w/ratio), (int) Math.round((h*7)/13));
	}
	
	//drawStars() takes Graphics (g) as the parameter
	//It calls drawStar() for every x,y that is needed
	private void drawStars(Graphics g) {
		g.setColor(Color.WHITE);
		double h = height;

		//9 rows of stars
		for(int i=1; i<=9; i++) {
			drawRowOfStars(i, h, g);
		}
	}
	
	private void drawRowOfStars(int i, double h, Graphics g) {
		//11 stars per row, but only see...
		for(int j=1; j<=11; j++) {
			//...every other star
			if(j%2 == i%2) {
				//Spacing between stars (Horizontally and vertically from center to center
				double starHorizontalSpacing = 0.063*h;
				double starVerticalSpacing = 0.054*h;
				double x = j*starHorizontalSpacing;
				double y = i*starVerticalSpacing;
				drawStar(g, x, y);
			}
		}
	}
	
	//Takes Graphics (g), double x (x coordinate) and double y (y coordinate)
	//Draws a 5 pointed star centered at x,y using g.fillPolygon()
	private void drawStar(Graphics g, double x, double y) {
		//Ratio of diameter to height of the flag
		double diameterRatio = 0.0616;
		//Outer radius of the star
		double radius = diameterRatio* 0.5 * height;
		//72 degrees in radians
		double starAngle = Math.PI/5;
		
		//Stores the points of the star
		int[] polyX = new int[10];
		int[] polyY = new int[10];

		//Find the points of the star
		for(int k=0; k<10; k++) {
			if(k%2==0) {
				//Multiply the radius by m to make sure you get the inner points and straight edges
				double innerRadiusRatio = 0.39;
				polyX[k] = (int) Math.round(innerRadiusRatio*radius*Math.sin(k*starAngle) + x);
				polyY[k] = (int) Math.round(innerRadiusRatio*radius*Math.cos(k*starAngle) + y);
			}
			else {
				polyX[k] = (int) Math.round(radius*Math.sin(k*starAngle) + x);
				polyY[k] = (int) Math.round(radius*Math.cos(k*starAngle) + y);
			}
		}
		g.fillPolygon(polyX, polyY, 10);
	}
}
