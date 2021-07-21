package sample;

import javafx.geometry.Point2D;

/**
 * The type Force.
 */
public abstract class Force extends Component {
    private double hitSpeed;
    private int HP;
    private int damage;
    private Class targetType ;
    private boolean isAttacking;
    private Force target;
    private final int constantHP;

    private boolean isAreaSplash;

    /**
     * Instantiates a new Force.
     *
     * @param position     the position
     * @param range        the range
     * @param role         the role
     * @param hitSpeed     the hit speed
     * @param HP           the hp
     * @param damage       the damage
     * @param targetType   the target type
     * @param isAreaSplash the is area splash
     */
    public Force(Point2D position , double range,Role role, double hitSpeed, int HP, int damage, Class targetType, boolean isAreaSplash){
        super(position,range,role);
        this.hitSpeed=hitSpeed;
        this.HP=HP;
        this.constantHP=HP;
        this.damage=damage;
        this.targetType=targetType;
        this.isAttacking=false;
        this.isAreaSplash=isAreaSplash;
    }

    /**
     * Reduce hp.
     *
     * @param amount the amount
     */
    public void reduceHP(int amount){
        HP-=amount;
        if(HP<0)
            HP=0;
    }


    /**
     * Gets target type.
     *
     * @return the target type
     */
    public Class getTargetType() {
        return targetType;
    }

    /**
     * Gets hit speed.
     *
     * @return the hit speed
     */
    public double getHitSpeed() {
        return hitSpeed;
    }

    /**
     * Gets target.
     *
     * @return the target
     */
    public Force getTarget() {
        return target;
    }

    /**
     * Gets damage.
     *
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Gets hp.
     *
     * @return the hp
     */
    public int getHP() {
        return HP;
    }


    /**
     * Is area splash boolean.
     *
     * @return the boolean
     */
    public boolean isAreaSplash() {
        return isAreaSplash;
    }

    /**
     * Is attacking boolean.
     *
     * @return the boolean
     */
    public boolean isAttacking() {
        return isAttacking;
    }

    /**
     * Sets attacking.
     *
     * @param attacking the attacking
     */
    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }

    /**
     * Sets target.
     *
     * @param target the target
     */
    public void setTarget(Force target) {
        this.target = target;
    }

    /**
     * Get hp percent double.
     *
     * @return the double
     */
    public double getHPPercent(){
        return ((double)HP )/constantHP;
    }
}
