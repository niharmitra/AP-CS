package thinkAPJava.chp15;

/* 
 * Example code for Think Java (http://thinkapjava.com)
 *
 * Copyright(c) 2011 Allen B. Downey
 * GNU General Public License v3.0 (http://www.gnu.org/copyleft/gpl.html)
 *
 * @author Allen B. Downey
 */

import java.math.BigInteger;

public class Exercise1 {
	/*
	 * Test code.
	 */
	public static void main(String[] args) {
		// Should print Ace of Diamonds 3 times
		Card1 card = new Card1(1, 1);
		card.print();
		String s = card.toString();

		Card1 card2 = new Card1(1, 1);

		Deck1 deck = new Deck1();

		// check sortDeck
		deck.shuffle();
		deck.sort();
		checkSorted(deck);

		// check that findBisect finds each card
		int index;
		for (int i = 0; i < 52; i++) {
			index = deck.findBisect(deck.cards[i], 0, deck.cards.length - 1);
			if (index != i) {
				System.out.println("Not found!");
			}
		}

		// make a subdeck
		Deck1 hand = deck.subdeck(8, 12);
		hand.print();

		// check that findBisect doesn't find a card that's not there
		Card1 badCard = new Card1(1, 1);
		index = hand.findBisect(badCard, 0, hand.cards.length - 1);
		if (index != -1) {
			System.out.println("Found?");
		}

		// check mergeSort
		deck.shuffle();
		deck = deck.mergeSort();
		checkSorted(deck);
	}

	/*
	 * Checks that the deck is sorted.
	 */
	public static void checkSorted(Deck1 deck) {
		for (int i = 0; i < 51; i++) {
			int flag = deck.cards[i].compareTo(deck.cards[i + 1]);
			if (flag != -1) {
				System.out.println("Not sorted!");
			}
		}
	}
}

/*
 * A Card represents a playing card with rank and suit.
 */
class Card1 {
	int suit, rank;

	static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static String[] ranks = { "narf", "Ace", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "Jack", "Queen", "King" };

	/*
	 * No-argument constructor.
	 */
	public Card1() {
		this.suit = 0;
		this.rank = 0;
	}

	/*
	 * Constructor with arguments.
	 */
	public Card1(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/*
	 * Prints a card in human-readable form.
	 */
	public void print() {
		System.out.println(ranks[rank] + " of " + suits[suit]);
	}

	/*
	 * Converts a card to human-readable form.
	 */
	public String toString() {
		return ranks[rank] + " of " + suits[suit];
	}

	/*
	 * Return true if the cards are equivalent.
	 */
	public boolean equals(Card1 that) {
		return (this.suit == that.suit && this.rank == that.rank);
	}

	/*
	 * Compares two cards: returns 1 if the first card is greater -1 if the
	 * seconds card is greater, and 0 if they are the equivalent.
	 */
	public int compareTo(Card1 that) {

		// first compare the suits
		if (this.suit > that.suit)
			return 1;
		if (this.suit < that.suit)
			return -1;

		// if the suits are the same,
		// use modulus arithmetic to rotate the ranks
		// so that the Ace is greater than the King.
		// WARNING: This only works with valid ranks!
		int rank1 = (this.rank + 11) % 13;
		int rank2 = (that.rank + 11) % 13;

		// compare the rotated ranks

		if (rank1 > rank2)
			return 1;
		if (rank1 < rank2)
			return -1;
		return 0;
	}
}

/*
 * A Deck contains an array of cards.
 */
class Deck1 {
	Card1[] cards;

	/*
	 * Makes a Deck with room for n Cards (but no Cards yet).
	 */
	public Deck1(int n) {
		this.cards = new Card1[n];
	}

