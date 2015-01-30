/*
 * String
 * Collection
 * Graph
 */
 /*
  * Note that this code doesn't compile
  * Because I haven't actually included an implementation of BST
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
		//A graph is composed of nodes (elements) and edges (the connections between nodes)
		//For example, if you had a BST
		BST graph = new BST();
		//If you could confirm that an edge exists between two nodes in a BST, this would tell you
		//That one is less than the other.
	}
}
