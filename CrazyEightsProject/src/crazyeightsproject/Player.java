package crazyeightsproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in the game.
 * Encapsulates the player's hand and provides methods to interact with it.
 */
public class Player {
    private List<Card> hand;
    private String name;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    /**
     * Draws a card from the draw pile and adds it to the player's hand.
     * @param drawPile The draw pile to draw from.
     */
    public void drawCard(DrawPile drawPile) {
        hand.add(drawPile.drawCard());
    }

    /**
     * Plays a card from the player's hand and adds it to the discard pile.
     * @param card The card to be played.
     * @param discardPile The discard pile to add the card to.
     * @return True if the player's hand is empty after playing the card, indicating the player has won.
     */
    public boolean playCard(Card card, DiscardPile discardPile) {
        if (hand.contains(card)) {
            hand.remove(card);
            discardPile.addCard(card);
            return hand.isEmpty(); // Return true if the player has won
        }
        return false; // Return false if the card was not in the player's hand
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }
}