package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

/**
 * The type Account.
 */
public class Account implements Serializable {
    private String name;
    private int XP;
    private int level;
    private ArrayList<Card> deckToSave;
    private transient ObservableList<Card> deck ;
    private History history;

    /**
     * Instantiates a new Account.
     *
     * @param name the name
     */
    public Account(String name){
        this.name=name;
        deckToSave=new ArrayList<>();
        deck = FXCollections.observableArrayList();
        level=1;
        XP=0;
        history=new History();
    }

    /**
     * Add a card to deck.
     *
     * @param card the card
     */
    public void addDeck(Card card){
        if(deck.size()<8){
            deck.add(card);
            saveAccount();
        }
    }

    /**
     * Remove card from deck.
     *
     * @param card the card
     */
    public void removeDeck(Card card){
        deck.remove(card);
        saveAccount();
    }
    private void calculateLevel(){
        if(XP<400)
            level=1;
        else if( XP<900)
            level=2;
        else if(XP<1700)
            level=3;
        else if(XP<2500)
            level=4;
        else
            level=5;

    }

    /**
     * Add xp.
     *
     * @param addAmount the add amount
     */
    public void addXP(int addAmount){
        XP+=addAmount;
        calculateLevel();
    }

    /**
     * Save account.
     */
    public void saveAccount(){
        try {
            putInSimpleArray();
            File file = new File(name);
            FileOutputStream fileOutputStream = new FileOutputStream(file) ;
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();



        } catch (IOException e) {
            System.out.println("could not save file");
            e.printStackTrace();
        }
    }

    /**
     * Load account account.
     *
     * @param name the name
     * @return the account
     */
    public static Account loadAccount(String name){
        try {

            FileInputStream fileInputStream = new FileInputStream(name);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Account account = (Account) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            account.initializeDeck();
            return account;

        }
        catch (IOException | ClassNotFoundException e){
            return null;
        }
    }
    private void putInSimpleArray(){
        deckToSave=new ArrayList<>();
        deckToSave.addAll(deck);
    }

    /**
     * Initialize deck.
     */
    public void initializeDeck(){
        deck=FXCollections.observableArrayList();
        deck.addAll(deckToSave);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets history.
     *
     * @return the history
     */
    public History getHistory() {
        return history;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        calculateLevel();
        return level;
    }

    /**
     * Gets xp.
     *
     * @return the xp
     */
    public int getXP() {
        return XP;
    }

    /**
     * Gets deck.
     *
     * @return the deck
     */
    public ObservableList<Card> getDeck() {
        return deck;
    }

}
