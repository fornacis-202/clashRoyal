package sample;

import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;

public class History implements Serializable {
    private ArrayList<String> games;
    public History(){
        games=new ArrayList<>();
    }
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

    public ArrayList<String> getGames() {
        return games;
    }
}
