package thinkAPJava.chp15;

/*
 * A Deck contains an array of cards.
 */
class Deck {
	Card[] cards;

	/*
	 * Makes a Deck with room for n Cards (but no Cards yet).
	 */
	public Deck(int n) {
		this.cards = new Card[n];
	}

	/*
	 * Makes an array of 52 cards.
	 */
	public Deck() {
		this.cards = new Card[52];

		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				this.cards[index] = new Card(suit, rank);
				index++;
			}
		}
	}
	
	public PokerHand deal() {
		PokerHand hand = new PokerHand(subdeck(0,4));
		Deck leftover = subdeck(5, cards.length-1);
		this.cards = leftover.cards;
		return hand;
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
	public int findCard(Card card) {
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
	public int findBisect(Card card, int low, int high) {
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
		Card temp = cards[i];
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
	public Deck subdeck(int low, int high) {
		Deck sub = new Deck(high - low + 1);

		for (int i = 0; i < sub.cards.length; i++) {
			sub.cards[i] = cards[low + i];
		}
		return sub;
	}

	/*
	 * Merges two sorted decks into a new sorted deck.
	 */
	public static Deck merge(Deck d1, Deck d2) {
		// create the new deck
		Deck result = new Deck(d1.cards.length + d2.cards.length);

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
	 * Sort the Deck using merge sort.
	 */
	public Deck mergeSort() {
		if (cards.length < 2) {
			return this;
		}
		int mid = (cards.length - 1) / 2;

		// divide the deck roughly in half
		Deck d1 = subdeck(0, mid);
		Deck d2 = subdeck(mid + 1, cards.length - 1);

		// sort the halves
		d1 = d1.mergeSort();
		d2 = d2.mergeSort();

		// merge the two halves and return the result
		// (d1 and d2 get garbage collected)
		return merge(d1, d2);
	}
}