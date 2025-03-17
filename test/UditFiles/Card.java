package crazyeightsproject;

import java.util.Objects;

/**
 * Represents a playing card with a suit and value.
 * Encapsulates card properties and provides methods to access them.
 */
public class Card {
    public enum Suit {
        HEARTS, CLUBS, SPADES, DIAMONDS
    }

    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private final Value value;
    private final Suit suit;

    /**
     * Constructor for Card.
     * @param value The value of the card.
     * @param suit The suit of the card.
     */
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
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
        return Objects.hash(value, suit);
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}