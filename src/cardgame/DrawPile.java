/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

import java.util.ArrayList;
import java.util.Collections;

/**Java DrawPile Class
 *Crazy Eights Game
 *Group 4
 *Austin, Gowthaman, Udit
 */
public class DrawPile {
    private ArrayList<Card> drawPile;

    public DrawPile(ArrayList<Card> deck) {
        Collections.shuffle(deck);
        this.drawPile = deck;
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
