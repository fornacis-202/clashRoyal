package sample;

import javafx.geometry.Point2D;

/**
 * The type Soldier.
 */
public abstract class Soldier extends Force{
    private Speed speed;

    /**
     * Instantiates a new Soldier.
     *
     * @param position     the position
     * @param range        the range
     * @param role         the role
     * @param hitSpeed     the hit speed
     * @param HP           the hp
     * @param damage       the damage
     * @param targetType   the target type
     * @param isAreaSplash the is area splash
     * @param speed        the speed
     */
    public Soldier(Point2D position , double range, Role role, double hitSpeed, int HP, int damage, Class targetType, boolean isAreaSplash, Speed speed){
        super(position, range,role, hitSpeed, HP, damage, targetType, isAreaSplash);
        this.speed=speed;
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public Speed getSpeed() {
        return speed;
    }

    /**
     * Move.
     *
     * @param addingPosition the adding position
     */
    public void move(Point2D addingPosition){
        setPosition(getPosition().add(addingPosition.multiply(speed.getNumVal())));
    }
}
