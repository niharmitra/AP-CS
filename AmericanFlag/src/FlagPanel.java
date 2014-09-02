import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;

import javax.swing.*;

public class FlagPanel extends JPanel {
	private static final Dimension niceSize = new Dimension(1900, 1000);
	private int height;
	private int width;
	//Aspect ratio of the flag (width/height)
	private static double ratio = 1.9;

	//Old Glory Red
	private static final Color red = new Color(224, 22, 43);
	//Old Glory Blue
	private static final Color blue = new Color(0, 38, 100);

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
	
	//Draws the 13 red stripes of the flag
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
	
	//Draws the blue union
	private void drawUnion(Graphics g) {
		g.setColor(blue);
		int h = height;
		int w = width;

		g.fillRect(0, 0, (int) Math.round(0.76*w/ratio), (int) Math.round((h*7)/13));
	}
	
	//Draws the 50 white stars
	private void drawStars(Graphics g) {
		g.setColor(Color.WHITE);
		double h = height;

		//9 rows of stars
		for(int i=1; i<=9; i++) {
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
	}
	
	//Draws a single star centered at x,y
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
