package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;

public class DeckInGame {
    private ObservableList<Card> fullDeck;
    private ObservableList<Card> showDeck;
    private Card nextCard;
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

    public Card getNextCard() {
        return nextCard;
    }

    public ObservableList<Card> getShowDeck() {
        return showDeck;
    }
}
