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

public class Exercise5 {
	public static void main(String[] args) {
		double numFlush = 0;
		double numTriple = 0;
		double numOnePair = 0;
		double numTwoPair = 0;
		double numStraight = 0;
		
		double probFlush;
		double probTriple;
		double probOnePair;
		double probTwoPair;
		double probStraight;
		
		int numTrials = 100000;
		for (int i = 0; i < numTrials; i++) {
			Deck deck = new Deck();
			deck.shuffle();
			PokerHand hand = new PokerHand(deck.deal());

			if (hand.hasFlush()) {
				numFlush += 1;
			}
			if (hand.hasThreeKind()) {
				numTriple += 1;
			}
			if(hand.hasOnePair()) {
				numOnePair+=1;
			}
			if(hand.hasTwoPair()) {
				numTwoPair+=1;
			}
			if(hand.hasStraight()) {
				numStraight+=1;
			}
		}
		
		probFlush = 100*numFlush/numTrials;
		probTriple = 100*numTriple/numTrials;
		probOnePair = 100* numOnePair / numTrials;
		probTwoPair = 100* numTwoPair/ numTrials;
		probStraight = 100* numStraight/numTrials;
		
		System.out.println("Probability of a flush is " + probFlush + "%");
		System.out.println("Probability of a three of a kind is " + probTriple + "%");
	}

	/*
	 * Checks that the deck is sorted.
	 */
	public static void checkSorted(Deck deck) {
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
class Card {
	int suit, rank;

	static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	static String[] ranks = { "narf", "Ace", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "Jack", "Queen", "King" };

	/*
	 * No-argument constructor.
	 */
	public Card() {
		this.suit = 0;
		this.rank = 0;
	}

	/*
	 * Constructor with arguments.
	 */
	public Card(int suit, int rank) {
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
	 * Prints a card in human-readable form.
	 */
	public String toString() {
		return ranks[rank] + " of " + suits[suit];
	}

	/*
	 * Return true if the cards are equivalent.
	 */
	public boolean equals(Card that) {
		return (this.suit == that.suit && this.rank == that.rank);
	}

	/*
	 * Compares two cards: returns 1 if the first card is greater -1 if the
	 * seconds card is greater, and 0 if they are the equivalent.
	 */
	public int compareTo(Card that) {

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