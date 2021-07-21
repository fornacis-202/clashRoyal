package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public abstract class Robot {
    private ArrayList<Component> enemyComponent;
    private ArrayList<Component> friendlyComponent;
    private DeckInGame deck;
    private Model model;
    public Robot(ArrayList<Component> enemyComponent,ArrayList<Component> friendlyComponent,DeckInGame deck , Model model){
        this.deck=deck;
        this.enemyComponent=enemyComponent;
        this.friendlyComponent=friendlyComponent;
        this.model=model;
    }

    public abstract void move();


    public ArrayList<Component> getEnemyComponent() {
        return enemyComponent;
    }

    public ArrayList<Component> getFriendlyComponent() {
        return friendlyComponent;
    }

    public DeckInGame getDeck() {
        return deck;
    }

    public Model getModel() {
        return model;
    }
}
