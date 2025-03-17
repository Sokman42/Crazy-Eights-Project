package crazyeightsproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for the Crazy Eights game.
 * Handles game initialization and user interaction.
 * Encapsulates game state and logic.
 */
public class CardGame {
    private DrawPile drawPile;
    private DiscardPile discardPile;
    private List<Player> players;
    private Settings settings;
    private int currentPlayer;
    private int roundCount;

    public CardGame(Settings settings) {
        this.settings = settings;
        drawPile = new DrawPile();
        discardPile = new DiscardPile();
        players = new ArrayList<>();
        for (String playerName : settings.getPlayerNames()) {
            Player player = new Player(playerName);
            for (int i = 0; i < 7; i++) { // Assuming each player starts with 7 cards
                player.drawCard(drawPile);
            }
            players.add(player);
        }
        discardPile.addCard(drawPile.drawCard()); // Start with one card in discard pile
        currentPlayer = 0;
        roundCount = 0;
    }

    public void playTurn() {
        Player player = players.get(currentPlayer);
        Scanner input = new Scanner(System.in);
        System.out.println("Your hand: " + player.getHand());
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
                        System.out.println("You drew a card: " + player.getHand().get(player.getHand().size() - 1));
                    }
                } else if (index >= 0 && index < player.getHand().size()) {
                    Card cardToPlay = player.getHand().get(index);
                    if (isValidMove(cardToPlay, discardPile.getTopCard())) {
                        boolean hasWon = player.playCard(cardToPlay, discardPile);
                        System.out.println("You played: " + cardToPlay);
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
        nextTurn();
    }

    private boolean isValidMove(Card card, Card topCard) {
        return card.getSuit() == topCard.getSuit() || card.getValue() == topCard.getValue() || card.getValue() == Card.Value.EIGHT;
    }

    private void nextTurn() {
        currentPlayer = (currentPlayer + 1) % settings.getNumberOfPlayers();
    }

    public boolean checkWinCondition(Player player) {
        return player.hasWon();
    }

    public void calculateScores() {
        for (Player player : players) {
            int score = calculateHandScore(player.getHand());
            System.out.println(player.getName() + " score: " + score);
        }
    }

    private int calculateHandScore(List<Card> hand) {
        int score = 0;
        for (Card card : hand) {
            score += card.getValue().ordinal() + 1; // Example scoring logic
        }
        return score;
    }

    public static void main(String[] args) {
        List<String> playerNames = List.of("Alice", "Bob", "Charlie", "Dave");
        Settings settings = new Settings(4, playerNames);
        CardGame game = new CardGame(settings);

        while (game.roundCount < 4) {
            game.playTurn();
            if (game.checkWinCondition(game.players.get(game.currentPlayer))) {
                break;
            }
            game.roundCount++;
        }
        game.calculateScores();
    }
}