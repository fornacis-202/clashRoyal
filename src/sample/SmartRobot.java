package sample;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type Smart robot.
 */
public class SmartRobot extends Robot {
    /**
     * Instantiates a new Smart robot.
     *
     * @param enemyComponent    the enemy component
     * @param friendlyComponent the friendly component
     * @param deck              the deck
     * @param model             the model
     */
    public SmartRobot(ArrayList<Component> enemyComponent, ArrayList<Component> friendlyComponent, DeckInGame deck, Model model){
        super(enemyComponent,friendlyComponent,deck,model);
    }

    @Override
    public void move() {
        Random random = new Random();
        int area;
        area = areaLessHp();
        if(area==0){
            area=areaSoldiers();
        }
        if (area==0){
            area=2;
        }
        Card card = null;
        do{
            card = getDeck().getShowDeck().get(random.nextInt(4));
        }while (card.getRole().equals(Role.RAGE) || card.getRole().equals(Role.FIRE_BALL) || card.getRole().equals(Role.ARROW));

        if(area==1){
            getModel().enemyAddComponent(card,new Point2D(430,92));
        }else {
            getModel().enemyAddComponent(card,new Point2D(430,356));
        }

    }
    private int areaLessHp(){
        int y=0;
        int count=0;
        for(Component component : getEnemyComponent()){
            if(component instanceof DefenseBuilding){
                DefenseBuilding defenseBuilding = (DefenseBuilding) component;
                if(defenseBuilding.getRole().equals(Role.ARCHER_TOWER)){
                    y+=defenseBuilding.getHPPercent()*defenseBuilding.getPosition().getY();
                    count++;
                }
            }
        }
        y = y/count;
        if(y>=223){
            return 1;
        }else if(y<=221){
            return 2;
        }else return 0;
    }
    private int areaSoldiers(){
        int y=0;
        int count=0;
        for (Component component : getEnemyComponent()){
            if(component instanceof Soldier){
                Soldier soldier = (Soldier) component;
                y+=soldier.getPosition().getY();
                count++;
            }
        }
        if(count == 0 )
            return 0;

        y=y/count;
        if(y>=222){
            return 2;
        }else {
            return 1;
        }
    }
}
