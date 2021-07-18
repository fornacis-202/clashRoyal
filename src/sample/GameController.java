package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class GameController {
    private final int frameRate = 15;





    @FXML
    private ListView<Card> cardListView;

    @FXML
    private Pane gamePane;

    @FXML
    private Label elixirLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label enemyStarsLabel;

    @FXML
    private Label friendlyStarsLabel;
    @FXML
    void mouseClickedOnPane(MouseEvent event) {
        System.out.println("x:"+event.getX()+"   y:" + event.getY());
    }


    public int getFrameRate() {
        return frameRate;
    }
}
