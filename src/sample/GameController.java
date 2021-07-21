package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * The type Game controller.
 */
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
    private VBox Vbox;

    @FXML
    private Label enemyStarsLabel;

    @FXML
    private Label friendlyStarsLabel;

    @FXML
    private Label endGameLabel;

    @FXML
    private ImageView nextCardImageView;

    @FXML
    private Button backToMenuButton;

    /**
     * Initialize.
     */
    public void initialize(){
        frameRate=View.getFrameRate();
        model=new Model();
        view=new View();
        cardListView.setItems(model.getFriendlyDeck().getShowDeck());
        Vbox.setVisible(false);
        elixirLabel.setText("");
        timeLabel.setText("");
        enemyStarsLabel.setText("");
        friendlyStarsLabel.setText("");
        endGameLabel.setText("");
        backToMenuButton.setVisible(false);
        nextCardImageView.setPreserveRatio(true);
        nextCardImageView.setFitHeight(55);
        nextCardImageView.setImage(new Image(model.getFriendlyDeck().getNextCard().getPhoto()));
        cardListView.setCellFactory(
                new Callback<ListView<Card>, ListCell<Card>>() {
                    @Override
                    public ListCell<Card> call(ListView<Card> listView) {
                        return new ImageTextCell(70);
                    }
                }
        );
        view.setPane(gamePane);
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

    /**
     * Update.
     */
    public void update(){
        if(! model.isGameIsFinished()){
            counter++;
            model.update(counter);
            view.update(model);
            elixirLabel.setText(""+model.getFriendlyElixir().getAmount());
            elixirLabel.setAlignment(Pos.CENTER);
            timeLabel.setText(""+model.getTimer().getSeconds());
            enemyStarsLabel.setText(model.getEnemyStars());
            friendlyStarsLabel.setText(model.getFriendlyStars());
            nextCardImageView.setImage(new Image(model.getFriendlyDeck().getNextCard().getPhoto()));
        }else {
            pause();
            String endGame = model.endGame();
            Vbox.setVisible(true);
            endGameLabel.setText(endGame);
            stop(4);
            backToMenuButton.setVisible(true);



        }
    }

    /**
     * Back to menu clicked.
     *
     * @param event the event
     */
    @FXML
    void backToMenuClicked(ActionEvent event) {
        switchToMenu(event);
    }

    /**
     * Switch to menu.
     *
     * @param event the event
     */
    public void switchToMenu(ActionEvent event) {
        try {
            Stage stage;
            Scene scene;
            Parent root;
            root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            JMetro jMetro = new JMetro(Style.LIGHT);
            jMetro.setScene(scene);
            stage.setScene(scene);
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Stop.
     *
     * @param seconds the seconds
     */
    public void stop(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);

        }catch (InterruptedException e){

        }
    }

    /**
     * Pause.
     */
    public void pause(){
        this.timer.cancel();
    }


    /**
     * Mouse clicked on pane.
     *
     * @param event the event
     */
    @FXML
    void mouseClickedOnPane(MouseEvent event) {
        //System.out.println("X:" + event.getX() + "   Y:" + event.getY());
        model.friendlyAddComponent(cardListView.getSelectionModel().getSelectedItem(),new Point2D(event.getX(),event.getY()));
    }

    /**
     * Gets game pane.
     *
     * @return the game pane
     */
    public Pane getGamePane() {
        return gamePane;
    }
}
