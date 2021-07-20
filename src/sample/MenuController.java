package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class MenuController {
    private Account account;
    private final ObservableList<Card> notDeckCards = FXCollections.observableArrayList();

    @FXML
    private ListView<Card> deckListView;

    @FXML
    private ListView<Card> notDeckListView;

    @FXML
    private ListView<String> historyListView;

    @FXML
    private Label nameLabel;

    @FXML
    private Label levelLabel;

    @FXML
    private Label XPLabel;

    @FXML
    private ListView<Card> deckListViewProfile;

    public void initialize(){
        account= SharedData.getAccount();
        deckListView.setItems(account.getDeck());
        deckListViewProfile.setItems(account.getDeck());
        notDeckListView.setItems(notDeckCards);
        //not deck list view should ba initialized
        nameLabel.setText(account.getName());
        levelLabel.setText("Level: "+account.getLevel());
        XPLabel.setText("XP: "+account.getXP());
        deckListView.setCellFactory(
                new Callback<ListView<Card>, ListCell<Card>>() {
                    @Override
                    public ListCell<Card> call(ListView<Card> listView) {
                        return new ImageTextCell(100);
                    }
                }
        );
        deckListViewProfile.setCellFactory(
                new Callback<ListView<Card>, ListCell<Card>>() {
                    @Override
                    public ListCell<Card> call(ListView<Card> listView) {
                        return new ImageTextCell(100);
                    }
                }
        );
        notDeckListView.setCellFactory(
                new Callback<ListView<Card>, ListCell<Card>>() {
                    @Override
                    public ListCell<Card> call(ListView<Card> listView) {
                        return new ImageTextCell(100);
                    }
                }
        );

        notDeckCards.addAll(CardGenerator.generate(account.getLevel()));
        for (Card card : account.getDeck()){
            card.setLevel(account.getLevel());
            notDeckCards.remove(card);
        }
        ObservableList<String> historyList = FXCollections.observableArrayList();
        historyList.addAll(account.getHistory().getGames());
        historyListView.setItems(historyList);


    }

    @FXML
    void addButtonPressed(ActionEvent event) {
        if(account.getDeck().size()<8){
            Card card = notDeckListView.getSelectionModel().getSelectedItem();
            if(card!=null) {
                notDeckCards.remove(card);
                account.addDeck(card);
            }
        }
    }

    @FXML
    void playWithIdiotBotPressed(ActionEvent event) {
        if(account.getDeck().size()==8){
            SharedData.setBot(Bot.IDIOT_BOT);
            switchToGame(event);
        }

    }

    @FXML
    void playWithSmartBotPressed(ActionEvent event) {
        if(account.getDeck().size()==8){
            SharedData.setBot(Bot.SMART_BOT);
            switchToGame(event);
        }

    }

    @FXML
    void removeButtonPressed(ActionEvent event) {
        Card card = deckListView.getSelectionModel().getSelectedItem();
        if(card!=null) {
            account.removeDeck(card);
            notDeckCards.add(card);
        }

    }
    public void switchToGame(ActionEvent event) {
        try {
            Stage stage;
            Scene scene;
            Parent root;
            root = FXMLLoader.load(getClass().getResource("game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
