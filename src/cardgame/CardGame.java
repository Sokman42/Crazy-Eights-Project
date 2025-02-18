/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

import cardgame.CardHandGenerator;
import cardgame.Card;
import java.util.Scanner;


/**
 *
 * @author soky4
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        Card[] hand = CardHandGenerator.generateHand(7);
        
        //print each card so we can see what was generated
        for (Card card : hand) {
            System.out.println(card.getValue() + " of " + card.getSuit());
        }

        //ask user for Card
        System.out.println("Please choose a suit for your lucky card:");
        for (int i = 0; i < Card.Suit.values().length; i++) {
            System.out.println((i + 1) + ": " + Card.Suit.values()[i]);
        }
        
        int suit = input.nextInt()-1;
        System.out.println("Enter a value (1 to 13)");
        int value = input.nextInt()-1;
        //create new Card with the two values chosen
        Card userGuess = new Card(Card.Value.values()[value], Card.Suit.values()[suit]);

        //check if it matches
        boolean match = false;
        for (Card card : hand) {
            if (card.getValue() == userGuess.getValue()
                    && (card.getSuit().equals(userGuess.getSuit()))) {
                match = true;
                break;
            }
        }
        System.out.println(userGuess.getSuit() + " of " + userGuess.getValue());
        System.out.println("Did you guess it? " + match);
    }
        
}

