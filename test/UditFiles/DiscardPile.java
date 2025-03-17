package crazyeightsproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the discard pile in the game.
 * Encapsulates the pile and provides methods to interact with it.
 */
public class DiscardPile {
    private List<Card> discardPile;

    public DiscardPile() {
        discardPile = new ArrayList<>();
    }

    /**
     * Adds a card to the discard pile.
     * @param card The card to be added.
     */
    public void addCard(Card card) {
        discardPile.add(card);
    }

    /**
     * Retrieves the top card from the discard pile.
     * @return The top card on the discard pile.
     */
    public Card getTopCard() {
        return discardPile.get(discardPile.size() - 1);
    }
}