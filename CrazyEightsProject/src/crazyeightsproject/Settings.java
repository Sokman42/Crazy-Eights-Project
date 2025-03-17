package crazyeightsproject;

import java.util.List;

/**
 * Represents the game settings.
 * Encapsulates the number of players and their names.
 */
public class Settings {
    private int numberOfPlayers;
    private List<String> playerNames;

    public Settings(int numberOfPlayers, List<String> playerNames) {
        this.numberOfPlayers = numberOfPlayers;
        this.playerNames = playerNames;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}