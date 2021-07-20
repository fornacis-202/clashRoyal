package sample;

import javafx.geometry.Point2D;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class View {
    private static final int frameRate=15;

    private Image archerAR;
    private Image archerAL;
    private Image archerWR;
    private Image archerWl;

    private Image barbarAR;
    private Image barbarAL;
    private Image barbarWR;
    private Image barbarWl;

    private Image dragonAR;
    private Image dragonAL;
    private Image dragonWR;
    private Image dragonWl;

    private Image giantAR;
    private Image giantAL;
    private Image giantWR;
    private Image giantWl;

    private Image pekaAR;
    private Image pekaAL;
    private Image pekaWR;
    private Image pekaWl;

    private Image valkyrieAR;
    private Image valkyrieAL;
    private Image valkyrieWR;
    private Image valkyrieWl;

    private Image wizardAR;
    private Image wizardAL;
    private Image wizardWR;
    private Image wizardWl;

    private Image archerTowerAR;
    private Image archerTowerAL;
    private Image archerTowerSR;
    private Image archerTowerSl;

    private Image kingTowerAR;
    private Image kingTowerAL;
    private Image kingTowerSR;
    private Image kingTowerSl;

    private Image cannonA;
    private Image cannonS;

    private Image infernoA;
    private Image infernoS;

    private Image rage;

    private Image arrows;

    private Image fireball;

    private Pane pane;







    public View(){
        this.archerAL =  new Image("file:images/archer/attacking-left.gif");
        this.archerAR =  new Image("file:images/archer/attacking-right.gif");
        this.archerWl =  new Image("file:images/archer/walk-left.gif");
        this.archerWR =  new Image("file:images/archer/walk-right.gif");


        this.barbarAL =  new Image("file:images/barbar/attack-left.gif");
        this.barbarAR =  new Image("file:images/barbar/attack-right.gif");
        this.barbarWl =  new Image("file:images/barbar/walk-left.gif");
        this.barbarWR =  new Image("file:images/barbar/walk-right.gif");


        this.dragonAL =  new Image("file:images/dragon/attack-left.gif");
        this.dragonAR =  new Image("file:images/dragon/attack-right.gif");
        this.dragonWl =  new Image("file:images/dragon/walk-left.gif");
        this.dragonWR =  new Image("file:images/dragon/walk-right.gif");

        this.giantAL =  new Image("file:images/giant/attack-left.gif");
        this.giantAR =  new Image("file:images/giant/attack-right.gif");
        this.giantWl =  new Image("file:images/giant/walk-left.gif");
        this.giantWR =  new Image("file:images/giant/walk-right.gif");

        this.pekaAL =  new Image("file:images/peka/attack-left.gif");
        this.pekaAR =  new Image("file:images/peka/attack-right.gif");
        this.pekaWl =  new Image("file:images/peka/walk-left.gif");
        this.pekaWR =  new Image("file:images/peka/walk-right.gif");

        this.valkyrieAL =  new Image("file:images/valkyrie/attack-left.gif");
        this.valkyrieAR =  new Image("file:images/valkyrie/attack-right.gif");
        this.valkyrieWl =  new Image("file:images/valkyrie/walk-left.gif");
        this.valkyrieWR =  new Image("file:images/valkyrie/walk-right.gif");

        this.wizardAL =  new Image("file:images/wizard/attack-left.gif");
        this.wizardAR =  new Image("file:images/wizard/attack-right.gif");
        this.wizardWl =  new Image("file:images/wizard/walk-left.gif");
        this.wizardWR =  new Image("file:images/wizard/walk-right.gif");

        this.archerTowerAL =  new Image("file:images/archer tower/attack-left.gif");
        this.archerTowerAR =  new Image("file:images/archer tower/attack-right.gif");
        this.archerTowerSl =  new Image("file:images/archer tower/stop-left.png");
        this.archerTowerSR =  new Image("file:images/archer tower/stop-right.png");

        this.kingTowerAL =  new Image("file:images/king tower/attack-left.gif");
        this.kingTowerAR =  new Image("file:images/king tower/attack-right.gif");
        this.kingTowerSl =  new Image("file:images/king tower/stop-left.png");
        this.kingTowerSR =  new Image("file:images/king tower/stop-right.png");

        this.cannonA =  new Image("file:images/cannon/attack.gif");
        this.cannonS =  new Image("file:images/cannon/stop.png");

        this.infernoA =  new Image("file:images/inferno/attack.gif");
        this.infernoS =  new Image("file:images/inferno/stop.png");

        this.rage =  new Image("file:images/rage/rage.gif");

        this.arrows =  new Image("file:images/arrows/arrows.gif");

        this.fireball =  new Image("file:images/fire ball/fireball.gif");


    }

    public void update(Model model){
        pane.getChildren().clear();
        for (Component component : model.getFriendlyComponent()){
            if(component.getRole().equals(Role.ARCHER)){
                updateSoldier((Soldier) component, archerAR , archerAL , archerWR , archerWl , 40);
            }else if(component.getRole().equals(Role.BARBARIAN)){
                updateSoldier((Soldier) component, barbarAR , barbarAL , barbarWR , barbarWl , 40);
            }else if(component.getRole().equals(Role.DRAGON)){
                updateSoldier((Soldier) component, dragonAR , dragonAL , dragonWR , dragonWl , 50);
            }else if(component.getRole().equals(Role.GIANT)){
                updateSoldier((Soldier) component, giantAR , giantAL , giantWR , giantWl , 55);
            }else if(component.getRole().equals(Role.PEKKA)){
                updateSoldier((Soldier) component, pekaAR , pekaAL , pekaWR , pekaWl , 40);
            }else if(component.getRole().equals(Role.VALKYRIE)){
                updateSoldier((Soldier) component, valkyrieAR , valkyrieAL , valkyrieWR , valkyrieWl , 70);
            }else if(component.getRole().equals(Role.WIZARD)){
                updateSoldier((Soldier) component, wizardAR , wizardAL , wizardWR , wizardWl , 40);
            }
        }
    }
    private void updateDefenseBuilding(DefenseBuilding defenseBuilding,Image ar,Image al , Image wr , Image wl , double height){
        ImageView imageView = new ImageView();
        double angel = calculateAngel(soldier);
        if(soldier.isAttacking()){
            if(angel<=90){
                imageView.setImage(ar);
            }else {
                imageView.setImage(al);
            }

        }else {
            if(angel<=90){
                imageView.setImage(wr);
            }else {
                imageView.setImage(wl);
            }

        }
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(height);
        double subtractingY = height * 2 / 3 ;
        double subtractingX = imageView.prefWidth(height)/2;
        imageView.setX(soldier.getPosition().getX() - subtractingX);
        imageView.setY(soldier.getPosition().getY() - subtractingY);
        ProgressBar healthBar = new ProgressBar();
        healthBar.setLayoutX(soldier.getPosition().getX() - subtractingX-20);
        healthBar.setLayoutY(soldier.getPosition().getY() - 40);
        healthBar.setScaleX(0.3);
        healthBar.setScaleY(0.3);
        healthBar.setProgress(soldier.getHPPercent());
        imageView.setRotate(angel);
        pane.getChildren().add(imageView);
        pane.getChildren().add(healthBar);

    }

    private void updateSoldier(Soldier soldier,Image ar,Image al , Image wr , Image wl , double height){
        ImageView imageView = new ImageView();
        double angel = calculateAngel(soldier);
        if(soldier.isAttacking()){
            if(angel<=90){
                imageView.setImage(ar);
            }else {
                imageView.setImage(al);
            }

        }else {
            if(angel<=90){
                imageView.setImage(wr);
            }else {
                imageView.setImage(wl);
            }

        }
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(height);
        double subtractingY = height * 2 / 3 ;
        double subtractingX = imageView.prefWidth(height)/2;
        imageView.setX(soldier.getPosition().getX() - subtractingX);
        imageView.setY(soldier.getPosition().getY() - subtractingY);
        ProgressBar healthBar = new ProgressBar();
        healthBar.setLayoutX(soldier.getPosition().getX() - subtractingX-20);
        healthBar.setLayoutY(soldier.getPosition().getY() - 40);
        healthBar.setScaleX(0.3);
        healthBar.setScaleY(0.3);
        healthBar.setProgress(soldier.getHPPercent());
        imageView.setRotate(angel);
        pane.getChildren().add(imageView);
        pane.getChildren().add(healthBar);

    }

    private double calculateAngel(Force force){
        Point2D subtract = force.getTarget().getPosition().subtract(force.getPosition());
        double angel = new Point2D(1,0).angle(subtract) ;
        if(force.getTarget().getPosition().getX() < force.getPosition().getX()){
            angel=180+angel;
        }
        if(force.getTarget().getPosition().getY() < force.getPosition().getY()){
            angel = -angel;
        }
        return angel;
    }




    public static int getFrameRate() {
        return frameRate;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }
}
