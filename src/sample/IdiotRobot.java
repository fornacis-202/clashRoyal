package sample;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Random;

public class IdiotRobot extends Robot{

    public IdiotRobot(ArrayList<Component> enemyComponent, ArrayList<Component> friendlyComponent, DeckInGame deck,Model model){
        super(enemyComponent,friendlyComponent,deck,model);
    }

    @Override
    public void move() {
        Random random = new Random();
        int x = random.nextInt(580) + 50;
        int y = random.nextInt(300)+50;
        int index = random.nextInt(4);
        getModel().enemyAddComponent(getDeck().getShowDeck().get(index) , new Point2D(x,y));
    }
}
