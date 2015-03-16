
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
	//
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	//Returns the distance between two points
	public double distance(MyPoint other) {
		return Math.sqrt(Math.pow(this.x - other.getX(), 2)
				+ Math.pow(this.y - other.getY(), 2));
	}
}
