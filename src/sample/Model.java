package sample;

import javafx.geometry.Point2D;

import java.util.ArrayList;

public class Model {
    private Account account;
    private ArrayList<Component> friendlyComponent;
    private ArrayList<Component> enemyComponent;
    private ElixirGenerator friendlyElixir;
    private ElixirGenerator enemyElixir;
    private MyTimer timer;
    private Bridge bridge1;
    private Bridge bridge2;

    private final int frameRate;
    private final int step=1;
    private final int tile=20;


    public Model(){
        friendlyComponent=new ArrayList<>();
        enemyComponent=new ArrayList<>();
        frameRate=View.getInstance().getFrameRate();
        friendlyElixir  = new ElixirGenerator(frameRate, 3);
        enemyElixir  = new ElixirGenerator(frameRate, 3);
        timer=new MyTimer(frameRate,180);
        initialize();

    }


    private static Model model;
    public static Model getInstance() {
        if(model==null){
            model=new Model();
        }
        return model;
    }


    private void initialize(){
        bridge1=new Bridge(new Point2D(375,90));
        bridge2=new Bridge(new Point2D(375,350));
        friendlyComponent.addAll(ComponentGenerator.generate(Role.ARCHER_TOWER,new Point2D(50,85),account.getLevel(),1));
        friendlyComponent.addAll(ComponentGenerator.generate(Role.ARCHER_TOWER,new Point2D(50,360),account.getLevel(),1));
        friendlyComponent.addAll(ComponentGenerator.generate(Role.KING_TOWER,new Point2D(50,222),account.getLevel(),1));
        enemyComponent.addAll(ComponentGenerator.generate(Role.ARCHER_TOWER,new Point2D(700,85),account.getLevel(),1));
        enemyComponent.addAll(ComponentGenerator.generate(Role.ARCHER_TOWER,new Point2D(700,360),account.getLevel(),1));
        enemyComponent.addAll(ComponentGenerator.generate(Role.KING_TOWER,new Point2D(700,222),account.getLevel(),1));

    }

    public void step(Component component , ArrayList<Component> friendlyComponent,ArrayList<Component> enemyComponent, long counter){
        if(component instanceof Force){
            Force force = (Force) component;
            force.setTarget(findTarget(force, enemyComponent));
            if(force.getPosition().distance(force.getTarget().getPosition()) <= force.getRange() * tile){
                force.setAttacking(true);
                attack(force,counter,enemyComponent);
                //attack method
            }else {
                force.setAttacking(false);
                if(force instanceof Soldier) {
                   walk((Soldier) force);
                }
            }

        }
    }
    private void attack(Force force,long counter,ArrayList<Component> enemyComponent){

        if(isHitTime(force,counter)){
            if(force.getRole().equals(Role.VALKYRIE)){
                //valkyrie hit
                hitValkyrie(force,enemyComponent);

            }else if(force.isAreaSplash()){
                //areaSplash hit
                hitAreaSplash(force,enemyComponent);
            }else {
                //simple hit
                hitSimple(force);
            }

            }

    }
    private void hitValkyrie(Force force, ArrayList<Component> enemyComponent){
        for(Component component : enemyComponent){
            if(force.getTargetType().isInstance(component) && force.getPosition().distance(component.getPosition()) <2* tile){
                Force targetForce = (Force) component;
                targetForce.reduceHP(force.getDamage());

            }
        }

    }
    private void hitAreaSplash(Force force , ArrayList<Component> enemyComponent){
        Force target = force.getTarget();
        for(Component component : enemyComponent){
            if(force.getTargetType().isInstance(component) && target.getPosition().distance(component.getPosition()) < tile){
                Force targetForce = (Force) component;
                targetForce.reduceHP(force.getDamage());

            }
        }
    }

    private void hitSimple(Force force){
        force.getTarget().reduceHP(force.getDamage());
    }

    private boolean isHitTime(Force force,long counter){
        int now = (int) ((counter/frameRate) / force.getHitSpeed());
        int previous = (int) ((counter-1/frameRate) / force.getHitSpeed());
        if(now-previous==1)
            return true;
        else
            return false;
    }


    private void walk(Soldier soldier){
        if((whichArea(soldier.getPosition()) ==1 && whichArea(soldier.getTarget().getPosition())==3 ) || (whichArea(soldier.getPosition()) ==3 && whichArea(soldier.getTarget().getPosition())==1 ) ){
            soldier.setTarget(((soldier.getPosition().distance(bridge1.getPosition()) > soldier.getPosition().distance(bridge2.getPosition()))? bridge2 : bridge1));
        }
        soldier.move(calculateDirection(soldier.getPosition(),soldier.getTarget().getPosition()).multiply(1.0/frameRate));

    }

    private Point2D calculateDirection(Point2D start , Point2D destination){
        double distance = start.distance(destination);
        double x = (destination.getX()-start.getX())/distance;
        double y = (destination.getY()-start.getY())/distance;
        return new Point2D(x,y).multiply(step);
    }

    private Force findTarget(Force force,ArrayList<Component> enemyComponent){
        Component target=null;
        for (Component component1 : enemyComponent){
            if(force.getTargetType().isInstance(component1)){
                if(target==null){
                    target=component1;
                }else if(force.getPosition().distance(target.getPosition()) > force.getPosition().distance(component1.getPosition())){
                    target=component1;
                }
            }
        }
        return (Force) target;
    }

    private int whichArea(Point2D position){
        if(position.distance(bridge1.getPosition())<20 || position.distance(bridge2.getPosition())<20){
            return 2;
        }else if(position.getX()<360){
            return 1;
        }else if(position.getX()>390) {
            return 3;
        }else
            return 0;

    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
