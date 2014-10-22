package practice;
/*
 * This class checks if two phrases are anagrams of each other
 */

public class Anagram {
	public static void main(String[] args) {
		System.out.println(Anagram.isAnagram("A decimal point", "Im a dot in place"));
		System.out.println(Anagram.isAnagram("Slot machines", "Cash lost in em"));
	}

	public static boolean isAnagram(String inputPhrase, String inputAnagram) {
		char[] phrase = inputPhrase.toLowerCase().trim().replaceAll("\\s", "")
				.toCharArray();
		char[] anagram = inputAnagram.toLowerCase().trim()
				.replaceAll("\\s", "").toCharArray();

		if (inputPhrase.equals(inputAnagram)) {
			System.out.println("");
			return true;
		}

		if (phrase.length != anagram.length) {
			System.out.println("Not the same length!");
			return false;
		}

		for (int i = 0; i < phrase.length; i++) {
			for (int j = 0; j < anagram.length; j++) {
				if (anagram[j] == phrase[i]) {
					// .trim() means there shouldn't be any spaces already
					anagram[j] = 0;
					break;
				}
			}
		}

		for (char u : anagram) {
			// Every character in anagram should be 0
			if (u != 0) {
				System.out.println("Unable to match:" + u);
				return false;
			}
		}
		return true;
	}
}