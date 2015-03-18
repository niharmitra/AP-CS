
/**
 * A representation of a 2 dimensional point
 * Allows you to set x,y cartesian coordinates, and find distance between two points
 */
public class MyPoint implements MyPointInterface {
	private int x;
	private int y;
	
	//Returns the x coordinate
	public int getX() {
		return x;
	}
	//Returns the y coordinate
	public int getY() {
		return y;
	}
	//Sets the x coordinate of this point
	public void setX(int x) {
		this.x = x;
	}
	//Sets the y coordinate of this point
	public void setY(int y) {
		this.y = y;
	}
	
	//Returns the distance between this point and another
	public double distance(MyPoint other) {
		return Math.sqrt(Math.pow(this.x - other.getX(), 2)
				+ Math.pow(this.y - other.getY(), 2));
	}
}
