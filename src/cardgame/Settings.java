/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**Java Settings Class
 *Crazy Eights Game
 *Group 4
 *Austin, Gowthaman, Udit
 */
public class Settings {
    private int numberOfPlayers;
    private List<String> playerNames;

    public Settings() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to Crazy Eights! Prepare to get crazy!");
        System.out.println("Start by entering the number of players (2-4):");
        this.numberOfPlayers = scn.nextInt();
        this.playerNames = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter Player Name: ");
            String name = scn.next();
            this.playerNames.add(name);
        }
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
