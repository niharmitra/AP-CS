/*
 * String
 * Collection
 * Graph
 */
public class Vocab4 {
	//Strings can be created with a string literal or the String constructor
	//Strings are a wrapper for arrays of characters
	String str = "String";
	str = new String("String");
	//Collections can hold any types of objects and have different features
	//For example, arraylists are a collection that allow duplicates
	ArrayList<String> strs = new ArrayList<String>();
	
	public static void main() {
		strs.add(str);
		strs.add(str);
	}
}
