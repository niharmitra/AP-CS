/*
 * Summary of the program:
 * This is a resizable American Flag that scales while mantaining the correct aspect ratio
 * The colors and dimensions are all exactly taken from the official specifications
 * 
 * Usage Instructions:
 * Run the main method
 * Resize the window and the flag should automatically change in dimensions
 * 
 * The first class is Main, which simply calls the constructor and creates the frame
 * FlagFrame (extends JFrame) sets the characteristics of the JFrame
 * FlagPanel (extends JPanel) is the content, containing:
 * 	-paint() to draw the flag
 * 	-setDimensions() which corrects the aspect ratio upon resizing
 * 	-drawStripes(), drawUnion(), drawStars() and drawStar() are all
 * 	encapsulated methods to draw the various parts of the American flag
 */

public class Main {
	//Calls the FlagFrame constructor
	public static void main(String[] args) {
		FlagFrame frame = new FlagFrame();
	}
}
