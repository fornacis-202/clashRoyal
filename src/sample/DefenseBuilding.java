package sample;

import javafx.geometry.Point2D;

/**
 * The type Defense building.
 */
public class DefenseBuilding extends Force implements Ground{
    private Double duration;

    /**
     * Instantiates a new Defense building.
     *
     * @param position     the position
     * @param range        the range
     * @param role         the role
     * @param hitSpeed     the hit speed
     * @param HP           the hp
     * @param damage       the damage
     * @param targetType   the target type
     * @param isAreaSplash the is area splash
     * @param duration     the duration
     */
    public DefenseBuilding(Point2D position , int range, Role role, double hitSpeed, int HP, int damage, Class targetType, boolean isAreaSplash , Double duration){
        super(position, range, role, hitSpeed, HP, damage, targetType, isAreaSplash);
        this.duration=duration;
    }

    /**
     * Step duration.
     *
     * @param frameRate the frame rate
     */
    public void stepDuration(int frameRate){
        duration-=1.0/frameRate;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public Double getDuration() {
        return duration;
    }
}
