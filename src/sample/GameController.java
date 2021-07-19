package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.Timer;
import java.util.TimerTask;

public class GameController {
    private  int frameRate ;
    private Model model;
    private View view;
    private Timer timer;
    private long counter = 0;



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
    private Label endGameLabel;

    @FXML
    private ImageView nextCardImageView;

    public void initialize(){
        frameRate=View.getFrameRate();
        model=new Model();
        view=new View();
        cardListView.setItems(model.getFriendlyDeck().getShowDeck());
        elixirLabel.setText("");
        timeLabel.setText("");
        enemyStarsLabel.setText("");
        friendlyStarsLabel.setText("");
        endGameLabel.setText("");
        nextCardImageView.setPreserveRatio(true);
        nextCardImageView.setFitHeight(55);
        nextCardImageView.setImage(new Image(model.getFriendlyDeck().getNextCard().getPhoto()));
        startTimer();

    }
    private void startTimer() {
        this.timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        update();
                    }
                });
            }
        };

        long frameTimeInMilliseconds = (long)(1000.0 / frameRate);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }

    public void update(){
        if(! model.isGameIsFinished()){
            counter++;
            model.update(counter);
            //updateView


            elixirLabel.setText(""+model.getFriendlyElixir().getAmount());
            timeLabel.setText(""+model.getTimer().getSeconds());
            enemyStarsLabel.setText(model.getEnemyStars());
            friendlyStarsLabel.setText(model.getFriendlyStars());
            nextCardImageView.setImage(new Image(model.getFriendlyDeck().getNextCard().getPhoto()));
        }
    }



    @FXML
    void mouseClickedOnPane(MouseEvent event) {
        model.friendlyAddComponent(cardListView.getSelectionModel().getSelectedItem(),new Point2D(event.getX(),event.getY()));
    }



}
