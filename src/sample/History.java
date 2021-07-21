package sample;

import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type History.
 */
public class History implements Serializable {
    private ArrayList<String> games;

    /**
     * Instantiates a new History.
     */
    public History(){
        games=new ArrayList<>();
    }

    /**
     * Add.
     *
     * @param playerName    the player name
     * @param playerStars   the player stars
     * @param opponentName  the opponent name
     * @param opponentStars the opponent stars
     */
    public void add(String playerName , String playerStars , String opponentName, String opponentStars){
        String game = "                                ";
        game +=String.format("%4s", playerStars);
        game+="      ";
        game+=String.format("%15s", playerName);
        game+="   vs   ";
        game+= String.format("%-15s", opponentName);
        game+="      ";
        game+=String.format("%-4s", opponentStars);
        games.add(game);
    }

    /**
     * Gets games.
     *
     * @return the games
     */
    public ArrayList<String> getGames() {
        return games;
    }
}
