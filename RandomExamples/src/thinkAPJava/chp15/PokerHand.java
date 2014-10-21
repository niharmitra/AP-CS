package thinkAPJava.chp15;

public class PokerHand extends Deck {
	public PokerHand(Deck deck) {
		cards = deck.cards;
		System.out.println(deck.cards.length);
	}
	
	public boolean hasFlush() {
		for(int i=0; i<cards.length;i++) {
			
		}
		return true;
	}
	
	public boolean hasThreeKind() {
		for(int i=0; i<cards.length-3; i++) {
			if(cards[i].equals(cards[i+1])) {
				if(cards[i+1].equals(cards[i+2])) {
					return true;
				}
			}
		}
		return false;
	}
}