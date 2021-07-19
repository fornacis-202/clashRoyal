package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

public class LoginController {
    private AccountReturner accountReturner;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label incorrectUserPassLabel;

    public void initialize(){
        accountReturner=new AccountReturner();
    }

    @FXML
    void loginPressed(ActionEvent event) {
        Account account = accountReturner.login(usernameTextField.getText(),passwordTextField.getText());
        if(account==null){
            incorrectUserPassLabel.setText("Username or password is incorrect.");
            incorrectUserPassLabel.setAlignment(Pos.CENTER);
            incorrectUserPassLabel.setVisible(true);
        }else {
            incorrectUserPassLabel.setVisible(false);
            SharedData.setAccount(account);
            switchToMenu(event);
        }

    }

    @FXML
    void registerPressed(ActionEvent event) {
        Account account = accountReturner.register(usernameTextField.getText(),passwordTextField.getText());
        if(account==null){
            incorrectUserPassLabel.setText("This username already exists.");
            incorrectUserPassLabel.setAlignment(Pos.CENTER);
            incorrectUserPassLabel.setVisible(true);
        }else {
            incorrectUserPassLabel.setVisible(false);
            SharedData.setAccount(account);
            switchToMenu(event);
        }

    }
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

}
