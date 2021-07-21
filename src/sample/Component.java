package sample;

import javafx.geometry.Point2D;

/**
 * The type Component.
 */
public abstract class Component {
    private Point2D position;
    private double range;
    private Role role;

    /**
     * Instantiates a new Component.
     *
     * @param position the position
     * @param range    the range
     * @param role     the role
     */
    public Component(Point2D position , double range,Role role){
        this.position=position;
        this.range=range;
        this.role=role;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Gets range.
     *
     * @return the range
     */
    public double getRange() {
        return range;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Point2D getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(Point2D position) {
        this.position = position;
    }
}
