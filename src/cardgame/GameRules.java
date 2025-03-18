/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;



/**Java GameRules Class
 *Crazy Eights Game
 *Group 4
 *Austin, Gowthaman, Udit
 */
public class GameRules {
    
    public static int currentPlayer = 0;
    public static int roundCount = 0;
    
    public static void playTurn(ArrayList<Player> players, DrawPile drawPile, 
                                DiscardPile discardPile, Settings settings) {
        Player player = players.get(currentPlayer);
        Scanner input = new Scanner(System.in);
        System.out.println(player.getName() + "'s hand: " + player.getHand());
        System.out.println("Top card on discard pile: " + discardPile.getTopCard());
        System.out.println("Choose a card to play or draw from the pile:");

        while (true) {
            try {
                System.out.println("Enter the index of the card to play or -1 to draw:");
                int index = input.nextInt();
                if (index == -1) {
                    if (drawPile.isEmpty()) {
                        System.out.println("Draw pile is empty. Cannot draw a card.");
                    } else {
                        player.drawCard(drawPile);
                        System.out.println(player.getName() + " drew a card: " + player.getHand().get(player.getHand().size() - 1));
                    }
                } else if (index >= 0 && index < player.getHand().size()) {
                    Card cardToPlay = player.getHand().get(index);
                    if (isValidMove(cardToPlay, discardPile.getTopCard())) {
                        boolean hasWon = player.playCard(cardToPlay, discardPile);
                        System.out.println(player.getName() + " played: " + cardToPlay);
                        System.out.println("Correct move!");
                        if (hasWon) {
                            System.out.println("Player " + player.getName() + " wins!");
                            return;
                        }
                        break;
                    } else {
                        System.out.println("Invalid move. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next(); // Clear the invalid input
            }
        }
        nextTurn(settings);
    }

    private static boolean isValidMove(Card card, Card topCard) {
        return card.getSuit() == topCard.getSuit() || card.getValue() == topCard.getValue() || card.getValue() == Card.Value.EIGHT;
    }

    private static void nextTurn(Settings settings) {
        currentPlayer = (currentPlayer + 1) % settings.getNumberOfPlayers();
    }

    public static boolean checkWinCondition(Player player) {
        return player.hasWon();
    }
}
