package crazyeightsproject;

import java.util.List;

/**
 * Represents the draw pile in the game.
 * Encapsulates the pile and provides methods to interact with it.
 */
public class DrawPile {
    private List<Card> drawPile;

    public DrawPile() {
        drawPile = CardHandGenerator.generateDeck();
    }

    /**
     * Draws a card from the draw pile.
     * @return The drawn card.
     */
    public Card drawCard() {
        return drawPile.remove(0);
    }

    /**
     * Checks if the draw pile is empty.
     * @return True if the draw pile is empty, false otherwise.
     */
    public boolean isEmpty() {
        return drawPile.isEmpty();
    }
}