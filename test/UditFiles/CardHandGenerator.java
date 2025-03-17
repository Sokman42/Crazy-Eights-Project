package crazyeightsproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility class for generating card hands and decks.
 * Provides methods to create and shuffle decks and hands.
 */
public class CardHandGenerator {

    /**
     * Generates a shuffled deck of cards.
     * @return A list representing a shuffled deck of cards.
     */
    public static List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                deck.add(new Card(value, suit));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    /**
     * Generates a hand of cards from a shuffled deck.
     * @param numCards The number of cards in the hand.
     * @return A list representing a hand of cards.
     */
    public static List<Card> generateHand(int numCards) {
        List<Card> deck = generateDeck();
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            hand.add(deck.remove(0));
        }
        return hand;
    }
}