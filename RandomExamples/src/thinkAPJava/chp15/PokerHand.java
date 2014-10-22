package thinkAPJava.chp15;

public class PokerHand extends Deck {
	public PokerHand(Deck deck) {
		cards = deck.cards;
		this.sort();
	}

	public boolean hasFlush() {
		int suit = cards[0].suit;
		// Check if the cards have the same suit
		for (int i = 1; i < cards.length; i++) {
			if (suit != cards[i].suit) {
				return false;
			}
		}
		return true;
	}

	public boolean hasThreeKind() {
		// Check if consecutive 3 are the same rank
		for (int i = 0; i < cards.length - 2; i++) {
			if (cards[i].rank == cards[i + 1].rank) {
				if (cards[i].rank == cards[i + 2].rank) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hasOnePair() {
		// Check if consecutive have same rank
		for (int i = 0; i < cards.length - 2; i++) {
			if (cards[i].rank == cards[i + 1].rank) {
				return true;
			}
		}
		return false;
	}

	public boolean hasTwoPair() {
		if (!hasOnePair()) {
			return false;
		} else {
			int rank1 = 0;
			// Check if there are two distinct pairs
			for (int i = 0; i < cards.length - 2; i++) {
				if (rank1 == 0 && cards[i].rank == cards[i + 1].rank) {
					rank1 = cards[i].rank;
				}
				if (cards[i].rank == cards[i + 1].rank
						&& cards[i].rank != rank1) {
					return true;
				}

			}
			return false;
		}
	}

	public boolean hasStraight() {
		// Check that rank is sequential
		for (int i = 0; i < 4; i++) {
			if (cards[i].rank != cards[i + 1].rank - 1) {
				return false;
			}
		}
		int suit = cards[0].suit;
		// Check for variation in suits
		for (int i = 0; i < 5; i++) {
			if (cards[i].suit != suit) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasFullHouse() {
		int rank1 = cards[0].rank;
		int rank2 = cards[3].rank;
		for(int i=0; i<3; i++) {
			if(cards[i].rank != rank1) {
				return false;
			}
		}
		for(int i=3; i<5; i++) {
			if(cards[i].rank != rank2) {
				return false;
			}
		}
		return true;
	}

	@Override
	// Sorts by rank not suit
	public void sort() {
		boolean sorted = false;
		while (!sorted) {
			for (int i = 0; i < cards.length-1; i++) {
				if (cards[i].rank > cards[i + 1].rank) {
					this.swapCards(i, i + 1);
					sorted = false;
				}
			}
			sorted = true;
		}
	}
}