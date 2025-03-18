package cardgame;

import java.util.Objects;

/**Java Card Class
 *Crazy Eights Game
 *Group 4
 *Austin, Gowthaman, Udit
 */
public class Card {
    //Example using Enum
    public enum Suit {
        HEARTS, CLUBS, SPADES, DIAMONDS
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    private Value value;
    private Suit suit;

    public Card(Value v, Suit s) {
        value = v;
        suit = s;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return value == card.value && suit == card.suit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.value);
        hash = 19 * hash + Objects.hashCode(this.suit);
        return hash;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}