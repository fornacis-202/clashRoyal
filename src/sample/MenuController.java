package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class MenuController {
    private Account account;

    @FXML
    private ListView<Card> deckListView;

    @FXML
    private ListView<Card> notDeckListView;

    @FXML
    private Label nameLabel;

    @FXML
    private Label levelLabel;

    @FXML
    private Label XPLabel;

    @FXML
    private ListView<Card> deckListViewProfile;

    public void initialize(){
        account=Model.getInstance().getAccount();
        deckListView.setItems(account.getDeck());
        deckListViewProfile.setItems(account.getDeck());
        //not deck list view should ba initialized
        nameLabel.setText(account.getName());
        levelLabel.setText("Level: "+account.getLevel());
        XPLabel.setText("XP: "+account.getXP());
    }

    @FXML
    void addButtonPressed(ActionEvent event) {

    }

    @FXML
    void playWithIdiotBotPressed(ActionEvent event) {

    }

    @FXML
    void playWithSmartBotPressed(ActionEvent event) {

    }

    @FXML
    void removeButtonPressed(ActionEvent event) {

    }

}
