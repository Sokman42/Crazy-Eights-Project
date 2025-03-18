/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**Java DiscardPile Class
 *Crazy Eights Game
 *Group 4
 *Austin, Gowthaman, Udit
 */
public class DiscardPile {
    private ArrayList<Card> discardPile;

    public DiscardPile(ArrayList<Card> deck) {
        Random random = new Random();
        Card c = deck.get(random.nextInt(deck.size()));
        deck.remove(c);
        ArrayList<Card> newDiscardPile = new ArrayList<>();
        newDiscardPile.add(c);
        this.discardPile = newDiscardPile;
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
