
public class CommonPrefix {
	public static void main(String[] args) {
		System.out.println(commonPrefix("Hello", "Help"));
	}
	
	//Returns the common prefix of two strings
	public static String commonPrefix(String a, String b) {
		String ret = "";
		//Uses the conditional operator to find the shorter string length
		int length = (a.length() < b.length()) ? a.length() : b.length();
		//Iterate through all the characters
		for(int i=0; i<=length; i++) {
		//If the first i+1 characters match, return value is that substring
			if(a.substring(0, i).equals(b.substring(0, i))) {
				ret = a.substring(0, i);
			}
		}
		return ret;
	}
}
