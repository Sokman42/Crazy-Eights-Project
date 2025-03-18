/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

import java.util.ArrayList;
import java.util.List;

/**Java Player Class
 *Crazy Eights Game
 *Group 4
 *Austin, Gowthaman, Udit
 */
public class Player {
    private ArrayList<Card> hand;
    private String name;

    public Player(ArrayList<Card> hand, String name) {
        this.name = name;
        this.hand = hand;
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

    public String stringHand() {
        String stringHand = "";
        for (Card c : hand) {
            stringHand += "[" + this.hand.indexOf(c) + ":" + c.toString() + "] ";
        }
        return stringHand;
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
