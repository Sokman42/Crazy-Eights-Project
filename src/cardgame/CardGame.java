/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgame;

import java.util.ArrayList;


/**Java CardGame Class
 *Crazy Eights Game
 *Group 4
 *Austin, Gowthaman, Udit
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Initialize Game Settings, player count and player names
        Settings settings = new Settings();
        
        //Initialize new deck of 52 cards
        ArrayList<Card> deck1 = CardGenerator.generateDeck();
        
        //Initialize Player list
        ArrayList<Player> players = new ArrayList<>();
        
        //Generate hands for players, 7 cards each
        for (int i = 0; i < settings.getNumberOfPlayers(); i++) {
            ArrayList<Card> pHand = CardGenerator.generateHand(deck1);
            Player player = new Player(pHand, settings.getPlayerNames().get(i));
            players.add(player);
        }
        
        //Convert remaining deck cards into discard and draw piles
        DiscardPile discardPile = new DiscardPile(deck1);
        DrawPile drawPile = new DrawPile(deck1);
        
        //Game starts! Loop runs the rules of the game while players take turns
        //selecting cards from their hands.
        while (GameRules.roundCount < 30) {
            GameRules.playTurn(players, drawPile, discardPile, settings);
            if (GameRules.checkWinCondition(players.get(GameRules.currentPlayer))) {
                break;
            }
            GameRules.roundCount++;
        }

    }
}