	/*
	 * Makes an array of 52 cards.
	 */
	public Deck1() {
		this.cards = new Card1[52];

		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				this.cards[index] = new Card1(suit, rank);
				index++;
			}
		}
	}

	/*
	 * Prints a deck of cards.
	 */
	public void print() {
		for (int i = 0; i < cards.length; i++) {
			cards[i].print();
		}
	}

	/*
	 * Returns index of the first location where card appears in deck. Or -1 if
	 * it does not appear. Uses a linear search.
	 */
	public int findCard(Card1 card) {
		for (int i = 0; i < cards.length; i++) {
			if (card.equals(cards[i])) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * Returns index of a location where card appears in deck. Or -1 if it does
	 * not appear. Uses a bisection search.
	 * 
	 * Searches from low to high, including both.
	 * 
	 * Precondition: the cards must be sorted from lowest to highest.
	 */
	public int findBisect(Card1 card, int low, int high) {
		if (high < low)
			return -1;

		int mid = (high + low) / 2;
		int comp = card.compareTo(cards[mid]);

		if (comp == 0) {
			return mid;
		} else if (comp < 0) {
			// card is less than cards[mid]; search the first half
			return findBisect(card, low, mid - 1);
		} else {
			// card is greater; search the second half
			return findBisect(card, mid + 1, high);
		}
	}

	/*
	 * Chooses a random integer between low and high, including low, not
	 * including high.
	 */
	public int randInt(int low, int high) {
		// Because Math.random can't return 1.0, and (int)
		// always rounds down, this method can't return high.
		int x = (int) (Math.random() * (high - low) + low);
		return x;
	}

	/*
	 * Swaps two cards in a deck of cards.
	 */
	public void swapCards(int i, int j) {
		Card1 temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}

	/*
	 * Shuffles the cards in a deck.
	 */
	public void shuffle() {
		for (int i = 0; i < cards.length; i++) {
			int j = randInt(i, cards.length - 1);
			swapCards(i, j);
		}
	}

	/*
	 * Sorts a deck from low to high.
	 */
	public void sort() {
		for (int i = 0; i < cards.length; i++) {
			int j = indexLowestCard(i, cards.length - 1);
			swapCards(i, j);
		}
	}

	/*
	 * Finds the index of the lowest card between low and high, including both.
	 */
	public int indexLowestCard(int low, int high) {
		int winner = low;
		for (int i = low + 1; i <= high; i++) {
			if (cards[i].compareTo(cards[winner]) < 0) {
				winner = i;
			}
		}
		return winner;
	}

	/*
	 * Makes a new deck of cards with a subset of cards from the original. The
	 * old deck and new deck share references to the same card objects.
	 */
	public Deck1 subdeck(int low, int high) {
		Deck1 sub = new Deck1(high - low + 1);

		for (int i = 0; i < sub.cards.length; i++) {
			sub.cards[i] = cards[low + i];
		}
		return sub;
	}

	/*
	 * Merges two sorted decks into a new sorted deck.
	 */
	public static Deck1 originalMerge(Deck1 d1, Deck1 d2) {
		// create the new deck
		Deck1 result = new Deck1(d1.cards.length + d2.cards.length);

		int choice; // records the winner (1 means d1, 2 means d2)
		int i = 0; // traverses the first input deck
		int j = 0; // traverses the second input deck

		// k traverses the new (merged) deck
		for (int k = 0; k < result.cards.length; k++) {
			choice = 1;

			// if d1 is empty, d2 wins; if d2 is empty, d1 wins; otherwise,
			// compare the two cards
			if (i == d1.cards.length)
				choice = 2;
			else if (j == d2.cards.length)
				choice = 1;
			else if (d1.cards[i].compareTo(d2.cards[j]) > 0)
				choice = 2;

			// make the new deck refer to the winner card
			if (choice == 1) {
				result.cards[k] = d1.cards[i];
				i++;
			} else {
				result.cards[k] = d2.cards[j];
				j++;
			}
		}
		return result;
	}

	/*
	 * Merges this deck with another one
	 */
	public Deck1 merge(Deck1 d) {
		Deck1 result = new Deck1(this.cards.length + d.cards.length);

		int choice;
		int i = 0;
		int j = 0;

		for (int k = 0; k < result.cards.length; k++) {
			choice = 1;
			if (i == this.cards.length) {
				choice = 2;
			} else if (j == d.cards.length) {
				choice = 1;
			} else if (this.cards[i].compareTo(d.cards[j]) > 0) {
				choice = 2;
			}

			if (choice == 1) {
				result.cards[k] = this.cards[i];
				i++;
			} else {
				result.cards[k] = d.cards[j];
				j++;
			}
		}

		return result;
	}

	/*
	 * Sort the Deck using merge sort.
	 */
	public Deck1 mergeSort() {
		if (cards.length < 2) {
			return this;
		}
		int mid = (cards.length - 1) / 2;

		// divide the deck roughly in half
		Deck1 d1 = subdeck(0, mid);
		Deck1 d2 = subdeck(mid + 1, cards.length - 1);

		// sort the halves
		d1 = d1.mergeSort();
		d2 = d2.mergeSort();

		// merge the two halves and return the result
		// (d1 and d2 get garbage collected)
		// return originalMerge(d1,d2);
		return d1.merge(d2);
	}
}
