package sample;

import javafx.geometry.Point2D;

/**
 * The type Air soldier.
 */
public class AirSoldier extends Soldier{

    /**
     * Instantiates a new Air soldier.
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
    public AirSoldier(Point2D position , int range, Role role, double hitSpeed, int HP, int damage, Class targetType, boolean isAreaSplash, Speed speed){
        super(position, range,role, hitSpeed, HP, damage, targetType, isAreaSplash,speed);

    }


}
