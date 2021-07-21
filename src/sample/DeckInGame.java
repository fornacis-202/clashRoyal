package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;

/**
 * The type Deck in game.
 */
public class DeckInGame {
    private ObservableList<Card> fullDeck;
    private ObservableList<Card> showDeck;
    private Card nextCard;

    /**
     * Instantiates a new Deck in game.
     *
     * @param fullDeck the full deck
     */
    public DeckInGame(ObservableList<Card> fullDeck){
        this.fullDeck=fullDeck;
        showDeck= FXCollections.observableArrayList();
        initialize();
    }
    private Card getRandomCard(){
        Random random = new Random();
        Card card ;
        while (true) {
            card= fullDeck.get(random.nextInt(fullDeck.size()));
            if(!showDeck.contains(card)){
                return card;
            }
        }
    }

    /**
     * Remove card.
     *
     * @param card the card
     */
    public void removeCard(Card card){
        showDeck.remove(card);
        showDeck.add(nextCard);
        nextCard=getRandomCard();

    }

    private void initialize(){
        while (showDeck.size() < 4){
            Card addingCard=getRandomCard();
            showDeck.add(addingCard);
        }
        nextCard=getRandomCard();
    }

    /**
     * Gets next card.
     *
     * @return the next card
     */
    public Card getNextCard() {
        return nextCard;
    }

    /**
     * Gets show deck.
     *
     * @return the show deck
     */
    public ObservableList<Card> getShowDeck() {
        return showDeck;
    }
}
