package cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**Java CardGenerator Class
 *Crazy Eights Game
 *Group 4
 *Austin, Gowthaman, Udit
 */
public class CardGenerator {
    
    //Code to generate a full 52 card deck with all unique cards.
    public static ArrayList<Card> generateDeck() {
        ArrayList<Card> deck = new ArrayList();

        int deckCount = 0;
        int numValues = Card.Value.values().length;
        int numSuits = Card.Suit.values().length;

        for (int i = 0; i < numSuits; i++) {
            for (int j = 0; j < numValues; j++) {
                Card.Value value = Card.Value.values()[j];
                Card.Suit suit = Card.Suit.values()[i];

                Card card = new Card(value,suit);
                deck.add(deckCount, card);
                deckCount++;
            }
        }
        return deck;
    }
    
    //Code to take cards from the deck and distribute them randomly into player hands
    public static ArrayList<Card> generateHand(ArrayList<Card> deck) {
        ArrayList<Card> hand = new ArrayList();
        int startingHandLength = 7;
        Random random = new Random();

        for(int i = 0 ; i < startingHandLength; i++)
        {
            Card c = deck.get(random.nextInt(deck.size()));
            deck.remove(c);
            hand.add(c);//put card into hand
        }
        return hand;
    }

    
}
