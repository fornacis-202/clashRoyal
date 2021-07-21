package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * The type Robot.
 */
public abstract class Robot {
    private ArrayList<Component> enemyComponent;
    private ArrayList<Component> friendlyComponent;
    private DeckInGame deck;
    private Model model;

    /**
     * Instantiates a new Robot.
     *
     * @param enemyComponent    the enemy component
     * @param friendlyComponent the friendly component
     * @param deck              the deck
     * @param model             the model
     */
    public Robot(ArrayList<Component> enemyComponent,ArrayList<Component> friendlyComponent,DeckInGame deck , Model model){
        this.deck=deck;
        this.enemyComponent=enemyComponent;
        this.friendlyComponent=friendlyComponent;
        this.model=model;
    }

    /**
     * Move.
     */
    public abstract void move();


    /**
     * Gets enemy component.
     *
     * @return the enemy component
     */
    public ArrayList<Component> getEnemyComponent() {
        return enemyComponent;
    }

    /**
     * Gets friendly component.
     *
     * @return the friendly component
     */
    public ArrayList<Component> getFriendlyComponent() {
        return friendlyComponent;
    }

    /**
     * Gets deck.
     *
     * @return the deck
     */
    public DeckInGame getDeck() {
        return deck;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public Model getModel() {
        return model;
    }
}
