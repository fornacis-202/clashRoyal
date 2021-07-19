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
    private String friendlyStars;
    private String enemyStars;
    private boolean gameIsFinished;
    private DeckInGame friendlyDeck;
    private DeckInGame enemyDeck;
    private Bot bot;


    private final int frameRate;
    private final int step=1;
    private final int tile=20;


    public Model(Bot bot){
        account=AccountHolder.getAccount();
        friendlyComponent=new ArrayList<>();
        enemyComponent=new ArrayList<>();
        frameRate=View.getInstance().getFrameRate();
        friendlyElixir  = new ElixirGenerator(frameRate, 3);
        enemyElixir  = new ElixirGenerator(frameRate, 3);
        timer=new MyTimer(frameRate,180);
        friendlyStars="";
        enemyStars="";
        gameIsFinished=false;
        friendlyDeck=new DeckInGame(account.getDeck());
        enemyDeck=new DeckInGame(account.getDeck());
        this.bot=bot;
        initialize();


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
    public void friendlyAddComponent(Card card,Point2D position){
        if(card.getCost()<=friendlyElixir.getAmount() && whichArea(position) == 1){
            friendlyElixir.reduceAmount(card.getCost());
            friendlyDeck.removeCard(card);
            friendlyComponent.addAll(ComponentGenerator.generate(card.getRole(),position,card.getLevel(),card.getCount()));
        }
    }
    public String endGame(){
        String output;
        if(friendlyStars.length() > enemyStars.length()){
            account.addXP(200);
            output = "YOU WIN!";


        }else if(enemyStars.length() > friendlyStars.length()){
            account.addXP(70);
            output = "YOU LOSE :(";

        }else {
            account.addXP(130);
            output = "DRAW :)";


        }
        account.getHistory().add(account.getName(),friendlyStars,bot.toString(),enemyStars);
        account.saveAccount();
        return output;
    }
    private void enemyAddComponent(Card card,Point2D position){
        if(card.getCost()<=enemyElixir.getAmount() && whichArea(position) == 3){
            enemyElixir.reduceAmount(card.getCost());
            enemyDeck.removeCard(card);
            enemyComponent.addAll(ComponentGenerator.generate(card.getRole(),position,card.getLevel(),card.getCount()));
        }
    }


    public void update(long counter){
        timer.step(counter);
        friendlyElixir.step(counter);
        enemyElixir.step(counter);
        for(Component component : friendlyComponent){
            step(component,friendlyComponent,enemyComponent,counter,1.0);
        }
        for (Component component : enemyComponent){
            step(component,enemyComponent,friendlyComponent,counter,1.0);
        }
        removeIfDead();
        checkTimeEnd();


        //update view

    }

    private void checkTimeEnd(){
        if(timer.getSeconds()<=0){
            gameIsFinished=true;
        }
    }



    private void removeIfDead(){
        for (Component component : friendlyComponent){
            if(component instanceof DefenseBuilding){
                DefenseBuilding defenseBuilding = (DefenseBuilding) component;
                if(defenseBuilding.getDuration()!= null && defenseBuilding.getDuration()<=0){
                    friendlyComponent.remove(defenseBuilding);
                }
            }if(component instanceof Force){
                Force force = (Force) component;
                if(force.getHP()<=0){
                    friendlyComponent.remove(force);
                    if( force.getRole().equals(Role.ARCHER_TOWER)){
                        enemyStars += "*";
                    }else if(force.getRole().equals(Role.KING_TOWER)){
                        enemyStars ="***";
                        gameIsFinished=true;
                    }
                }
            }else if(component instanceof Spell){
                Spell spell = (Spell) component;
                if(spell.getDuration()<=0){
                    friendlyComponent.remove(spell);
                }
            }
        }
        for (Component component : enemyComponent){
            if(component instanceof DefenseBuilding){
                DefenseBuilding defenseBuilding = (DefenseBuilding) component;
                if(defenseBuilding.getDuration()!= null && defenseBuilding.getDuration()<=0){
                    enemyComponent.remove(defenseBuilding);
                }
            }if(component instanceof Force){
                Force force = (Force) component;
                if(force.getHP()<=0){
                    enemyComponent.remove(force);
                    if( force.getRole().equals(Role.ARCHER_TOWER)){
                        friendlyStars += "*";
                    }else if(force.getRole().equals(Role.KING_TOWER)){
                        friendlyStars="***";
                        gameIsFinished=true;
                    }
                }
            }else if(component instanceof Spell){
                Spell spell = (Spell) component;
                if(spell.getDuration()<=0){
                    enemyComponent.remove(spell);
                }
            }
        }
    }

    public void step(Component component , ArrayList<Component> friendlyComponent,ArrayList<Component> enemyComponent, long counter,double magnitude){
        if(component instanceof Force){
            Force force = (Force) component;
            force.setTarget(findTarget(force, enemyComponent));
            if(force.getPosition().distance(force.getTarget().getPosition()) <= force.getRange() * tile){
                force.setAttacking(true);
                attack(force,counter,enemyComponent, magnitude);
                //attack method
            }else {
                force.setAttacking(false);
                if(force instanceof Soldier) {
                   walk((Soldier) force,magnitude);
                }
            }
            if(component instanceof DefenseBuilding && !component.getRole().equals(Role.ARCHER_TOWER) && !component.getRole().equals(Role.KING_TOWER)){
                DefenseBuilding defenseBuilding = (DefenseBuilding) component;
                defenseBuilding.stepDuration(frameRate);
            }

        }
        else if(component instanceof Spell){
            Spell spell = (Spell) component;
            if(spell.getRole().equals(Role.RAGE)){
                rageStep(spell,friendlyComponent,enemyComponent,counter);
            }else {
                notRageStep(spell,enemyComponent);
            }
            spell.stepDuration(frameRate);
        }
    }
    private void rageStep(Spell spell,ArrayList<Component>friendlyComponent,ArrayList<Component> enemyComponent,long counter){
        for (Component component:friendlyComponent){
            if(component instanceof Force && component.getPosition().distance(spell.getPosition()) <= spell.getRange()*tile){
                step(component,friendlyComponent,enemyComponent,counter,spell.getParameter());
            }
        }
    }
    private void notRageStep(Spell spell , ArrayList<Component> enemyComponent){
        for (Component component:enemyComponent){
            if(component instanceof Force && component.getPosition().distance(spell.getPosition()) <= spell.getRange()*tile){
                Force force = (Force) component;
                force.reduceHP((int) (spell.getParameter()/(frameRate * spell.getDuration())));
            }
        }
    }
    private void attack(Force force,long counter,ArrayList<Component> enemyComponent,double magnitude){

        if(isHitTime(force,counter)){
            if(force.getRole().equals(Role.VALKYRIE)){
                //valkyrie hit
                hitValkyrie(force,enemyComponent,magnitude);

            }else if(force.isAreaSplash()){
                //areaSplash hit
                hitAreaSplash(force,enemyComponent,magnitude);
            }else {
                //simple hit
                hitSimple(force,magnitude);
            }

            }

    }
    private void hitValkyrie(Force force, ArrayList<Component> enemyComponent,double magnitude){
        for(Component component : enemyComponent){
            if(force.getTargetType().isInstance(component) && force.getPosition().distance(component.getPosition()) <2* tile){
                Force targetForce = (Force) component;
                targetForce.reduceHP((int) (force.getDamage()*magnitude));

            }
        }

    }
    private void hitAreaSplash(Force force , ArrayList<Component> enemyComponent,double magnitude){
        Force target = force.getTarget();
        for(Component component : enemyComponent){
            if(force.getTargetType().isInstance(component) && target.getPosition().distance(component.getPosition()) < tile){
                Force targetForce = (Force) component;
                targetForce.reduceHP((int) (force.getDamage()* magnitude));

            }
        }
    }

    private void hitSimple(Force force,double magnitude){
        force.getTarget().reduceHP((int) (force.getDamage()*magnitude));
    }

    private boolean isHitTime(Force force,long counter){
        int now = (int) ((counter/frameRate) / force.getHitSpeed());
        int previous = (int) ((counter-1/frameRate) / force.getHitSpeed());
        if(now-previous==1)
            return true;
        else
            return false;
    }


    private void walk(Soldier soldier,double magnitude){
        if((whichArea(soldier.getPosition()) ==1 && whichArea(soldier.getTarget().getPosition())==3 ) || (whichArea(soldier.getPosition()) ==3 && whichArea(soldier.getTarget().getPosition())==1 ) ){
            soldier.setTarget(((soldier.getPosition().distance(bridge1.getPosition()) > soldier.getPosition().distance(bridge2.getPosition()))? bridge2 : bridge1));
        }
        soldier.move(calculateDirection(soldier.getPosition(),soldier.getTarget().getPosition()).multiply(magnitude/frameRate));

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
