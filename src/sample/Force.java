package sample;

import javafx.geometry.Point2D;

public abstract class Force extends Component {
    private double hitSpeed;
    private int HP;
    private int damage;
    private Class targetType ;
    private boolean isAttacking;
    private Force target;

    private boolean isAreaSplash;

    public Force(Point2D position , int range,Role role, double hitSpeed, int HP, int damage, Class targetType, boolean isAreaSplash){
        super(position,range,role);
        this.hitSpeed=hitSpeed;
        this.HP=HP;
        this.damage=damage;
        this.targetType=targetType;
        this.isAttacking=false;
        this.isAreaSplash=isAreaSplash;
    }
    public void reduceHP(int amount){
        HP-=amount;
        if(HP<0)
            HP=0;
    }



    public Class getTargetType() {
        return targetType;
    }

    public double getHitSpeed() {
        return hitSpeed;
    }

    public Force getTarget() {
        return target;
    }

    public int getDamage() {
        return damage;
    }

    public int getHP() {
        return HP;
    }


    public boolean isAreaSplash() {
        return isAreaSplash;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }

    public void setTarget(Force target) {
        this.target = target;
    }
}
