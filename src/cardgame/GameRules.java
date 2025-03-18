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
        System.out.println(player.getName() + "'s hand: " + player.stringHand());
        System.out.println("Top card on discard pile: " + discardPile.getTopCard());
        System.out.println("Choose a card to play or draw from the pile:");

        while (true) {
            try {
                System.out.println("Enter the index of the card to play or -1 to draw:");
                int index = input.nextInt();
                if (index == -1) {
                    if (drawPile.isEmpty()) {
                        System.out.println("Draw pile is empty. Cannot draw a card.");
                        System.out.println("The game is over!");
                        GameRules.countHands(players);
                        break;
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
                        if (cardToPlay.getValue() == Card.Value.EIGHT) {
                            System.out.println("CRAZY 8!!! Choose a suit for the next turn: ");
                                for (int i = 0; i < Card.Suit.values().length; i++) {
                                    System.out.println((i + 1) + ": " + Card.Suit.values()[i]);
                            }
                            int newSuit = input.nextInt() - 1;
                            Card crazy = discardPile.getTopCard();
                            crazy.setSuit(Card.Suit.values()[newSuit]);
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
    
    public static void countHands(ArrayList<Player> players) {
        int smallestHand = 52;
        List<String> winner = new ArrayList<>();
        for (Player p : players) {
            if (p.getHand().size() <= smallestHand) {
                smallestHand = p.getHand().size();
            }
        }
        for (Player p : players) {
            if (p.getHand().size() == smallestHand) {
                winner.add(p.getName());
            }
        }
        if (winner.size() > 1) {
            System.out.println(winner.toString() + ", the players with the smallest hands, tie for first place!");
        }
        else {
            System.out.println(winner + ", the player with the smallest hand, is the winner!");
        }
    }

    public static boolean checkWinCondition(Player player) {
        return player.hasWon();
    }
}
